package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import src.dao.ConnectionProvider; 
import src.model.Facture;

public class RetournerRobe extends javax.swing.JFrame {
    final int PINALITE_VALUE=0;
    GestionLocationRobe loca_robe=new  GestionLocationRobe();
   
 
    /**
     * Creates new form ReturnDressFrame
     */ 
    public RetournerRobe() {
        initComponents();
        Calendar minDate = Calendar.getInstance();
         minDate.set(2000, Calendar.JANUARY, 1);
         Calendar maxDate = Calendar.getInstance();
         maxDate.set(2025, Calendar.DECEMBER, 31);

         // Apply to model
         SpinnerDateModel model = (SpinnerDateModel) date_sp.getModel();
         model.setStart(minDate.getTime());
         model.setEnd(maxDate.getTime());
         date_sp.setEditor(new JSpinner.DateEditor(date_sp, "yyyy-MM-dd"));

// Prevent manual typing
(    (JSpinner.DefaultEditor) date_sp.getEditor()).getTextField().setEditable(false);
      
       
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        retourner_rb = new javax.swing.JButton();
        robe_louer = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        robe_tab = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        penalt_tab = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        client = new javax.swing.JComboBox<>();
        facture = new javax.swing.JButton();
        date_sp = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel1.setText("Client");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, -1));

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel2.setText("Id robe louée");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel3.setText("Date retour");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        retourner_rb.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        retourner_rb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/retourner.png"))); // NOI18N
        retourner_rb.setText("Retourner robe");
        retourner_rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourner_rbActionPerformed(evt);
            }
        });
        getContentPane().add(retourner_rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 690, -1, -1));

        robe_louer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        robe_louer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robe_louerActionPerformed(evt);
            }
        });
        getContentPane().add(robe_louer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 190, 30));

        robe_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Description", "Taille", "Couleur", "Nom du Client", "Date de Location"
            }
        ));
        jScrollPane2.setViewportView(robe_tab);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 230, 514, 430));

        penalt_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nom du Client ", " Date de Location ", " Date de Retour Prévue", "  Date de Retour Effective", " Pénalité "
            }
        ));
        jScrollPane3.setViewportView(penalt_tab);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 700, 200));

        jLabel4.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel4.setText("Table de Robes louées par vous");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, 370, -1));

        jLabel5.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel5.setText("Table de penalité");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 210, -1));

        client.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientActionPerformed(evt);
            }
        });
        getContentPane().add(client, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 190, 30));

        facture.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        facture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        facture.setText("Facture");
        facture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factureActionPerformed(evt);
            }
        });
        getContentPane().add(facture, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 690, 200, -1));

        date_sp.setModel(new javax.swing.SpinnerDateModel());
        date_sp.setEditor(new javax.swing.JSpinner.DateEditor(date_sp, "yyyy-mm-dd"));
        getContentPane().add(date_sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 190, 30));

        jButton1.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/retourner.png"))); // NOI18N
        jButton1.setText("Reculer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 690, 210, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/retourner robe page.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void retourner_rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourner_rbActionPerformed

       String id = (String) robe_louer.getSelectedItem(); 
        int idLocation=Integer.parseInt(id);
        Date dateRetourReelle = new Date(); // aujourd’hui
        long joursRetard=0;
            try (Connection conn = ConnectionProvider.orclConnection()) {
                // 1. Récupérer la date_retour_due
                PreparedStatement ps1 = conn.prepareStatement("SELECT date_retour_due FROM locations WHERE id_location = ?");
                ps1.setInt(1, idLocation);
                ResultSet rs = ps1.executeQuery();
                
                if (rs.next()) {
                    Date dateRetourDue = rs.getDate("date_retour_due");
                    
                    // 2. Mettre à jour la date de retour réelle
                    PreparedStatement ps2 = conn.prepareStatement("UPDATE locations SET date_retour = ? WHERE id_location = ?");
                    ps2.setDate(1, new java.sql.Date(dateRetourReelle.getTime()));
                    ps2.setInt(2, idLocation);
                    ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Date de retour mise à jour avec succès !");
                    
                    // 3. Vérifier le retard
                    long diffMillis = dateRetourReelle.getTime() - dateRetourDue.getTime();
                    joursRetard = diffMillis / (1000 * 60 * 60 * 24);
                    
                    if (joursRetard > 0) {
                        double montantPenalite = joursRetard * PINALITE_VALUE; 
                        
                        // 4. Ajouter la pénalité
                        PreparedStatement ps3 = conn.prepareStatement(
                                "update locations set penalite =? where id_location=?"
                        );
                        ps3.setDouble(1, montantPenalite);
                        ps3.setDouble(2, idLocation);
                       
                        ps3.executeUpdate();
                        JOptionPane.showMessageDialog(null, 
                        "Retour en retard !\nPénalité appliquée : " + montantPenalite + " $");  
                    }
                    else{
                         JOptionPane.showMessageDialog(null, "Retour à temps. Aucune pénalité."); 
                    }
                  }
                 System.out.println("Bouton cliqué !");
                 setVisible(false);
new RetournerRobe().setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur lors du retour de la robe : " + e.getMessage());
    }
            


    }//GEN-LAST:event_retourner_rbActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        remplirComboClient(client);  
        loca_robe.remplirComboid_RobesLouees(robe_louer,client);    
        loca_robe.afficherRobesLouees(robe_tab,client);         
        loca_robe.afficherPenalites(penalt_tab,client); 
        
    }//GEN-LAST:event_formWindowOpened

    private void robe_louerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robe_louerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_robe_louerActionPerformed

    private void clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientActionPerformed
    client.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        loca_robe.afficherRobesLouees(robe_tab, client);
        loca_robe.afficherPenalites(penalt_tab,client); 
        loca_robe.remplirComboid_RobesLouees(robe_louer,client);
    }
});

    }//GEN-LAST:event_clientActionPerformed

    private void factureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factureActionPerformed
                  // Demander l'ID de la location
    String id = JOptionPane.showInputDialog("Entrer l'ID de la location :");
    if (id == null || id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une robe louée.");
        return;
    }

    try {
        int idLocation = Integer.parseInt(id);
        double prix = 0;
        float penalite = 0;

      String query = "SELECT r.prix, l.penalite FROM Robes r, locations l " +
               "WHERE l.id_robe = r.id AND l.id_location = ?";
                  java.sql.Connection conn = ConnectionProvider.orclConnection();

        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, idLocation);
        ResultSet rs = pst.executeQuery();
        if (rs != null && rs.next()) {
            prix = rs.getDouble("prix");
            penalite = rs.getFloat("penalite");
        }

        rs.getStatement().getConnection().close();

        double totalFacture = prix + penalite;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateAujourdHui = sdf.format(new java.util.Date());

        String factureDetails = """
                            ==================== FACTURE ====================
                            ID Facture: """ + idLocation +
                            "\nDate: " + dateAujourdHui +
                            "\nPrix: " + prix +
                            "\nPénalité: " + penalite +
                            "\n----------------------------------------------" +
                            "\nTotal Facture: " + totalFacture +
                            "\n=============================================";

        JOptionPane.showMessageDialog(null, factureDetails);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID de location invalide : " + id);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de l'affichage de la facture : " + e.getMessage());
    
    }//GEN-LAST:event_factureActionPerformed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         setVisible(false);
        new mainInterface().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
     
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RetournerRobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetournerRobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetournerRobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetournerRobe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetournerRobe().setVisible(true);
            }
        });
    }
    public void remplirComboClient(JComboBox<String> comboBox){
        comboBox.removeAllItems();
        try{
        Connection con=ConnectionProvider.orclConnection();
        int id=LoginInetrface.clientConnecte.id;
        String query ="select prenom from clients where id=?  ";
          System.out.println(LoginInetrface.clientConnecte.id);
         PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            comboBox.addItem(rs.getString("prenom"));
        }
        con.close(); 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> client;
    private javax.swing.JSpinner date_sp;
    private javax.swing.JButton facture;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable penalt_tab;
    private javax.swing.JButton retourner_rb;
    private javax.swing.JComboBox<String> robe_louer;
    private javax.swing.JTable robe_tab;
    // End of variables declaration//GEN-END:variables

}