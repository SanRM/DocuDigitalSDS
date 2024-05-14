package com.docudigitalsds.controller.gestionDocumentoControlller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.FechaRetencionLegalDao;
import com.docudigitalsds.model.entities.gestionDocumento.FechaRetencionLegal;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LegalRetentionDateController extends HttpServlet {
    
    private Connection connection;
    private FechaRetencionLegalDao fechaRetencionLegalDao;
    DatabaseConnection dbConnection = new DatabaseConnection();

    public LegalRetentionDateController() {
        connection = dbConnection.getConnection();
        fechaRetencionLegalDao = new FechaRetencionLegalDao(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getFechasRetencionLegales(request);
        request.getRequestDispatcher("/view/documentosView/fechasRetencionCrudView.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createFechaRetencionLegal(request);
        } else if ("update".equals(action)) {
            updateFechaRetencionLegal(request);
        } else if ("delete".equals(action)) {
            deleteFechaRetencionLegal(request);
        }

        response.sendRedirect(request.getRequestURI());
    }

    private void getFechasRetencionLegales(HttpServletRequest request) {

        List<FechaRetencionLegal> fechasRetencionLegales = fechaRetencionLegalDao.getAll();
        request.setAttribute("fechasRetencionLegales", fechasRetencionLegales);
    }

    private void createFechaRetencionLegal(HttpServletRequest request) {

        System.out.println("La fecha de retencion legal es: " + request.getParameter("fechaRetencionFinal"));
    
        String fechaRetencionFinalStr = request.getParameter("fechaRetencionFinal");
        
        if (fechaRetencionFinalStr != null && fechaRetencionFinalStr.length() == 16) {
            fechaRetencionFinalStr = fechaRetencionFinalStr.replace("T", " ") + ":00";
        }
    
        Timestamp fechaRetencionFinal = Timestamp.valueOf(fechaRetencionFinalStr);
        String descripcion = request.getParameter("descripcion");
    
        if (descripcion != null && !descripcion.isEmpty() && fechaRetencionFinal != null) {
    
            FechaRetencionLegal fechaRetencionLegal = new FechaRetencionLegal();
    
            fechaRetencionLegal.setFechaRetencionFinal(fechaRetencionFinal);
            fechaRetencionLegal.setDescripcion(descripcion);
            
            try {
                fechaRetencionLegalDao.create(fechaRetencionLegal);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    private void updateFechaRetencionLegal(HttpServletRequest request) {

        String idParam = request.getParameter("fechaId");
        String fechaRetencionFinalStr = request.getParameter("fechaRetencionFinal");
        String descripcion = request.getParameter("descripcion");
    
        if (idParam != null && !idParam.isEmpty() && descripcion != null && !descripcion.isEmpty()) {
            int id = Integer.parseInt(idParam);
    
            if (fechaRetencionFinalStr != null && fechaRetencionFinalStr.length() == 16) {
                fechaRetencionFinalStr = fechaRetencionFinalStr.replace("T", " ") + ":00";
            }
    
            Timestamp fechaRetencionFinal = Timestamp.valueOf(fechaRetencionFinalStr);
    
            FechaRetencionLegal fechaRetencionLegal = new FechaRetencionLegal();
            fechaRetencionLegal.setIdRetencionLegal(id);
            fechaRetencionLegal.setFechaRetencionFinal(fechaRetencionFinal);
            fechaRetencionLegal.setDescripcion(descripcion);
            try {
    
                fechaRetencionLegalDao.update(id, "FechaRetencionFinal", fechaRetencionFinal.toString());
                fechaRetencionLegalDao.update(id, "descripcion", descripcion);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteFechaRetencionLegal(HttpServletRequest request) {

        String idParam = request.getParameter("idRetencionLegal");
        
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            try {
                fechaRetencionLegalDao.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
