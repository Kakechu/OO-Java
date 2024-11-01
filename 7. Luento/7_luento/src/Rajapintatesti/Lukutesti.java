package Rajapintatesti;

import java.util.ArrayList;

public class Lukutesti {
    public static void main(String[] args) {
        ArrayList<String> sivut = new ArrayList<>();
        sivut.add("Pilko metodisi lyhyiksi luettaviksi kokonaisuuksiksi.");
        sivut.add("Erota käyttöliittymälogiikka sovelluksen logiikasta.");
        sivut.add("Ohjelmoi aina ensin pieni osa, jolla ratkaiset osan ongelmasta.");
        sivut.add("Harjoittelu tekee mestarin. Keksi ja tee omia kokeiluja ja projekteja.");

        Ekirja kirja = new Ekirja("Vinkkejä ohjelmointiin.", sivut);

        int sivu = 0;
        while (sivu < kirja.sivuja()) {
            System.out.println(kirja.lue());
            sivu = sivu + 1;
        }
    }
}
