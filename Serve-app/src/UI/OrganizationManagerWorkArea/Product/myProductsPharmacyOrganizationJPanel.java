/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.OrganizationManagerWorkArea.Product;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductManagement.Product;
import Organization.ProductManagement.ProductCatalog;
import Organization.ProductOrganization;
import UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vraosharma
 */
public class myProductsPharmacyOrganizationJPanel extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    ProductOrganization organization;
    DefaultTableModel tModel;
    Product currProduct;
    /**
     * Creates new form PharmacyOrganizationJPanel
     */
    public myProductsPharmacyOrganizationJPanel(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = (ProductOrganization) organization;
        this.tModel = (DefaultTableModel) this.jTable1.getModel();
        populateProducts();
    }
    
    
    
    public boolean validatePA(){
        boolean flag = true;
        if(productName1.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Product Name can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        } 
        try {
                double price = Double.parseDouble(productPrice.getText());
                if (price < 0) {
                    return false;
                }
        }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Product Price must be a valid price.",TOOL_TIP_TEXT_KEY, HEIGHT);
                return false;
            }
        if(productCategory.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Product Name can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        } 
        return true;
    }
    
    public boolean validateMP(){
        boolean flag = true;
        if(productName4.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Product Name can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        } 
        try {
                double price = Double.parseDouble(productName5.getText());
                if (price < 0) {
                    return false;
                }
        }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Product Price must be a valid price.",TOOL_TIP_TEXT_KEY, HEIGHT);
                return false;
            }
        if(productName3.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Product Name can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        } 
        return true;
    }
    
    public void populateProducts(){
        tModel.setRowCount(0);
        ProductCatalog catalog = this.organization.getProductCatalog();
        if(catalog != null & catalog.getAllProducts() != null){
            for (Product p : catalog.getAllProducts()){
                Object[] row = new Object[5];
                row[0] = p;
                row[1] = p.getName();
                row[2] = String.format("$%.2f",p.getPrice());
                row[3] = p.getCategory();
                row[4] = p.isPrescriptionRequired();
                tModel.addRow(row);
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

        productName3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        productName4 = new javax.swing.JTextField();
        productName5 = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel15 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        updateBtn1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        productName1 = new javax.swing.JTextField();
        productPrice = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        productCategory = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productName3.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        productName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productName3ActionPerformed(evt);
            }
        });
        add(productName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 610, 110, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("My Products");

        jTable1.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Price", "Product Category", "Prescription Required?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 750, 850));

        jLabel7.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel7.setText("Perscription?");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 670, -1, 30));

        jLabel12.setFont(new java.awt.Font("Krub", 1, 24)); // NOI18N
        jLabel12.setText("Manage Products");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 460, -1, 40));

        jLabel13.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel13.setText("Product Name");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, -1, 30));

        jLabel14.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel14.setText("Product Price");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 560, -1, 30));

        productName4.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        productName4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productName4ActionPerformed(evt);
            }
        });
        add(productName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 510, 110, -1));

        productName5.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        productName5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productName5ActionPerformed(evt);
            }
        });
        add(productName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 560, 110, -1));

        jToggleButton2.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jToggleButton2.setText("NO");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 670, 80, -1));

        jLabel15.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel15.setText("Product Category");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 610, -1, 30));

        updateBtn.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        updateBtn.setText("Update Details");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 730, -1, -1));

        updateBtn1.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        updateBtn1.setText("Delete Product");
        updateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn1ActionPerformed(evt);
            }
        });
        add(updateBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 770, -1, -1));

        jLabel9.setFont(new java.awt.Font("Krub", 1, 24)); // NOI18N
        jLabel9.setText("Product Addition");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, -1, -1));

        addBtn.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        addBtn.setText("Add Product");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 320, 131, -1));

        jLabel10.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel10.setText("Product Name");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, -1, 30));

        jLabel11.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel11.setText("Product Price");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, 30));

        productName1.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        productName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productName1ActionPerformed(evt);
            }
        });
        add(productName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 110, -1));

        productPrice.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        productPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPriceActionPerformed(evt);
            }
        });
        add(productPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 160, 110, -1));

        jToggleButton1.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jToggleButton1.setText("NO");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 80, -1));

        jLabel6.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel6.setText("Product Category");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, -1, 30));

        productCategory.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        productCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productCategoryActionPerformed(evt);
            }
        });
        add(productCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 210, 110, -1));

        jLabel5.setFont(new java.awt.Font("Krub", 0, 14)); // NOI18N
        jLabel5.setText("Perscription?");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void productName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productName3ActionPerformed

    private void productName4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productName4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productName4ActionPerformed

    private void productName5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productName5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productName5ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        if ("NO".equals(jToggleButton2.getText())){
            jToggleButton2.setText("YES");
            jToggleButton2.setSelected(true);
        }else{
            jToggleButton2.setText("NO");
            jToggleButton2.setSelected(false);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selRow = jTable1.getSelectedRow();
        
        if(selRow >= 0){
            if(validateMP()){
                currProduct.setName(productName4.getText());
                currProduct.setPrice(Double.parseDouble(productName5.getText()));
                currProduct.setCategory(productName3.getText());
                currProduct.setPrescriptionRequired(jToggleButton2.isSelected());
                populateProducts();
            JOptionPane.showMessageDialog(null, "The product has been updated!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a product to update.");
        }
        
    }//GEN-LAST:event_updateBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selRow = jTable1.getSelectedRow();
        this.currProduct = (Product) tModel.getValueAt(selRow, 0);
        productName4.setText(currProduct.getName());
        productName5.setText(String.valueOf(currProduct.getPrice()));
        productName3.setText(currProduct.getCategory());
        jToggleButton2.setSelected(currProduct.isPrescriptionRequired());
        if(currProduct.isPrescriptionRequired()){
            jToggleButton2.setText("YES");
        }else{
            jToggleButton2.setText("NO");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if ("NO".equals(jToggleButton1.getText())){
            jToggleButton1.setText("YES");
            jToggleButton1.setSelected(true);
        }else{
            jToggleButton1.setText("NO");
            jToggleButton1.setSelected(false);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void productName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productName1ActionPerformed

    private void productPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productPriceActionPerformed

    private void productCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productCategoryActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if (validatePA()){
            this.organization.getProductCatalog().newPharmacyProduct(productName1.getText(), Double.parseDouble(productPrice.getText()), productCategory.getText(), jToggleButton1.isSelected());
            JOptionPane.showMessageDialog(null, "Your product has been added!");
        }
        populateProducts();
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn1ActionPerformed
        // TODO add your handling code here:
        ProductCatalog catalog = this.organization.getProductCatalog();
        Product removedProd = catalog.removeProduct(currProduct);
        populateProducts();
        JOptionPane.showMessageDialog(null, removedProd.toString() +" has been removed.");
    }//GEN-LAST:event_updateBtn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField productCategory;
    private javax.swing.JTextField productName1;
    private javax.swing.JTextField productName3;
    private javax.swing.JTextField productName4;
    private javax.swing.JTextField productName5;
    private javax.swing.JTextField productPrice;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn1;
    // End of variables declaration//GEN-END:variables
}
