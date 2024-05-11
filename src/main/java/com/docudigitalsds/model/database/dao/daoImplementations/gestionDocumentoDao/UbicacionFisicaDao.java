package com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao;

import com.docudigitalsds.model.database.dao.Dao;
import com.docudigitalsds.model.entities.gestionDocumento.UbicacionFisica;

import java.sql.*;

public class UbicacionFisicaDao extends Dao<UbicacionFisica> {

    public UbicacionFisicaDao(Connection connection) {
        super(connection);
    }

    @Override
    protected UbicacionFisica createEntityFromResultSet(ResultSet rs) throws SQLException {
        UbicacionFisica ubicacionFisica = new UbicacionFisica();
        ubicacionFisica.setIdUbicacionFisica(rs.getInt("idUbicacionFisica"));
        ubicacionFisica.setNombre(rs.getString("nombre"));
        ubicacionFisica.setDescripcion(rs.getString("descripcion"));
        return ubicacionFisica;
    }

    @Override
    protected String getTableName() {
        return "ubicacionFisica";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO ubicacionFisica (nombre, descripcion) VALUES (?, ?)";
    }

    @Override
    protected void setInsertStatementParameters(PreparedStatement ps, UbicacionFisica ubicacionFisica) throws SQLException {
        ps.setString(1, ubicacionFisica.getNombre());
        ps.setString(2, ubicacionFisica.getDescripcion());
    }

    @Override
    protected String getIdColumnName() {
        return "idUbicacionFisica";
    }
    
}