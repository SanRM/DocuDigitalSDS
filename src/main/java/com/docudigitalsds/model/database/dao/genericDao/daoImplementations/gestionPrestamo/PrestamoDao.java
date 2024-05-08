package com.docudigitalsds.model.database.dao.genericDao.daoImplementations.gestionPrestamo;

import com.docudigitalsds.model.database.dao.genericDao.GenericDao;
import com.docudigitalsds.model.entities.gestionPrestamo.Prestamo;

import java.sql.*;

public class PrestamoDao extends GenericDao<Prestamo> {

    public PrestamoDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return "prestamos";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO prestamos (fechaCreacion, fechaLimite, estadoActual, idUsuario, idDocumento) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected void setInsertStatementParameters(PreparedStatement ps, Prestamo prestamo) throws SQLException {
        ps.setTimestamp(1, prestamo.getFechaCreacion());
        ps.setTimestamp(2, prestamo.getFechaLimite());
        ps.setBoolean(3, prestamo.getEstadoActual());
        ps.setInt(4, prestamo.getIdUsuario());
        ps.setInt(5, prestamo.getIdDocumento());
    }

    @Override
    protected Prestamo createEntityFromResultSet(ResultSet rs) throws SQLException {
        Prestamo prestamo = new Prestamo();
        prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
        prestamo.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
        prestamo.setFechaLimite(rs.getTimestamp("fechaLimite"));
        prestamo.setEstadoActual(rs.getBoolean("estadoActual"));
        prestamo.setIdUsuario(rs.getInt("idUsuario"));
        prestamo.setIdDocumento(rs.getInt("idDocumento"));
        return prestamo;
    }

    @Override
    protected String getIdColumnName() {
        return "idPrestamo";
    }

}