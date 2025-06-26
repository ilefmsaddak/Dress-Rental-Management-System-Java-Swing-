package src;
import src.dao.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import src.model.Client;
/**
 *
 * @author Administrator
 */
public  class LouerRobe extends javax.swing.JFrame {
    /**
     * Creates new form RentDress
     */
    public LouerRobe() {
        initComponents();
        Calendar minDate = Calendar.getInstance();
        minDate.set(2000, Calendar.JANUARY, 1);
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(2025, Calendar.DECEMBER, 31);
        // Apply to model
        SpinnerDateModel model = (SpinnerDateModel) date_sp.getModel();
        model.setStart(minDate.getTime());
        model.setEnd(maxDate.getTime());

       // Set format (yyyy-MM-dd is correct)
        date_sp.setEditor(new JSpinner.DateEditor(date_sp, "yyyy-MM-dd"));

       // Prevent manual typing
       ((JSpinner.DefaultEditor) date_sp.getEditor()).getTextField().setEditable(false);
}
    
       
    public  List <String> get_Client(){
        List<String> clientNames = new ArrayList<>();
        String query = "SELECT prenom FROM clients"; 

        try (Connection connection = ConnectionProvider.orclConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Loop through the result set and add client names to the list
            while (resultSet.next()) {
                clientNames.add(resultSet.getString("prenom"));
            }

        } catch (SQLException e) {
            System.out.println("erreur de connexion");
            
        }
        return clientNames;
    }
    
