package com.docudigitalsds.model.database.dao.daoImplementations.gestionUsuarioDao;

import com.docudigitalsds.model.database.dao.Dao;
import com.docudigitalsds.model.entities.gestionUsuario.Usuario;

import java.sql.*;

public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao(Connection connection) {
        super(connection);
    }

    //This method is exclusive to the UsuarioDao class for this reason it is not in the GenericDao class
    public Usuario getUsuarioByEmailAndPassword(Connection connection, String email, String password) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND contraseña = ?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return createEntityFromResultSet(rs);
        }
        return null;
    }

    @Override
    protected String getTableName() {
        return "usuarios";
    }

    @Override
    protected String getInsertStatement() {
        return "INSERT INTO usuarios (nombre, apellidoPaterno, apellidoMaterno, email, contraseña, fechaCreacion, fechaUltimaEdicion, idRoles) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setInsertStatementParameters(PreparedStatement ps, Usuario usuario) throws SQLException {
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getApellidoPaterno());
        ps.setString(3, usuario.getApellidoMaterno());
        ps.setString(4, usuario.getEmail());
        ps.setString(5, usuario.getContraseña());
        ps.setTimestamp(6, usuario.getFechaCreacion());
        ps.setTimestamp(7, usuario.getFechaUltimaEdicion());
        ps.setInt(8, usuario.getIdRoles());
    }

    @Override
    protected String getIdColumnName() {
        return "idUsuario";
    }

    @Override
    protected Usuario createEntityFromResultSet(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
        usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
        usuario.setEmail(rs.getString("email"));
        usuario.setContraseña(rs.getString("contraseña"));
        usuario.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
        usuario.setFechaUltimaEdicion(rs.getTimestamp("fechaUltimaEdicion"));
        usuario.setIdRoles(rs.getInt("idRoles"));
        return usuario;
    }   

}