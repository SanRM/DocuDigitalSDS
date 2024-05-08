package com.docudigitalsds.model.database.dao;

import java.util.List;

public interface Dao<T> {

    //El método get funciona para obtener un registro de una tabla
    T get(int id);

    //El método getAll funciona para obtener todos los registros de una tabla
    List<T> getAll();

    //El método save funciona para insertar o crear un nuevo registro en una tabla
    void create(T t);

    //El método update funciona para actualizar un registro de una tabla
    void update(int idUsuario, String attributeName, String newValue);

    //El método delete funciona para eliminar un registro de una tabla
    void delete(int id);
}