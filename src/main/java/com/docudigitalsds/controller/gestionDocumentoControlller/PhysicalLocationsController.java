package com.docudigitalsds.controller.gestionDocumentoControlller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;
import com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PhysicalLocationsController extends HttpServlet {
    
    private Connection connection;
    private UbicacionFisicaDao ubicacionFisicaDao;
    DatabaseConnection dbConnection = new DatabaseConnection();

    public PhysicalLocationsController() {
        connection = dbConnection.getConnection();
        ubicacionFisicaDao = new UbicacionFisicaDao(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getPhysicalLocations(request);
        request.getRequestDispatcher("/view/documentosView/ubicacionesFisicasCrudView.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createPhysicalLocation(request);
        } else if ("update".equals(action)) {
            updatePhysicalLocation(request);
        } else if ("delete".equals(action)) {
            deletePhysicalLocation(request);
        }

        response.sendRedirect(request.getRequestURI());
    }


    private void getPhysicalLocations(HttpServletRequest request) {

        List<UbicacionFisica> physicalLocations = ubicacionFisicaDao.getAll();
        request.setAttribute("physicalLocationList", physicalLocations);

    }

    private void createPhysicalLocation(HttpServletRequest request) {

        String nombre = request.getParameter("nuevaUbicacionFisica");

        if (nombre != null && !nombre.isEmpty()) {
            UbicacionFisica ubicacionFisica = new UbicacionFisica();
            ubicacionFisica.setNombre(nombre);
            try {
                ubicacionFisicaDao.create(ubicacionFisica);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updatePhysicalLocation(HttpServletRequest request) {

        String idParam = request.getParameter("idUbicacionFisica");
        String nombre = request.getParameter("nombreUbicacionFisica");
        
        if (idParam != null && !idParam.isEmpty() && nombre != null && !nombre.isEmpty()) {

            int id = Integer.parseInt(idParam);

            UbicacionFisica ubicacionFisica = new UbicacionFisica();

            ubicacionFisica.setIdUbicacionFisica(id);
            ubicacionFisica.setNombre(nombre);

            try {

                System.err.println("El nuevo nombre de la ubicacion fisica con id " + id + " es: " + nombre);

                ubicacionFisicaDao.update(id, "nombre", nombre);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    

    private void deletePhysicalLocation(HttpServletRequest request) {

        String idParam = request.getParameter("idUbicacionFisica");

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            try {
                ubicacionFisicaDao.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}