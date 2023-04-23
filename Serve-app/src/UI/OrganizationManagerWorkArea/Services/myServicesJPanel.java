/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.OrganizationManagerWorkArea.Services;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.Organization;
import Organization.ServiceManagement.Service;
import Organization.ServiceManagement.ServiceCatalog;
import Organization.ServicesOrganization;
import UI.ClientWorkArea.HospitalMP;
import UserAccount.UserAccount;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vraosharma
 */
public class myServicesJPanel extends javax.swing.JPanel {
    private Network appSystem;
    private UserAccount useraccount;
    Enterprise enterprise;
    ServicesOrganization organization;
    DefaultTableModel tModel;
    
    Service currService;
    /**
     * Creates new form PharmacyOrganizationJPanel
     */
    public myServicesJPanel(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = (ServicesOrganization) organization;
        this.tModel = (DefaultTableModel) this.jTable1.getModel();
        populateServices();
    }
        
    
    public boolean validateSA(){
        if(sNamePA.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Service Name can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        } 
        try {
                int time = Integer.parseInt(aTimePA.getText());
                if (time < 0) {
                    return false;
                }
        }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Alloted time must be a valid integer.",TOOL_TIP_TEXT_KEY, HEIGHT);
                return false;
            }
        if(sCatPA.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Service Category can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        }
        if(descPA.getText().isBlank() || (descPA.getText().length() > 45)){
            JOptionPane.showMessageDialog(null, "Service Category can not be blank or more than 45 chars.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        }
        
        return true;
    }
    
    public boolean validateMS(){
        if(serviceName.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Service Name can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        } 
        try {
                double price = Double.parseDouble(aTime.getText());
                if (price < 0) {
                    return false;
                }
        }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Alloted time must be a integer.",TOOL_TIP_TEXT_KEY, HEIGHT);
                return false;
            }
        if(catName.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Service Name can not be blank.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        }
        if(desc.getText().isBlank() || (desc.getText().length() > 45)){
            JOptionPane.showMessageDialog(null, "Service Category can not be blank or more than 45 chars.",TOOL_TIP_TEXT_KEY, HEIGHT);
            return false;
        }
        
        return true;
    }
    
    public void populateServices(){
        tModel.setRowCount(0);
        ServiceCatalog catalog = this.organization.getServices();
        System.out.println(catalog.getAllServices().size());
        if(catalog != null & catalog.getAllServices()!= null){
            for (Service s : catalog.getAllServices()){
                Object[] row = new Object[5];
                row[0] = s.getsID();
                row[1] = s;
                if (s.getAllottedTime() == 1) {
                row[2] =  String.format("%d minute", s.getAllottedTime());
                 } else {
                row[2] =  String.format("%d minutes", s.getAllottedTime());
                 }
                row[3] = s.getCategory();
                row[4] = s.getDescription();
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

        catName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        serviceName = new javax.swing.JTextField();
        aTime = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        updateBtn1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sNamePA = new javax.swing.JTextField();
        aTimePA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sCatPA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextPane();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descPA = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();
        imageBrowser = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        imgDisp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1150, 800));

        catName.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        catName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catNameActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(236, 100, 44));

