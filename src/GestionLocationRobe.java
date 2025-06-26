package src;
import src.dao.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import src.model.Client;

public class GestionLocationRobe {
  public int id_location ;
  public String date_location ;
  public String date_retour_due ;
  public String date_retour ;
  public int nombre_limite;
  public float penalite ;
     public GestionLocationRobe(){
         id_location=0;
         date_location="";
         date_retour_due="";
         date_retour="";
         nombre_limite=0;
         penalite=0;
    }
    public GestionLocationRobe(int id_loc,String date_location,String date_retour_due, String date_retour,int nombre_limite,float penalite){
        this.id_location=id_loc;
        this.date_location=date_location;
        this.date_retour_due=date_retour_due;
        this.date_retour=date_retour;
        this.nombre_limite=nombre_limite;
        this.penalite=penalite;      
    }
    
    
    
    
    public void remplirComboid_RobesLouees(JComboBox<String> comboBox,JComboBox<String> comboBox1){
    comboBox.removeAllItems();
    try {
        String client=comboBox1.getSelectedItem().toString();
        int client_id=Client.getClientId(client);
        Connection con = ConnectionProvider.orclConnection();
        int id=LoginInetrface.clientConnecte.id;
        String query ="SELECT id_location FROM locations l where l.id_client=? and date_retour is null  ";
          System.out.println(LoginInetrface.clientConnecte.id);
         PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            comboBox.addItem(String.valueOf(rs.getInt("id_location")));
        }
        con.close(); 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
    }
    
    }
   

    public  void afficherRobesLouees(JTable tableLouees,JComboBox<String> comboBox) {
    DefaultTableModel model = (DefaultTableModel) tableLouees.getModel();
    model.setRowCount(0);
     Client client = LoginInetrface.clientConnecte;
    if (client == null) {
        JOptionPane.showMessageDialog(null,"Aucun client connecté !");
        return;
    }
    try {
        Connection con =ConnectionProvider.orclConnection();
        String query ="SELECT r.description AS robe , r.taille, r.couleur, c.nom , date_location FROM robes r,clients c,locations l  where l.id_client=c.id and l.id_robe=r.id and l.id_client=? ";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, client.id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
                model.addRow(new Object[]{
                rs.getString("robe"),
                rs.getString("taille"),
                rs.getString("couleur"),
                rs.getString("nom"),
               rs.getDate("date_location"),
                
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
    }
}


 

    
 public void afficher_robe_disponible(JTable  tableRobe,JComboBox<String> comboBox,JComboBox<String> comboBox1){
     DefaultTableModel model = (DefaultTableModel) tableRobe.getModel();
     String taille = comboBox.getSelectedItem().toString();
     String couleur = comboBox.getSelectedItem().toString();
     model.setRowCount(0);
     try{
         Connection con=ConnectionProvider.orclConnection();
String query = 
            "SELECT r.id, r.taille, r.couleur, r.prix, l.date_location " +
            "FROM robes r " +
            "LEFT JOIN locations l ON r.id = l.id_robe " +
            "WHERE r.taille = ? AND r.couleur = ? " +
            "AND (l.id_robe IS NULL OR l.date_retour IS NOT NULL)";
PreparedStatement pst=con.prepareStatement(query);
         ResultSet rs=pst.executeQuery();
         pst.setString(1,taille);
         pst.setString(2,couleur);
         while(rs.next()){
            model.addRow(new Object[]{
           rs.getString("id"),
           rs.getString("taille"),
           rs.getString("couleur"),
           rs.getString("prix"),
           rs.getDate("date_location"),
         }); 
         }
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
         
     }
  
 }
      
   public void afficherPenalites(JTable tablePenalites,JComboBox<String> combobox) {
    String nomChoisi = combobox.getSelectedItem().toString();
    int id_client = Client.getClientId(nomChoisi);
    DefaultTableModel model = (DefaultTableModel) tablePenalites.getModel();
    model.setRowCount(0);
    try {
        Connection con = ConnectionProvider.orclConnection();
        String query = "SELECT  prenom,date_location,date_retour_due,date_retour,penalite  FROM clients c,locations l where l.id_client=c.id and l.id_client=? " ;
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,id_client);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("prenom") ,
                rs.getString("date_location"),
                rs.getDate("date_retour_due"),
                rs.getDate("date_retour"),
                rs.getFloat("penalite"),
                
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur: " + e.getMessage());
    }
}
   
   public int extractIdLocation(String selectedRental) {
    // Split the string based on " - " to separate the rental name from the location ID
    String[] parts = selectedRental.split(" - ");
    
    // Assuming the location ID is the last part, we extract it and convert it to an integer
    return Integer.parseInt(parts[1]); 
}


    public static void main(String args[]){
    }
    
}
    

