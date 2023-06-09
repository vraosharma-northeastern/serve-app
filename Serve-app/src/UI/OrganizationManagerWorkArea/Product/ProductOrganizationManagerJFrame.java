/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.OrganizationManagerWorkArea.Product;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductOrganization;
import UI.MainJFrame;
import UI.MyRequests;
import UserAccount.UserAccount;

/**
 *
 * @author vraosharma
 */
public class ProductOrganizationManagerJFrame extends javax.swing.JFrame {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    Organization organization;
    /**
     * Creates new form OrganizationManagerJFrame
     */
    public ProductOrganizationManagerJFrame() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public ProductOrganizationManagerJFrame(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;
         if(this.organization.getName().equals("Pharmacy")){
            pharmOrgManagerRequestsBtn.setVisible(true);
        }else{
            pharmOrgManagerRequestsBtn.setVisible(false);
        }
        test();
    }
    
    public void test(){
        jLabel5.setText(String.valueOf(this.useraccount.getPerson().getName()));
//        jLabel1.setText(String.valueOf(this.useraccount.getUserName()));
        jLabel2.setText(String.valueOf(this.enterprise.getName()));
        jLabel3.setText(String.valueOf(this.organization.getName()));

        
        appSystem.addIcon(1, jLabel4);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        productCatalogBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pharmOrgManagerRequestsBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1300, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 800));
        jPanel1.setSize(new java.awt.Dimension(150, 800));
        jPanel1.setLayout(null);

        jLabel2.setForeground(new java.awt.Color(236, 100, 44));
        jLabel2.setText("jLabel1");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 310, 130, 17);

        jLabel3.setForeground(new java.awt.Color(236, 100, 44));
        jLabel3.setText("jLabel1");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 360, 140, 17);

        backBtn.setBackground(new java.awt.Color(236, 100, 44));
        backBtn.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("LOGOUT");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn);
        backBtn.setBounds(0, 50, 150, 40);

        productCatalogBtn.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        productCatalogBtn.setForeground(new java.awt.Color(236, 100, 44));
        productCatalogBtn.setText("My Products");
        productCatalogBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCatalogBtnActionPerformed(evt);
            }
        });
        jPanel1.add(productCatalogBtn);
        productCatalogBtn.setBounds(0, 130, 150, 40);

        jLabel5.setForeground(new java.awt.Color(236, 100, 44));
        jLabel5.setText("jLabel1");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 260, 140, 17);

        pharmOrgManagerRequestsBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        pharmOrgManagerRequestsBtn.setForeground(new java.awt.Color(236, 100, 44));
        pharmOrgManagerRequestsBtn.setText("My Requests");
        pharmOrgManagerRequestsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharmOrgManagerRequestsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(pharmOrgManagerRequestsBtn);
        pharmOrgManagerRequestsBtn.setBounds(0, 180, 150, 40);

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 100, 44));
        jLabel6.setText("Hello ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 240, 42, 17);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 100, 44));
        jLabel7.setText("Enterprise:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 290, 90, 17);

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 100, 44));
        jLabel8.setText("Organization:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 340, 90, 17);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(236, 100, 44));
        jPanel2.setPreferredSize(new java.awt.Dimension(1150, 800));
        jPanel2.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon("/Users/khatna/Desktop/INFO5100/serve-app/Serve-app/src/Icon/image.png")); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(310, 190, 610, 430);

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MainJFrame(appSystem, enterprise,organization,useraccount);
    }//GEN-LAST:event_backBtnActionPerformed

    private void productCatalogBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCatalogBtnActionPerformed
        // TODO add your handling code here:
        if(this.organization.getOrganizationType().equals("Pharmacy")){
            this.jSplitPane1.setRightComponent(new myProductsPharmacyOrganizationJPanel(appSystem, enterprise,organization,useraccount));
        }else{
            this.jSplitPane1.setRightComponent(new myProductsGroceryOrganizationJPanel(appSystem, enterprise,organization,useraccount));
        }        
    }//GEN-LAST:event_productCatalogBtnActionPerformed

    private void pharmOrgManagerRequestsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharmOrgManagerRequestsBtnActionPerformed
        // TODO add your handling code here:
        jSplitPane1.setRightComponent(new MyRequests(appSystem, enterprise,organization,useraccount));
    }//GEN-LAST:event_pharmOrgManagerRequestsBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ProductOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductOrganizationManagerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton pharmOrgManagerRequestsBtn;
    private javax.swing.JButton productCatalogBtn;
    // End of variables declaration//GEN-END:variables
}