        jLabel8.setFont(new java.awt.Font("Krub", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("My Services");

        jTable1.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service ID", "Service Name", "Allotted Time", "Service Category", "Description"
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );

        jLabel7.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 100, 44));
        jLabel7.setText("Description");

        jLabel12.setFont(new java.awt.Font("Krub", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 100, 44));
        jLabel12.setText("Manage Services");

        serviceName.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        serviceName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceNameActionPerformed(evt);
            }
        });

        aTime.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        aTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aTimeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(236, 100, 44));
        jLabel15.setText("Service Category");

        updateBtn.setFont(new java.awt.Font("Krub", 1, 12)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(236, 100, 44));
        updateBtn.setText("Update Details");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        updateBtn1.setFont(new java.awt.Font("Krub", 1, 12)); // NOI18N
        updateBtn1.setForeground(new java.awt.Color(236, 100, 44));
        updateBtn1.setText("Delete Service");
        updateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Krub", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 100, 44));
        jLabel9.setText("Service Addition");

        addBtn.setFont(new java.awt.Font("Krub", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(236, 100, 44));
        addBtn.setText("Add Service");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 100, 44));
        jLabel10.setText("Service Name");

        jLabel11.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 100, 44));
        jLabel11.setText("Allotted Time (min.)");

        sNamePA.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        sNamePA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNamePAActionPerformed(evt);
            }
        });

        aTimePA.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        aTimePA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aTimePAActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 100, 44));
        jLabel6.setText("Service Category");

        sCatPA.setFont(new java.awt.Font("KoHo", 0, 14)); // NOI18N
        sCatPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sCatPAActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 100, 44));
        jLabel5.setText("Description");

        desc.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jScrollPane2.setViewportView(desc);

        jLabel16.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(236, 100, 44));
        jLabel16.setText("Service Name");

        descPA.setFont(new java.awt.Font("Krub", 0, 13)); // NOI18N
        jScrollPane3.setViewportView(descPA);

        jLabel13.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 100, 44));
        jLabel13.setText("Allotted Time (min.)");

        imageBrowser.setFont(new java.awt.Font("Krub", 1, 12)); // NOI18N
        imageBrowser.setForeground(new java.awt.Color(236, 100, 44));
        imageBrowser.setText("Update Imagery");
        imageBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBrowserActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Krub", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(236, 100, 44));
        jLabel17.setText("Current Image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(41, 41, 41))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel5)
                                .addComponent(jLabel16)
                                .addComponent(jLabel6))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(aTimePA)
                                .addComponent(sCatPA)
                                .addComponent(sNamePA)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel15))
                                        .addGap(14, 14, 14)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(serviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(aTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(catName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(imgDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addGap(31, 31, 31)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(updateBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageBrowser))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sNamePA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aTimePA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sCatPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBtn)
                .addGap(29, 29, 29)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serviceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imgDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageBrowser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateBtn1)
                .addGap(52, 52, 52))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void catNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catNameActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selRow = jTable1.getSelectedRow();
        this.currService = (Service) tModel.getValueAt(selRow, 1);
        serviceName.setText(currService.getName());
        aTime.setText(String.valueOf(currService.getAllottedTime()));
        catName.setText(currService.getCategory());
        desc.setText(currService.getDescription());
        try {
            BufferedImage bufferedImage = ImageIO.read(currService.getProductImageFile());
            Image image = bufferedImage.getScaledInstance(imgDisp.getWidth(), imgDisp.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(image);
            imgDisp.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(HospitalMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void serviceNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serviceNameActionPerformed

    private void aTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aTimeActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selRow = jTable1.getSelectedRow();

        if(selRow >= 0){
            if(validateMS()){
                currService.setName(serviceName.getText());
                currService.setAllottedTime(Integer.parseInt(aTime.getText()));
                currService.setCategory(catName.getText());
                currService.setDescription(desc.getText());
                populateServices();
                JOptionPane.showMessageDialog(null, "The service has been updated!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a service to update.");
        }
        populateServices();

    }//GEN-LAST:event_updateBtnActionPerformed

    private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn1ActionPerformed
        // TODO add your handling code here:
        ServiceCatalog catalog = this.organization.getServices();
        Service removedServ = catalog.removeService(currService);
        populateServices();
        JOptionPane.showMessageDialog(null, removedServ.toString() +" has been removed.");
        
    }//GEN-LAST:event_updateBtn1ActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if (validateSA()){
            this.organization.getServices().newService(sNamePA.getText(), Integer.parseInt(aTimePA.getText()), sCatPA.getText(), descPA.getText() );
            JOptionPane.showMessageDialog(null, "Your service has been added!");
        }
        populateServices();
    }//GEN-LAST:event_addBtnActionPerformed

    private void sNamePAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNamePAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNamePAActionPerformed

    private void aTimePAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aTimePAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aTimePAActionPerformed

    private void sCatPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sCatPAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sCatPAActionPerformed

    private void imageBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBrowserActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();

        //Specify file filtered to imgs only
        FileNameExtensionFilter filter = new FileNameExtensionFilter ("IMAGES", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(filter);

        int showOpenDialogue = browseImageFile.showOpenDialog(null);

        //If matches filter, accept file and set the RecipeImagePath attr.
        if (filter.accept(browseImageFile.getSelectedFile())){
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            ImageIcon icon = new ImageIcon(selectedImagePath);
            int input = JOptionPane.showConfirmDialog(null, "Would you like to save this image?", "Product Imagery", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
            if (input == 0){
                currService.setServiceImageFile(selectedImageFile);
                imgDisp.setIcon(icon);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please provide a 'jpeg' file", "Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_imageBrowserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aTime;
    private javax.swing.JTextField aTimePA;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField catName;
    private javax.swing.JTextPane desc;
    private javax.swing.JTextPane descPA;
    private javax.swing.JButton imageBrowser;
    private javax.swing.JLabel imgDisp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sCatPA;
    private javax.swing.JTextField sNamePA;
    private javax.swing.JTextField serviceName;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn1;
    // End of variables declaration//GEN-END:variables
}
