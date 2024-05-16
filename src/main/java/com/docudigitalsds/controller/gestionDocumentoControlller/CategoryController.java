package com.docudigitalsds.controller.gestionDocumentoControlller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;
import com.docudigitalsds.model.entities.gestionDocumento.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryController extends HttpServlet {
    
    private Connection connection;
    private CategoriaDao categoriaDao;
    DatabaseConnection dbConnection = new DatabaseConnection();

    public CategoryController() {
        connection = dbConnection.getConnection();
        categoriaDao = new CategoriaDao(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getCategories(request);
        request.getRequestDispatcher("/view/documentosView/categoriasCrudView.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createCategory(request);
        } else if ("update".equals(action)) {
            updateCategory(request);
        } else if ("delete".equals(action)) {
            deleteCategory(request);
        }

        response.sendRedirect(request.getRequestURI());
    }


    public void getCategories(HttpServletRequest request) {

        List<Categoria> categories = categoriaDao.getAll();
        request.setAttribute("categoryNameList", categories);

    }

    public void createCategory(HttpServletRequest request) {

        String nombre = request.getParameter("nuevaCategoria");

        if (nombre != null && !nombre.isEmpty()) {
            Categoria categoria = new Categoria();
            categoria.setNombre(nombre);
            try {
                categoriaDao.create(categoria);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateCategory(HttpServletRequest request) {

        String idParam = request.getParameter("idCategoria");
        String nombre = request.getParameter("nombreCategoria");
        
        if (idParam != null && !idParam.isEmpty() && nombre != null && !nombre.isEmpty()) {

            int id = Integer.parseInt(idParam);

            Categoria categoria = new Categoria();

            categoria.setIdCategoria(id);
            categoria.setNombre(nombre);

            try {

                System.err.println("El nuevo nombre de la categoria con id " + id + " es: " + nombre);

                categoriaDao.update(id, "nombre", nombre);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    

    private void deleteCategory(HttpServletRequest request) {

        String idParam = request.getParameter("idCategoria");

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            try {
                categoriaDao.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
