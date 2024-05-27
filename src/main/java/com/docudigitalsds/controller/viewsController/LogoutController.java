package com.docudigitalsds.controller.viewsController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getSession().invalidate();
        request.getRequestDispatcher("/view/welcome.html").forward(request, response);
    }

}
