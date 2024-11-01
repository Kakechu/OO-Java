package Rajapintatesti;

import java.util.ArrayList;

public class Ekirja implements Luettava {
    private String nimi;
    private ArrayList<String> sivut;
    private int sivunumero;

    public Ekirja(String nimi, ArrayList<String> sivut) {
        this.nimi = nimi;
        this.sivut = sivut;
        this.sivunumero = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public int sivuja() {
        return this.sivut.size();
    }

    public String lue() {
        String sivu = this.sivut.get(this.sivunumero);
        seuraavaSivu();
        return sivu;
    }

    private void seuraavaSivu() {
        this.sivunumero = this.sivunumero + 1;
        if (this.sivunumero % this.sivut.size() == 0) {
            this.sivunumero = 0;
        }
    }






}
