public class Unilelu {
    private String nimi;
    private String lelunTyyppi;
    private int ika;

    public Unilelu(String nimi, String lelunTyyppi, int ika) {
        this.nimi = nimi;
        this.lelunTyyppi = lelunTyyppi;
        this.ika = ika;
    }

    public Unilelu(String nimi) {
        this.nimi = nimi;
        this.lelunTyyppi = "Tuntematon";
        //this.ika = 0;
    }

    // Konstruktori, joka saa vain lelun tyypin - Java ei salli

    public Unilelu(String nimi, String lelunTyyppi) {
        this.nimi = nimi;
        this.lelunTyyppi = lelunTyyppi;
        //this.ika = 0;
    }

    @Override
    public String toString() {
        return "Unilelun nimi:" + nimi + "\n" +
                "Unilelun tyyppi: " + lelunTyyppi + "\n" +
                "Unilelun ikä: " + ika;
    }
}
