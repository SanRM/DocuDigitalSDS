package com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionUsuario;

import com.docudigitalsds.model.database.dao.genericDao.GenericDao;
import com.docudigitalsds.model.entities.gestionUsuario.Rol;

import java.sql.*;

public class RolDao extends GenericDao<Rol> {

    public RolDao(Connection connection) {
        super(connection);
    }

    @Override
    protected Rol createEntityFromResultSet(ResultSet rs) throws SQLException {
        Rol rol = new Rol();
        rol.setIdRoles(rs.getInt("idRoles"));
        rol.setRol(rs.getString("rol"));
        rol.setDescripcion(rs.getString("descripcion"));
        return rol;
    }

    @Override
    protected String getTableName() {
        return "roles";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO roles (rol, descripcion) VALUES (?, ?)";
    }

    @Override
    protected void setInsertStatementParameters(PreparedStatement ps, Rol rol) throws SQLException {
        ps.setString(1, rol.getRol());
        ps.setString(2, rol.getDescripcion());
    }

    @Override
    protected String getIdColumnName() {
        return "idRoles";
    }

}