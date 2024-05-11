package com.docudigitalsds.model.database.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.DocumentoDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;
import com.docudigitalsds.model.entities.gestionDocumento.Categoria;
import com.docudigitalsds.model.entities.gestionDocumento.Documento;
import com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica;

import jakarta.servlet.http.HttpServletRequest;

public class BaseService {

    protected HttpServletRequest request;
    protected Connection connection;

    public BaseService(HttpServletRequest request) {
        this.request = request;
        DatabaseConnection dbConnection = new DatabaseConnection();
        this.connection = dbConnection.getConnection();
        getDocumentosPorUbicacionYCategoria();
    }

    protected Map<String, Map<String, List<Documento>>> getDocumentosPorUbicacionYCategoria() {

        DocumentoDao documentoDao = new DocumentoDao(connection);
        List<Documento> documentos = documentoDao.getAll();
    
        UbicacionFisicaDao ubicacionFisicaDao = new UbicacionFisicaDao(connection);
        List<UbicacionFisica> ubicacionesFisicas = ubicacionFisicaDao.getAll();
    
        CategoriaDao categoriaDao = new CategoriaDao(connection);
        List<Categoria> categorias = categoriaDao.getAll();
    
        Map<String, Map<String, List<Documento>>> documentosPorUbicacionYCategoria = new HashMap<>();
    
        // Inicializar el mapa con todas las ubicaciones físicas y un mapa vacío de categorías y documentos
        for (UbicacionFisica ubicacionFisica : ubicacionesFisicas) {
            documentosPorUbicacionYCategoria.put(ubicacionFisica.getNombre(), new HashMap<>());
        }
    
        // Agregar los documentos a las listas correspondientes
        for (Documento documento : documentos) {
            String nombreUbicacion = ubicacionesFisicas.stream()
                .filter(ubicacion -> ubicacion.getIdUbicacionFisica() == documento.getIdUbicacionFisica())
                .findFirst()
                .get()
                .getNombre();

            String nombreCategoria = categorias.stream()
                .filter(categoria -> categoria.getIdCategoria() == documento.getIdCategorias())
                .findFirst()
                .get()
                .getNombre();
            Map<String, List<Documento>> mapCategoriaDocumento = documentosPorUbicacionYCategoria.get(nombreUbicacion);
            
            if (!mapCategoriaDocumento.containsKey(nombreCategoria)) {
                mapCategoriaDocumento.put(nombreCategoria, new ArrayList<>());
            }

            mapCategoriaDocumento.get(nombreCategoria).add(documento);
            
        }
    
        request.getSession().setAttribute("documentosPorUbicacionYCategoria", documentosPorUbicacionYCategoria);

        return documentosPorUbicacionYCategoria;
    }

}