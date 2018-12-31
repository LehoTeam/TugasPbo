/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siakad.form;

import siakad.lib.ManajerKoneksi;
import com.leho.daftar.IUser;
import com.leho.daftar.daftarFrame;
import com.leho.model.UserModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
   

/**
 *
 * @author Private
 */
public class FormLogin extends javax.swing.JFrame {
    public static IUser loginUser;
    private static Connection koneksi;
    public static UserModel usermodel = new UserModel();
    /**
     * Creates new form FormLogin
     */
    public FormLogin() {
        initComponents();
        loginUser = new ManajerKoneksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtJudul = new javax.swing.JLabel();
        btnUserName = new javax.swing.JLabel();
        btnPassword = new javax.swing.JLabel();
        usernameLogin = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        userPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtJudul.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        txtJudul.setText("SELAMAT DATANG DI SISTEM INFORMASI AKADEMIK");
        getContentPane().add(txtJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 11, -1, -1));

        btnUserName.setText("Username     :");
        getContentPane().add(btnUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, -1, -1));

        btnPassword.setText("Password     :");
        getContentPane().add(btnPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, -1, -1));

        usernameLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameLoginActionPerformed(evt);
            }
        });
        getContentPane().add(usernameLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 51, 330, -1));

        btnLogin.setText("Log In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        jButton1.setText("register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));
        getContentPane().add(userPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 330, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameLoginActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        usermodel.setUsername(usernameLogin.getText());
	ResultSet rs = loginUser.cekLogin(usernameLogin.getText(), userPassword.getText());
	
            try {
                if (rs.next()) {
                    if(usernameLogin.getText().equals(rs.getString("username")) && userPassword.getText().equals(rs.getString("password"))){
                       JOptionPane.showMessageDialog(null, "berhasil login");
                       new FormMahasiswa().show();
                       this.dispose();
                    }
                }else{
                       JOptionPane.showMessageDialog(null, "username atau password salah");
                       new FormLogin().show();
                       this.dispose();
                }
		      
            } catch (SQLException ex) {
                   Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
   
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        usernameLogin.setText("");
        userPassword.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new daftarFrame().show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel btnPassword;
    private javax.swing.JLabel btnUserName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel txtJudul;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JTextField usernameLogin;
    // End of variables declaration//GEN-END:variables
}