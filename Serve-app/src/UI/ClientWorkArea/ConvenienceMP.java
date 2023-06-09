/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.ClientWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ProductManagement.OrderItem;
import Organization.ProductManagement.Product;
import Organization.ProductManagement.ProductCart;
import Organization.ProductManagement.ProductCatalog;
import Organization.ProductManagement.ProductOrder;
import Organization.ProductOrganization;
import Person.Client.Client;
import Requests.ConvenienceRequest;
import UserAccount.UserAccount;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vraosharma
 */
public class ConvenienceMP extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    
    
    ProductOrganization pharmacyOrg;
    ProductCart pharmCart;
    DefaultTableModel pharProdModel;
    DefaultTableModel pharCartModel;
    
    ProductOrganization grocery;
    ProductCart groCart;
    DefaultTableModel groProdModel;
    DefaultTableModel groCartModel;
    
    
    Client client;
    
    
    Product currProduct;
    Product currProduct2;
    /**
     * Creates new form ConvenienceMP
     */
    public ConvenienceMP(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.client = (Client) useraccount.getPerson();
        

        //find pharmacy org, create product/cart table models, init new cart every time user shops convenience
        this.pharmacyOrg =(ProductOrganization) appSystem.getEnterprises().findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Pharmacy");
        this.pharProdModel = (DefaultTableModel) this.pharTable.getModel();
        this.pharCartModel = (DefaultTableModel) this.pharmCartTable.getModel();
        this.pharmCart = new ProductCart();
        
        this.grocery =(ProductOrganization) appSystem.getEnterprises().findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Grocery Store");
        this.groProdModel = (DefaultTableModel) this.groTable.getModel();
        this.groCartModel = (DefaultTableModel) this.groCartTable.getModel();
        this.groCart = new ProductCart();
        
        
        
        pharmPopup.setVisible(false);
        groPopup.setVisible(false);
        
        
        
        populatePharmProducts();
        populateGroProducts();
        populateCurrPharmCart();
        populateCurrGroCart();
        addIcons();
        
    }
    
    public void addIcons(){
        String filepath = "src/Resources/cart.jpeg";
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(filepath));
            Image image = bufferedImage.getScaledInstance(76, 61, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            cartImage1.setIcon(icon);
            cartImage2.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void populateCurrPharmCart(){
        pharCartModel.setRowCount(0);
        ArrayList<OrderItem> currOrderItems = this.pharmCart.getCartOrderItems();
        if(currOrderItems != null){
            int count = 0;
            double cartTotal = 0;
            for (OrderItem oi : currOrderItems){
                Object[] row = new Object[4];
                
                row[0] = count++;
                row[1] = oi.getSelectedProduct();
                row[2] = oi.getQuantity();
                row[3] = String.format("$%.2f",oi.getOrderItemRevenue());
                cartTotal += oi.getOrderItemRevenue();
                
                pharCartModel.addRow(row);
            }
            jLabel3.setText(String.format("$%.2f",cartTotal));
        }
    }
    
    public void populateCurrGroCart(){
        groCartModel.setRowCount(0);
        ArrayList<OrderItem> currOrderItems = this.groCart.getCartOrderItems();
        if(currOrderItems != null){
            int count = 0;
            double cartTotal = 0;
            for (OrderItem oi : currOrderItems){
                Object[] row = new Object[4];
                
                row[0] = count++;
                row[1] = oi.getSelectedProduct();
                row[2] = oi.getQuantity();
                row[3] = String.format("$%.2f",oi.getOrderItemRevenue());
                cartTotal += oi.getOrderItemRevenue();
                
                groCartModel.addRow(row);
            }
            jLabel5.setText(String.format("$%.2f",cartTotal));
        }
    }
    
    public void populatePharmProducts(){
        pharProdModel.setRowCount(0);
        ProductCatalog catalog = this.pharmacyOrg.getProductCatalog();
        if(catalog != null & catalog.getAllProducts() != null){
            for (Product p : catalog.getAllProducts()){
                if(!p.isPrescriptionRequired() || this.client.getPerscribedMeds().contains(p)){
                    Object[] row = new Object[4];
                    row[0] = p;
                    row[1] = String.format("$%.2f",p.getPrice());
                    row[2] = p.getCategory();
                    row[3] = p.isPrescriptionRequired();
                    pharProdModel.addRow(row);
                }
            }
        }
    }
    
    public void populateGroProducts(){
        groProdModel.setRowCount(0);
        ProductCatalog catalog = this.grocery.getProductCatalog();
        if(catalog != null & catalog.getAllProducts() != null){
            for (Product p : catalog.getAllProducts()){
                Object[] row = new Object[3];
                row[0] = p;
                row[1] = String.format("$%.2f",p.getPrice());
                row[2] = p.getCategory();
                groProdModel.addRow(row);
            }
        }
    }
    
    public boolean validatePharOrderItem(){
        try{
            int qty = Integer.parseInt(String.valueOf(pharQtySpinner.getValue()));
        
            if(qty <1){
                JOptionPane.showMessageDialog(null,"Please set qty. to be greater than 0.");
                return false;
            }
            }catch (NumberFormatException e){
                return false;
        }
        if (currProduct == null){
            JOptionPane.showMessageDialog(null,"Select a product to add to cart.");
            return false;
        }
        return true;
    }
    
    public boolean validateGroOrderItem(){
        try{
            int qty = Integer.parseInt(String.valueOf(groQtySpinner.getValue()));
        
            if(qty <1){
                JOptionPane.showMessageDialog(null,"Please set qty. to be greater than 0.");
                return false;
            }
            }catch (NumberFormatException e){
                return false;
        }
        if (currProduct2 == null){
            JOptionPane.showMessageDialog(null,"Select a product to add to cart.");
            return false;
        }
        return true;
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cartImage2 = new javax.swing.JLabel();
        groPopup = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        groCartTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        groTable = new javax.swing.JTable();
        productDets1 = new javax.swing.JPanel();
        groQtySpinner = new javax.swing.JSpinner();
        productImage3 = new javax.swing.JLabel();
        groProdImg = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        cartImage1 = new javax.swing.JLabel();
        pharmPopup = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pharmCartTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        purchasePharProds = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pharTable = new javax.swing.JTable();
        productDets = new javax.swing.JPanel();
        pharQtySpinner = new javax.swing.JSpinner();
        productImage2 = new javax.swing.JLabel();
        pharProductImage = new javax.swing.JLabel();
        addPharmtoCart = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1150, 800));
        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(236, 100, 44));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Krub", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1150, 800));
        jPanel2.setLayout(null);

        cartImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartImage2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartImage2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartImage2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cartImage2MouseReleased(evt);
            }
        });
        jPanel2.add(cartImage2);
        cartImage2.setBounds(1050, 10, 76, 61);

        groPopup.setBackground(new java.awt.Color(255, 255, 255));
        groPopup.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        groPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        groCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line Item", "Product Name", "Quantity", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        groCartTable.setSelectionBackground(new java.awt.Color(236, 100, 44));
        jScrollPane6.setViewportView(groCartTable);

        groPopup.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 329, 214));

        jLabel5.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 100, 44));
        groPopup.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 70, 20));

        jButton8.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(236, 100, 44));
        jButton8.setText("Place Order");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        groPopup.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        jButton9.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jButton9.setForeground(new java.awt.Color(236, 100, 44));
        jButton9.setText("Clear Cart");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        groPopup.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 100, -1));

        jLabel6.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 100, 44));
        jLabel6.setText("Your Total");
        groPopup.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jPanel2.add(groPopup);
        groPopup.setBounds(750, 60, 376, 362);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 100, 44));
        jLabel9.setText("Shop Grocery");

        groTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        groTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Price", "Product Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        groTable.setSelectionBackground(new java.awt.Color(236, 100, 44));
        groTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(groTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel9)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 730, 814);

        productDets1.setBackground(new java.awt.Color(236, 100, 44));
        productDets1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        groQtySpinner.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        groQtySpinner.setToolTipText("");
        productDets1.add(groQtySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        productImage3.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productImage3.setForeground(new java.awt.Color(255, 255, 255));
        productImage3.setText("Quantity");
        productDets1.add(productImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));
        productDets1.add(groProdImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 200, 160));

        jButton3.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(236, 100, 44));
        jButton3.setText("Add to Cart");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        productDets1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jPanel2.add(productDets1);
        productDets1.setBounds(770, 230, 328, 365);

        jTabbedPane1.addTab("Grocery", jPanel2);

        cartImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartImage1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartImage1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartImage1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cartImage1MouseReleased(evt);
            }
        });
        jLayeredPane2.add(cartImage1);
        cartImage1.setBounds(1070, 0, 76, 61);

        pharmPopup.setBackground(new java.awt.Color(255, 255, 255));
        pharmPopup.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pharmPopup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharmCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line Item", "Product Name", "Quantity", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pharmCartTable.setSelectionBackground(new java.awt.Color(236, 100, 44));
        jScrollPane5.setViewportView(pharmCartTable);

        pharmPopup.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 21, 329, 214));

        jLabel3.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 100, 44));
        pharmPopup.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        purchasePharProds.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        purchasePharProds.setForeground(new java.awt.Color(236, 100, 44));
        purchasePharProds.setText("Place Order");
        purchasePharProds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchasePharProdsActionPerformed(evt);
            }
        });
        pharmPopup.add(purchasePharProds, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        jButton7.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(236, 100, 44));
        jButton7.setText("Clear Cart");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pharmPopup.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 300, 100, -1));

        jLabel4.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 100, 44));
        jLabel4.setText("Your Total");
        pharmPopup.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLayeredPane2.add(pharmPopup);
        pharmPopup.setBounds(760, 90, 376, 362);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(236, 100, 44));
        jLabel10.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 100, 44));
        jLabel10.setText("Shop Pharmacy");

        pharTable.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        pharTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Price", "Product Category", "Prescription Required?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pharTable.setSelectionBackground(new java.awt.Color(236, 100, 44));
        pharTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(pharTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(183, 183, 183))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLayeredPane2.add(jPanel5);
        jPanel5.setBounds(0, 0, 740, 820);

        productDets.setBackground(new java.awt.Color(236, 100, 44));
        productDets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharQtySpinner.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        pharQtySpinner.setToolTipText("");
        productDets.add(pharQtySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        productImage2.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        productImage2.setForeground(new java.awt.Color(255, 255, 255));
        productImage2.setText("Quantity");
        productDets.add(productImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));
        productDets.add(pharProductImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 200, 190));

        addPharmtoCart.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        addPharmtoCart.setForeground(new java.awt.Color(236, 100, 44));
        addPharmtoCart.setText("Add to Cart");
        addPharmtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPharmtoCartActionPerformed(evt);
            }
        });
        productDets.add(addPharmtoCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLayeredPane2.add(productDets);
        productDets.setBounds(780, 230, 328, 365);

        jTabbedPane1.addTab("Pharmacy", jLayeredPane2);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cartImage1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseReleased

    private void cartImage1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MousePressed
        // TODO add your handling code here:
        if (!this.pharmPopup.isVisible()){
            this.pharmPopup.setVisible(true);
        } else {
            this.pharmPopup.setVisible(false);
        }
    }//GEN-LAST:event_cartImage1MousePressed

    private void cartImage1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseExited

    private void cartImage1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage1MouseEntered

    private void pharTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharTableMouseClicked
        // TODO add your handling code here:
        int selRow = pharTable.getSelectedRow();
        this.currProduct = (Product) pharProdModel.getValueAt(selRow, 0);
        
        try {
            BufferedImage bufferedImage = ImageIO.read(currProduct.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(pharProductImage.getWidth(), pharProductImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            pharProductImage.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pharTableMouseClicked

    private void groTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groTableMouseClicked
        // TODO add your handling code here:
        int selRow = groTable.getSelectedRow();
        this.currProduct2 = (Product) groProdModel.getValueAt(selRow, 0);
        try {
            BufferedImage bufferedImage = ImageIO.read(currProduct2.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(groProdImg.getWidth(), groProdImg.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            groProdImg.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_groTableMouseClicked

    private void addPharmtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPharmtoCartActionPerformed
        // TODO add your handling code here:
        if (validatePharOrderItem()){
            this.pharmCart.addToCart(currProduct, (int) pharQtySpinner.getValue());
            JOptionPane.showMessageDialog(null,"Order Item added to cart.");

        }
        populateCurrPharmCart();
    }//GEN-LAST:event_addPharmtoCartActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here: clear phar cart
        ArrayList<OrderItem> currOrderItems = this.pharmCart.getCartOrderItems();
        if(currOrderItems != null){
            this.pharmCart.emptyCart();
            JOptionPane.showMessageDialog(null,"Your cart has been emptied.");
        }else{
            JOptionPane.showMessageDialog(null,"Cart is already empty.");
        }
        populateCurrPharmCart();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void purchasePharProdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchasePharProdsActionPerformed
        // TODO add your handling code here: place phar order
        ArrayList<OrderItem> currOrderItems = this.pharmCart.getCartOrderItems();
        if(currOrderItems != null){
            ProductOrder po = pharmCart.processCart((Client) this.useraccount.getPerson(), this.pharmacyOrg);
            this.pharmPopup.setVisible(false);
            this.appSystem.getReqDir().createConvenienceRequest(this.useraccount, po);
            JOptionPane.showMessageDialog(null,"Order placed, go to'My Pharmacy Requests' page in 'My Requests' to see order status updates ");
        }else{
            JOptionPane.showMessageDialog(null,"Please add products to cart to place order.");
        }
        populateCurrPharmCart();
    }//GEN-LAST:event_purchasePharProdsActionPerformed

    private void cartImage2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cartImage2MouseEntered

    private void cartImage2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage2MouseExited

    private void cartImage2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MousePressed
        // TODO add your handling code here:
        if (!this.groPopup.isVisible()){
            this.groPopup.setVisible(true);
        } else {
            this.groPopup.setVisible(false);
        }
    }//GEN-LAST:event_cartImage2MousePressed

    private void cartImage2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartImage2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cartImage2MouseReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here: place order
        ArrayList<OrderItem> currOrderItems = this.groCart.getCartOrderItems();
        if(currOrderItems != null){
            ProductOrder po = groCart.processCart((Client) this.useraccount.getPerson(), this.grocery);
            this.groPopup.setVisible(false);
//            ConvenienceRequest conReq = this.appSystem.getReqDir().createConvenienceRequest(this.useraccount, po);
            this.appSystem.getReqDir().createDeliveryRequest(this.useraccount, po);
            JOptionPane.showMessageDialog(null,"Order placed, go to 'My Deliveries' page in 'My Requests' to see delivery status.");
        }else{
            JOptionPane.showMessageDialog(null,"Please add products to cart to place order.");
        }
        populateCurrPharmCart();
     
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here: clear cart
        ArrayList<OrderItem> currOrderItems = this.groCart.getCartOrderItems();
        if(currOrderItems != null){
            this.groCart.emptyCart();
            JOptionPane.showMessageDialog(null,"Your cart has been emptied.");
        }else{
            JOptionPane.showMessageDialog(null,"Cart is already empty.");
        }
        populateCurrPharmCart();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (validateGroOrderItem()){
            this.groCart.addToCart(currProduct2, (int) groQtySpinner.getValue());
            JOptionPane.showMessageDialog(null,"Order Item added to cart.");

        }
        populateCurrGroCart();
          
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPharmtoCart;
    private javax.swing.JLabel cartImage1;
    private javax.swing.JLabel cartImage2;
    private javax.swing.JTable groCartTable;
    private javax.swing.JPanel groPopup;
    private javax.swing.JLabel groProdImg;
    private javax.swing.JSpinner groQtySpinner;
    private javax.swing.JTable groTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel pharProductImage;
    private javax.swing.JSpinner pharQtySpinner;
    private javax.swing.JTable pharTable;
    private javax.swing.JTable pharmCartTable;
    private javax.swing.JPanel pharmPopup;
    private javax.swing.JPanel productDets;
    private javax.swing.JPanel productDets1;
    private javax.swing.JLabel productImage2;
    private javax.swing.JLabel productImage3;
    private javax.swing.JButton purchasePharProds;
    // End of variables declaration//GEN-END:variables
}
