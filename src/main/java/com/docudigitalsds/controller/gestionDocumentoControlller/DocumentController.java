package com.docudigitalsds.controller.gestionDocumentoControlller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.DocumentoDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.FechaRetencionLegalDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;
import com.docudigitalsds.model.entities.gestionDocumento.Categoria;
import com.docudigitalsds.model.entities.gestionDocumento.Documento;
import com.docudigitalsds.model.entities.gestionDocumento.FechaRetencionLegal;
import com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class DocumentController extends HttpServlet {
    
    private Connection connection;
    private DocumentoDao documentoDao;
    DatabaseConnection dbConnection = new DatabaseConnection();

    public DocumentController() {
        connection = dbConnection.getConnection();
        documentoDao = new DocumentoDao(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getDocuments(request);

        getCategories(request);
        getPhysicalLocations(request);
        getFechasRetencionLegales(request);

        request.getRequestDispatcher("/view/documentosView/documentosCrudView.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createDocument(request);
        } else if ("update".equals(action)) {
            updateDocument(request);
        } else if ("delete".equals(action)) {
            deleteDocument(request);
        }

        response.sendRedirect(request.getRequestURI());
    }


    private void getDocuments(HttpServletRequest request) {

        List<Documento> documents = documentoDao.getAll();
        request.setAttribute("documentList", documents);

    }

    private void getCategories(HttpServletRequest request) {

        CategoriaDao categoriaDao = new CategoriaDao(connection);
        List<Categoria> categories = categoriaDao.getAll();
        request.setAttribute("categoryNameList", categories);

    }

    private void getPhysicalLocations(HttpServletRequest request) {

        UbicacionFisicaDao ubicacionFisicaDao = new UbicacionFisicaDao(connection);
        List<UbicacionFisica> physicalLocations = ubicacionFisicaDao.getAll();
        request.setAttribute("physicalLocationList", physicalLocations);

    }

   private void getFechasRetencionLegales(HttpServletRequest request) {

        FechaRetencionLegalDao fechaRetencionLegalDao = new FechaRetencionLegalDao(connection);
        List<FechaRetencionLegal> fechasRetencionLegales = fechaRetencionLegalDao.getAll();
        request.setAttribute("fechasRetencionLegales", fechasRetencionLegales);
    }

    private void createDocument(HttpServletRequest request) throws IOException, ServletException {
        System.err.println("Solicitud de creación de documento");
    
        String titulo = request.getParameter("titulo");
        Timestamp fechaCrecion = Timestamp.valueOf(LocalDateTime.now());
        Timestamp fechaUltimaEdicion = fechaCrecion;
        String descripcion = request.getParameter("descripcion");
        Part archivo = request.getPart("archivo");
        long tamaño = archivo.getSize();
        int numeroDeFolios = 0;
        Integer categoria = Integer.parseInt(request.getParameter("categoria"));
        Integer fechaRetencionLegal = Integer.parseInt(request.getParameter("fechaRetencionLegal"));
        Integer ubicacionFisica = Integer.parseInt(request.getParameter("ubicacionFisica"));
    
        if (titulo != null && !titulo.isEmpty() ) {
            Documento documento = new Documento();
            documento.setTitulo(titulo);
            documento.setFechaCreacion(fechaCrecion);
            documento.setFechaUltimaEdicion(fechaUltimaEdicion);
            documento.setDescripcion(descripcion);
            documento.setTamaño(tamaño);
            documento.setNumeroDeFolios(numeroDeFolios);
            documento.setIdCategorias(categoria);
            documento.setIdFechasRetencionlegal(fechaRetencionLegal);
            documento.setIdUbicacionFisica(ubicacionFisica);
    
            InputStream inputStream = archivo.getInputStream();
            byte[] bytes = new byte[(int) archivo.getSize()];
            inputStream.read(bytes);
            documento.setArchivo(bytes); 

            try {
                documentoDao.create(documento);
                System.err.println("Documento creado con éxito");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateDocument(HttpServletRequest request) {

        String idParam = request.getParameter("idDocumento");
        String titulo = request.getParameter("tituloDocumento");
        
        if (idParam != null && !idParam.isEmpty() && titulo != null && !titulo.isEmpty()) {

            int id = Integer.parseInt(idParam);

            Documento documento = new Documento();

            documento.setIdDocumento(id);
            documento.setTitulo(titulo);

            try {

                System.err.println("El nuevo titulo del documento con id " + id + " es: " + titulo);

                documentoDao.update(id, "titulo", titulo);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    

    private void deleteDocument(HttpServletRequest request) {

        String idParam = request.getParameter("idDocumento");

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            try {
                documentoDao.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}