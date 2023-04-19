/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Applicant;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author siqiyang
 */
public class ApplicationDirectory {
    ArrayList<Application> applicationList;
    
    public ApplicationDirectory(){
        this.applicationList = new ArrayList();
    }

    
    
    public Application createApplication(String name, String ssn, String address,
            Date dob, String email,String ecn, String ecname, String occ, String contactNum, 
            String username, String password){
        Application a = new Application(name,ssn,address,
            dob,email, ecn, ecname, occ, contactNum,username,password);
        this.applicationList.add(a);
        return a;
    }
    


    public ArrayList<Application> getApplicationList() {
        return applicationList;
    }
    
     
}
