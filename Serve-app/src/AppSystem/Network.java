/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppSystem;


import Applicant.ApplicationDirectory;
import Enterprise.Enterprise;
import Enterprise.EnterpriseDirectory;
import Organization.ConvenienceVolOrganization;
import Organization.Organization;
import Organization.ProductManagement.OrderItem;
import Organization.ProductManagement.Product;
import Organization.ProductManagement.ProductOrder;
import Organization.ProductOrganization;
import Organization.ServiceManagement.Service;
import Organization.ServiceManagement.ServiceOrder;
import Organization.ServicesOrganization;
import Person.Client.Client;
import Person.Person;
import Person.PersonDirectory;
import Requests.ConvenienceRequest;
import Requests.DeliveryRequest;
import Requests.RequestDirectory;
import Requests.ServiceRequest;
import UI.ClientWorkArea.HospitalMP;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import Volunteer.VolunteerProfile;
import WorkAreas.ClientRole;
import WorkAreas.ConnectionVolunteerRole;
import WorkAreas.ConvenienceVolunteerRole;
import WorkAreas.EnterpriseManagerRole;
import WorkAreas.HealthcareSpecialistRole;
import WorkAreas.LegalSpecialistRole;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import WorkAreas.ConvenienceVolunteerRole;

import WorkAreas.EnterpriseManagerRole;
import WorkAreas.HealthcareSpecialistRole;
import WorkAreas.LegalSpecialistRole;
import WorkAreas.ProductOrganizationManagerRole;
import WorkAreas.ServicesOrganizationManagerRole;
import WorkAreas.SystemAdminRole;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author siqiyang
 */
public class Network {
        String name;
        static EnterpriseDirectory enterprises;
        static UserAccountDirectory topLevelUserAccountDirectory;        
        static PersonDirectory personDirectory;
        ApplicationDirectory applicantDirectory;
        static RequestDirectory reqDir;
      
    public Network( ) {
        this.name= name;
        this.enterprises = new EnterpriseDirectory();
        this.topLevelUserAccountDirectory = new UserAccountDirectory();
        this.topLevelUserAccountDirectory.createUserAccount("admin", "admin", new SystemAdminRole());
        this.personDirectory = new PersonDirectory();
        this.applicantDirectory= new ApplicationDirectory();
        this.reqDir = new RequestDirectory();
    }
    
    public Network(String name) {
        this.name= name;
        this.enterprises = new EnterpriseDirectory();
        this.topLevelUserAccountDirectory = new UserAccountDirectory();
        this.topLevelUserAccountDirectory.createUserAccount("admin", "admin", new SystemAdminRole());
        this.personDirectory = new PersonDirectory();
        this.applicantDirectory= new ApplicationDirectory();
        this.reqDir = new RequestDirectory();
    }
    
    
//    public static Network getInstance() {
//        return new Network();
//    }
    
    public static Network createSystemInstance() {
        Network app = new Network("Serve Boston");
        
        Enterprise convenience = app.getEnterprises().createConvenienceEnterprise("Convenience");
        
        //MAKE THIS PRODUCT ORGANIZATION???!?!!?!?
        
        Organization o1 = convenience.getOrganizationDirectory().createProductOrganization("Pharmacy", convenience, "Pharmacy");
        Organization o2 = convenience.getOrganizationDirectory().createProductOrganization("Grocery Store", convenience, "Grocery Store");
        
        //MAKE THESE SERVICE ORGANIZATIONS???!?!!?!?
        Enterprise healthcare  = app.getEnterprises().createEnterprise("Health");
        Organization o3 = healthcare.getOrganizationDirectory().createServicesOrganization("Hospital",healthcare, "Hospital");
        
        Enterprise legal  = app.getEnterprises().createEnterprise("Legal");
        Organization o4 = legal.getOrganizationDirectory().createServicesOrganization("Law Office",legal, "Law Office");
        
        Enterprise connection  = app.getEnterprises().createEnterprise("Connection");
        Organization o5 = connection.getOrganizationDirectory().createServicesOrganization("Community Organization",connection, "Community Organization");
        Organization o6 = connection.getOrganizationDirectory().createServicesOrganization("School",connection, "School");  
        
        Organization o7 = convenience.getOrganizationDirectory().createVolunteerOrganization("ConvenienceVolOrganization", convenience,"Volunteer");
       
        //comment out to remove fake data

        adminfaker(app, convenience,healthcare,legal,connection,o1,o2,o3,o4,o5,o6);
        
        
        productfaker((ProductOrganization)o1, (ProductOrganization) o2);

        servicefaker((ServicesOrganization) o3,(ServicesOrganization) o4,(ServicesOrganization) o5,(ServicesOrganization) o6);
        clientfaker();

//        servicefaker((ServicesOrganization) o3,(ServicesOrganization) o4,(ServicesOrganization) o5,(ServicesOrganization) o6);

        convVolfaker((ConvenienceVolOrganization) o7);


        
        servVolfaker((ServicesOrganization) o3,(ServicesOrganization) o4,(ServicesOrganization) o5,(ServicesOrganization) o6);
        
        System.out.println("Network Systm isnstance "+reqDir.getDeliveryRequests().size());

        return app;
    }


