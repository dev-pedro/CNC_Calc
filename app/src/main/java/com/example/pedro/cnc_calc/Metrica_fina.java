package com.example.pedro.cnc_calc;

/**
 * Created by pedro on 26/06/15.
 */
public class Metrica_fina {
    private String macho;
    private String d_broca;
    private String  passo;

    public Metrica_fina(String macho, String d_broca, String passo) {
        this.macho = macho;
        this.d_broca = d_broca;
        this.passo = passo;
    }

    public String getMacho() {
        return macho;
    }

    public void setMacho(String macho) {
        this.macho = macho;
    }

    public String getD_broca() {
        return d_broca;
    }

    public void setD_broca(String d_broca) {
        this.d_broca = d_broca;
    }

    public String getPasso() {
        return passo;
    }

    public void setPasso(String passo) {
        this.passo = passo;
    }
}
