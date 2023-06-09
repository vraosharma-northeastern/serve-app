/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ProductManagement;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class Product {
    private static int counter = 0;
    String pID;
    private String name;
    private double price;
    String category;
    boolean prescriptionRequired;
    File productImageFile = new File( "src/Resources/NoImage.jpeg");
    
    ArrayList<OrderItem> orderitems;
    
    public Product(String n, double p, String category) {
        pID = "pID" + counter++;
        name = n;
        price = p;
        this.prescriptionRequired = false;
        orderitems = new ArrayList();
    }
    
    public Product(String n, double p, String category, boolean perscribed) {
        pID = "pID" + counter++;
        name = n;
        price = p;
        this.category = category;
        this.prescriptionRequired = perscribed;
        orderitems = new ArrayList();
    }
    
    public double productRevenue(){
        double sum = 0;
        for (OrderItem oi : orderitems){
            sum += oi.getOrderItemRevenue();
        }
        return sum;
    }
    
    public Product updateProduct(String newName, double newPrice) {
        this.name = newName;
        this.price = newPrice;
        return this; //returns itself
    }
    
    public void addOrderItem(OrderItem oi){     
        orderitems.add(oi);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Product.counter = counter;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public ArrayList<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(ArrayList<OrderItem> orderitems) {
        this.orderitems = orderitems;
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

    public void setProductImageFile(File productImageFile) {
        this.productImageFile = productImageFile;
    }
    
    public void setProductImageFilewithFilePath(String productImageFilePath) {
        this.productImageFile = new File(productImageFilePath );
    }
    
    
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
    

}
