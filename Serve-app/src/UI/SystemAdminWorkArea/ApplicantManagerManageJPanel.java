/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdminWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Person.Person;
import Person.PersonDirectory;
import UserAccount.UserAccount;
import UserAccount.UserAccountDirectory;
import WorkAreas.ApplicationManagerRole;
import WorkAreas.ProductOrganizationManagerRole;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author siqiyang
 */
public class ApplicantManagerManageJPanel extends javax.swing.JPanel {
    private UserAccount useraccount;
    private Network appSystem;
    Enterprise enterprise;
    Organization organization;
    DefaultTableModel viewtableModel;
    /**
     * Creates new form EmployeeManagementJPanel
     */
    public ApplicantManagerManageJPanel(Network appSystem,Enterprise enterprise, Organization organization, UserAccount useraccount) {
        initComponents();
        
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;        
        this.viewtableModel = (DefaultTableModel) jTable1.getModel();
        
        tablePopulate();
    }

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DeleteApplicationManageBtn = new javax.swing.JButton();
        addApplicationManagerBtn = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        updateApplicationManagerBtn = new javax.swing.JButton();
        updateNameField = new javax.swing.JTextField();
        updatePasswordTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User ID", "Manager Name", "Username", "Password"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        DeleteApplicationManageBtn.setText("Delete Application Manager");
        DeleteApplicationManageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteApplicationManageBtnActionPerformed(evt);
            }
        });

        addApplicationManagerBtn.setText("Add Application Manager");
        addApplicationManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addApplicationManagerBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Manager Name:");

        jLabel3.setText("User Name:");

        jLabel4.setText("Password");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        updateApplicationManagerBtn.setText("Update Application Manager");
        updateApplicationManagerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateApplicationManagerBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Update Manager Name:");

        jLabel6.setText("Update Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField)
                    .addComponent(usernameField)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(553, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateApplicationManagerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(addApplicationManagerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addComponent(DeleteApplicationManageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(updatePasswordTextField)
                                        .addComponent(updateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addContainerGap(37, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
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
                    .addComponent(jLabel4))
                .addGap(81, 81, 81)
                .addComponent(updateApplicationManagerBtn)
                .addContainerGap(217, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(68, 68, 68)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addApplicationManagerBtn)
                        .addComponent(DeleteApplicationManageBtn))
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updatePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addContainerGap(96, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addApplicationManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addApplicationManagerBtnActionPerformed
        // TODO add your handling code here:
        Boolean foundDuplicate = false;

        for(Enterprise enterprise: this.appSystem.getEnterprises().getEnterpiseList()){
            UserAccountDirectory ua = enterprise.getUseraccountDirectory();

            if(ua.accountExists(usernameField.getText(), passwordField.getText())) {
                foundDuplicate = true;
                JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
                break;
            }

        }
        UserAccountDirectory ua = this.appSystem.getTopLevelUserAccountDirectory();
        if(ua.accountExists(usernameField.getText(), passwordField.getText())) {
            foundDuplicate = true;
            JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
        }
        if(foundDuplicate == false){
                Person p = appSystem.getPersonDirectory().createPerson( nameField.getText());
                UserAccount applicationManager =appSystem.getTopLevelUserAccountDirectory().createUserAccount(usernameField.getText(), passwordField.getText(), new ApplicationManagerRole());
                applicationManager.setPerson(p);
                JOptionPane.showMessageDialog(null, "Application Manager created");
            }else{
                JOptionPane.showMessageDialog(null, "Application Manager exists");
            }

            tablePopulate();
        
        
    }//GEN-LAST:event_addApplicationManagerBtnActionPerformed

    private void DeleteApplicationManageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteApplicationManageBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        UserAccount u = (UserAccount) jTable1.getValueAt(selectedRow, 0);
        this.appSystem.getTopLevelUserAccountDirectory().deleteApplicationManager(u);
        if (this.appSystem.getTopLevelUserAccountDirectory().getUserAccountList().size()>0){
            tablePopulate();
        }else{
            viewtableModel.setRowCount(0);
        }
    }//GEN-LAST:event_DeleteApplicationManageBtnActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void updateApplicationManagerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateApplicationManagerBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
        UserAccount u = (UserAccount) jTable1.getValueAt(selectedRow, 0);
        u.getPerson().setName(updateNameField.getText());
        u.setPassword(updatePasswordTextField.getText());

        tablePopulate();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
    }//GEN-LAST:event_updateApplicationManagerBtnActionPerformed
    public void  tablePopulate() {
        ArrayList<UserAccount> userAccount = this.appSystem.getTopLevelUserAccountDirectory().getUserAccountList();
        
        if(userAccount.size()>0){
            viewtableModel.setRowCount(0);
                for(UserAccount u: appSystem.getTopLevelUserAccountDirectory().getUserAccountList()){
                    if(u.getRole().getRoleType().equals("Application Manager")){
                        Object row[] = new Object[4];
                        row[0] =u;
                        row[1] = u.getPerson().getName();
                        row[2] = u.getUserName();
                        row[3] = u.getPassword();


                        viewtableModel.addRow(row);
                    }
                }       
        } else {
            System.out.print("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteApplicationManageBtn;
    private javax.swing.JButton addApplicationManagerBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton updateApplicationManagerBtn;
    private javax.swing.JTextField updateNameField;
    private javax.swing.JTextField updatePasswordTextField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}