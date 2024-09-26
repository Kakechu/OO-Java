public class Lemmikit {
    private String laji;
    private String nimi;
    private int ika;
    private String aantely;

    public Lemmikit(String laji, String nimi, int ika, String aantely) {
        this.laji = laji;
        this.nimi = nimi;
        this.ika = ika;
        this.aantely = aantely;
    }

    public void tulostaLemmikki() {
        System.out.println(nimi + " on " + ika + "-vuotias " + laji + ", joka sanoo " + aantely);
    }

    public String aantele() {
        return aantely;
    }
}
