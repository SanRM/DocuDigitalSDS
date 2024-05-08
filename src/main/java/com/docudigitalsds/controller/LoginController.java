package com.docudigitalsds.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + msg + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if ("admin@hotmail.com".equals(email) && "1234".equals(password)){

            processRequest(request, response, "Inicio de sesión exitoso");

        } else {

            processRequest(request, response, "Inicio de sesión fallido");

        }
        
    }


    // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     response.sendRedirect("view/login/login.jsp");
    // }

    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //     String email = request.getParameter("email");
    //     String password = request.getParameter("password");

    //     // Aquí debes autenticar al usuario. Este es solo un ejemplo.
    //     Usuario usuario = authenticate(email, password);

    //     if (usuario != null) {
    //         // El usuario se ha autenticado correctamente.
    //         // Ahora verificamos su rol y lo redirigimos a la vista correspondiente.
    //         if (usuario.getIdRoles() == 1) {
    //             // El usuario es un administrador.
    //             response.sendRedirect("view/admin/dashboard.jsp");
    //         } else if (usuario.getIdRoles() == 2) {
    //             // El usuario es un usuario normal.
    //             response.sendRedirect("view/user/dashboard.jsp");
    //         }
    //     } else {
    //         // La autenticación ha fallado. Redirigimos al usuario de vuelta a la página de
    //         // inicio de sesión.
    //         response.sendRedirect("view/login/login.jsp");
    //     }
    // }

    // private Usuario authenticate(String email, String password) {
    //     DatabaseConnection dbConnection = new DatabaseConnection();
    //     Connection connection = dbConnection.getConnection();

    //     System.out.println("Connection: " + connection);

    //     UsuarioDao usuarioDao = new UsuarioDao(connection);

    //     try {
    //         Usuario usuario = usuarioDao.getUsuarioByEmailAndPassword(email, password);
    //         return usuario;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     } finally {
    //         try {
    //             if (connection != null) {
    //                 connection.close();
    //             }
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return null;
    // }
 
}