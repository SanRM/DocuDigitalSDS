package com.docudigitalsds.model.entities.gestionDocumento;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.docudigitalsds.model.database.DatabaseConnection;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.CategoriaDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.FechaRetencionLegalDao;
import com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao.UbicacionFisicaDao;

import java.util.Base64;

import java.sql.Connection;

public class Documento {
    private int idDocumento;
    private String titulo;
    private Timestamp fechaCreacion;
    private Timestamp fechaUltimaEdicion;
    private String descripcion;
    private long tamaño;
    private int numeroDeFolios;
    private int idCategorias;
    private int idFechasRetencionlegal;
    private int idUbicacionFisica;
    private byte[] archivo;

    // getters y setters...
    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTitulo() {
        return titulo; 
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaCreacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(fechaCreacion);
    }

    public Timestamp getFechaCreacionFinalAsTimestamp() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaUltimaEdicion() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(fechaUltimaEdicion);
    }

    public Timestamp getFechaUltimaEdicionFinalAsTimestamp() {
        return fechaUltimaEdicion;
    }
    
    public void setFechaUltimaEdicion(Timestamp fechaUltimaEdicion) {
        this.fechaUltimaEdicion = fechaUltimaEdicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public String getTamañoFormateado() {
        double tamañoBytes = this.tamaño;
        String tamañoFormateado;
    
        // Convertir a KB si el tamaño es mayor que 1024 bytes
        if (tamaño >= 1024) {
            tamañoBytes /= 1024;
            // Convertir a MB si el tamaño es mayor que 1024 KB
            if (tamañoBytes >= 1024) {
                tamañoBytes /= 1024;
                // Convertir a GB si el tamaño es mayor que 1024 MB
                if (tamañoBytes >= 1024) {
                    tamañoBytes /= 1024;
                    tamañoFormateado = String.format("%.2f GB", tamañoBytes);
                } else {
                    tamañoFormateado = String.format("%.2f MB", tamañoBytes);
                }
            } else {
                tamañoFormateado = String.format("%.2f KB", tamañoBytes);
            }
        } else {
            tamañoFormateado = String.format("%.2f bytes", tamañoBytes);
        }
    
        return tamañoFormateado;
    }

    public void setTamaño(long tamaño) {
        this.tamaño = tamaño;
    }

    public int getNumeroDeFolios() {
        return numeroDeFolios;
    }

    public void setNumeroDeFolios(int numeroDeFolios) {
        this.numeroDeFolios = numeroDeFolios;
    }

    public int getIdCategorias() {
        return idCategorias;
    }

    public String getNombreCategoria(){

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();
        CategoriaDao categoriaDao = new CategoriaDao(connection);
        return categoriaDao.getCategoryNameById(this.idCategorias);

    }

    public String getNombreUbicacionFisica(){

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();
        UbicacionFisicaDao ubicacionFisicaDao = new UbicacionFisicaDao(connection);
        return ubicacionFisicaDao.getUbicacionFisicaById(this.idUbicacionFisica);

    }

    public String getNombreFechaRetencion(){

        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();
        FechaRetencionLegalDao fechaRetencionLegalDao = new FechaRetencionLegalDao(connection);
        return fechaRetencionLegalDao.getFechaDeRetencionNameById(this.idFechasRetencionlegal);

    }

    public void setIdCategorias(int idCategorias) {
        this.idCategorias = idCategorias;
    }

    public int getIdFechasRetencionlegal() {
        return idFechasRetencionlegal;
    }

    public void setIdFechasRetencionlegal(int idFechasRetencionlegal) {
        this.idFechasRetencionlegal = idFechasRetencionlegal;
    }

    public int getIdUbicacionFisica() {
        return idUbicacionFisica;
    }

    public void setIdUbicacionFisica(int idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public String getArchivoBase64() {
        return archivo != null ? Base64.getEncoder().encodeToString(archivo) : null;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

}