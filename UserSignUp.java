package com.chatapp;
import java.sql.*;

public class UserSignUp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/chat_app";
        String dbUsername = "root";
        String dbPassword = "nish1234";

        // Example user data to save
        String username = "testuser";
        String password = "testpass";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1. Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to database
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("Connected to database successfully!");

            // 3. Prepare SQL query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            // 4. Execute query
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User saved successfully!");
            } else {
                System.out.println("User not saved!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        } finally {
            // 5. Close resources
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
