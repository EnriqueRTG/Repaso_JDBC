package com.educacionit.dominio.usuario;

public class Usuario {
    private int id;
    private String email;
    private String clave;

    public Usuario() {
    }

    public Usuario(int id, String email, String clave) {
        this.id = id;
        this.email = email;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
