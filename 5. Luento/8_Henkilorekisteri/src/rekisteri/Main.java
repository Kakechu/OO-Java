package rekisteri;
import rekisteri.henkilot.Henkilo;
import rekisteri.kayttoliittyma.*;

public class Main {
    public static void main(String[] args) {
        Henkilo h1 = new Henkilo("Kake", 37);
        Henkilo h2 = new Henkilo("Lotta", 1);
        Henkilo h3 = new Henkilo("Antti", 37);

        Kayttoliittyma k = new Kayttoliittyma();
        k.naytaHenkilo(h1);
        k.naytaHenkilo(h2);
        k.naytaHenkilo(h3);

    }

}
