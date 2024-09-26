import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Team> joukkuelista = muodostaJoukkueet();
        //System.out.println(joukkuelista);

        Scanner scan = new Scanner(System.in);
        System.out.println("Anna joukkue: ");
        String joukkuekysely = scan.nextLine();
        //String joukkuekysely = "Buffalo";
        for (Team joukkue : joukkuelista) {
            if (joukkue.getNimi().equals(joukkuekysely)) {
                System.out.println(joukkue);
            }
        }
    }


    public static ArrayList<Team> muodostaJoukkueet() {
        ArrayList<Team> joukkuelista = new ArrayList<>();
        ArrayList<String> nimilista = new ArrayList<>();

        try {
            Scanner Fscanner = new Scanner(new File("Football_statistics.txt"));
            while (Fscanner.hasNextLine()) {
                String rivi = Fscanner.nextLine();
                String rivinSisalto[] = rivi.split(", ");
                //tiedot talteen muuttujiin
                String kotijoukkue = rivinSisalto[0];
                String vierasjoukkue = rivinSisalto[1];
                int kotipisteet = Integer.parseInt(rivinSisalto[2]);
                int vieraspisteet = Integer.parseInt(rivinSisalto[3]);

                // Varmistetaan, että joukkueet ovat sekä nimilistalla että joukkuelistalla (vain kerran)

                if (!nimilista.contains(kotijoukkue)) {
                    nimilista.add(kotijoukkue);
                    Team lisataanJoukkue = new Team(kotijoukkue);
                    joukkuelista.add(lisataanJoukkue);
                }

                if (!nimilista.contains(vierasjoukkue)) {
                    nimilista.add(vierasjoukkue);
                    Team lisataanJoukkue = new Team(vierasjoukkue);
                    joukkuelista.add(lisataanJoukkue);
                }

                //Tarkistetaan voitot

                if (kotipisteet > vieraspisteet) {//kotijoukkue voitti, vierasjoukkue hävisi
                    boolean kotijoukkueLoytyi = false;
                    boolean vierasjoukkueLoytyi = false;
                    for (Team joukkue : joukkuelista) {
                        if (joukkue.getNimi().equals(kotijoukkue)) { //etsitään kotijoukkue
                            joukkue.setVoitot(joukkue.getVoitot() + 1);//lisätään kotijoukkueen voittoihin 1
                            kotijoukkueLoytyi = true;
                        }
                        if (joukkue.getNimi().equals(vierasjoukkue)) { //etsitään vierasjoukkue
                            joukkue.setTappiot(joukkue.getTappiot() + 1);
                            vierasjoukkueLoytyi = true;//lisätään vierasjoukkueen tappioihin 1
                        }
                        if (kotijoukkueLoytyi && vierasjoukkueLoytyi) break;
                        //break; //lopetetaan tämä silmukka tähän, eli ei käydä loppuja läpi
                    }
                } else if (vieraspisteet > kotipisteet) {
                    boolean kotijoukkueLoytyi = false;
                    boolean vierasjoukkueLoytyi = false;//vierasjoukkue voitti, kotijoukkue hävisi
                    for (Team joukkue : joukkuelista) {
                        if (joukkue.getNimi().equals(vierasjoukkue)) { //etsitään vierasjoukkue
                            joukkue.setVoitot(joukkue.getVoitot() + 1); //lisätään kotijoukkueen voittoihin 1
                            kotijoukkueLoytyi = true;
                        }
                        if (joukkue.getNimi().equals(kotijoukkue)) { //etsitään kotijoukkue
                            joukkue.setTappiot(joukkue.getTappiot() + 1);
                            vierasjoukkueLoytyi = true;
                        }
                        if (kotijoukkueLoytyi && vierasjoukkueLoytyi) break;
                        //break; //ei käydä muita läpi, kun löydettiin jo haluamamme
                    }
                } else { //tasapeli
                    boolean kotijoukkueLoytyi = false;
                    boolean vierasjoukkueLoytyi = false;
                    for (Team joukkue : joukkuelista) {

                        if (joukkue.getNimi().equals(kotijoukkue)) { //etsitään vierasjoukkue
                            joukkue.setTasapelit(joukkue.getTasapelit() + 1); //lisätään kotijoukkueen tasapeleihin 1
                            kotijoukkueLoytyi = true;

                        }
                        if (joukkue.getNimi().equals(vierasjoukkue)) { //etsitään kotijoukkue
                            joukkue.setTasapelit(joukkue.getTasapelit() + 1);
                            vierasjoukkueLoytyi = true;
                        }
                        if (kotijoukkueLoytyi && vierasjoukkueLoytyi) break;
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Virhe, tiedostoa ei löytynyt.");
        }
        return joukkuelista;
    }



    public static ArrayList<Team> lueJoukkueetTiedostosta() {

        ArrayList<String> nimilista = new ArrayList<>();

        try {
            Scanner Fscanner = new Scanner(new File("Football_statistics.txt"));
            while (Fscanner.hasNextLine()) {
                String rivi = Fscanner.nextLine();
                String rivinSisalto[] = rivi.split(", ");
                String nimi = rivinSisalto[0];
                if (!nimilista.contains(nimi)) {
                    nimilista.add(nimi);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Virhe, tiedostoa ei löytynyt.");
        }

        ArrayList<Team> joukkuelista = new ArrayList<>();

        for (String nimi : nimilista) {
            Team lisattavaTeam = new Team(nimi);
            joukkuelista.add(lisattavaTeam);
        }
        return joukkuelista;
    }

    public static ArrayList<Game> luePelitTiedostosta() {
        ArrayList<Game> pelilista = new ArrayList<>();
        try {
            Scanner Fscanner = new Scanner(new File("Football_statistics.txt"));
            while (Fscanner.hasNextLine()) {
                String rivi = Fscanner.nextLine();
                String rivinSisalto[] = rivi.split(", ");
                String kotijoukkue = rivinSisalto[0];
                String vierasjoukkue = rivinSisalto[1];
                int kotipisteet = Integer.parseInt(rivinSisalto[2]);
                int vieraspisteet = Integer.parseInt(rivinSisalto[3]);

                pelilista.add(new Game(kotijoukkue, vierasjoukkue, kotipisteet, vieraspisteet));

            }
        } catch (FileNotFoundException e) {
            System.out.println("Virhe, tiedostoa ei löytynyt.");
        }
        return pelilista;
    }
}