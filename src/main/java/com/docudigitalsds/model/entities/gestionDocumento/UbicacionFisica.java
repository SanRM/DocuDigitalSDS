package com.docudigitalsds.model.entities.gestionDocumento;

public class UbicacionFisica {
    private int idUbicacionFisica;
    private String nombre;
    private String descripcion;

    // getters y setters...
    public int getIdUbicacionFisica() {
        return idUbicacionFisica;
    }
    
    public void setIdUbicacionFisica(int idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
