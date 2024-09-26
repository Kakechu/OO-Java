public class Elokuva {
    private String nimi;
    private String ohjaaja;
    private int julkaisuvuosi;
    private int ikaraja;
    private String genre;

    public Elokuva(String nimi, String ohjaaja, int julkaisuvuosi, int ikaraja, String genre) {
        this.nimi = nimi;
        this.ohjaaja = ohjaaja;
        this.julkaisuvuosi = julkaisuvuosi;
        this.ikaraja = ikaraja;
        this.genre = genre;
    }

    public void setIkaraja(int ikaraja) {
        this.ikaraja = ikaraja;
    }

    public String getNimi() {
        return nimi;
    }

    public String getOhjaaja() {
        return ohjaaja;
    }

    public int getJulkaisuvuosi() {
        return julkaisuvuosi;
    }

    public int getIkaraja() {
        return ikaraja;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Elokuva:\n" +
                "nimi: " + nimi + "\n" +
                "ohjaaja: " + ohjaaja + "\n" +
                "julkaisuvuosi: " + julkaisuvuosi + "\n" +
                "ikäraja: " + ikaraja + "\n" +
                "genre: " + genre + "\n";
    }



}
