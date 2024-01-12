package com.educacionit.dominio.usuario;

import com.educacionit.persistencia.UsuarioDAO;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void crearUsuario(String email, String clave) throws Exception {
        try {

            if (email == null || email.trim().isEmpty()) {
                throw new Exception("Debe ingresar el correo electronico");
            }
            if (email.contains("@") == false) {
                throw new Exception("El correo electronico es incorrecto");
            }
            if (clave == null || clave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }
            if (clave.length() < 8) {
                throw new Exception("La clave no puede tener menos de 8 caracteres");
            }
            if (this.usuarioDAO.buscarUsuarioPorEmail(email) != null) {
                throw new Exception("Ya existe un usuario con el correo indicado");
            }

            Usuario usuario = new Usuario();

            usuario.setEmail(email);
            usuario.setClave(clave);

            this.usuarioDAO.guardarUsuario(usuario);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public void modificarUsuario(Usuario usuario) throws Exception {

    }

}
