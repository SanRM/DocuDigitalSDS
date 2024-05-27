package com.docudigitalsds.controller.viewsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionUsuarioDao.UsuarioDao;
import com.docudigitalsds.model.entities.gestionUsuario.Usuario;

public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = authenticate(email, password);

        if (usuario != null) {

            request.getSession().setAttribute("successMessage", "Inicio de sesión exitoso.");
            request.getSession().setAttribute("userRole", usuario.getIdRoles());
            response.sendRedirect("/docudigitalsds/HomeController");
            
        } else {

            request.getSession().setAttribute("errorMessage", "El inicio de sesión falló. Por favor, intenta de nuevo.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login.jsp");
            dispatcher.forward(request, response);

        }
    }

    private static Usuario authenticate(String email, String password) {

        Usuario usuario = null;
        Connection connection = null;
    
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            connection = dbConnection.getConnection();
    
            UsuarioDao usuarioDao = new UsuarioDao(connection);
            usuario = usuarioDao.getUsuarioByEmailAndPassword(connection, email, password);
        
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        
        return usuario;
    }

}