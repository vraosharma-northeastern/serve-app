/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.SystemAdminWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import UI.MainJFrame;
import UserAccount.UserAccount;

/**
 *
 * @author siqiyang
 */
public class SystemAdminJFrame extends javax.swing.JFrame {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    Organization organization;
    
    /**
     * Creates new form SystemAdminJFrame
     */
    public SystemAdminJFrame(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
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

        jSplitPane1 = new javax.swing.JSplitPane();
        controlPanel = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        userAcccountBtn = new javax.swing.JButton();
        employeetBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(800, 800));

        controlPanel.setBackground(new java.awt.Color(255, 255, 255));
        controlPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setText("LOGOUT");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        controlPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, 30));

        userAcccountBtn.setText("Manage Enterprise Admin");
        userAcccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAcccountBtnActionPerformed(evt);
            }
        });
        controlPanel.add(userAcccountBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 210, 60));

        employeetBtn.setText("Manage Application Manager");
        employeetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeetBtnActionPerformed(evt);
            }
        });
        controlPanel.add(employeetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 190, 60));

        jSplitPane1.setTopComponent(controlPanel);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jSplitPane1.setRightComponent(jPanel1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        new MainJFrame(appSystem, enterprise,organization,useraccount);
    }//GEN-LAST:event_backBtnActionPerformed

    private void userAcccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAcccountBtnActionPerformed
        // TODO add your handling code here:
        jSplitPane1.setRightComponent(new EnterpriseManagementJPanel(appSystem, enterprise,organization,useraccount));
    }//GEN-LAST:event_userAcccountBtnActionPerformed

    private void employeetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeetBtnActionPerformed
        // TODO add your handling code here:
        jSplitPane1.setRightComponent(new ApplicantManagerManageJPanel(appSystem,enterprise,organization,useraccount));
    }//GEN-LAST:event_employeetBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SystemAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SystemAdminJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton employeetBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton userAcccountBtn;
    // End of variables declaration//GEN-END:variables
}