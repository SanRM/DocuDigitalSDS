package com.docudigitalsds.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionUsuario.UsuarioDao;
import com.docudigitalsds.model.entities.gestionUsuario.Usuario;

public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = authenticate(email, password);

        if (usuario != null) {

            System.out.println("Inicio de sesión exitoso");

            if (usuario.getIdRoles() == 1) {
                System.out.println("El usuario es un administrador, redirigir a la página de administrador");
            } else if (usuario.getIdRoles() == 2) {
                System.out.println("El usuario es un usuario normal, redirigir a la página de usuario normal");
            }

        } else {

            System.out.println("El inicio de sesión falló, redirigir a la página de inicio de sesión");
        
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