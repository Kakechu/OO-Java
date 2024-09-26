public class Main {
    public static void main(String[] args) {
        Luokkahuone luokka1 = new Luokkahuone(8);
        luokka1.setLuokanKoodi("Lambda");
        luokka1.tulostaLuokkahuone();

        while(!luokka1.taynna()) {
            luokka1.varaaPaikka();
            luokka1.tulostaTilanne();
        }

        if (luokka1.taynna()) {
            System.out.println("Luokka täynnä!");
        }

        luokka1.poistuuPaikalta();
        luokka1.poistuuPaikalta();

        luokka1.tulostaLuokkahuone();

        Luokkahuone luokka2 = new Luokkahuone(2);
        Luokkahuone luokka3 = new Luokkahuone(34);

        luokka2.setIstumapaikat(6);
        luokka2.setLuokanKoodi("B1038");

        luokka3.setLuokanKoodi("Alfa");
        luokka3.setIstumapaikat(50);

        luokka2.tulostaLuokkahuone();
        luokka3.tulostaLuokkahuone();

        luokka2.varaaPaikka();
        luokka2.varaaPaikka();
        luokka2.poistuuPaikalta();
        System.out.println(luokka2.getLuokanKoodi() + ": ");
        luokka2.tulostaTilanne();
        luokka2.varaaPaikka();
        System.out.println("Luokka: " + luokka2.getLuokanKoodi() + ", istumapaikkoja: " + luokka2.getIstumapaikat() + ", paikkoja varattu: " + luokka2.getVaratutPaikat());

    }
}