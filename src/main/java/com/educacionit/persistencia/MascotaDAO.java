package com.educacionit.persistencia;

import com.educacionit.dominio.mascota.Mascota;

import java.util.ArrayList;
import java.util.Collection;

public final class MascotaDAO extends DAO {

    private UsuarioDAO usuarioDAO;

    public MascotaDAO() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void guardarMascota(Mascota mascota) throws Exception {
        try {
            if (mascota == null) {
                throw new Exception("Debe indicar la mascota que desea dar de alta");
            }

            String sql = "INSERT INTO Mascotas (apodo, raza, id_usuario)"
                    + " VALUES ( '" + mascota.getApodo() + "' , '" + mascota.getRaza() + "' , '"
                    + mascota.getUsuario().getId() + "' );";

            this.insertarModificarEliminar(sql);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public void modificarMascota(Mascota mascota) throws Exception {
        try {
            if (mascota == null) {
                throw new Exception("Debe indicar la mascota que desea modificar");
            }

            String sql = "UPDATE Mascotas SET "
                    + "apodo = '" + mascota.getApodo() + "' , raza = '" + mascota.getRaza()
                    + "' id_usuario = '" + mascota.getUsuario().getId()
                    + "' WHERE id = '" + mascota.getId() + "' );";

            this.insertarModificarEliminar(sql);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public void eliminarMascota(int id) throws Exception {
        try {

            String sql = "DELETE FROM Mascotas WHERE id = '"
                    + id + "'";

            this.insertarModificarEliminar(sql);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public Mascota buscarMascotaPorId(int id) throws Exception {

        try {

            String sql = "SELECT * FROM Mascotas WHERE id = '" + id + "'";

            this.consultarBase(sql);

            Mascota mascota = null;

            while (resultado.next()) {
                mascota = new Mascota();

                mascota.setId(resultado.getInt("id"));
                mascota.setApodo(resultado.getString("apodo"));
                mascota.setRaza(resultado.getString("raza"));

                int id_usuario = resultado.getInt("id_usuario");

                mascota.setUsuario(this.usuarioDAO.buscarUsuarioPorId(id_usuario));
            }

            this.desconectarBase();

            return mascota;

        } catch (Exception exception) {
            this.desconectarBase();
            throw exception;
        }

    }

    public Collection<Mascota> listarMascotas() throws Exception {
        try {

            String sql = "SELECT * FROM Mascotas";

            this.consultarBase(sql);

            Mascota mascota = null;
            Collection<Mascota> mascotas = new ArrayList<>();

            while (resultado.next()) {
                mascota = new Mascota();

                mascota.setId(resultado.getInt("id"));
                mascota.setApodo(resultado.getString("apodo"));
                mascota.setRaza(resultado.getString("raza"));
                mascota.setUsuario(new UsuarioDAO().buscarUsuarioPorId(resultado.getInt("id_usuario")));

                mascotas.add(mascota);
            }

            this.desconectarBase();

            return mascotas;

        } catch (Exception exception) {
            this.desconectarBase();
            throw exception;
        }
    }


}
