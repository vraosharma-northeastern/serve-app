/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.EnterpriseManagerWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductOrganization;
import Person.Person;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import WorkAreas.OrganizationManagerRole;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author siqiyang
 */
public class OrganizationManagementJPanel extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    Organization organization;
    DefaultTableModel viewtableModel;
    /**
     * Creates new form OrganizationManagementJPanel
     */
    public OrganizationManagementJPanel(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;
        this.viewtableModel = (DefaultTableModel) jTable1.getModel();
        populateOrganization();
        tablePopulate();
    }
    
    public void populateOrganization() {  
        if(enterprise.getName().equals("Convenience")){
            organizationNameBox.addItem("CVS");
            organizationNameBox.addItem("Trader Joe");
        }else if(enterprise.getName().equals("Healthcare")){
            organizationNameBox.addItem("Beth Israel");
            
        }else if(enterprise.getName().equals("Connection")){
            organizationNameBox.addItem("Boy Scouts"); 
            organizationNameBox.addItem("Brookline High School"); 
        }else if(enterprise.getName().equals("Legal")){
            organizationNameBox.addItem("Burns and Levinson LLP");
    }
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateEnterpriseBtn = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        DeleteEnterpriseBtn = new javax.swing.JButton();
        organizationNameBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addEnterpriseManagerBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateNameField = new javax.swing.JTextField();
        updatePasswordTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        updateEnterpriseBtn.setText("Update Organization  Manager");
        updateEnterpriseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEnterpriseBtnActionPerformed(evt);
            }
        });

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        DeleteEnterpriseBtn.setText("Delete Organization  Manager");
        DeleteEnterpriseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEnterpriseBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("User Name:");

        jLabel2.setText("Manager Name:");

        addEnterpriseManagerBtn.setText("Add Organization Manager");
        addEnterpriseManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnterpriseManagerBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Organization Name: ");

        jLabel4.setText("Password");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ent Name", "Org Name", "Manager Name", "Username", "Password"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setText("Update Manager Name:");

        jLabel6.setText("Update Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel6)
                .addContainerGap(546, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(addEnterpriseManagerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addComponent(DeleteEnterpriseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateEnterpriseBtn)
                            .addGap(39, 39, 39))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nameField)
                                        .addComponent(organizationNameBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(usernameField)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(updatePasswordTextField)
                                        .addComponent(updateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(13, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(78, 78, 78))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(organizationNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))))
                    .addGap(48, 48, 48)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addEnterpriseManagerBtn)
                        .addComponent(DeleteEnterpriseBtn)
                        .addComponent(updateEnterpriseBtn))
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGap(18, 18, 18)
                    .addComponent(updatePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addEnterpriseManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnterpriseManagerBtnActionPerformed
        // TODO add your handling code here:
        //        Enterprise enterprise = this.appSystem.getEnterprises().createEnterprise(enterpriseField.getText(), (String) typeComboBox.getSelectedItem());
        //
        //        JOptionPane.showMessageDialog(null, "Enterprise Created");
        //        displayEnterpriseInfo();
        Boolean foundDuplicate = false;
        
        
        for(Enterprise enterprise: this.appSystem.getEnterprises().getEnterpiseList()){
            UserAccountDirectory entUserAccDir = enterprise.getUseraccountDirectory();
            if(entUserAccDir.accountExists(usernameField.getText(), passwordField.getText())) {
                    foundDuplicate = true;
                    JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
                    break;
                }
            if(foundDuplicate==false){
                
           
            for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
                UserAccountDirectory orgUserAccDir = org.getOrganizationAccountDirectory();
                if(orgUserAccDir != null){
                    if(orgUserAccDir.accountExists(usernameField.getText(), passwordField.getText())){
                        foundDuplicate = true;
                        JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
                        break;
                    }
                }
            }
        }}
        UserAccountDirectory ua = this.appSystem.getTopLevelUserAccountDirectory();
        if(foundDuplicate==false){
        if(ua.accountExists(usernameField.getText(), passwordField.getText())) {
            foundDuplicate = true;
            JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
        }}
        if(foundDuplicate == false) {
            Organization o = enterprise.getOrganizationDirectory().findOrganization((String) organizationNameBox.getSelectedItem());
            if (o != null){
                //create new Org Manager for selected organization
                UserAccount newManager = o.getOrganizationAccountDirectory().createUserAccount(usernameField.getText(), passwordField.getText(), new OrganizationManagerRole());
                //assign person to useraccount
                Person p = appSystem.getPersonDirectory().createPerson( newManager.getAccountId(), nameField.getText());
                //set this useraccount as the manager role
                o.setOrganizationManager(newManager);
                //add this user account to the enterprise 
                o.getE().getUseraccountDirectory().getUserAccountList().add(newManager);
                appSystem.getTopLevelUserAccountDirectory().getUserAccountList().add(newManager);
            }
        
//                            
//            Enterprise e = appSystem.getEnterprises().findEnterprise((String) organizationNameBox.getSelectedItem());
//            
//            if(e.getUseraccountDirectory().getUserAccountList().size()==0){
//                UserAccount user= e.getUseraccountDirectory().createUserAccount(usernameField.getText(), passwordField.getText(), new EnterpriseManagerRole());
//                Person p = appSystem.getPersonDirectory().createPerson( user.getAccountId(), nameField.getText());
//                user.setPerson(p);
//                JOptionPane.showMessageDialog(null, "Manager created");
//            }
           
            } else{
                JOptionPane.showMessageDialog(null, "Manager exists");

            tablePopulate();
        }
        tablePopulate();
    }//GEN-LAST:event_addEnterpriseManagerBtnActionPerformed

    private void DeleteEnterpriseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEnterpriseBtnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_DeleteEnterpriseBtnActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void updateEnterpriseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEnterpriseBtnActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_updateEnterpriseBtnActionPerformed
//    public void  tablePopulate() {
//        
//        ArrayList<Enterprise> enterprise = this.appSystem.getEnterprises().getEnterpiseList();
//        
//        if(enterprise.size()>0){
//            viewtableModel.setRowCount(0);
//            for (Enterprise e : enterprise){
//                for(UserAccount u: e.getUseraccountDirectory().getUserAccountList()){
//                Object row[] = new Object[5];
//                row[0] = e;
//                row[1] =u;
//                row[2] = u.getPerson().getName();
//                row[3] = u.getUserName();
//                row[4] = u.getPassword();
//
//             
//                viewtableModel.addRow(row);
//            }
//          } 
//        } else {
//            System.out.print("");
//        }
//    }
    
    public void  tablePopulate() {
        

         ArrayList<Organization> organization = enterprise.getOrganizationDirectory().getOrganizationList();
        

         if(organization.size()>0){
            viewtableModel.setRowCount(0);

            for (Organization o: organization){
                
                UserAccount u = o.getOrganizationManager();
                if(o.getOrganizationManager()!=null){
                Object row[] = new Object[5];
                row[0] = enterprise;
                row[1] =o;
                row[2] = u.getPerson().getName();
                row[3] = u.getUserName();
                row[4] = u.getPassword();

             
                viewtableModel.addRow(row);
            }
            
            }
               
          
        }else {
            System.out.print("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteEnterpriseBtn;
    private javax.swing.JButton addEnterpriseManagerBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JComboBox<String> organizationNameBox;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton updateEnterpriseBtn;
    private javax.swing.JTextField updateNameField;
    private javax.swing.JTextField updatePasswordTextField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
