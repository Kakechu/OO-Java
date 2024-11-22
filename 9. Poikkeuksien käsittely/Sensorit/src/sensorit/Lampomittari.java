package sensorit;

import java.util.Random;

public class Lampomittari implements Sensori {
    private boolean paalla;

    public Lampomittari() {
        this.paalla = false;
    }

    @Override
    public boolean onPaalla() {
        return paalla;
    }

    @Override
    public void paalle() {
        this.paalla = true;
    }

    @Override
    public void poisPaalta() {
        this.paalla = false;
    }

    public int mittaa() {
        if (!this.paalla) {
            throw new IllegalArgumentException("Mittari ei ole päällä");
        }
        int tulos = new Random().nextInt(61)-30;
        return tulos;
    }



    /*
        boolean onPaalla();  // palauttaa true jos sensori on päällä
        void paalle();       // käynnistä sensorin
    void poisPaalta();   // sulkee sensorin
    int mittaa();        // palauttaa sensorin lukeman jos sensori on
    //päällä
    // jos sensori ei ole päällä heittää poikkeuksen
    // IllegalStateException
     */
}
