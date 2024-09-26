import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    komennot();

    }

    public static void komennot() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Komento (1 haku, 2 lisää, 3 lopeta):");
            try {
                int syote = scan.nextInt();
                if (syote == 3) {
                    System.out.println("Lopetetaan...");
                    break;
                } else if (syote == 1) {
                    hae();
                } else if (syote == 2) {
                    lisaa();
                } else {
                    System.out.println("Virheellinen syöte.");
                }
            } catch (Exception e) {
                System.out.println("Virheellinen syöte. Syötä kokonaisluku.");
                scan.next();
            }
        }
        scan.close();
    }


    public static void lisaa() {
        Scanner scan = new Scanner(System.in);
        //kysytään nimi ja numero erikseen
        System.out.println("Nimi: ");
        String nimi = scan.nextLine();
        System.out.println("Numero: ");
        String numero = scan.nextLine();


        try {
            File tiedosto = new File("tiedosto.txt");
            StringBuilder sisalto = new StringBuilder(); //luodaan stringbuilder-objekti, jotta sisältöä voidaan muokata
            boolean loytyi = false;


            if (tiedosto.exists()) {
                Scanner fileScanner = new Scanner(tiedosto);

                while (fileScanner.hasNextLine()) {
                    String rivi = fileScanner.nextLine();
                    if (rivi.startsWith(nimi)) {
                        rivi = rivi + "," + numero; //jos nimi löytyy, lisätään numero rivin jatkeeksi
                        loytyi = true;
                    }
                    //lisätään muokattu tai alkuperäinen rivi takaisin sisältöön
                    sisalto.append(rivi).append(System.lineSeparator());
                }
                fileScanner.close();
            }
            //Jos nimeä ei löytynyt, lisätään uusi rivi stringbuilder-objektiin.
            if (!loytyi) {
                sisalto.append(nimi).append(",").append(numero).append(System.lineSeparator());
            }

            FileWriter fw = new FileWriter(tiedosto); //filewriter-objekti, jotta saadaan lisättyä tiedostoon
            PrintWriter kirjoittaja = new PrintWriter(fw); // luodaan printwriter-objekti kirjoittamista varten
            kirjoittaja.print(sisalto);
            kirjoittaja.close();
            System.out.println("Ok!");
        } catch (IOException e) {
            System.out.println("Virhe" + e);
        }


    }

    public static void hae() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nimi: ");
        String nimi = scan.nextLine();

        boolean loytyi = false;


        try {
            File tiedosto = new File("tiedosto.txt");
            Scanner fileScanner = new Scanner(tiedosto);

            while (fileScanner.hasNextLine()) {
                String rivi = fileScanner.nextLine();
                //tarkistetaan, alkaako rivi nimellä, tulostetaan numerot
                if (rivi.startsWith(nimi)) {
                    String[] tulos = rivi.split(",");
                    for (int i = 1; i < tulos.length; i++) {
                        System.out.println(tulos[i]);
                    }
                    loytyi = true;
                    break;
                }
            }

            if (!loytyi) {
                System.out.println(("Ei numeroa"));
            }
            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Virhe");
        }
    }

}