package com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao;

import com.docudigitalsds.model.database.dao.Dao;
import com.docudigitalsds.model.entities.gestionDocumento.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao extends Dao<Categoria> {

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

    public List<String> getCategoryNameList() {
        List<String> nombres = new ArrayList<>();
        for (Categoria categoria : getAll()) {
            nombres.add(categoria.getNombre());
        }
        return nombres;
    }

    public List<Integer> getCategoryIdList() {
        List<Integer> ids = new ArrayList<>();
        for (Categoria categoria : getAll()) {
            ids.add(categoria.getIdCategoria());
        }
        return ids;
    }

}