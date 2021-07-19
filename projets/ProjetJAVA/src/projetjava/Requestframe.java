/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import projetjava.DBConnect;
import projetjava.InsertR;
import projetjava.MenuJFrame;

/**
 *
 * @author ASUS
 */
public class Requestframe extends javax.swing.JFrame {

    /**
     * Creates new form requestframe
     */
    DefaultTableModel dm;
    Connection con;
    Statement st;
    ResultSet res;

    public Requestframe() {
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
             MenuJFrame m = new MenuJFrame(); // open the main menu 
             m.setVisible(true);
            try{
                con.close();
                dispose();
                
        }catch(Exception ex){System.out.println(ex.getMessage());}
        }
        });
       setLocation(400,100);
       initComponents();
       Showtable();
       // Create Columns
       
   }
    public void Showtable(){
        dm=(DefaultTableModel)jTable1.getModel();
         try{
             Connection cnx= DBConnect.openConnection();
             PreparedStatement ps=cnx.prepareStatement("SELECT distinct r.REQUEST_ID,rvr.RECEIVER_FNAME,rvr.RECEIVER_LNAME,ar.REQUEST_DATE,\n" +
             "r.REQUEST_STATUS \n" +
             "from javadatabase.requests as r join javadatabase.article_request ar on r.REQUEST_ID = ar.REQUEST_ID \n" +
             "join javadatabase.receivers rvr on rvr.RECEIVER_ID= r.RECEIVER_ID");
             ResultSet rs=ps.executeQuery();
             DefaultTableModel tm=(DefaultTableModel)jTable1.getModel();

             tm.setRowCount(0);

             while(rs.next()){
                 Object o[] = {rs.getInt("REQUEST_ID"), rs.getString("RECEIVER_FNAME"), rs.getString("RECEIVER_LNAME"),
                     rs.getDate("REQUEST_DATE"),rs.getString("r.REQUEST_STATUS")};
                 tm.addRow(o);
                }
          
            }
         catch(Exception e){
             JOptionPane.showMessageDialog(this, e);
            }
        }
    private void filter(String query)
    {
        //Filter Data
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
        jTable1.setRowSorter(tr);
        //Check Filter Query
        if (query!="All")
        {
            tr.setRowFilter(RowFilter.regexFilter(query));
        }else
        {
            jTable1.setRowSorter(tr);
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

        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Requests");
        setResizable(false);
        setSize(new java.awt.Dimension(723, 483));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jLabel2.setText("Show");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Rvr. Name", "Rvr. Last Name", "Request Date", "Request Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 410, 310));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Accepted", "inProgress", "Refused" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 152, -1));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 70, 30));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/purple.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String query= jComboBox1.getSelectedItem().toString();
        filter(query);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int value1= Integer.parseInt(model.getValueAt(index, 0).toString());
        RequestInfo info = new RequestInfo(value1);
        info.setVisible(true);
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Showtable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        InsertR r =new InsertR();
        //r.SetVisible(true);
        dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // search
        try
        {
            Connection con= DBConnect.openConnection();
            st=con.createStatement();
            String search;
            search=jTextField1.getText();
            String req="SELECT distinct r.REQUEST_ID,rvr.RECEIVER_FNAME,rvr.RECEIVER_LNAME,ar.REQUEST_DATE,\n" +
             "r.REQUEST_STATUS \n" +
             "from javadatabase.requests as r join javadatabase.article_request ar on r.REQUEST_ID = ar.REQUEST_ID \n" +
             "join javadatabase.receivers rvr on rvr.RECEIVER_ID= r.RECEIVER_ID "
                    + "and ( rvr.RECEIVER_FNAME like '%"+search+"%' or r.REQUEST_ID like '%"+search+"%'"
                    + " or rvr.RECEIVER_LNAME like '%"+search+"%' or ar.REQUEST_DATE like '%"+search+"%' "
                    + "or r.REQUEST_STATUS like '%"+search+"%') ;";    
            
            if(search=="") req="SELECT distinct r.REQUEST_ID,rvr.RECEIVER_FNAME,rvr.RECEIVER_LNAME,ar.REQUEST_DATE,\n" +
             "r.REQUEST_STATUS \n" +
             "from javadatabase.requests as r join javadatabase.article_request ar on r.REQUEST_ID = ar.REQUEST_ID \n" +
             "join javadatabase.receivers rvr on rvr.RECEIVER_ID= r.RECEIVER_ID;";
            
            ResultSet rs=st.executeQuery(req);
            dm.setRowCount(0); // clear jtable
            while(rs.next())
            {
                 Object o[] = {rs.getInt("REQUEST_ID"), rs.getString("RECEIVER_FNAME"), rs.getString("RECEIVER_LNAME"),
                     rs.getDate("REQUEST_DATE"),rs.getString("r.REQUEST_STATUS")};
                dm.addRow(o);
            }           
        } catch (Exception ex) {
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null, ex.toString(), "Failure", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Requestframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Requestframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Requestframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Requestframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requestframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}