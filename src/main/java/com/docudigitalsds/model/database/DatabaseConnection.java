package com.docudigitalsds.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database...");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found -> Include in library path");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();

        }
    }
   
    public Connection getConnection() {
        return this.connection;
    }
}