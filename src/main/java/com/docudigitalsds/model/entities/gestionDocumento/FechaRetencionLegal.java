package com.docudigitalsds.model.entities.gestionDocumento;

import java.sql.Timestamp;

public class FechaRetencionLegal {
    private int idRetencionLegal;
    private Timestamp FechaRetencionFinal;
    private String descripcion;

    // getters y setters...
    public int getIdRetencionLegal() {
        return idRetencionLegal;
    }

    public void setIdRetencionLegal(int idRetencionLegal) {
        this.idRetencionLegal = idRetencionLegal;
    }

    public Timestamp getFechaRetencionFinal() {
        return FechaRetencionFinal;
    }

    public void setFechaRetencionFinal(Timestamp FechaRetencionFinal) {
        this.FechaRetencionFinal = FechaRetencionFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}