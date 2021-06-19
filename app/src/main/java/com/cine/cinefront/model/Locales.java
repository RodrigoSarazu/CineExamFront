package com.cine.cinefront.model;

public class Locales {
    private long id;
    private String nomloc;
    private String foto;


    public Locales(long id, String nomloc, String foto) {
        this.id = id;
        this.nomloc = nomloc;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomloc() {
        return nomloc;
    }

    public void setNomloc(String nomloc) {
        this.nomloc = nomloc;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
