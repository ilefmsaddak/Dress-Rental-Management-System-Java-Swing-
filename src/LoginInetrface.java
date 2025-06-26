package src;

import src.dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import src.model.Client;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class LoginInetrface extends javax.swing.JFrame {    
public static Client clientConnecte;

    
    /**
     * Creates new form LoginInetrface
     */
     public LoginInetrface() {
        initComponents();
        btnLogin.setEnabled(false);
        btnchmdp.setEnabled(false);
        addListeners();
    }
    
    private void addListeners() {
        DocumentListener listener = new DocumentListener() {
            
            public void insertUpdate(DocumentEvent e) { checkFields(); }
            public void removeUpdate(DocumentEvent e) { checkFields(); }
            public void changedUpdate(DocumentEvent e) { checkFields(); }
        };

        txtEmail.getDocument().addDocumentListener(listener);
        txtmdp.getDocument().addDocumentListener(listener);
    }

    private void checkFields() {
        String email = txtEmail.getText().trim();
        String mdp = new String(txtmdp.getPassword()).trim();
        btnLogin.setEnabled(!email.isEmpty() && !mdp.isEmpty());
        btnchmdp.setEnabled(!email.isEmpty());
    }
    
   
   
  
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtmdp = new javax.swing.JPasswordField();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnsignup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnchmdp = new javax.swing.JButton();
        txtAdmin = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel1.setText("Email");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 190, -1));

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel2.setText("mot de passe");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 190, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 300, 30));

        btnLogin.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        btnLogin.setText("Se connectre");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, -1, -1));
        getContentPane().add(txtmdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 350, 300, 30));

        btnClear.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Effacer");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, -1, -1));

        btnExit.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnExit.setText("Se déconnecter");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 470, -1, -1));

        btnsignup.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnsignup.setText("s'inscrire");
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btnsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 540, -1, 40));

        jLabel4.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel4.setText("code admin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, -1, -1));

        btnchmdp.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        btnchmdp.setText("Changer mot de passe");
        btnchmdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchmdpActionPerformed(evt);
            }
        });
        getContentPane().add(btnchmdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, -1, 40));
        getContentPane().add(txtAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 410, 300, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loginpage.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String email = txtEmail.getText().trim();
        String mdp = new String(txtmdp.getPassword()).trim();
        String admin = txtAdmin.getText().trim(); 

        try {
            java.sql.Connection con = ConnectionProvider.orclConnection();
            String query = "SELECT * FROM clients WHERE email = ? AND mdp = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, mdp); 

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            int id = rs.getInt("id");
             String nom = rs.getString("nom");
    
            // 🔹 Enregistre le client connecté
            LoginInetrface.clientConnecte = new Client(id, nom);
            System.out.println(LoginInetrface.clientConnecte.id);
                    if (admin.equals("1234")) {
                        JOptionPane.showMessageDialog(this, "Bienvenue Admin ! Redirection vers la page Admin.", "Admin", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        new mainAdminInterface().setVisible(true);
                        
                    } else {
                        JOptionPane.showMessageDialog(this, "Connexion réussie ! Redirection vers la page Client.", "Client", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        new mainInterface().setVisible(true);
                    }
            }else {
                JOptionPane.showMessageDialog(this, "Email ou mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            
        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erreur de connexion à la base : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new signupinterface().setVisible(true);
    }//GEN-LAST:event_btnsignupActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null,"Do you really want to close Application ?","SELECT",JOptionPane.YES_NO_OPTION );
        if (a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtEmail.setText("");
        txtmdp.setText("");
        btnLogin.setEnabled(false);
    
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnchmdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchmdpActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        String email = txtEmail.getText().trim();
        new changepasswordinterface(email).setVisible(true);
    }//GEN-LAST:event_btnchmdpActionPerformed

    

    
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
            java.util.logging.Logger.getLogger(LoginInetrface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInetrface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInetrface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInetrface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInetrface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnchmdp;
    private javax.swing.JButton btnsignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtAdmin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtmdp;
    // End of variables declaration//GEN-END:variables

}
