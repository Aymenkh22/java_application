/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class Sold extends javax.swing.JInternalFrame {

    /**
     * Creates new form Sold
     */
    public String mess;

    public Sold(String msg) {
        initComponents();
        
        try{
            Connection cnx= DBConnect.openConnection();
            String s ="meuble";
            this.mess=msg;
            //System.out.print(donation);
            PreparedStatement ps=cnx.prepareStatement("SELECT ARTICLE_ID,NATURE,RECEIPT_QUANTITY,SALE_DATE FROM javadatabase.articles join\n" +
                                                    "javadatabase.category on \n" +
                                                    "javadatabase.articles.CATEGORY_ID = javadatabase.category.CATEGORY_ID join \n" +
                                                    "javadatabase.deposit_sale on\n" +
                                                    "javadatabase.deposit_sale.DEPSALE_ID=javadatabase.articles.DEPSALE_ID join\n" +
                                                    "javadatabase.type on \n" +
                                                    "javadatabase.type.TYPE_ID = javadatabase.articles.TYPE_ID\n" +
                                                    "WHERE ( ARTICLE_STATUS = 'Accepted')\n" +
                                                    "AND(javadatabase.category.CATEGORY_NAME=\""+mess+"\") and (DEPSALE_STATUS='Sold') ;");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)jTable1.getModel();
            
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[] = {rs.getInt("ARTICLE_ID"), rs.getString("NATURE"),rs.getString("RECEIPT_QUANTITY"),rs.getString("SALE_DATE")};
                tm.addRow(o);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
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
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(700, 250));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ARTICLE_ID", "NATURE", "QUANTITY", "SALE_DATE"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(600, 64));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
