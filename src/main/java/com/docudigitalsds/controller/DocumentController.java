package com.docudigitalsds.controller;

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

public class DocumentController extends HttpServlet {
    
    private Connection connection;
    private CategoriaDao categoriaDao;
    DatabaseConnection dbConnection = new DatabaseConnection();

    public DocumentController() {
        connection = dbConnection.getConnection();
        categoriaDao = new CategoriaDao(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getCategories(request);
        request.getRequestDispatcher("/view/documentCrudView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createCategory(request);
        deleteCategory(request);
        updateCategory(request);
        response.sendRedirect(request.getRequestURI());
    }

    private void getCategories(HttpServletRequest request) {
        List<String> categoryNameList = categoriaDao.getCategoryNameList();
        List<Integer> categoryIdList = categoriaDao.getCategoryIdList();

        System.out.println("Category Name List: " + categoryNameList); // Debug code
        System.out.println("Category ID: " + categoryIdList); // Debug code
        request.getSession().setAttribute("categoryNameList", categoryNameList);
        request.getSession().setAttribute("categoryIdList", categoryIdList);
    }

    private void createCategory(HttpServletRequest request) {
        String nombre = request.getParameter("nuevaCategoria");
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        
        try {
            categoriaDao.create(categoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteCategory(HttpServletRequest request) {
        String idCategoriaParam = request.getParameter("idCategoria");
        
        if (idCategoriaParam != null) {
            int idCategoria = Integer.parseInt(idCategoriaParam);
            
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idCategoria);
            
            try {
                categoriaDao.delete(categoria.getIdCategoria());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void updateCategory(HttpServletRequest request) {
        String idCategoriaParam = request.getParameter("idCategoria");
        String nuevoNombre = request.getParameter("editCategoryName"); // Cambiado a editCategoryName
        
        if (idCategoriaParam != null && nuevoNombre != null) {
            int idCategoria = Integer.parseInt(idCategoriaParam);
            
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idCategoria);
            categoria.setNombre(nuevoNombre); 
            
            try {
                System.out.println("La categoria con id " + idCategoria + " se ha actualizado con el nombre " + nuevoNombre);
                categoriaDao.update(idCategoria, "nombre", nuevoNombre);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
