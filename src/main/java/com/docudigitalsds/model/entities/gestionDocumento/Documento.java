package com.docudigitalsds.model.entities.gestionDocumento;

import java.sql.Timestamp;

public class Documento {
    private int idDocumento;
    private String titulo;
    private Timestamp fechaCreacion;
    private Timestamp fechaUltimaEdicion;
    private String descripcion;
    private double tamaño;
    private int numeroDeFolios;
    private int idCategorias;
    private int idFechasRetencionlegal;
    private int idUbicacionFisica;

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

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaUltimaEdicion() {
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

    public void setTamaño(double tamaño) {
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

}