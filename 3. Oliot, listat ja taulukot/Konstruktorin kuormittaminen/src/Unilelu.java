public class Unilelu {
    private String nimi;
    private String lelunTyyppi;
    private int ika;

    public Unilelu(String nimi, String lelunTyyppi, int ika) {
        this.nimi = nimi;
        this.lelunTyyppi = lelunTyyppi;
        this.ika = ika;
    }


    //Konstruktori, joka saa parametrikseen vain nimen
    public Unilelu(String nimi) {
        this.nimi = nimi;
        this.lelunTyyppi = "Tuntematon";
        //this.ika = 0;
    }

    // Konstruktori, joka saa vain lelun tyypin - Java ei salli tätä, joten tein vaihtoehtoisratkaisun:
    // Parametrina nimi ja tyyppi

    public Unilelu(String nimi, String lelunTyyppi) {
        this.nimi = nimi;
        this.lelunTyyppi = lelunTyyppi;
        //this.ika = 0;
    }

     /*

// Tässä vaihtoehtoinen tapa luoda konstruktorit, jotka ottavat vain nimen tai vain tyypin

// Static factory method -metodeja tosin kutsutaan kuin metodeja, ei konstruktorina.
    public static Unilelu nimi(String nimi) {
        return new Unilelu(nimi, "Tuntematon", 0);
    }

    public static Unilelu tyyppi(String tyyppi) {
        return new Unilelu("Tuntematon", tyyppi, 0);
    }
*/

    @Override
    public String toString() {
        return "Unilelun nimi:" + nimi + "\n" +
                "Unilelun tyyppi: " + lelunTyyppi + "\n" +
                "Unilelun ikä: " + ika;
    }
}
