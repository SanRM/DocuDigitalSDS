package com.docudigitalsds.controller.viewsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;
import com.docudigitalsds.model.database.services.DefaultService;

public class HomeController extends HttpServlet {

    DatabaseConnection dbConnection = new DatabaseConnection();
    UbicacionFisicaDao ubicacionFisicaDao;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        new DefaultService(request);

        request.getRequestDispatcher("/view/homeView.jsp").forward(request, response);
    }

}