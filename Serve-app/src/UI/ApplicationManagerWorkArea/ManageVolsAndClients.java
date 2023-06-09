/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.ApplicationManagerWorkArea;

import AppSystem.Network;
import Enterprise.Enterprise;
import Organization.ConvenienceVolOrganization;
import Organization.Organization;
import Person.Person;
import Person.PersonDirectory;
import Requests.ApplicationRequest;
import Requests.RequestDirectory;
import UserAccount.UserAccount;
import Volunteer.VolunteerProfile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khatna
 */
public class ManageVolsAndClients extends javax.swing.JPanel {

    /**
     * Creates new form ManageVolsAndClients
     */
    private Network appSystem;
    private UserAccount useraccount;
    DefaultTableModel viewTableModel;
    DefaultTableModel TableModel;
    Enterprise enterprise;
    Organization organization; 
    public ManageVolsAndClients(Network appSystem, Enterprise enterprise, Organization organization,UserAccount useraccount) {
        initComponents();
        this.setVisible(true);
        this.setSize(1120,800);
        this.appSystem = appSystem;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        this.organization = organization;
        this.viewTableModel = (DefaultTableModel) jTable1.getModel();
        this.TableModel = (DefaultTableModel) jTable2.getModel();
//        jPanel1.setVisible(false);
//        approvedIcon.setVisible(false);
//        rejectIcon.setVisible(false);
        display();
//        displayPersons();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1150, 800));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(271, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(554, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void display(){
        viewTableModel.setRowCount(0);
        ConvenienceVolOrganization convolorg  = (ConvenienceVolOrganization) appSystem.getEnterprises().findEnterprise("Convenience").getOrganizationDirectory().findOrganizationbyType("Volunteer");
        System.out.println(convolorg.getVolunteerDir().getVolunteerList().toString());
            
        for (VolunteerProfile vol : convolorg.getVolunteerDir().getVolunteerList()) {

//                VolunteerProfile vol = entry.getValue();
                Object row[] = new Object[4];
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                row[0] = vol.getId();
                row[1] = vol.getName();
                row[2] = vol.getUseraccount().getUserName();
                row[3] = vol.getUseraccount().getPassword();
//                row[4] = appReq.getApp().getStatus();
                
                viewTableModel.addRow(row);           
        }        
 
    }
//    public void displayPersons(){
//        viewTableModel.setRowCount(0);
//        PersonDirectory perDir  = appSystem.getPersonDirectory();
////        System.out.println(reqDir.getAllRequests().toString());
//        
//        for (Person p : perDir.getPersonList()) {
//
//               
//                Object row[] = new Object[4];
//                DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//                row[0] = p.getId();
//                row[1] = p.getName();
//                row[2] = p.getUseraccount().getUserName();
//                row[3] = p.getUseraccount().getPassword();
////                row[4] = appReq.getApp().getStatus();
//                
//                TableModel.addRow(row);           
//        }        
// 
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
