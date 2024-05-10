package com.docudigitalsds.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionDocumento.UbicacionFisicaDao;
import com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionUsuario.UsuarioDao;
import com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica;
import com.docudigitalsds.model.entities.gestionUsuario.Usuario;

public class LoginController extends HttpServlet {

    List<String> getUbicacionesFisicas() {

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();

        UbicacionFisicaDao ubicacionFisicaDao = new UbicacionFisicaDao(connection);

        List<UbicacionFisica> ubicaciones = ubicacionFisicaDao.getAll();

        List<String> ubicacionesStr = ubicaciones.stream()
            .map(ubicacion -> "ID: " + ubicacion.getIdUbicacionFisica() + ", Nombre: " + ubicacion.getNombre())
            .collect(Collectors.toList());

        return ubicacionesStr;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = authenticate(email, password);

        if (usuario != null) {

            System.out.println("Inicio de sesión exitoso");
            request.getSession().setAttribute("successMessage", "Inicio de sesión exitoso.");

            if (usuario.getIdRoles() == 1) {

                System.out.println("El usuario es un administrador, redirigir a la página de administrador");
                
                //TODO: Mejorar la forma en que se obtienen las ubicaciones físicas
                List<String> ubicaciones = getUbicacionesFisicas();
                request.getSession().setAttribute("ubicaciones", ubicaciones);

                request.getRequestDispatcher("/view/adminView.jsp").forward(request, response);

            } else if (usuario.getIdRoles() == 2) {
                System.out.println("El usuario es un usuario normal, redirigir a la página de usuario normal");
            }

        } else {

            System.out.println("El inicio de sesión falló, redirigir a la página de inicio de sesión");
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