/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aymen
 */
public final class SearchDonators extends javax.swing.JFrame {

    /**
     * Creates new form SearchDonators
     */
   // private String fname , lname,adr,email;
    //int phonenum;
    
    Connection con;
    Statement stm;
    ResultSet res;
    DefaultTableModel model=new DefaultTableModel();
   public SearchDonators() throws ClassNotFoundException {
        initComponents();
        this.setTitle("Search Donators");
        model=(DefaultTableModel) jTable1.getModel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try{
            /*Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javadatabase","root","Ay1234ee");*/
            Connection con= DBConnect.openConnection();
            stm=con.createStatement();
            
         String req="select * from donators;";
         try {
             res=stm.executeQuery(req);
             while (res.next()){
                 String t[]=new String[]{res.getString("DONATOR_ID"),res.getString("DONATOR_FNAME"),res.getString("DONATOR_LNAME"),res.getString("DONATOR_NUM"),res.getString("DONATOR_ADR"),res.getString("DONATOR_EMAIL")};
                 model.addRow(t);
             }
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
         }
            
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 490));
        setPreferredSize(new java.awt.Dimension(550, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Enter the donator first name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jButton1.setText("Search");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 70, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 140, 30));

        jButton2.setText("Remove Donator");
        jButton2.setToolTipText("");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 150, 30));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 357, 201, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Phone Num", "Adress", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 570, 280));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 137, 21));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/meubles_1.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 530));

        setSize(new java.awt.Dimension(629, 425));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // search
        String search=jTextField1.getText();
            String req="SELECT * FROM javadatabase.donators where DONATOR_ID like '%"+search+"%' or DONATOR_FNAME like '%"+search+"%' or DONATOR_LNAME like'%"+search+"%' or DONATOR_NUM like '%"+search+"%' or DONATOR_ADR like '%"+search+"%' or DONATOR_EMAIL like '%"+search+"%';";    
            if(jTextField1.getText().length()<1) req="select * from donators";
        try {
             model.setRowCount(0);
             res=stm.executeQuery(req);
             while (res.next()){
                 String t[]=new String[]{res.getString("DONATOR_ID"),res.getString("DONATOR_FNAME"),res.getString("DONATOR_LNAME"),res.getString("DONATOR_NUM"),res.getString("DONATOR_ADR"),res.getString("DONATOR_EMAIL")};
                 model.addRow(t);
             }
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
                 boolean i= "".equals(jTextField1.getText());
                 if(i==true){
                     jLabel2.setText("Please enter a name");
                 }else{jLabel2.setText("");}

    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
         jTextField1.setText("");
        
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Remove donator
        try
        {
            int selectedRowIndex = jTable1.getSelectedRow();
            if(selectedRowIndex==-1)
            {
                JOptionPane jp=new JOptionPane();
                jp.showMessageDialog(null, "select a row first", "Failure", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            String id=(String) model.getValueAt(selectedRowIndex, 0);
            String req="DELETE FROM `javadatabase`.`donators` where DONATOR_ID="+id+";";
            int ins=stm.executeUpdate(req);
            if(ins==1){ 
                JOptionPane jp=new JOptionPane();
                jp.showMessageDialog(null, "Donator has been removed from the database", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            ResultSet rs=stm.executeQuery("SELECT * FROM javadatabase.donators;");
            model.setRowCount(0);
            while(rs.next())
            {
                String[] t=new String[]{
                    rs.getString("DONATOR_ID"),rs.getString("DONATOR_FNAME"),rs.getString("DONATOR_LNAME"),rs.getString("DONATOR_NUM"),rs.getString("DONATOR_ADR"),rs.getString("DONATOR_EMAIL")
                };             
                model.addRow(t);
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
            java.util.logging.Logger.getLogger(SearchDonators.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchDonators.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchDonators.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchDonators.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new SearchDonators().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SearchDonators.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