    public static void adminfaker(Network app, Enterprise convenience, Enterprise healthcare,Enterprise legal,Enterprise connection,Organization o1, Organization o2,Organization o3,Organization o4,Organization o5,Organization o6){

        Person convP = personDirectory.createPerson( "Connie Venience");
        UserAccount convUA = app.getTopLevelUserAccountDirectory().createUserAccount("conv", "conv", new EnterpriseManagerRole());
        convUA.setPerson(convP);
        convenience.setEnterpriseAdmin(convUA);
        convenience.getUseraccountDirectory().getUserAccountList().add(convUA);
        
        Person healthP = personDirectory.createPerson( "Happ Peabody");
        UserAccount healthUA = app.getTopLevelUserAccountDirectory().createUserAccount("health", "health", new EnterpriseManagerRole());
        healthUA.setPerson(healthP);
        healthcare.setEnterpriseAdmin(healthUA);
        healthcare.getUseraccountDirectory().getUserAccountList().add(healthUA);
        
        
        Person lawP = personDirectory.createPerson("Justice N. Fairtrial");
        UserAccount lawUA = app.getTopLevelUserAccountDirectory().createUserAccount("lawe", "lawe", new EnterpriseManagerRole());
        lawUA.setPerson(lawP);
        legal.setEnterpriseAdmin(lawUA);
        legal.getUseraccountDirectory().getUserAccountList().add(lawUA);

        Person connP = personDirectory.createPerson( "Love Tim Eatwood");
        UserAccount connUA = app.getTopLevelUserAccountDirectory().createUserAccount("conn", "conn", new EnterpriseManagerRole());
        connUA.setPerson(connP);
        connection.setEnterpriseAdmin(connUA);
        connection.getUseraccountDirectory().getUserAccountList().add(connUA);
        
        Person p1 = personDirectory.createPerson( "Moe Trin");
        UserAccount ua1 = o1.getOrganizationAccountDirectory().createUserAccount("phar", "phar", new ProductOrganizationManagerRole());
        o1.setOrganizationManager(ua1);
        ua1.setPerson(p1);
        o1.getE().getUseraccountDirectory().getUserAccountList().add(ua1);
        
        Person p2 = personDirectory.createPerson( "Cal Ories");
        UserAccount ua2 = o2.getOrganizationAccountDirectory().createUserAccount("gro", "gro", new ProductOrganizationManagerRole());
        o2.setOrganizationManager(ua2);
        ua2.setPerson(p2);
        o2.getE().getUseraccountDirectory().getUserAccountList().add(ua2);
        
        Person p3 = personDirectory.createPerson(  "John Dorian");
        UserAccount ua3 = o3.getOrganizationAccountDirectory().createUserAccount("hos", "hos", new ServicesOrganizationManagerRole());
        o3.setOrganizationManager(ua3);
        ua3.setPerson(p3);
        o3.getE().getUseraccountDirectory().getUserAccountList().add(ua3);
        
        UserAccount ua4 = o4.getOrganizationAccountDirectory().createUserAccount("law", "law", new ServicesOrganizationManagerRole());
        o4.setOrganizationManager(ua4);
        Person p4 = personDirectory.createPerson( "Bob Loblaw");
        ua4.setPerson(p4);
        o4.getE().getUseraccountDirectory().getUserAccountList().add(ua4);
        
        UserAccount ua5 = o5.getOrganizationAccountDirectory().createUserAccount("boy", "boy", new ServicesOrganizationManagerRole());
        o5.setOrganizationManager(ua5);
        Person p5 = personDirectory.createPerson( "Baden Powell");
        ua5.setPerson(p5);
        o5.getE().getUseraccountDirectory().getUserAccountList().add(ua5);
        
        UserAccount ua6 = o6.getOrganizationAccountDirectory().createUserAccount("scho", "scho", new ServicesOrganizationManagerRole());
        o6.setOrganizationManager(ua6);
        Person p6 = personDirectory.createPerson(  "Reese S.");
        ua6.setPerson(p6);
        o6.getE().getUseraccountDirectory().getUserAccountList().add(ua6);
        
    }
    
