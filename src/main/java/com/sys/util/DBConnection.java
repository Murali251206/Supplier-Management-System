package com.sys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for database connectivity.
 */
public class DBConnection {
    // Database credentials - Update these as per your local setup
    private static final String URL = "jdbc:mysql://localhost:3306/supplier_management?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root"; 
    private static final String PASSWORD = "password"; // Use your MySQL password here

    private static Connection connection = null;

    /**
     * Establishes a connection to the database.
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Register JDBC driver (optional for modern JDBC versions)
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database Connection Failed! Check your MySQL credentials and status.");
            System.err.println("Error: " + e.getMessage());
        }
        return connection;
    }

    /**
     * Closes the connection.
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}
