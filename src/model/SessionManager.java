/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sima
 */
public class SessionManager {
    private static String loggedInUserEmail; // Store the logged-in user's email

    // Set the email of the logged-in user
    public static void setLoggedInUserEmail(String email) {
        loggedInUserEmail = email;
    }

    // Get the email of the logged-in user
    public static String getLoggedInUserEmail() {
        return loggedInUserEmail;
    }

    // Clear the session (e.g., on logout)
    public static void clearSession() {
        loggedInUserEmail = null;
    }
}