    public static void clientfaker(){
        Person p = personDirectory.createPerson("Client A");
        Client c = (Client) personDirectory.createClient(p);
        UserAccount ua = topLevelUserAccountDirectory.createUserAccount("client", "client", new ClientRole());
        c.setUseraccount(ua);
        ua.setPerson(c);
        System.out.println("AppSystem.Network.clientfaker() Client A" + reqDir.getDeliveryRequestsbyClient(c).size());
        createConvenienceReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c, 9);
        createConvenienceReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c, 4);
        createConvenienceReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c, 3);
        createConvenienceReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c, 10);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c, 2);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c, 13);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c, 0);
        c.setAddress("123 Main St");

        
        Person p1 = personDirectory.createPerson("Client B");
        Client c1 = (Client) personDirectory.createClient(p1);
        UserAccount ua1 = topLevelUserAccountDirectory.createUserAccount("c1", "c1", new ClientRole());
        c1.setUseraccount(ua1);
        c1.setAddress("456 Oak St");
        ua1.setPerson(c1);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c1, 2);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c1, 9);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c1, 12);
        
        
        Person p2 = personDirectory.createPerson("Client C");
        Client c2 = (Client) personDirectory.createClient(p2);
        UserAccount ua2 = topLevelUserAccountDirectory.createUserAccount("c2", "c2", new ClientRole());
        c2.setUseraccount(ua2);
        c2.setAddress("789 Elm St");
        ua2.setPerson(c2);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Connection").getOrganizationDirectory().findOrganizationbyType("School"), c2, 0);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Health").getOrganizationDirectory().findOrganizationbyType("Hospital"), c2, 2);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Health").getOrganizationDirectory().findOrganizationbyType("Hospital"), c2, 4);

        
        Person p3 = personDirectory.createPerson("Client D");
        Client c3 = (Client) personDirectory.createClient(p3);
        UserAccount ua3 = topLevelUserAccountDirectory.createUserAccount("c3", "c3", new ClientRole());
        c3.setUseraccount(ua3);
        c3.setAddress("321 Maple Ave");
        ua3.setPerson(c3);
        createPharDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c3, 15); 
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c3, 9);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Health").getOrganizationDirectory().findOrganizationbyType("Hospital"), c3, 0);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Legal").getOrganizationDirectory().findOrganizationbyType("Law Office"), c3, 0);

        
        
        Person p4 = personDirectory.createPerson("Client E");
        Client c4 = (Client) personDirectory.createClient(p4);
        UserAccount ua4 = topLevelUserAccountDirectory.createUserAccount("c4", "c4", new ClientRole());
        c4.setUseraccount(ua4);
        c4.setAddress("987 Pine St");
        ua4.setPerson(c4);
        createGroDeliveryReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store"), c4, 0);

        Person p5 = personDirectory.createPerson("Client F");
        Client c5 = (Client) personDirectory.createClient(p5);
        UserAccount ua5 = topLevelUserAccountDirectory.createUserAccount("c5", "c5", new ClientRole());
        c5.setUseraccount(ua5);
        c5.setAddress("34 Eastern Ave");
        ua5.setPerson(c5);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Connection").getOrganizationDirectory().findOrganizationbyType("Community Organization"), c5, 0);
        createServeOrgReqs((ServicesOrganization) enterprises.findEnterprise("Legal").getOrganizationDirectory().findOrganizationbyType("Law Office"), c5, 3);
        createConvenienceReqs((ProductOrganization) enterprises.findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy"), c5, 9);

    }

    public static void productfaker(ProductOrganization pharmacy, ProductOrganization grocery){
        Product pharPro1 = pharmacy.getProductCatalog().newPharmacyProduct("Ibuprofen", 20, "Pain Relief", false);
        pharPro1.setProductImageFilewithFilePath("src/Resources/ProductImages/ibuprofen.jpeg");
       
        Product pharPro2 = pharmacy.getProductCatalog().newPharmacyProduct("Amoxicillin", 40, "Antibiotics", true);
        pharPro2.setProductImageFilewithFilePath("src/Resources/ProductImages/amoxicillin.jpg");     
       
        Product pharPro3 = pharmacy.getProductCatalog().newPharmacyProduct("Aspirin", 16, "Pain Relief", false);
        pharPro3.setProductImageFilewithFilePath("src/Resources/ProductImages/Aspirin.jpg");        
        
        Product pharPro4 = pharmacy.getProductCatalog().newPharmacyProduct("Ibuprofen", 30, "Pain Relief", true);
        pharPro4.setProductImageFilewithFilePath("src/Resources/ProductImages/ibuprofen.jpg");       
        
        Product pharPro5 = pharmacy.getProductCatalog().newPharmacyProduct("Loratadine", 24, "Allergy", false);
        pharPro5.setProductImageFilewithFilePath("src/Resources/ProductImages/Loratadine.jpg");       
        
        Product pharPro6 = pharmacy.getProductCatalog().newPharmacyProduct("Naproxen", 36, "Pain Relief", false);
        pharPro6.setProductImageFilewithFilePath("src/Resources/ProductImages/Naproxen.jpg");        
        
        Product pharPro7 = pharmacy.getProductCatalog().newPharmacyProduct("Cetirizine", 18, "Allergy", false);
        pharPro7.setProductImageFilewithFilePath("src/Resources/ProductImages/Cetirizine.jpg");        
        
        Product pharPro8 = pharmacy.getProductCatalog().newPharmacyProduct("Diphenhydramine", 50, "Allergy", false);
        pharPro8.setProductImageFilewithFilePath("src/Resources/ProductImages/Diphenhydramine.jpg");        
        
        Product pharPro9 = pharmacy.getProductCatalog().newPharmacyProduct("Cephalexin", 12, "Antibiotics", true);
        pharPro9.setProductImageFilewithFilePath("src/Resources/ProductImages/Cephalexin.jpg");        
        
        Product pharPro10 = pharmacy.getProductCatalog().newPharmacyProduct("Acetaminophen", 28, "Acid Reducers", false);
        pharPro10.setProductImageFilewithFilePath("src/Resources/ProductImages/Acetaminophen.jpg");        
        
        Product pharPro11 = pharmacy.getProductCatalog().newPharmacyProduct("Omeprazole", 80, "Pain Relief", false);
        pharPro11.setProductImageFilewithFilePath("src/Resources/ProductImages/Omeprazole.jpg");
        
        Product pharPro12 = pharmacy.getProductCatalog().newPharmacyProduct("Hydrocodone", 35, "Blood Pressure", true);
        pharPro12.setProductImageFilewithFilePath("src/Resources/ProductImages/Hydrocodone.jpg");
        
        Product pharPro13 = pharmacy.getProductCatalog().newPharmacyProduct("Lisinopril", 40, "Cholesterol", true);
        pharPro13.setProductImageFilewithFilePath("src/Resources/ProductImages/Lisinopril.jpg");
        
        Product pharPro14 = pharmacy.getProductCatalog().newPharmacyProduct("Simvastatin", 20, "Diabetes", true);
        pharPro14.setProductImageFilewithFilePath("src/Resources/ProductImages/Simvastatin.jpg");
       
        Product pharPro15 = pharmacy.getProductCatalog().newPharmacyProduct("Metformin", 30, "Asthma", true);
        pharPro15.setProductImageFilewithFilePath("src/Resources/ProductImages/Metformin.jpg");
        
        Product pharPro16 = pharmacy.getProductCatalog().newPharmacyProduct("Albuterol", 18, "Inflammation", false);
        pharPro16.setProductImageFilewithFilePath("src/Resources/ProductImages/Albuterol.jpg");
        
        Product pharPro17 = pharmacy.getProductCatalog().newPharmacyProduct("Prednisone", 25, "Diuretics", true);
        pharPro17.setProductImageFilewithFilePath("src/Resources/ProductImages/Prednisone.jpg");
        
        Product pharPro18 = pharmacy.getProductCatalog().newPharmacyProduct("Furosemide", 45, "Asthma", true);
        pharPro18.setProductImageFilewithFilePath("src/Resources/ProductImages/Furosemide.jpg");
        
        Product pharPro19 = pharmacy.getProductCatalog().newPharmacyProduct("Montelukast", 38, "Blood Pressure", true);
        pharPro19.setProductImageFilewithFilePath("src/Resources/ProductImages/Montelukast.jpg");
       
        Product pharPro20 = pharmacy.getProductCatalog().newPharmacyProduct("Losartan", 50, "Inflammation", true);
        pharPro20.setProductImageFilewithFilePath("src/Resources/ProductImages/Losartan.jpg");
       
        
        Product groPro1 =grocery.getProductCatalog().newProduct("Apples", 2.99, "Fruits");
        groPro1.setProductImageFilewithFilePath("src/Resources/ProductImages/apple.jpeg");

        Product groPro2 =grocery.getProductCatalog().newProduct("Bananas", 1.99, "Fruits");
        groPro2.setProductImageFilewithFilePath("src/Resources/ProductImages/Bananas.jpg");

        Product groPro3 =grocery.getProductCatalog().newProduct("Chicken Breast", 5.99, "Meat");
        groPro3.setProductImageFilewithFilePath("src/Resources/ProductImages/Chicken Breast.jpg");

        Product groPro4 =grocery.getProductCatalog().newProduct("Ground Beef", 4.99, "Meat");
        groPro4.setProductImageFilewithFilePath("src/Resources/ProductImages/Ground Beef.jpg");        

        Product groPro5 =grocery.getProductCatalog().newProduct("Milk", 3.49, "Dairy");
        groPro5.setProductImageFilewithFilePath("src/Resources/ProductImages/Milk.jpg");

        Product groPro6 =grocery.getProductCatalog().newProduct("Eggs", 2.49, "Dairy");
        groPro6.setProductImageFilewithFilePath("src/Resources/ProductImages/Eggs.jpg");

        Product groPro7 =grocery.getProductCatalog().newProduct("Bread", 2.99, "Bakery");
        groPro7.setProductImageFilewithFilePath("src/Resources/ProductImages/Bread.jpg");

        Product groPro8 =grocery.getProductCatalog().newProduct("Butter", 2.99, "Dairy");
        groPro8.setProductImageFilewithFilePath("src/Resources/ProductImages/Butter.jpg");

        Product groPro9 =grocery.getProductCatalog().newProduct("Cheese", 4.99, "Dairy");
        groPro9.setProductImageFilewithFilePath("src/Resources/ProductImages/Cheese.jpg");

        Product groPro10 =grocery.getProductCatalog().newProduct("Rice", 2.99, "Grains");
        groPro10.setProductImageFilewithFilePath("src/Resources/ProductImages/Rice.jpg");

        Product groPro11 =grocery.getProductCatalog().newProduct("Pasta", 2.49, "Grains");
        groPro11.setProductImageFilewithFilePath("src/Resources/ProductImages/Pasta.jpg");

        Product groPro12 =grocery.getProductCatalog().newProduct("Tomatoes", 1.99, "Vegetables");
        groPro12.setProductImageFilewithFilePath("src/Resources/ProductImages/Tomatoes.jpg");

        Product groPro13 =grocery.getProductCatalog().newProduct("Carrots", 1.49, "Vegetables");
        groPro13.setProductImageFilewithFilePath("src/Resources/ProductImages/Carrots.jpg");

        Product groPro14 =grocery.getProductCatalog().newProduct("Broccoli", 1.99, "Vegetables");
        groPro14.setProductImageFilewithFilePath("src/Resources/ProductImages/Broccoli.jpg");

        Product groPro15 =grocery.getProductCatalog().newProduct("Lettuce", 1.99, "Vegetables");
        groPro15.setProductImageFilewithFilePath("src/Resources/ProductImages/Lettuce.jpg");        
    }

