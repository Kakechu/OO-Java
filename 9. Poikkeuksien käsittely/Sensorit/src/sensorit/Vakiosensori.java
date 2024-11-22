package sensorit;

public class Vakiosensori implements Sensori {
    private boolean paalla = true;
    private int luku;

    public Vakiosensori(int luku) {
        this.luku = luku;
    }

    @Override
    public boolean onPaalla() {
        return paalla;
    }

    @Override
    public void paalle() {
    }

    @Override
    public void poisPaalta() {
    }

    @Override
    public int mittaa() {
        return this.luku;
    }
}
