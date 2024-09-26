public class Esiintyja {
    private String nimi;
    private String genre;

    public Esiintyja(String nimi, String genre) {
        this.nimi = nimi;
        this.genre = genre;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Esiintyjan nimi: " + nimi + "\n" +
                "Genre: " + genre;
    }
}
