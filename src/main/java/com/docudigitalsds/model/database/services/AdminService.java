package com.docudigitalsds.model.database.services;

import java.util.ArrayList;
import java.util.List;

import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;
import com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica;

import jakarta.servlet.http.HttpServletRequest;

public class AdminService extends BaseService {

    public AdminService(HttpServletRequest request) {
        super(request);
    }

    // public void eliminarUbicacion(int idUbicacion) {
    //     UbicacionFisicaDao ubicacionFisicaDao = new UbicacionFisicaDao(connection);
    //     ubicacionFisicaDao.delete(idUbicacion);
    //     // Recargar los documentos después de eliminar una ubicación
    //     getDocumentosPorUbicacionYCategoria();
    // }

    // public void editarUbicacion(UbicacionFisica ubicacionFisica, String nuevoNombre) {
    //     UbicacionFisicaDao ubicacionFisicaDao = new UbicacionFisicaDao(connection);
    //     ubicacionFisicaDao.update(ubicacionFisica.getIdUbicacionFisica(), "nombre", nuevoNombre);
    //     // Recargar los documentos después de editar una ubicación
    //     getDocumentosPorUbicacionYCategoria();
    // }

    public List<String> getUbicaciones() {
        UbicacionFisicaDao ubicacionFisicaDao = new UbicacionFisicaDao(connection);
        List<UbicacionFisica> ubicaciones = ubicacionFisicaDao.getAll();
        List<String> nombresUbicaciones = new ArrayList<>();
        for (UbicacionFisica ubicacion : ubicaciones) {
            nombresUbicaciones.add(ubicacion.getNombre());
        }
        return nombresUbicaciones;
    }

}