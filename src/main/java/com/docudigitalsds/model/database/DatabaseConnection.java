package com.docudigitalsds.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {
        try {

            Properties prop = loadProperties();
            
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database...");
            
        } catch (SQLException | IOException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    private Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
        }
        return prop;
    }

    public Connection getConnection() {
        return this.connection;
    }
}