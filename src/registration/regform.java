/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import cafeapp.login;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class regform extends javax.swing.JFrame {

    /**
     * Creates new form regform
     */
    public regform() {
        initComponents();
        
    }
public static String eml, usern;
    
    public boolean duplicateCheck(){
        dbConnector dbc = new dbConnector();
        try{
            String sql = "SELECT * tbl_user WHERE user_name = '" +un.getText()+"' OR user_email = '"+em.getText()+"'";
             ResultSet rs = dbc.getData(sql);
            
             if(rs.next()){
                usern = rs.getString("user_name");
                if(usern.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already Used!");
                    un.setText("");
                }
                eml = rs.getString("user_email");
                if(eml.equals(em.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already Used!");
                    em.setText("");
                }
                return true; 
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println("" +ex);
            return false;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        con = new javax.swing.JButton();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CC = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        q = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(219, 180, 118));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("First name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 127, -1, 40));

        jLabel3.setText("Last name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel6.setText("Username:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        con.setText("Confirm");
        con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conActionPerformed(evt);
            }
        });
        jPanel1.add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 220, -1));
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 220, -1));
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 220, -1));

        jLabel7.setText("Password:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        CC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Cashier" }));
        jPanel1.add(CC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 210, -1));

        jLabel8.setText("Account Type:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));
        jPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 220, -1));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 220, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("REGISTER");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 200, 20));

        q.setText("Quit");
        jPanel1.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conActionPerformed
         
        if(fn.getText().isEmpty()
                || fn.getText().isEmpty()
                || ln.getText().isEmpty()
                || em.getText().isEmpty()
                || pass.getText().isEmpty())
            {
            JOptionPane.showMessageDialog(null, "All Fields should be Filled");
            }else if(pass.getText().length() <8){
            JOptionPane.showMessageDialog(null, "Maximum password should be above 8 character");
            pass.setText("");  
            
            }else if(duplicateCheck()){
                System.out.println("Duplicate");
            }else{
            dbConnector db = new dbConnector();

                if(db.insertData("INSERT INTO tbl_user (user_fname, user_lname, user_email, user_name, user_pass, account_type, account_status) "
                    + "VALUES ('"+fn.getText()+"',"
                    + " '"+ln.getText()+"',"
                    + " '"+em.getText()+"', "
                    + " '"+un.getText()+"', "
                    + "'"+pass.getText()+"', "
                    + "'"+CC.getSelectedItem()+"', 'Pending' ) ")){

                    JOptionPane.showMessageDialog(null, "Inserted Successfully!");
                }else{
                    JOptionPane.showMessageDialog(null, "Connection Error!");
                }
                    login login = new login();
                    login.setVisible(true);
                    this.dispose(); 
            }
        
        
    }//GEN-LAST:event_conActionPerformed

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
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CC;
    private javax.swing.JButton con;
    private javax.swing.JTextField em;
    private javax.swing.JTextField fn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField ln;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton q;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
