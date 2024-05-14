package com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao;

import com.docudigitalsds.model.database.dao.Dao;
import com.docudigitalsds.model.entities.gestionDocumento.FechaRetencionLegal;

import java.sql.*;

public class FechaRetencionLegalDao extends Dao<FechaRetencionLegal> {

    public FechaRetencionLegalDao(Connection connection) {
        super(connection);
    }

    @Override
    protected FechaRetencionLegal createEntityFromResultSet(ResultSet rs) throws SQLException {
        FechaRetencionLegal fechaRetencionLegal = new FechaRetencionLegal();
        fechaRetencionLegal.setIdRetencionLegal(rs.getInt("idRetencionLegal"));
        fechaRetencionLegal.setFechaRetencionFinal(rs.getTimestamp("FechaRetencionFinal"));
        fechaRetencionLegal.setDescripcion(rs.getString("descripcion"));
        return fechaRetencionLegal;
    }

    @Override
    protected String getTableName() {
        return "fechasretencioneslegales";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO fechasretencioneslegales (FechaRetencionFinal, descripcion) VALUES (?, ?)";
    }

    @Override
    protected void setInsertStatementParameters(PreparedStatement ps, FechaRetencionLegal fechaRetencionLegal) throws SQLException {
        ps.setTimestamp(1, fechaRetencionLegal.getFechaRetencionFinal());
        ps.setString(2, fechaRetencionLegal.getDescripcion());
    }

    @Override
    protected String getIdColumnName() {
        return "idRetencionLegal";
    }
    
}