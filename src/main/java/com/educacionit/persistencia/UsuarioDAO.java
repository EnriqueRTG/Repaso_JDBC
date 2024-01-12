package com.educacionit.persistencia;

import com.educacionit.dominio.usuario.Usuario;

import java.util.ArrayList;
import java.util.Collection;

public final class UsuarioDAO extends DAO {

    public void guardarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario que desea dar de alta");
            }

            String sql = "INSERT INTO Usuarios (email, clave)"
                    + " VALUES ( '" + usuario.getEmail() + "' , '" + usuario.getClave() + "' );";

            this.insertarModificarEliminar(sql);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }

            String sql = "UPDATE Usuarios SET "
                    + "clave = '" + usuario.getClave() + "' WHERE email = '" + usuario.getEmail() + "' );";

            this.insertarModificarEliminar(sql);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public void eliminarUsuario(String email) throws Exception {
        try {

            String sql = "DELETE FROM Usuarios WHERE email = '"
                    + email + "'";

            insertarModificarEliminar(sql);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) throws Exception {

        try {

            String sql = "SELECT * FROM Usuarios WHERE email = '" + email + "'";

            this.consultarBase(sql);

            Usuario usuario = null;

            while (resultado.next()) {
                usuario = new Usuario();

                usuario.setId(resultado.getInt("id"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setClave(resultado.getString("clave"));
            }

            this.desconectarBase();

            return usuario;

        } catch (Exception exception) {
            this.desconectarBase();
            throw exception;
        }

    }

    public Usuario buscarUsuarioPorId(int id) throws Exception {

        try {

            String sql = "SELECT * FROM Usuarios WHERE id = '" + id + "'";

            this.consultarBase(sql);

            Usuario usuario = null;

            while (resultado.next()) {
                usuario = new Usuario();

                usuario.setId(resultado.getInt("id"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setClave(resultado.getString("clave"));
            }

            this.desconectarBase();

            return usuario;

        } catch (Exception exception) {
            this.desconectarBase();
            throw exception;
        }

    }

    public Collection<Usuario> listarUsuarios() throws Exception {

        try {

            String sql = "SELECT * FROM Usuarios";

            this.consultarBase(sql);

            Usuario usuario = null;
            Collection<Usuario> usuarios = new ArrayList<>();

            while (resultado.next()) {
                usuario = new Usuario();

                usuario.setId(resultado.getInt("id"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setClave(resultado.getString("clave"));

                usuarios.add(usuario);
            }

            this.desconectarBase();

            return usuarios;

        } catch (Exception exception) {
            this.desconectarBase();
            throw exception;
        }

    }

}
