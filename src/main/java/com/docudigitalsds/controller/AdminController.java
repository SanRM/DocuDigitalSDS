package com.docudigitalsds.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;
import com.docudigitalsds.model.database.services.AdminService;

public class AdminController extends HttpServlet {

    DatabaseConnection dbConnection = new DatabaseConnection();
    UbicacionFisicaDao ubicacionFisicaDao;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        new AdminService(request);

        request.getRequestDispatcher("/view/adminView.jsp").forward(request, response);
    }

}