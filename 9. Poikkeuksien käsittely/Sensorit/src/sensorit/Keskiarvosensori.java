package sensorit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Keskiarvosensori implements Sensori {
    private ArrayList<Sensori> sensorit = new ArrayList<>();
    private List<Integer> mittaukset = new ArrayList<>();
    private boolean paalla;

    public void lisaaSensori(Sensori sensori) {
        this.sensorit.add(sensori);
    }

    @Override
    public boolean onPaalla() {
        // Päällä silloin kuin kaikki sen sisältävät sensorit ovat päällä
        // Aluksi oletetaan, että on päällä.
        this.paalla = true;
        // Käydään läpi kaikki sensorit:
        // Jos yksikin on poissa päältä, this.paalla on false.
        for (Sensori sensori : sensorit) {
            if (!sensori.onPaalla()) {
                this.paalla = false;
            }
        }
        return this.paalla;

    }

    @Override
    public void paalle() {
        // Kun keskiarvosensori käynnistetään, täytyy kaikkien sen sisältävien sensorien käynnistyä jos ne eivät ole käynnissä
        for (Sensori sensori : sensorit) {
            if (!sensori.onPaalla()) {
                sensori.paalle();
            }
        }
        this.paalla = true;
    }

    @Override
    public void poisPaalta() {
        //Kun keskiarvosensori suljetaan, täytyy ainakin yhden sen sisältävän sensorin mennä pois päältä. Saa myös käydä niin että kaikki sen sisältävät sensorit menevät pois päältä.
        for (Sensori sensori : sensorit) {
            if (sensori.onPaalla()) {
                sensori.poisPaalta();
            }
        }
        this.paalla = false;
    }

    @Override
    public int mittaa() {
        if (!this.paalla) {
            throw new IllegalArgumentException("Mittari ei ole päällä");
        }

        int keskiarvo;
        int maara = this.sensorit.size();
        int summa = 0;

        for (Sensori sensori : sensorit) {
            int mittaustulos = sensori.mittaa();
            //System.out.println("Sensorin mittaustulos: " + mittaustulos); //testiprintti
            summa += mittaustulos;
        }

        keskiarvo = summa / maara;
        this.mittaukset.add(keskiarvo);

        return keskiarvo;
    }

    public List<Integer> mittaukset() {
        return this.mittaukset;
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
