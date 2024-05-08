package com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionDocumento;

import com.docudigitalsds.model.database.dao.genericDao.GenericDao;
import com.docudigitalsds.model.entities.gestionDocumento.Categoria;

import java.sql.*;

public class CategoriaDao extends GenericDao<Categoria> {

    public CategoriaDao(Connection connection) {
        super(connection);
    }

    @Override
    protected Categoria createEntityFromResultSet(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("idCategoria"));
        categoria.setNombre(rs.getString("nombre"));
        categoria.setDescripcion(rs.getString("descripcion"));
        return categoria;
    }

    @Override
    protected String getTableName() {
        return "categorias";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
    }

    @Override
    protected void setInsertStatementParameters(PreparedStatement ps, Categoria categoria) throws SQLException {
        ps.setString(1, categoria.getNombre());
        ps.setString(2, categoria.getDescripcion());
    }

    @Override
    protected String getIdColumnName() {
        return "idCategoria";
    }

}