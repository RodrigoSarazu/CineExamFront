package com.cine.cinefront.model;

public class Peliculas {
    private Long Idpeli;
    private String Nompeli;
    private String Infopeli;
    private String Fotopeli;

    public Peliculas(Long idpeli, String nompeli, String infopeli, String fotopeli) {
        Idpeli = idpeli;
        Nompeli = nompeli;
        Infopeli = infopeli;
        Fotopeli = fotopeli;
    }

    public Long getIdpeli() {
        return Idpeli;
    }

    public void setIdpeli(Long idpeli) {
        Idpeli = idpeli;
    }

    public String getNompeli() {
        return Nompeli;
    }

    public void setNompeli(String nompeli) {
        Nompeli = nompeli;
    }

    public String getInfopeli() {
        return Infopeli;
    }

    public void setInfopeli(String infopeli) {
        Infopeli = infopeli;
    }

    public String getFotopeli() {
        return Fotopeli;
    }

    public void setFotopeli(String fotopeli) {
        Fotopeli = fotopeli;
    }
}