     public static List<String> get_robes(){
        List<String> Robe_disc = new ArrayList<>();
        String query = "SELECT name FROM robes";  

        try (Connection connection = ConnectionProvider.orclConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Loop through the result  and add Robe discription to the list
            while (resultSet.next()) {
                Robe_disc.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            // Handle exceptions
            
        }
        return Robe_disc; 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        client_cb = new javax.swing.JComboBox<>();
        robe_cb = new javax.swing.JComboBox<>();
        louer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        robe_dispo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        taille_cb = new javax.swing.JComboBox<>();
        couleur_cb = new javax.swing.JComboBox<>();
        afficher = new javax.swing.JButton();
        date_sp = new javax.swing.JSpinner();
        nom_cl = new javax.swing.JTextField();
        dur = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        client_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        client_cb.setName("client_cb"); // NOI18N
        client_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                client_cbActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        robe_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        robe_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robe_cbActionPerformed(evt);
            }
        });
        getContentPane().add(robe_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 240, 40));

        louer.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        louer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/location.png"))); // NOI18N
        louer.setText("Louer");
        louer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                louerActionPerformed(evt);
            }
        });
        getContentPane().add(louer, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 680, 130, 50));

        robe_dispo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Robe", "Description", "Taille", "Couleur", "Matiere", "Prix"
            }
        ));
        jScrollPane1.setViewportView(robe_dispo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 535, 450));

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel2.setText("Robes disponibles");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 260, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 359, 87, -1));

        taille_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        taille_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taille_cbActionPerformed(evt);
            }
        });
        getContentPane().add(taille_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 240, 40));

        couleur_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(couleur_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 240, 40));

        afficher.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        afficher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestionrobe.png"))); // NOI18N
        afficher.setText("Afficher les robes disponibles");
        afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficherActionPerformed(evt);
            }
        });
        getContentPane().add(afficher, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, 320, 50));

        date_sp.setModel(new javax.swing.SpinnerDateModel());
        date_sp.setEditor(new javax.swing.JSpinner.DateEditor(date_sp, "yyyy-mm-dd"));
        getContentPane().add(date_sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 240, 40));
        getContentPane().add(nom_cl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 240, 40));

        dur.setModel(new javax.swing.SpinnerNumberModel());
        dur.setEditor(new javax.swing.JSpinner.NumberEditor(dur, ""));
        getContentPane().add(dur, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 240, 40));

        jLabel4.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel4.setText("Prenom ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, 30));

        jLabel5.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel5.setText("Taille");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jLabel6.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel6.setText("Couleur");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel7.setText("Date de Location");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        jLabel8.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel8.setText("Durée (jours)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, -1, -1));

        jLabel9.setFont(new java.awt.Font("Footlight MT Light", 0, 24)); // NOI18N
        jLabel9.setText("Choisir robe");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));

        jButton1.setFont(new java.awt.Font("Footlight MT Light", 0, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/retourner.png"))); // NOI18N
        jButton1.setText("Reculer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 680, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/location page.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       remplirCombotaille(taille_cb);
       remplirCombocouleur(couleur_cb);
       ((JSpinner.DefaultEditor) date_sp.getEditor()).getTextField().setEditable(false);   
    }//GEN-LAST:event_formWindowOpened

    private void louerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_louerActionPerformed
                                   
                                       
    String prenom = nom_cl.getText();
    int selectedRobe = Integer.parseInt(robe_cb.getSelectedItem().toString());
    Integer rentalDuration = ((Number) dur.getValue()).intValue();
    Date currentDate = new Date();
    Date returnDate = calculateReturnDate(rentalDuration, currentDate);

    try (Connection conn = ConnectionProvider.orclConnection()) {
        int idClient = Client.getClientId(prenom);

        // Vérifier si le client a déjà effectué une location
        String checkSql = "SELECT COUNT(*) FROM locations WHERE id_client = ?";
        boolean isNewClient = false;

        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            checkStmt.setInt(1, idClient);
            try (ResultSet checkRs = checkStmt.executeQuery()) {
                if (checkRs.next()) {
                    isNewClient = checkRs.getInt(1) == 0;  // si 0 => nouveau client
                }
            }
        }

        // Si nouveau client → insérer directement
        if (isNewClient) {
            String insertSql = "INSERT INTO locations (id_location, id_client, id_robe, date_location, date_retour_due, nombre_limite) VALUES (location_seq.nextval, ?, ?, ?, ?, 3)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, idClient);
                insertStmt.setInt(2, selectedRobe);
                insertStmt.setDate(3, new java.sql.Date(currentDate.getTime()));
                insertStmt.setDate(4, new java.sql.Date(returnDate.getTime()));
                int rows = insertStmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Robe louée avec succès (nouveau client) !");
                }
            }
            return; // Fin de l'exécution ici
        }

        // Sinon → client existant, faire les vérifications
        String activeSql = "SELECT COUNT(*) FROM locations WHERE id_client = ? AND date_retour IS NULL";
        int activeLocations = 0;
        try (PreparedStatement stmt = conn.prepareStatement(activeSql)) {
            stmt.setInt(1, idClient);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    activeLocations = rs.getInt(1);
                }
            }
        }

        String limitSql = "SELECT nombre_limite FROM locations WHERE id_client = ? FETCH FIRST 1 ROWS ONLY";
        int maxAllowed = 0;
        try (PreparedStatement stamt = conn.prepareStatement(limitSql)) {
            stamt.setInt(1, idClient);
            try (ResultSet res = stamt.executeQuery()) {
                if (res.next()) {
                    maxAllowed = res.getInt("nombre_limite");
                }
            }
        }

        System.out.println("Active: " + activeLocations + ", Max: " + maxAllowed);

        if (activeLocations >= maxAllowed) {
            JOptionPane.showMessageDialog(null, "Ce client a atteint le nombre maximum de locations autorisées.");
            return;
        }

        // Insertion normale
        String sql = "INSERT INTO locations (id_location, id_client, id_robe, date_location, date_retour_due, nombre_limite) VALUES (location_seq.nextval, ?, ?, ?, ?, ?)";
        try (PreparedStatement stamte = conn.prepareStatement(sql)) {
            stamte.setInt(1, idClient); 
            stamte.setInt(2, selectedRobe); 
            stamte.setDate(3, new java.sql.Date(currentDate.getTime())); 
            stamte.setDate(4, new java.sql.Date(returnDate.getTime())); 
            stamte.setInt(5, maxAllowed); // réutilise la même limite
            int rowsAffected = stamte.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Robe louée avec succès !");
            } else {
                System.out.println("Erreur lors de la location de la robe.");
            }
        }

    } catch (SQLException e) {
        System.out.println("Erreur de connexion à la base de données.");
    }

    } 
     private Date calculateReturnDate(int durationInDays, Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, durationInDays); 
        return calendar.getTime(); 
    }
  public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
           new LouerRobe().setVisible(true);
       });
   
        
        
        
        
        
        
        
        
        
        
        
     
        
        
        
        /* String prenom=(String) nom_cl.getText();
       int selectedRobe = Integer.parseInt((String) robe_cb.getSelectedItem());
          Integer rentalDuration = ((Number) dur.getValue()).intValue();
          Date currentDate = new Date(); // (date d'aujourdui)
          Date returnDate = calculateReturnDate(rentalDuration, currentDate);
          
        try (Connection conn = ConnectionProvider.orclConnection()) {
             // 1. Récupérer le nombre de locations actives du client
            String activeSql = "SELECT COUNT(*) FROM locations WHERE id_client = ? AND date_retour IS NULL";
            int activeLocations = 0;
            PreparedStatement stmt = conn.prepareStatement(activeSql);
                stmt.setInt(1, Client.getClientId(prenom));
                 ResultSet rs = stmt.executeQuery();
             if (rs.next()) {
            activeLocations = rs.getInt(1);
         }

         // 2. Récupérer la limite autorisée depuis la table client
         String limitSql = "SELECT nombre_limite FROM locations WHERE id_client = ?";
         int maxAllowed = 0;
         /*PreparedStatement stamt = conn.prepareStatement(limitSql);
             stamt.setInt(1, Client.getClientId(prenom));
             ResultSet res = stamt.executeQuery();
          if (res.next()) {
              maxAllowed = res.getInt("nombre_limite");
              
           try (PreparedStatement stamt = conn.prepareStatement(limitSql)) {
            stamt.setInt(1, Client.getClientId(prenom));
            try (ResultSet res = stamt.executeQuery()) {
                if (res.next()) {
                    maxAllowed = res.getInt("nombre_limite");
                }
            }
        }
          
    }
    // 3. Vérification
    if (activeLocations >= maxAllowed) {
        JOptionPane.showMessageDialog(null, "Ce client a atteint le nombre maximum de locations autorisées.");
        return;
    }       

         String sql = "INSERT INTO locations (id_location, id_client, id_robe, date_location, date_retour_due,nombre_limite) VALUES (location_seq.nextval, ?, ?, ?, ?,3)";
            try (PreparedStatement stamte = conn.prepareStatement(sql)) {
                stamte.setInt(1, Client.getClientId(prenom)); 
                stamte.setInt(2, selectedRobe); 
                stamte.setDate(3, new java.sql.Date(currentDate.getTime())); 
                stamte.setDate(4, new java.sql.Date(returnDate.getTime())); 
                int rowsAffected = stamte.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null,"Robe louée avec succès !");
                   
                } else {
                    System.out.println("Erreur lors de la location de la robe.");
                }
            }
   
            }
        catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données.");
        }
    }

    // Function to calculate the return date (date_retour_due)
   

    
   */

    }//GEN-LAST:event_louerActionPerformed

    private void taille_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taille_cbActionPerformed
        
    }//GEN-LAST:event_taille_cbActionPerformed

    private void afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherActionPerformed
        DefaultTableModel model = (DefaultTableModel) robe_dispo.getModel();
        model.setRowCount(0);
        String taille =(String) taille_cb.getSelectedItem();
        String couleur =(String) couleur_cb.getSelectedItem();
        Date date = (Date) date_sp.getValue();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        robe_cb.removeAllItems();
        try{
            Connection con=ConnectionProvider.orclConnection();
            String query="select id,description,taille,couleur,matiere,prix from robes where taille=? and couleur=? AND id NOT IN ( SELECT id_robe fROM locations wHERE date_retour IS NULL)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,taille);
            ps.setString(2,couleur);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
             Object[] row = {
            rs.getInt("id"),
            rs.getString("description"),
            rs.getString("taille"),
            rs.getString("couleur"),
            rs.getString("matiere"),
            rs.getDouble("prix"),
         };
              model.addRow(row);
              int id =rs.getInt("id");
              robe_cb.addItem(String.valueOf(id));
                
            }  
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
        }
        
    
        
        
    }//GEN-LAST:event_afficherActionPerformed

    private void robe_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robe_cbActionPerformed
       
 
    }//GEN-LAST:event_robe_cbActionPerformed

    private void client_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client_cbActionPerformed

    }//GEN-LAST:event_client_cbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         setVisible(false);
        new mainInterface().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    
 public void remplirCombotaille(JComboBox<String> comboBox){
        comboBox.removeAllItems();
        try{
            try (Connection con = ConnectionProvider.orclConnection()) {
                String query="select taille from robes";
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    comboBox.addItem(rs.getString("taille"));
                }   } 
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
        }
        
    }    
 public void remplirCombocouleur(JComboBox<String> comboBox){
        comboBox.removeAllItems();
        try{
            try (Connection con = ConnectionProvider.orclConnection()) {
                String query="select couleur from robes";
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    comboBox.addItem(rs.getString("couleur"));
                }   } 
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
        }
        
    }    

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afficher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> client_cb;
    private javax.swing.JComboBox<String> couleur_cb;
    private javax.swing.JSpinner date_sp;
    private javax.swing.JSpinner dur;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton louer;
    private javax.swing.JTextField nom_cl;
    private javax.swing.JComboBox<String> robe_cb;
    private javax.swing.JTable robe_dispo;
    private javax.swing.JComboBox<String> taille_cb;
    // End of variables declaration//GEN-END:variables

}