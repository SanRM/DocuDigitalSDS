package com.docudigitalsds.test;

import java.sql.Connection;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;

public class AppTest {

    private static Connection connection;

    public AppTest() {
        // this.request = request;
        DatabaseConnection dbConnection = new DatabaseConnection();
        AppTest.connection = dbConnection.getConnection();
    }

    public static void main(String[] args) {

        new AppTest();

        CategoriaDao categoriaDao = new CategoriaDao(connection);

        categoriaDao.update(97, "nombre", "test update");

        //categoriaDao.update(69, "nombre", "123");

    }

}