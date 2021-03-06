/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WareHouse;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.WareHouseEnterprise;
import Business.Enterprise.WareHouseInventory;
import Business.GlobalWaste;
import Business.Organization.WareHouseOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jay
 */
public class MyInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyInventoryJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    WareHouseOrganization wareHouseOrganization;
    Enterprise enterprise;
    EcoSystem business;

    MyInventoryJPanel(JPanel userProcessContainer, UserAccount account, WareHouseOrganization wareHouseOrganization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.wareHouseOrganization = wareHouseOrganization;
        this.enterprise = (WareHouseEnterprise)enterprise;
        this.business = business;
        populate();
    }
    
    public void populate(){
        DefaultTableModel dtm = (DefaultTableModel) wasteTable.getModel();
        dtm.setRowCount(0);
        
        for (GlobalWaste gw : business.getWasteDirectory().getWasteList()){
        for(WareHouseInventory wi : ((WareHouseEnterprise)enterprise).getInventoryDirectory().getInventoryList())
        {
            if (gw.getWasteNsme().equals(wi.getInventoryName())){
            
        Object[] row = new Object[4];
        row[0] = wi;
        row[1] = wi.getQuanitity();
        row[2] = gw.getPrice();
        row[3]= wi.getSellingPrice();
        dtm.addRow(row);
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        wasteTable = new javax.swing.JTable();
        sellingPriceTextField = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        wasteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "WasteName", "Quantity", "Buying Price", "Selling price"
            }
        ));
        jScrollPane1.setViewportView(wasteTable);

        submitBtn.setText("submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Selling Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sellingPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(366, 366, 366))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellingPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addContainerGap(183, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        int selectedRow = wasteTable.getSelectedRow();
        WareHouseInventory wi = (WareHouseInventory) wasteTable.getValueAt(selectedRow, 0);

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row");
        } else {
            wi.setSellingPrice(Integer.parseInt(sellingPriceTextField.getText()));
            
            populate();
        // TODO add your handling code here:
    }//GEN-LAST:event_submitBtnActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sellingPriceTextField;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTable wasteTable;
    // End of variables declaration//GEN-END:variables
}
