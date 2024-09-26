import java.util.ArrayList;
import java.util.Scanner;

public class Festarit {
    Scanner scan = new Scanner(System.in);

    private String alkamisaika;
    private String paattymisaika;
    private String tapahtumapaikka;

    ArrayList<Esiintyja> esiintyjat;
    ArrayList<Tyontekija> tyontekijat;

    int esiintyjienMaara = 0;
    int tyontekijoidenMaara = 0;

    //Konstruktori
    public Festarit(String alkamisaika, String paattymisaika, String tapahtumapaikka) {
        this.alkamisaika = alkamisaika;
        this.paattymisaika = paattymisaika;
        this.tapahtumapaikka = tapahtumapaikka;
        this.esiintyjat = new ArrayList<>();
        this.tyontekijat = new ArrayList<>();
    }

    //Lisää esiintyjä
    public void lisaaEsiintyja(Esiintyja e) {
        this.esiintyjat.add(e);
        this.esiintyjienMaara++;
    }

    //Poista esiintyjä
    public ArrayList<Esiintyja> poistaEsiintyja(Esiintyja e) {
        if (this.esiintyjat.contains(e)) {
            System.out.println("Haluatko varmasti poistaa esiintyjän " + e + "?\nVahvista valinta kirjoittamalla \"kyllä\".");
            String vastaus = scan.nextLine();
            if (vastaus == "Kyllä") {
                this.esiintyjat.remove(e);
                this.esiintyjienMaara--;
            } else {
                System.out.println("Esiintyjää ei poisteta.");
            }

        } else {
            System.out.println("Esiintyjää ei ole.");
        }
        return this.esiintyjat;
    }

    //Tulosta esiintyjät
    public void tulostaEsiintyjat() {
        for (Esiintyja e : this.esiintyjat) {
            System.out.println(e);
        }
    }


    //Lisää työntekijä
    public void lisaaTyontekija(Tyontekija t) {
        this.tyontekijat.add(t);
        this.tyontekijoidenMaara++;
        t.setKokemustaFestareista(t.getKokemustaFestareista()+1); //lisätään festarit kokemukseen, kun palkattu
    }

    //Poista tyontekija
    public ArrayList<Tyontekija> poistaTyontekija(Tyontekija t) {
        if (this.tyontekijat.contains(t)) {
            System.out.println("Haluatko varmasti poistaa työntekijän " + t + "?\nVahvista valinta kirjoittamalla \"kyllä\".");
            String vastaus = scan.nextLine();
            if (vastaus == "Kyllä") {
                this.tyontekijat.remove(t);
                this.tyontekijoidenMaara--;
            } else {
                System.out.println("Työntekijää ei poisteta.");
            }

        } else {
            System.out.println("Esiintyjää ei ole.");
        }
        return this.tyontekijat;
    }

    //Tulosta työntekijät
    public void tulostaTyontekijat() {
        for (Tyontekija t : this.tyontekijat) {
            System.out.println(t);
        }
    }


    //Getterit ja setterit

    public String getAlkamisaika() {
        return alkamisaika;
    }

    public void setAlkamisaika(String alkamisaika) {
        this.alkamisaika = alkamisaika;
    }

    public String getPaattymisaika() {
        return paattymisaika;
    }

    public void setPaattymisaika(String paattymisaika) {
        this.paattymisaika = paattymisaika;
    }

    public String getTapahtumapaikka() {
        return tapahtumapaikka;
    }

    public void setTapahtumapaikka(String tapahtumapaikka) {
        this.tapahtumapaikka = tapahtumapaikka;
    }

    @Override
    public String toString() {
        return "Festarit: \n"
                + "alkamisaika='" + alkamisaika + '\'' +
                ", paattymisaika='" + paattymisaika + '\'' +
                ", tapahtumapaikka='" + tapahtumapaikka + '\'' +
                '}';
    }
}