//      public static void servicefaker(ServicesOrganization hospital, ServicesOrganization lawOff,ServicesOrganization scouts,ServicesOrganization school){
//      Service hosServ1 = hospital.getServices().newService(n, 0, category, desc);
//      hosServ1.setProductImageFilewithFilePath("");
//      }


      public static void servicefaker(ServicesOrganization hospital, ServicesOrganization lawOff,ServicesOrganization scouts,ServicesOrganization school){
      Service hosServ1 = hospital.getServices().newService("Physical Therapy", 30, "Rehabilitation", "A type of treatment that helps individuals recover  maintain or improve physical abilities after an injury, illness, or surgery.");
      hosServ1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Physical Therapy.jpg");
      
      Service hosServ2 = hospital.getServices().newService("Occupational Therapy", 45, "Rehabilitation", "A type of therapy that focuses on helping people achieve independence in their daily activities after an illness injury or disability.");
      hosServ2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Occupational Therapy.jpg");      
      
      Service hosServ3 = hospital.getServices().newService("Speech Therapy", 60, "Rehabilitation", "A type of therapy that helps individuals improve communication and language skills  as well as swallowing disorders");
      hosServ3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Speech Therapy.jpg");      
      
      Service hosServ4 = hospital.getServices().newService("Medication Management", 15, "Medical Management", "A service that ensures seniors are taking their medication as prescribed and can include medication reminders administration and monitoring.");
      hosServ4.setProductImageFilewithFilePath("src/Resources/ServiceImages/Medication Management.jpg");      
      
      Service hosServ5 = hospital.getServices().newService("Tele-health Check-up", 30, "Physician Care", "A type of treatment that helps individuals recover  maintain or improve physical abilities after an injury, illness, or surgery.");
      hosServ5.setProductImageFilewithFilePath("src/Resources/ServiceImages/Tele-health Check-up.jpg");  
      
      Service lawOff1 = lawOff.getServices().newService("Estate Planning", 60, "Legal Services", "Estate planning is the process of arranging for the management and distribution of a person's estate during their life and after their death.");
      lawOff1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Estate Planning.jpg");

      Service lawOff2 = lawOff.getServices().newService("Elder Law", 30, "Legal Services", "Elder law is a specialized area of legal practice that focuses on the unique needs of older adults and their families.");
      lawOff2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Elder Law.jpg");

      Service lawOff3 = lawOff.getServices().newService("Medicaid Planning", 45, "Legal Services", "Medicaid planning is the process of arranging your finances in such a way as to qualify for Medicaid while still preserving as much of your assets as possible.");
      lawOff3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Medicaid Planning.jpg");

      Service lawOff4 = lawOff.getServices().newService("Social Security Benefits", 20, "Legal Services", "Social Security benefits are a federal program designed to provide financial assistance to retired  disabled and low-income individuals.");
      lawOff4.setProductImageFilewithFilePath("src/Resources/ServiceImages/Social Security Benefits.jpg");

      Service scouts1 = scouts.getServices().newService("Lawn Care", 90, "Home Services", "Boy Scouts of America volunteers can provide lawn care services for seniors who may have difficulty maintaining their yards. Services can include mowing, trimming, and weeding.");
      scouts1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Lawn Care.jpg");  

      Service scouts2 = scouts.getServices().newService("Technology Assistance", 30, "Home Services", "Many seniors struggle with technology and the Boy Scouts of America can help by providing technology assistance such as setting up and troubleshooting devices and teaching seniors how to use software and apps.");
      scouts2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Technology Assistance.jpg");  
     
      Service scouts3 = scouts.getServices().newService("Outdoor Activities", 120, "Physical Activity", "Boy Scouts of America volunteers can take seniors on outdoor activities such as nature walks  bird watching and camping trips. These activities can provide seniors with fresh air exercise and social interaction.");
      scouts3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Outdoor Activities.jpg");  
     
      Service school1 = school.getServices().newService("Reading Buddies", 30, "Companionship & Connection", "High school students can volunteer as reading buddies for seniors who enjoy reading or being read to. This can provide social interaction and mental stimulation for seniors.");
      school1.setProductImageFilewithFilePath("src/Resources/ServiceImages/Reading Buddies.jpg");
     
      Service school2 = school.getServices().newService("Puzzle Partners", 60, "Companionship & Connection", "High school students can play puzzles such as jigsaw puzzles crosswords and sudoku with seniors. This can provide mental stimulation and a fun way to spend time together.");
      school2.setProductImageFilewithFilePath("src/Resources/ServiceImages/Puzzle Partners.jpg");

      Service school3 = school.getServices().newService("Virtual Visits", 60, "Companionship & Connection", "High school students can volunteer to visit seniors virtually through video calls or phone calls. This can provide social interaction and a way for seniors to connect with others.");
      school3.setProductImageFilewithFilePath("src/Resources/ServiceImages/Virtual Visits.jpg");

      Service school4 = school.getServices().newService("Pet Therapy", 30, "Companionship & Connection", "High school students can bring well-behaved pets such as dogs or cats to visit seniors. This can provide companionship and emotional support for seniors who love animals.");
      school4.setProductImageFilewithFilePath("src/Resources/ServiceImages/Pet Therapy.jpg");     
      }
       
      

