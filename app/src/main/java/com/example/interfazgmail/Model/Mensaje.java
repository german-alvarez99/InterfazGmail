package com.example.interfazgmail.Model;

public class Mensaje {
    private int user=0;
    private String mensaje="";
    private String aunto="";
    private String cuerpo="";
    private String fecha="";
    private Boolean favorito;

    public Mensaje(int IdUser,String mensaje, String asunto, String cuerpo, String fecha, Boolean favorito) {
        this.user=IdUser;
        this.mensaje = mensaje;
        this.aunto = asunto;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.favorito = favorito;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAunto() {
        return aunto;
    }

    public void setAunto(String aunto) {
        this.aunto = aunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }
}
