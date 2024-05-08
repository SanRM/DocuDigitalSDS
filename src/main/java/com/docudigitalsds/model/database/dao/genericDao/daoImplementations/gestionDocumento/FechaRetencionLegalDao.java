package com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionDocumento;

import com.docudigitalsds.model.database.dao.genericDao.GenericDao;
import com.docudigitalsds.model.entities.gestionDocumento.FechaRetencionLegal;

import java.sql.*;

public class FechaRetencionLegalDao extends GenericDao<FechaRetencionLegal> {

    public FechaRetencionLegalDao(Connection connection) {
        super(connection);
    }

    @Override
    protected FechaRetencionLegal createEntityFromResultSet(ResultSet rs) throws SQLException {
        FechaRetencionLegal fechaRetencionLegal = new FechaRetencionLegal();
        fechaRetencionLegal.setIdRetencionLegal(rs.getInt("legalRetentionid"));
        fechaRetencionLegal.setFechaRetencionFinal(rs.getTimestamp("FinalRetentionDate"));
        fechaRetencionLegal.setDescripcion(rs.getString("description"));
        return fechaRetencionLegal;
    }

    @Override
    protected String getTableName() {
        return "fechaRetencionLegal";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO fechaRetencionLegal (FinalRetentionDate, description) VALUES (?, ?)";
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