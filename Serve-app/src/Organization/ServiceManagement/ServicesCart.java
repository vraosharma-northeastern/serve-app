/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ServiceManagement;


import Organization.ServicesOrganization;
import Person.Client.Client;
import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class ServicesCart {
    ArrayList<Service> serviceCart;
    
    public ServicesCart(){
        serviceCart = new ArrayList<>();
    }
    
    //add to cart
    public Service addToCart(Service s){
        serviceCart.add(s);
        return s;
    }
    
    //process cart/ order items, add each order item to selected product's <OrderItem>
    public ArrayList<ServiceOrder> processCart(Client client, ServicesOrganization servOrg, ArrayList<String> reqDets){
        ArrayList<ServiceOrder> tempCart = new ArrayList<ServiceOrder>();
        if (this.serviceCart != null){
            int idx = 0;
            for(Service s : serviceCart){
                ServiceOrder so = new ServiceOrder(client, s, servOrg, reqDets.get(idx));
                tempCart.add(so);
                idx++;
            }
        }
        emptyCart();
        return tempCart;
    }
    //empty cart, create new product cart
    public void emptyCart(){
        this.serviceCart = new ArrayList<>(); 
    }
    
    public boolean isInCart(Service s){
        if(this.serviceCart.contains(s)){
            return true;
        }
        return false;
    }
    
    public ArrayList<Service> getStagedServicesinCart() {
        return serviceCart;
    }

    public void setServiceCart(ArrayList<Service> serviceCart) {
        this.serviceCart = serviceCart;
    }

    
}
