package com.docudigitalsds.model.database.dao.daoImplementations.gestionDocumentoDao;

import com.docudigitalsds.model.database.dao.Dao;
import com.docudigitalsds.model.entities.gestionDocumento.Documento;

import java.sql.*;

public class DocumentoDao extends Dao<Documento> {

    public DocumentoDao(Connection connection) {
        super(connection);
    }

    @Override
    protected Documento createEntityFromResultSet(ResultSet rs) throws SQLException {
        Documento documento = new Documento();
        documento.setIdDocumento(rs.getInt("idDocumento"));
        documento.setTitulo(rs.getString("titulo"));
        documento.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
        documento.setFechaUltimaEdicion(rs.getTimestamp("fechaUltimaEdicion"));
        documento.setDescripcion(rs.getString("descripcion"));
        documento.setArchivo(rs.getBytes("archivo"));
        documento.setTamaño(rs.getLong("tamaño"));
        documento.setNumeroDeFolios(rs.getInt("numeroDeFolios"));
        documento.setIdCategorias(rs.getInt("idCategorias"));
        documento.setIdFechasRetencionlegal(rs.getInt("idFechasRetencionlegal"));
        documento.setIdUbicacionFisica(rs.getInt("idUbicacionFisica"));
        return documento;
    }

    @Override
    protected String getTableName() {
        return "documentos";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO documentos (titulo, fechaCreacion, fechaUltimaEdicion, descripcion, archivo, tamaño, numeroDeFolios, idCategorias, idFechasRetencionlegal, idUbicacionFisica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }
    

    @Override
    protected void setInsertStatementParameters(PreparedStatement ps, Documento documento) throws SQLException {
        ps.setString(1, documento.getTitulo());
        ps.setTimestamp(2, documento.getFechaCreacion());
        ps.setTimestamp(3, documento.getFechaUltimaEdicion());
        ps.setString(4, documento.getDescripcion());
        ps.setBytes(5, documento.getArchivo());
        ps.setDouble(6, documento.getTamaño());
        ps.setInt(7, documento.getNumeroDeFolios());
        ps.setInt(8, documento.getIdCategorias());
        ps.setInt(9, documento.getIdFechasRetencionlegal());
        ps.setInt(10, documento.getIdUbicacionFisica());
    }

    @Override
    protected String getIdColumnName() {
        return "idDocumento";
    }

}