package src;


import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.SessionManager;
import javax.swing.event.DocumentListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Sima
 */
public class changepasswordinterface extends javax.swing.JFrame {

    private final String emailUtilisateur;

    /**
     * Creates new form changepasswordinterface
     */
    // This line is misplaced and should be moved to the main method or another appropriate method.

    public changepasswordinterface(String email) {
        this.emailUtilisateur = email;
        initComponents();
    }
       
 
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtamdp = new javax.swing.JPasswordField();
        txtnmdp = new javax.swing.JPasswordField();
        txtcmdp = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 2, 24)); // NOI18N
        jLabel2.setText("ancien mot de passe ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, -1, 30));

        jLabel3.setFont(new java.awt.Font("Footlight MT Light", 2, 24)); // NOI18N
        jLabel3.setText("nouveau mot de passe ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, 30));

        jLabel4.setFont(new java.awt.Font("Footlight MT Light", 2, 24)); // NOI18N
        jLabel4.setText("confirmation de mot de passe ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, -1, 30));

        jButton1.setFont(new java.awt.Font("Footlight MT Light", 2, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enregistrer.png"))); // NOI18N
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, -1, -1));

        jButton2.setFont(new java.awt.Font("Footlight MT Light", 2, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        jButton2.setText("se connecter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 560, -1, -1));

        txtamdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamdpActionPerformed(evt);
            }
        });
        getContentPane().add(txtamdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 260, 30));
        getContentPane().add(txtnmdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 390, 260, 30));

        txtcmdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcmdpActionPerformed(evt);
            }
        });
        getContentPane().add(txtcmdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 440, 260, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/changepasswdpage.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtamdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamdpActionPerformed

    private void txtcmdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcmdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcmdpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ancienMDP = new String (txtamdp.getPassword()).trim();
        String nouveauMDP = new String (txtnmdp.getPassword()).trim();
        String confirmationMDP = new String (txtcmdp.getPassword()).trim();
    
            if (!nouveauMDP.equals(confirmationMDP)) {
                JOptionPane.showMessageDialog(null, "Le mot de passe de confirmation ne correspond pas.");
                return;
            }
    
            if (nouveauMDP.length() < 8) {
                JOptionPane.showMessageDialog(null, "Le nouveau mot de passe doit contenir au moins 8 caractères.");
                return;
            }
            
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                try (Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/orcl", "sys as sysdba", "maha13")) {
                
                // Vérification de l'ancien mot de passe
                String checkQuery = "SELECT * FROM clients WHERE email = ? AND mdp = ?";
                    try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
                        checkStmt.setString(1, emailUtilisateur);
                        checkStmt.setString(2, ancienMDP);
                    try (ResultSet rs = checkStmt.executeQuery()) {
                        if (rs.next()) {
                            // Mise à jour du mot de passe
                            String updateQuery = "UPDATE clients SET mdp = ? WHERE email = ?";
                            try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
                                updateStmt.setString(1, nouveauMDP);
                                updateStmt.setString(2, emailUtilisateur);
                                updateStmt.executeUpdate();
                                
                                JOptionPane.showMessageDialog(null, "Mot de passe modifié avec succès.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ancien mot de passe incorrect.");
                        }
                    }
                    }
            }
    
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage());
        
    }                                        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new LoginInetrface().setVisible(true);
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
            java.util.logging.Logger.getLogger(changepasswordinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepasswordinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepasswordinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepasswordinterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new changepasswordinterface("exemple@email.com").setVisible(true);
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txtamdp;
    private javax.swing.JPasswordField txtcmdp;
    private javax.swing.JPasswordField txtnmdp;
    // End of variables declaration//GEN-END:variables
}
