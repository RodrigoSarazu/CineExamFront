package com.cine.cinefront.model;

public class MetodoPago {
    private Long idmetpag;
    private String tipopago;
    private String imgtipopago;

    public MetodoPago(Long idmetpag, String tipopago, String imgtipopago) {
        this.idmetpag = idmetpag;
        this.tipopago = tipopago;
        this.imgtipopago = imgtipopago;
    }

    public Long getIdmetpag() {
        return idmetpag;
    }

    public void setIdmetpag(Long idmetpag) {
        this.idmetpag = idmetpag;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getImgtipopago() {
        return imgtipopago;
    }

    public void setImgtipopago(String imgtipopago) {
        this.imgtipopago = imgtipopago;
    }
}
