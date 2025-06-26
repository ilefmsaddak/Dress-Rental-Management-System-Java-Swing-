/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.dao;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionProvider {
    
    public static Connection orclConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/orcl", "sys as sysdba", "maha13"
            );
            return conn;
        } 
         catch (Exception e) {
            
            System.out.println("Erreur de connexion "+e);
        }
        return null;
    }



    public static ResultSet operations(String query, String msg) {
            Connection connection = null;
                ResultSet rs = null;
            connection = orclConnection();  

            try {
                if (connection != null) {
                    Statement st = connection.createStatement();
                     rs = st.executeQuery(query);
                    if (!msg.equals("")) {
                        JOptionPane.showMessageDialog(null, msg);  

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }                   
            return rs;

     }
}