/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Deposit extends javax.swing.JFrame {
    Connection con;
    /**
     * Creates new form Deposit
     */
    public Deposit() {
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
        initComponents();
        this.setLocation(400, 50);
        this.show();
     
        this.setTitle("Deposit");
        table2.setDefaultRenderer(Object.class, new Render());
        JButton btn1 = new JButton();
        btn1.setName("u");
        btn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\systemsoftwareupdate_104262.png"));
        JButton btn2 = new JButton();
        btn2.setName("r");
        btn2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\ic_keyboard_return_128_28490.png"));
        
        try{
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT * FROM deposit_sale");
            ResultSet rs=ps.executeQuery();
            
            DefaultTableModel tm=(DefaultTableModel)table2.getModel();
            
            tm.setRowCount(0);
            
            while(rs.next()){
                PreparedStatement ps1=cnx.prepareStatement("SELECT * FROM javadatabase.type, javadatabase.category, javadatabase.articles WHERE type.category_id=category.category_id AND articles.category_id=category.category_id AND articles.depsale_id="+rs.getInt("depsale_id"));
                ResultSet rs1=ps1.executeQuery();
                rs1.next();
            
                Object o[] = {rs.getInt("depsale_id"), rs1.getString("nature"), rs1.getInt("type_quantity"), rs.getInt("estimate_price"), rs.getInt("sale_amount"), rs.getDate("sale_date"),rs.getString("depsale_status"), rs.getDate("deposit_date"), btn1, btn2};
                tm.addRow(o);
            }
        }
        catch(Exception e){
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
        table2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DEPOSIT_ID", "NATURE", "QUANTITY", "ESTIMATED PRICE", "SALE AMOUNT", "SALE DATE", "STATUS", "DEPOSIT DATE", "UPDATE", "RETURN"
            }
        ));
        table2.setRowHeight(40);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 640, 320));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/sign-add-icon_34367.png"))); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 209, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/geometrical_gradients_lg_g8_thinq_stock.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 620, 515, 0));

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\ProjetJAVA\\ProjetJAVA\\src\\projetjava\\iconfinder-search-4341327_120553.png")); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 110, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/iconfinder-money-4341308_120564.png"))); // NOI18N
        jLabel3.setText("DEPOSIT-SALE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/cropped-1366-768-1049469.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // update
        int column = table2.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/table2.getRowHeight();
        
        if(row<table2.getRowCount() && row>=0 && column < table2.getColumnCount() && column>=0){
            Object value=table2.getValueAt(row, column);
            if (value instanceof JButton){
                ((JButton)value).doClick();
                JButton bouton = (JButton)value;
                
                if(bouton.getName().equals("u")){
                     int q = JOptionPane.showConfirmDialog(null, "Do you really want to update this row?","Update",JOptionPane.YES_NO_OPTION);
                     if(q==0){
                     try{
                     String Status =(table2.getModel().getValueAt(row,6)).toString();
                     String Estimate =(table2.getModel().getValueAt(row,3)).toString();
                     String Sale =(table2.getModel().getValueAt(row,4)).toString();
                     String Sale_Date =(table2.getModel().getValueAt(row,5)).toString();
                     String Deposit_Date =(table2.getModel().getValueAt(row,7)).toString();
                     String Nature =(table2.getModel().getValueAt(row,1)).toString();
                     int idUser = Integer.parseInt((table2.getModel().getValueAt(row,0)).toString());
                     
                         dispose();
                         new Deposit_Update(idUser,Nature, Status, Estimate, Sale, Sale_Date, Deposit_Date).setVisible(true);
                        
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null, e);
                     }
                     }
                }
                
                if(bouton.getName().equals("r")){
                     int p = JOptionPane.showConfirmDialog(null, "Do you really want to return this article?","Return",JOptionPane.YES_NO_OPTION);
                     if(p==0){
                     try{
                        String x=(table2.getModel().getValueAt(row,0)).toString();
                        String sql1, sql2;
                        sql1="UPDATE deposit_sale SET depsale_status=? WHERE depsale_id=?";
                        sql2="UPDATE articles SET article_status=? WHERE depsale_id=?";
                         PreparedStatement pst1=null;
                         PreparedStatement pst2=null;
                         
                         Connection cnx1= DBConnect.openConnection();
                         pst1=cnx1.prepareStatement(sql1);
                         pst1.setString(1,"Returned");
                         pst1.setString(2,x);
                         pst1.executeUpdate();
                         
                         Connection cnx2= DBConnect.openConnection();
                         pst2=cnx1.prepareStatement(sql2);
                         pst2.setString(1,"Accepted");
                         pst2.setString(2,x);
                         pst2.executeUpdate();
                         dispose();
                         new Deposit().setVisible(true);
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null, e);
                     }
                     }
                }
            }
        }
    }//GEN-LAST:event_table2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // search
        try
        {
            table2.setDefaultRenderer(Object.class, new Render());
            JButton btn1 = new JButton();
            btn1.setName("u");
            btn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\systemsoftwareupdate_104262.png"));
            DefaultTableModel tm=(DefaultTableModel)table2.getModel();
            
            JButton btn2 = new JButton();
            btn2.setName("r");
            btn2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\ic_keyboard_return_128_28490.png"));
            
            String search;
            search=jTextField1.getText();
            String req="SELECT * FROM deposit_sale where depsale_id like '%"+search+"%' or estimate_price like '%"+search+"%' or sale_amount like '%"+search+"%' or sale_date like '%"+search+"%' or depsale_status like '%"+search+"%' or YEAR(deposit_date) like '%"+search+"%' or MONTH(deposit_date) = '%"+search+"%' or DAY(deposit_date) = '%"+search+"%';";  
            if(search=="") req="SELECT * FROM deposit_sale";
            /*Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url,DB_user,password);*/
            Connection con= DBConnect.openConnection();
            Statement st=(Statement) con.createStatement();
            ResultSet rs=st.executeQuery(req);
            tm.setRowCount(0); // clear jtable
            while(rs.next())
            {
                PreparedStatement ps1=con.prepareStatement("SELECT * FROM type, category, articles WHERE type.category_id=category.category_id AND articles.category_id=category.category_id AND articles.depsale_id="+rs.getInt("depsale_id"));
                ResultSet rs1=ps1.executeQuery();
                rs1.next();
                
                Object o[] = {rs.getInt("depsale_id"), rs1.getString("nature"), rs1.getInt("type_quantity"), rs.getInt("estimate_price"), rs.getInt("sale_amount"), rs.getDate("sale_date"),rs.getString("depsale_status"), rs.getDate("deposit_date"), btn1, btn2};
                tm.addRow(o);
            }           
            st.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null, ex.toString(), "Failure", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        new Deposit_Update().setVisible(true);
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
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
