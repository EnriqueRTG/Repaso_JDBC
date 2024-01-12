package com.educacionit;

import com.educacionit.dominio.mascota.MascotaService;
import com.educacionit.dominio.usuario.UsuarioService;

import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();
        MascotaService mascotaService = new MascotaService();

        try {
            usuarioService.crearUsuario("maria@gmail.com", "maria123");
        } catch (Exception exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        try {
            mascotaService.crearMascota("negra", "Callejero", 3);
        } catch (Exception exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

    }
}