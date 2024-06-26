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

//Esta clase contiene los servicios por defecto que se puede utlizar cualquier rol

public class DefaultService {

    protected HttpServletRequest request;
    protected Connection connection;

    public DefaultService(HttpServletRequest request) {
        this.request = request;
        DatabaseConnection dbConnection = new DatabaseConnection();
        this.connection = dbConnection.getConnection();
        getDocumentosPorUbicacionYCategoria();
    }

    public void getCategoryNameList() {

        CategoriaDao categoriaDao = new CategoriaDao(connection);
        List<String> categoryNameList = categoriaDao.getCategoryNameList();
        List<Integer> categoryIdList = categoriaDao.getCategoryIdList();

        System.out.println("Category Name List: " + categoryNameList); // Debug code
        System.out.println("Category ID: " + categoryIdList); // Debug code
        request.getSession().setAttribute("categoryList", categoryNameList);
        request.getSession().setAttribute("categoryIdList", categoryIdList);
    }

    protected void getDocumentosPorUbicacionYCategoria() {

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
    }

}