//      public static void servVolfaker(ServicesOrganization hospital, ServicesOrganization lawOff,ServicesOrganization scouts,ServicesOrganization school){
//          
//          Person d1 = this.personDirectory.createPerson("Dr. Rob");
//          hospital.getVolunteerDir().createNewVolunteer(d1, new )
//      }
      
      public static void convVolfaker(ConvenienceVolOrganization convVolOrg){
          Person vol1 = Network.personDirectory.createPerson("Dell Man");
          VolunteerProfile volProfile1 = convVolOrg.getVolunteerDir().createNewVolunteer(vol1, new ConvenienceVolunteerRole());
          UserAccount vol1ua = convVolOrg.getOrganizationAccountDirectory().createUserAccount("v1", "v1", new ConvenienceVolunteerRole());
          vol1.setUseraccount(vol1ua);
          vol1ua.setPerson(volProfile1);
         
          
          Person vol2 = Network.personDirectory.createPerson("Sandy Mae");
          VolunteerProfile volProfile2 = convVolOrg.getVolunteerDir().createNewVolunteer(vol2, new ConvenienceVolunteerRole());
          UserAccount vol2ua = convVolOrg.getOrganizationAccountDirectory().createUserAccount("v2", "v2", new ConvenienceVolunteerRole());
          vol2.setUseraccount(vol2ua);
          vol2ua.setPerson(volProfile2);
          
          Person vol3 = Network.personDirectory.createPerson("Joe F.");
          VolunteerProfile volProfile3 = convVolOrg.getVolunteerDir().createNewVolunteer(vol3, new ConvenienceVolunteerRole());
          UserAccount vol3ua = convVolOrg.getOrganizationAccountDirectory().createUserAccount("v3", "v3", new ConvenienceVolunteerRole());
          vol3.setUseraccount(vol3ua);
          vol3ua.setPerson(volProfile3);
          
          Person vol4 = Network.personDirectory.createPerson("Kevin Chang");
          VolunteerProfile volProfile4 = convVolOrg.getVolunteerDir().createNewVolunteer(vol4, new ConvenienceVolunteerRole());
          UserAccount vol4ua = convVolOrg.getOrganizationAccountDirectory().createUserAccount("v4", "v4", new ConvenienceVolunteerRole());
          vol4.setUseraccount(vol4ua);
          vol4ua.setPerson(volProfile4);
          
          Person vol5 = Network.personDirectory.createPerson("Michael Sager");
          VolunteerProfile volProfile5 = convVolOrg.getVolunteerDir().createNewVolunteer(vol5, new ConvenienceVolunteerRole());
          UserAccount vol5ua = convVolOrg.getOrganizationAccountDirectory().createUserAccount("v5", "v5", new ConvenienceVolunteerRole());
          vol5.setUseraccount(vol5ua);
          vol5ua.setPerson(volProfile5);
      }
          

      public static void servVolfaker(ServicesOrganization hospital, ServicesOrganization lawOff,ServicesOrganization scouts,ServicesOrganization school){
          //Doctor
          Person d1 = personDirectory.createPerson("Dr. Rob");
          VolunteerProfile volProfile1 = hospital.getVolunteerDir().createNewVolunteer(d1, new HealthcareSpecialistRole());
          UserAccount ua1 = hospital.getOrganizationAccountDirectory().createUserAccount("d1", "d1", new HealthcareSpecialistRole());
          hospital.getE().getUseraccountDirectory().getUserAccountList().add(ua1);        
          d1.setUseraccount(ua1);
          ua1.setPerson(volProfile1);
          
          Person d2 = personDirectory.createPerson("Dr. Lisa");
          VolunteerProfile volProfile2 = hospital.getVolunteerDir().createNewVolunteer(d2, new HealthcareSpecialistRole());
          UserAccount ua2 = hospital.getOrganizationAccountDirectory().createUserAccount("d2", "d2", new HealthcareSpecialistRole());
          hospital.getE().getUseraccountDirectory().getUserAccountList().add(ua2);
          d2.setUseraccount(ua2);
          ua2.setPerson(volProfile2);
          
          Person d3 = personDirectory.createPerson("Dr. Lisa");
          VolunteerProfile volProfile3 = hospital.getVolunteerDir().createNewVolunteer(d3, new HealthcareSpecialistRole());
          UserAccount ua3 = hospital.getOrganizationAccountDirectory().createUserAccount("d3", "d3", new HealthcareSpecialistRole());
          hospital.getE().getUseraccountDirectory().getUserAccountList().add(ua3);
          d3.setUseraccount(ua3);
          ua3.setPerson(volProfile3);
          
          //Legal
          Person l1 = personDirectory.createPerson("Charlie Esq.");
          VolunteerProfile volProfile4 = lawOff.getVolunteerDir().createNewVolunteer(l1, new LegalSpecialistRole());
          UserAccount ua4 = lawOff.getOrganizationAccountDirectory().createUserAccount("l1", "l1", new LegalSpecialistRole());
          lawOff.getE().getUseraccountDirectory().getUserAccountList().add(ua4);
          l1.setUseraccount(ua4);
          ua4.setPerson(volProfile4);
          
          Person l2 = personDirectory.createPerson("Rob Esq.");
          VolunteerProfile volProfile5 = lawOff.getVolunteerDir().createNewVolunteer(l2, new LegalSpecialistRole());
          UserAccount ua5 = lawOff.getOrganizationAccountDirectory().createUserAccount("l2", "l2", new LegalSpecialistRole());
          lawOff.getE().getUseraccountDirectory().getUserAccountList().add(ua5);
          l2.setUseraccount(ua5);
          ua5.setPerson(volProfile5);
          
          Person l3 = personDirectory.createPerson("Glenn Esq.");
          VolunteerProfile volProfile6 = lawOff.getVolunteerDir().createNewVolunteer(l3, new LegalSpecialistRole());
          UserAccount ua6 = lawOff.getOrganizationAccountDirectory().createUserAccount("l3", "l3", new LegalSpecialistRole());
          lawOff.getE().getUseraccountDirectory().getUserAccountList().add(ua6);
          l3.setUseraccount(ua6);
          ua6.setPerson(volProfile6);
          
          //Scout
          Person sc1 = personDirectory.createPerson("Eagle Badge");
          VolunteerProfile volProfile7 = scouts.getVolunteerDir().createNewVolunteer(sc1, new LegalSpecialistRole());
          UserAccount ua7 = scouts.getOrganizationAccountDirectory().createUserAccount("sc1", "sc1", new ConnectionVolunteerRole());
          scouts.getE().getUseraccountDirectory().getUserAccountList().add(ua7);
          sc1.setUseraccount(ua7);
          ua7.setPerson(volProfile7);
          
          Person sc2 = personDirectory.createPerson("Life Badge");
          VolunteerProfile volProfile8 = scouts.getVolunteerDir().createNewVolunteer(sc2, new LegalSpecialistRole());
          UserAccount ua8 = scouts.getOrganizationAccountDirectory().createUserAccount("sc2", "sc2", new ConnectionVolunteerRole());
          scouts.getE().getUseraccountDirectory().getUserAccountList().add(ua8);
          sc2.setUseraccount(ua8);
          ua8.setPerson(volProfile8);
          
          Person sc3 = personDirectory.createPerson("Ten DerFoot");
          VolunteerProfile volProfile9 = scouts.getVolunteerDir().createNewVolunteer(sc3, new LegalSpecialistRole());
          UserAccount ua9 = scouts.getOrganizationAccountDirectory().createUserAccount("sc3", "sc3", new ConnectionVolunteerRole());
          scouts.getE().getUseraccountDirectory().getUserAccountList().add(ua9);
          sc3.setUseraccount(ua9);
          ua9.setPerson(volProfile9);
          
          //School
          Person st1 = personDirectory.createPerson("Sally Student");
          VolunteerProfile volProfile10 = school.getVolunteerDir().createNewVolunteer(sc1, new LegalSpecialistRole());
          UserAccount ua10 = school.getOrganizationAccountDirectory().createUserAccount("st1", "st1", new ConnectionVolunteerRole());
          school.getE().getUseraccountDirectory().getUserAccountList().add(ua7);
          st1.setUseraccount(ua10);
          ua10.setPerson(volProfile10);
          
          Person st2 = personDirectory.createPerson("Ronny Class");
          VolunteerProfile volProfile11 = school.getVolunteerDir().createNewVolunteer(sc2, new LegalSpecialistRole());
          UserAccount ua11 = school.getOrganizationAccountDirectory().createUserAccount("st2", "st2", new ConnectionVolunteerRole());
          school.getE().getUseraccountDirectory().getUserAccountList().add(ua8);
          st2.setUseraccount(ua11);
          ua11.setPerson(volProfile11);
          
          Person st3 = personDirectory.createPerson("Skip Lunch");
          VolunteerProfile volProfile12 = school.getVolunteerDir().createNewVolunteer(sc3, new LegalSpecialistRole());
          UserAccount ua12 = school.getOrganizationAccountDirectory().createUserAccount("st3", "st3", new ConnectionVolunteerRole());
          school.getE().getUseraccountDirectory().getUserAccountList().add(ua9);
          st3.setUseraccount(ua12);
          ua12.setPerson(volProfile12);

      }
      
    public static void createServeOrgReqs(ServicesOrganization servOrg, Client c, int i){
        ArrayList<Service> hosServs = servOrg.getServices().getAllServices();
        ServiceOrder so = new ServiceOrder(c,hosServs.get(i), servOrg, "");
        ServiceRequest sr = (ServiceRequest) reqDir.createServiceRequest(c.getUseraccount(), so);
        sr.setRequester(c.getUseraccount());
    }
      
    public static void createConvenienceReqs(ProductOrganization phar, Client c, int idx){
        ArrayList<Product> pharProds = phar.getProductCatalog().getAllProducts();
        
        ArrayList<OrderItem> currOrd = new ArrayList<>();
            OrderItem oi = new OrderItem(pharProds.get(idx), 1); currOrd.add(oi);
            
            ProductOrder po = new ProductOrder(c, phar);
            po.setProductsPurchased(currOrd);
            c.addClientProductOrder(po);
        
            ConvenienceRequest cr = reqDir.createConvenienceRequest(c.getUseraccount(), po);
            cr.setRequester(c.getUseraccount());
        
    }
     public static void createPharDeliveryReqs(ProductOrganization phar, Client c, int idx){
        ArrayList<Product> pharProds = phar.getProductCatalog().getAllProducts();
        
        
        ArrayList<OrderItem> currOrd = new ArrayList<>();
            OrderItem oi = new OrderItem(pharProds.get(idx), 1); currOrd.add(oi);
            
            ProductOrder po = new ProductOrder(c, phar);
            po.setProductsPurchased(currOrd);
            c.addClientProductOrder(po);
        
            DeliveryRequest delReq = reqDir.createDeliveryRequest(c.getUseraccount(), po);
            delReq.setRequester(c.getUseraccount());
    }
     
    public static void createGroDeliveryReqs(ProductOrganization gro, Client c, int i){
        ArrayList<Product> groProds = gro.getProductCatalog().getAllProducts();
        
            ArrayList<OrderItem> currOrd = new ArrayList<>();
            OrderItem oi = new OrderItem(groProds.get(i), 1); currOrd.add(oi);
            
            ProductOrder po = new ProductOrder(c, gro);
            po.setProductsPurchased(currOrd);
            c.addClientProductOrder(po);
        
            DeliveryRequest delReq = reqDir.createDeliveryRequest(c.getUseraccount(), po);
            delReq.setRequester(c.getUseraccount());

    } 

      
    public void addIcon(int i, javax.swing.JLabel lbl){
        
        String filepath = "src/Resources/servelogo2.jpeg";
        if (i == 1){
             filepath = "src/Resources/servelogo1.jpeg";
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(filepath));
            Image image = bufferedImage.getScaledInstance(lbl.getWidth(),lbl.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            lbl.setIcon(icon);
        } catch (IOException ex) {
//            Logger.(HospitalMP.class.getName()).log(Level.ERROR, null, ex);
        }
       
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EnterpriseDirectory getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(EnterpriseDirectory enterprises) {
        this.enterprises = enterprises;
    }

    public UserAccountDirectory getTopLevelUserAccountDirectory() {
        return topLevelUserAccountDirectory;
    }

    public void setTopLevelUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.topLevelUserAccountDirectory = userAccountDirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public ApplicationDirectory getApplicantDirectory() {
        return applicantDirectory;
    }

    public RequestDirectory getReqDir() {
        return reqDir;
    }
    
    
}
