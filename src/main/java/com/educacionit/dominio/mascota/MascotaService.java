package com.educacionit.dominio.mascota;

import com.educacionit.dominio.usuario.Usuario;
import com.educacionit.persistencia.MascotaDAO;
import com.educacionit.persistencia.UsuarioDAO;

public class MascotaService {
    private MascotaDAO mascotaDAO;
    private UsuarioDAO usuarioDAO;

    public MascotaService() {
        this.mascotaDAO = new MascotaDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void crearMascota(String apodo, String raza, int id_usuario) throws Exception {
        try {

            if (apodo == null || apodo.trim().isEmpty()) {
                throw new Exception("Debe ingresar el apodo");
            }
            if (raza == null || raza.trim().isEmpty()) {
                throw new Exception("Debe indicar la raza");
            }
            if (id_usuario == 0) {
                throw new Exception("Debe indicar el id de usuario");
            }
            if (this.usuarioDAO.buscarUsuarioPorId(id_usuario) == null) {
                throw new Exception("El usuario indicado no existe");
            }

            Mascota mascota = new Mascota();

            mascota.setApodo(apodo);
            mascota.setRaza(raza);
            mascota.setUsuario(this.usuarioDAO.buscarUsuarioPorId(id_usuario));

            this.mascotaDAO.guardarMascota(mascota);

        } catch (Exception exception) {
            throw exception;
        }
    }
}
