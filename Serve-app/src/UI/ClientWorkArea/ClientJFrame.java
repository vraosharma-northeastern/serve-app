/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.ClientWorkArea;

import UI.OrganizationManagerWorkArea.Product.*;
import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductOrganization;
import UI.MainJFrame;
import UserAccount.UserAccount;

/**
 *
 * @author vraosharma
 */
public class ClientJFrame extends javax.swing.JFrame {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    Organization organization;
    /**
     * Creates new form OrganizationManagerJFrame
     */
    public ClientJFrame() {
        initComponents();
        this.setVisible(true);
    }
    
    public ClientJFrame(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        productCatalogBtn = new javax.swing.JButton();
        productReportBtn = new javax.swing.JButton();
        productReportBtn1 = new javax.swing.JButton();
        productReportBtn2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("jLabel1");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel1");

        jLabel3.setText("jLabel1");

        backBtn.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        backBtn.setText("LOGOUT");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        productCatalogBtn.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productCatalogBtn.setText("Convenience");
        productCatalogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCatalogBtnActionPerformed(evt);
            }
        });

        productReportBtn.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productReportBtn.setText("Legal");
        productReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtnActionPerformed(evt);
            }
        });

        productReportBtn1.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productReportBtn1.setText("Health");
        productReportBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtn1ActionPerformed(evt);
            }
        });

        productReportBtn2.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productReportBtn2.setText("Connection");
        productReportBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productReportBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(backBtn))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productCatalogBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productReportBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(productReportBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addGap(62, 62, 62)
                .addComponent(productCatalogBtn)
                .addGap(74, 74, 74)
                .addComponent(productReportBtn)
                .addGap(18, 18, 18)
                .addComponent(productReportBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(331, 331, 331))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(productReportBtn1)
                    .addContainerGap(805, Short.MAX_VALUE)))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1347, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
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

    private void productCatalogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCatalogBtnActionPerformed
        // TODO add your handling code here:
        this.jSplitPane1.setRightComponent(new ConvenienceMP(appSystem, enterprise,organization,useraccount));
            
    }//GEN-LAST:event_productCatalogBtnActionPerformed

    private void productReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productReportBtnActionPerformed

    private void productReportBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productReportBtn1ActionPerformed

    private void productReportBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productReportBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productReportBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ProductOrganizationManagerJFrame().setVisible(true);
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
    private javax.swing.JButton productCatalogBtn;
    private javax.swing.JButton productReportBtn;
    private javax.swing.JButton productReportBtn1;
    private javax.swing.JButton productReportBtn2;
    // End of variables declaration//GEN-END:variables
}
