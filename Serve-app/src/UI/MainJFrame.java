/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import UserAccount.UserAccount;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author siqiyang
 */
public class MainJFrame extends javax.swing.JFrame {
        private Network appSystem; 
        private UserAccount useraccount;
        Enterprise enterprise;
        Organization organization;
                
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        
        
        this.setLocationRelativeTo(null);
        this.appSystem = Network.createSystemInstance();
    }
    
    public MainJFrame(Network appSystem,Enterprise enterprise, Organization organization, UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;

    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Left = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        right = new java.awt.Panel();
        userNameField = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clientSignUpBtn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        volunteerSignUpBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1300, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 800));
        jPanel1.setLayout(null);

        Left.setBackground(new java.awt.Color(236, 100, 44));
        Left.setPreferredSize(new java.awt.Dimension(650, 800));

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel3)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(0, 0, 650, 800);

        right.setBackground(new java.awt.Color(255, 255, 255));
        right.setPreferredSize(new java.awt.Dimension(650, 800));

        userNameField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        loginBtn.setBackground(new java.awt.Color(236, 100, 44));
        loginBtn.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Log in");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setText("User Name:");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("Password:");

        clientSignUpBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        clientSignUpBtn.setForeground(new java.awt.Color(236, 100, 44));
        clientSignUpBtn.setText("New Client?");
        clientSignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientSignUpBtnActionPerformed(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Krub", 1, 44)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 100, 44));
        jLabel4.setText("Welcome");

        volunteerSignUpBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        volunteerSignUpBtn.setForeground(new java.awt.Color(236, 100, 44));
        volunteerSignUpBtn.setText("New Volunteer?");
        volunteerSignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volunteerSignUpBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addGap(0, 251, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(206, 206, 206))
            .addGroup(rightLayout.createSequentialGroup()
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                                .addComponent(passwordField))
                            .addGroup(rightLayout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(loginBtn))))
                    .addGroup(rightLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(volunteerSignUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clientSignUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel4)
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginBtn)
                .addGap(40, 40, 40)
                .addComponent(clientSignUpBtn)
                .addGap(12, 12, 12)
                .addComponent(volunteerSignUpBtn)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        jPanel1.add(right);
        right.setBounds(650, 0, 650, 800);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientSignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientSignUpBtnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_clientSignUpBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:

        Boolean foundUser = false;
        Boolean orgLevel = false;
        Boolean entLevel = false;
        for(Enterprise enterprise: this.appSystem.getEnterprises().getEnterpiseList()) {
            for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
                if(org.getOrganizationAccountDirectory().authenticateUser(passwordField.getText(), userNameField.getText()) != null) {
                    UserAccount orgLvlUser = org.getOrganizationAccountDirectory().authenticateUser(String.valueOf(passwordField.getPassword()), userNameField.getText());
                    foundUser = true; orgLevel = true;
                    orgLvlUser.getRole().createWorkArea(appSystem, enterprise, org, orgLvlUser);
                    this.setVisible(false);
                }
            }
        }
        if(!orgLevel){
            for(Enterprise enterprise: this.appSystem.getEnterprises().getEnterpiseList()) {
                if(enterprise.getUseraccountDirectory().authenticateUser(passwordField.getText(), userNameField.getText()) != null) {
                    UserAccount entLvlUser = enterprise.getUseraccountDirectory().authenticateUser(passwordField.getText(), userNameField.getText());
                    foundUser = true;
                    entLvlUser.getRole().createWorkArea(appSystem, enterprise, organization, entLvlUser);
                    this.setVisible(false);
                }
            }
        }
        if (!orgLevel && !entLevel){
            if(this.appSystem.getTopLevelUserAccountDirectory().authenticateUser(userNameField.getText(), passwordField.getText()) != null) {
                UserAccount sysLvlUser = this.appSystem.getTopLevelUserAccountDirectory().authenticateUser(userNameField.getText(), passwordField.getText());
                foundUser = true;
                sysLvlUser.getRole().createWorkArea(appSystem, enterprise, organization, sysLvlUser);
                this.setVisible(false);
            }
        }
        if(!foundUser) {
            JOptionPane.showMessageDialog(null, "Invalid Credentials");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void volunteerSignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volunteerSignUpBtnActionPerformed
        // TODO add your handling code here:
        VolunteerSignUp volunteerSignUp = new VolunteerSignUp(this.appSystem,
                this.appSystem.getEnterprises().findEnterprise("Convenience")
                        .getOrganizationDirectory().findOrganizationbyType("Volunteer"));
        volunteerSignUp.setVisible(true);
        volunteerSignUp.pack();
        volunteerSignUp.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_volunteerSignUpBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel Left;
    private javax.swing.JButton clientSignUpBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private java.awt.Panel right;
    private javax.swing.JTextField userNameField;
    private javax.swing.JButton volunteerSignUpBtn;
    // End of variables declaration//GEN-END:variables
}
