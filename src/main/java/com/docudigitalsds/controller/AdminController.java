package com.docudigitalsds.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;
import com.docudigitalsds.model.database.services.AdminService;
import com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica;

public class AdminController extends HttpServlet {

    private Connection connection;
    DatabaseConnection dbConnection = new DatabaseConnection();
    UbicacionFisicaDao ubicacionFisicaDao;

    public AdminController() {
        connection = dbConnection.getConnection();
        ubicacionFisicaDao = new UbicacionFisicaDao(connection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");

        UbicacionFisica ubicacionFisica = new UbicacionFisica();
        ubicacionFisica.setNombre(nombre);

        ubicacionFisicaDao.create(ubicacionFisica);

        response.sendRedirect(request.getRequestURI());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new AdminService(request);
        new CategoriaDao(connection);
        request.getRequestDispatcher("/view/adminView.jsp").forward(request, response);
    }

}