package com.educacionit.persistencia;

import java.sql.*;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "DeveloperJava1993";
    private final String DATABASE = "mascotas_jdbc";
    private final String DRIVE = "com.mysql.cj.jdbc.Driver";

    protected void conectarBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVE);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3307/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException exception) {
            throw exception;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception exception) {
            throw exception;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            this.conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException exception) {
            //connection.rollback(); si ocurre una exeption omite las operaciones realizadas
            throw exception;
        } finally {
            this.conectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            this.conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception exception) {
            throw exception;
        }
    }

}
