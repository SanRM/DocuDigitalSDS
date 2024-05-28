package com.docudigitalsds.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {

        // Imprimir el classpath
        System.out.println(System.getProperty("java.class.path"));

        // Imprimir todas las claves de las variables de entorno
        System.out.println("MySQL Environment variables | DB_URL | DB_USER | DB_PASSWORD:");
        System.out.println("DB_URL: " + System.getenv("DB_URL"));
        System.out.println("DB_USER: " + System.getenv("DB_USER"));
        System.out.println("DB_PASSWORD: " + System.getenv("DB_PASSWORD"));

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