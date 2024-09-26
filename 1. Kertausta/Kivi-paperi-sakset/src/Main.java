import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int omatVoitot = 0;
        int tietokoneenVoitot = 0;

        while (omatVoitot < 3 && tietokoneenVoitot < 3) {
            int[] tulos = pelaaKierros(omatVoitot, tietokoneenVoitot);
            omatVoitot = tulos[0];
            tietokoneenVoitot = tulos[1];
            System.out.println("Tietokone " + tietokoneenVoitot + ", sinä " + omatVoitot);
        }
        System.out.println("Peli päättyi!");
        if (omatVoitot == 3) {
            System.out.println("Voitit!");
        } else {
            System.out.println("Hävisit!");
        }

    }
    public static String kysyValinta() {
        String syote = "";
        Scanner scan = new Scanner(System.in);
        while (true) {

            System.out.println("Kivi (k), paperi (p) vai sakset (s)?");
            syote = scan.nextLine();
            syote = syote.toLowerCase();
            if (syote.equals("k") || syote.equals("p") || syote.equals("s")) {
                //System.out.println("Valintasi: " + syote);
                break;
            } else {
                System.out.println("Tarkista syöte.");
            }
        }
        return syote;
    }

    public static String tietokoneenValinta() {
        Random rand = new Random();
        int numero = rand.nextInt(3) + 1;
        String valinta = "";
        switch (numero) {
            case 1:
                valinta = "k";
                System.out.println("Tietokone valitsi kiven.");
                break;
            case 2:
                valinta = "p";
                System.out.println("Tietokone valitsi paperin.");
                break;
            case 3:
                valinta = "s";
                System.out.println("Tietokone valitsi sakset.");
                break;
        }
        return valinta;
    }

    public static boolean voittikoKayttaja(String omaValinta, String tietokoneenValinta) {
        boolean voitto = false;
        if (omaValinta.equals("k")) {
            if (tietokoneenValinta.equals("p")) {
                System.out.println("Paperi peittää kiven!");
            } else if (tietokoneenValinta.equals("s")) {
                System.out.println("Kivi murskaa sakset!");
                voitto = true;
            }
        } else if (omaValinta.equals("p")) {
            if (tietokoneenValinta.equals("s")) {
                System.out.println("Sakset leikkaa paperin!");
            } else if (tietokoneenValinta.equals("k")) {
                System.out.println("Paperi peittää kiven!");
                voitto = true;
            }
        } else if (omaValinta.equals("s")) {
            if (tietokoneenValinta.equals("k")) {
                System.out.println("Kivi murskaa sakset!");
            } else if (tietokoneenValinta.equals("p")) {
                System.out.println("Sakset leikkaa paperin!");
                voitto = true;
            }
        }
        return voitto;

        /*
        return ((omaValinta.equals("k") && tietokoneenValinta.equals("s")) ||
                (omaValinta.equals("p") && tietokoneenValinta.equals("k")) ||
        (omaValinta.equals("s") && tietokoneenValinta.equals("p")));

         */
    }

    public static int[] pelaaKierros(int omatVoitot, int tietokoneenVoitot) {

        String valinta = kysyValinta();
        String tietokoneenValinta = tietokoneenValinta();
        int[] tulos = {omatVoitot, tietokoneenVoitot};
        if (valinta.equals(tietokoneenValinta)) {
            System.out.println("Tasapeli!");
        } else {
            if (voittikoKayttaja(valinta, tietokoneenValinta)) {
                System.out.println("Voitit!");
                omatVoitot++;
                tulos[0] = omatVoitot;
            } else {
                System.out.println("Hävisit!");
                tietokoneenVoitot++;
                tulos[1] = tietokoneenVoitot;
            }
        }
        return tulos;

    }
}