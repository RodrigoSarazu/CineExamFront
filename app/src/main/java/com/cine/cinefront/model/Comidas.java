package com.cine.cinefront.model;

public class Comidas {
    private int idcom;
    private String nomcom;
    private String precio;
    private String fotocom;

    public Comidas(int idcom, String nomcom, String precio, String fotocom) {
        this.idcom = idcom;
        this.nomcom = nomcom;
        this.precio = precio;
        this.fotocom = fotocom;
    }

    public int getIdcom() {
        return idcom;
    }

    public void setIdcom(int idcom) {
        this.idcom = idcom;
    }

    public String getNomcom() {
        return nomcom;
    }

    public void setNomcom(String nomcom) {
        this.nomcom = nomcom;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFotocom() {
        return fotocom;
    }

    public void setFotocom(String fotocom) {
        this.fotocom = fotocom;
    }
}
