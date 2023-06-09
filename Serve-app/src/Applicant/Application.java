/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Applicant;

import Enterprise.Enterprise;
import Person.Client.Client;
import Person.Person;
import UserAccount.UserAccount;
import Volunteer.VolunteerProfile;
import java.util.Date;


/**
 *
 * @author siqiyang
 */
public class Application {
    private static int count = 0;
//    Enterprise e;
    String applicationId; 
    String status;
    Person person;
    Client client;
    VolunteerProfile volunteer;
    String username;
    String password;
    
     public Application(String name, String ssn, String address,
            Date dob, String email,String ecn, String ecname, String occ, String contactNum,String username, String password){
//        this.e = this.useraccount.getEnterprise();
        this.applicationId = "app" + count++;
        this.status = "Pending";
        this.username = username;
        this.password = password;
        this.person = new Person(name,ssn,address,
            dob,email, ecn, ecname, occ, contactNum);
        this.volunteer = new VolunteerProfile(this.person);
    }
     
     public Application(String name, String ssn, String address,
            Date dob, String email,String ecn, String ecname, String occ, String contactNum,String username, String password, String s){
//        this.e = this.useraccount.getEnterprise();
        this.applicationId = "app" + count++;
        this.status = "Pending";
        this.username = username;
        this.password = password;
        this.person = new Person(name,ssn,address,
            dob,email, ecn, ecname, occ, contactNum);
        this.client = new Client(this.person);
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
     
    
}
