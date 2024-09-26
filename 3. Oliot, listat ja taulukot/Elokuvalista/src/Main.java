import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Luodaan olioita.
        Elokuva elokuva1 = new Elokuva("Hohto", "Stanley Kubrick", 1980, 16, "kauhu");
        System.out.println("Hello world!");

        Elokuva elokuva2 = new Elokuva("Enter the Dragon", "Robert Clouse", 1973, 18 , "action");

        Elokuva elokuva3 = new Elokuva("Beethovenin toinen", "Rod Daniel", 1994, 7, "komedia");

        Elokuva elokuva4 = new Elokuva("Titanic", "James Cameron", 1998, 13, "draama");

        Elokuva elokuva5 = new Elokuva("Barbie", "Greta Gerwig", 2023, 12, "fantasia");

        Elokuva elokuva6 = new Elokuva("Joker", "Todd Philips", 2019, 16, "trilleri");

        // Luodaan lista ja lisätään oliot listaan.
        ArrayList<Elokuva> leffalista = new ArrayList<>();
        leffalista.add(elokuva1);
        leffalista.add(elokuva2);
        leffalista.add(elokuva3);
        leffalista.add(elokuva4);
        leffalista.add(elokuva5);
        leffalista.add(elokuva6);

        // Tulostetaan kaikki listan oliot.
        /*
        for(int i = 0; i < leffalista.size(); i++) {
            System.out.println(leffalista.get(i));
        }

         */

        for(Elokuva elokuva : leffalista) {
            System.out.println(elokuva);
        }

        //tulostaUudet(leffalista);
        tulostaGenre(leffalista);
    }

    public static void tulostaUudet(ArrayList<Elokuva> leffalista) {
        for(int i = 0; i < leffalista.size(); i++) {
            if (2024 - leffalista.get(i).getJulkaisuvuosi() <= 5) {
                System.out.println("Uutta: ");
                System.out.println(leffalista.get(i));
            }
        }
    }

    public static void tulostaGenre(ArrayList<Elokuva> leffalista) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Anna genre: ");
        String genre = scan.nextLine();
        for(int i = 0; i < leffalista.size(); i++) {
            if (leffalista.get(i).getGenre().equals(genre)) {
                System.out.println("Löytyi elokuva");
                System.out.println(leffalista.get(i));
            }
        }
    }

}