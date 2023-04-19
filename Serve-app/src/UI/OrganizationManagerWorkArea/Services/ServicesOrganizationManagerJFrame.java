/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.OrganizationManagerWorkArea.Services;

import UI.OrganizationManagerWorkArea.Product.*;
import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductOrganization;
import Organization.ServicesOrganization;
import UI.MainJFrame;
import UserAccount.UserAccount;

/**
 *
 * @author vraosharma
 */
public class ServicesOrganizationManagerJFrame extends javax.swing.JFrame {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    ServicesOrganization organization;
    /**
     * Creates new form OrganizationManagerJFrame
     */
    public ServicesOrganizationManagerJFrame() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public ServicesOrganizationManagerJFrame(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = (ServicesOrganization) organization;
        this.setLocationRelativeTo(null);
        test();
    }
    
    public void test(){
        jLabel1.setText(String.valueOf(this.useraccount.getUserName()));
        jLabel2.setText(String.valueOf(this.enterprise.getName()));
        jLabel3.setText(String.valueOf(this.organization.getName()));
        jLabel4.setText(String.valueOf(this.organization.getClass()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        servicesCatalogBtn = new javax.swing.JButton();
        productReportBtn = new javax.swing.JButton();
        productReportBtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel4.setText("jLabel1");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(16, 452, 42, 17);

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(16, 371, 42, 17);

        jLabel2.setText("jLabel1");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(16, 325, 42, 17);

        jLabel3.setText("jLabel1");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(16, 417, 42, 17);

        backBtn.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        backBtn.setText("LOGOUT");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn);
        backBtn.setBounds(16, 24, 80, 24);

        servicesCatalogBtn.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        servicesCatalogBtn.setText("My Services");
        servicesCatalogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesCatalogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(servicesCatalogBtn);
        servicesCatalogBtn.setBounds(6, 102, 141, 24);

        productReportBtn.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productReportBtn.setText("My Reports");
        productReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtnActionPerformed(evt);
            }
        });
        jPanel1.add(productReportBtn);
        productReportBtn.setBounds(6, 132, 141, 24);

        productReportBtn1.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productReportBtn1.setText("Create Application");
        productReportBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(productReportBtn1);
        productReportBtn1.setBounds(6, 162, 141, 24);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1300, 800));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MainJFrame(appSystem, enterprise,organization,useraccount);
    }//GEN-LAST:event_backBtnActionPerformed

    private void servicesCatalogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicesCatalogBtnActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new myServicesJPanel(appSystem, enterprise,organization,useraccount));      
    }//GEN-LAST:event_servicesCatalogBtnActionPerformed

    private void productReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productReportBtnActionPerformed

    private void productReportBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtn1ActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new ManageApplicationsJPanel(appSystem, enterprise,organization,useraccount));
        
    }//GEN-LAST:event_productReportBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(ServicesOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicesOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicesOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicesOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ServicesOrganizationManagerJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton productReportBtn;
    private javax.swing.JButton productReportBtn1;
    private javax.swing.JButton servicesCatalogBtn;
    // End of variables declaration//GEN-END:variables
}
