/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WorkAreas;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import UI.ApplicationManagerWorkArea.ApplicationManagerJFrame;
import UserAccount.UserAccount;
import javax.swing.JFrame;

/**
 *
 * @author siqiyang
 */
public class ApplicationManagerRole extends AbstractRole {
    public ApplicationManagerRole(){
        super.roleType = "Application Manager";
    }      

    
    @Override
    public JFrame createWorkArea(Network applicationSystem,Enterprise enterprise, Organization organization, UserAccount useraccount) {
        return new ApplicationManagerJFrame(applicationSystem, enterprise, organization,useraccount);
    }  
    
    @Override
    public String toString() {
        return "Application Manager";
    }  
}
