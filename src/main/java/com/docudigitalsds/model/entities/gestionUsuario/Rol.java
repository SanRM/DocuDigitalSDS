package com.docudigitalsds.model.entities.gestionUsuario;

public class Rol {
    private int idRoles;
    private String rol;
    private String descripcion;

    public int getIdRoles() {
        return idRoles;
    }
    
    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}