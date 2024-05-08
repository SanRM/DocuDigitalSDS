package com.docudigitalsds.model.entities.gestionPrestamo;

import java.sql.Timestamp;

public class Prestamo {
    
    private int idPrestamo;
    private Timestamp fechaCreacion;
    private Timestamp fechaLimite;
    private boolean estadoActual;
    private int idUsuario;
    private int idDocumento;

    public int getIdPrestamo() {
        return idPrestamo;
    }
    
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Timestamp fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(boolean estadoActual) {
        this.estadoActual = estadoActual;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }
}