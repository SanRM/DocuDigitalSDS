package com.docudigitalsds.model.database.dao;

//import com.docudigitalsds.model.database.dao.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Dao<T> {

    //In this class, the methods that are common to all the DAOs are implemented.

    protected Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    protected abstract T createEntityFromResultSet(ResultSet rs) throws SQLException;

    protected abstract String getTableName();

    protected abstract String getIdColumnName();

    protected abstract String getInsertStatement();

    protected abstract void setInsertStatementParameters(PreparedStatement ps, T entity) throws SQLException;

    public T get(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createEntityFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + getTableName());
            while (rs.next()) {
                T entity = createEntityFromResultSet(rs);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void create(T entity) {
        try {
            PreparedStatement ps = connection.prepareStatement(getInsertStatement());
            setInsertStatementParameters(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String attributeName, String newValue) {
        try {
            String query = "UPDATE " + getTableName() + " SET " + attributeName + " = ? WHERE " + getIdColumnName() + " = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newValue);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}