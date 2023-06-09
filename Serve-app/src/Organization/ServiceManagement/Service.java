/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ServiceManagement;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class Service {
    private static int counter = 0;
    String sID;
    private String name;
    private int allottedTime;
    String category;
    String description;
    File productImageFile = new File( "src/Resources/NoImage.jpeg");
    
   ArrayList<ServiceOrder> renderedServices;
    
    public Service(String n, int t, String category,String cat,String desc) {
        sID = "sID" + counter++;
        name = n;
        allottedTime= t;
        this.category = cat;
        this.description=desc;
        renderedServices = new ArrayList<ServiceOrder>();
    }
   
    
    public int serviceHoursRendered(){
        int sum = 0;
        for (ServiceOrder so : renderedServices){
            sum += this.allottedTime;
        }
        return sum;
    }
    
    public ServiceOrder serviceOrdered(ServiceOrder so){
        renderedServices.add(so);
        return so;
    }
    
    public Service updateService(String newName, int newTime) {
        this.name = newName;
        this.allottedTime = newTime;
        return this; //returns itself
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Service.counter = counter;
    }

    public String getsID() {
        return sID;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAllottedTime() {
        return allottedTime;
    }

    public void setAllottedTime(int estimatedTime) {
        this.allottedTime = estimatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ServiceOrder> getRenderedServices() {
        return renderedServices;
    }

    public void setRenderedServices(ArrayList<ServiceOrder> renderedServices) {
        this.renderedServices = renderedServices;
    }

    
    public String getName() {
        return name;
    }
    
    public void setName(String n){
        name = n;
    }

    public File getProductImageFile() {
        return productImageFile;
    }

    public void setServiceImageFile(File productImageFile) {
        this.productImageFile = productImageFile;
    }
    
    public void setProductImageFilewithFilePath(String productImageFilePath) {
        this.productImageFile = new File(productImageFilePath );
    }
    
    @Override
    public String toString(){
        return name;
    }
    

}
