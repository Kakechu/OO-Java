public class Tyontekija {
    private String nimi;
    private String tyo;
    private int kokemustaFestareista;


    public Tyontekija(String nimi, String tyo, int kokemustaFestareista) {
        this.nimi = nimi;
        this.tyo = tyo;
        this.kokemustaFestareista = kokemustaFestareista;
    }

    //Getterit ja setterit
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getTyo() {
        return tyo;
    }

    public void setTyo(String tyo) {
        this.tyo = tyo;
    }

    public int getKokemustaFestareista() {
        return kokemustaFestareista;
    }

    public void setKokemustaFestareista(int kokemustaFestareista) {
        this.kokemustaFestareista = kokemustaFestareista;
    }

    @Override
    public String toString() {
        return "Tyontekijän nimi: " + nimi + "\n" +
                "Työtehtävä: " + tyo + "\n" +
                "Kokemusta " + kokemustaFestareista + " festareista.";
    }
}
