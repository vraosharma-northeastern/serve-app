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
import WorkAreas.OrganizationManagerRole;
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
    DefaultTableModel tableModel;
    /**
     * Creates new form EmployeeManagementJPanel
     */
    public ApplicantManagerManageJPanel(Network appSystem,Enterprise enterprise, Organization organization, UserAccount useraccount) {
        initComponents();
        
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;        
        this.tableModel = (DefaultTableModel) jTable1.getModel();
        
        populateDesignation();   
        populateEnterpriseDropdown();
        tablePopulate();               
    }
        
    public void populateDesignation() {
   
        designationComboBox.addItem("Relation Manager");
        designationComboBox.addItem("Application Manager");
        
    }
    
    public void populateEnterpriseDropdown(){
        ArrayList<Enterprise> enterprise = this.appSystem.getEnterprises().getEnterpiseList();
        
        for(Enterprise e: enterprise){
           jComboBox1.addItem(e);
        }
    }
    
    public void tablePopulate() {
        
        tableModel.setRowCount(0);
        for(Enterprise e: this.appSystem.getEnterprises().getEnterpiseList()) {
            for(UserAccount u: e.getUseraccountDirectory().getUserAccountList()){
                
   
            Object[] row = new Object[6];
            
            row[0] = e.getName();
            row[1] = u.getAccountId();
            row[2] = u.getPerson().getName();
            row[3] =u.getUserName();
            row[4] =u.getPassword();
            row[5] =u.getRole();
            tableModel.addRow(row);
        }
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

        fieldusername = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        userNameLabel2 = new javax.swing.JLabel();
        designationComboBox = new javax.swing.JComboBox<>();
        fieldPassword = new javax.swing.JTextField();
        designationLabel1 = new javax.swing.JLabel();
        addBtn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        userNameLabel3 = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();

        jLabel2.setText("Assign Enterprise");

        userNameLabel2.setText("User Name");

        designationLabel1.setText("Designation");

        addBtn1.setText("Add Employee");
        addBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise", "ID", "Name", "Username", "Password", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        userNameLabel3.setText("Name");

        passwordLabel1.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(addBtn1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLabel1)
                                .addGap(22, 22, 22)
                                .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(designationLabel1)
                                .addGap(22, 22, 22)
                                .addComponent(designationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(userNameLabel3))
                                    .addComponent(userNameLabel2))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldusername, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(userNameLabel3))
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNameLabel2)
                            .addComponent(fieldusername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(passwordLabel1))
                            .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(designationLabel1)
                            .addComponent(designationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(addBtn1)
                .addGap(172, 172, 172))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed
        // TODO add your handling code here:
               Boolean foundDuplicate = false;

//        for(Enterprise enterprise: this.appSystem.getEnterprises().getEnterpiseList()){
//            UserAccountDirectory ua = enterprise.getUseraccountDirectory();
//        
//            if(ua.accountExists(fieldusername.getText(), fieldPassword.getText())) {
//                foundDuplicate = true;
//                JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
//                break;
//            }
//            
//        }
//        UserAccountDirectory ua = this.appSystem.getTopLevelUserAccountDirectory();
//        if(ua.accountExists(fieldusername.getText(), fieldPassword.getText())) {
//            foundDuplicate = true;
//            JOptionPane.showMessageDialog(null, "Sorry credentials are taken.");
//        }
//        if(foundDuplicate == false) {
//            Enterprise e= (Enterprise) jComboBox1.getSelectedItem();
//
//            //boolean i=this.branch.getLibrary().getEmployeDirectory().checkEmployeeUnique(Integer.valueOf(user.getAccountId()));
//            if(designationComboBox.getSelectedItem().equals("Enterprise Manager") ){
//                //
//                UserAccount user= e.getUseraccountDirectory().createUserAccount(fieldusername.getText(), fieldPassword.getText(), new OrganizationManagerRole());
//                Person p = appSystem.getPersonDirectory().createPerson( user.getAccountId(), nameField.getText());
//                user.setPerson(p);
//
//            }else if(designationComboBox.getSelectedItem().equals("Application Manager") ){
//                UserAccount user= e.getUseraccountDirectory().createUserAccount(fieldusername.getText(), fieldPassword.getText(), new ApplicationManagerRole());
//                Person p = appSystem.getPersonDirectory().createPerson( user.getAccountId(), nameField.getText());
//                user.setPerson(p);
//            }
//
//            tablePopulate();
//        }
// 
    }//GEN-LAST:event_addBtn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn1;
    private javax.swing.JComboBox<String> designationComboBox;
    private javax.swing.JLabel designationLabel1;
    private javax.swing.JTextField fieldPassword;
    private javax.swing.JTextField fieldusername;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel userNameLabel2;
    private javax.swing.JLabel userNameLabel3;
    // End of variables declaration//GEN-END:variables
}