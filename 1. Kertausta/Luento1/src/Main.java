//Käyttäjän syöte
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in); //Tarvitaan, jotta voidaan lukea syötteitä.

        //System.out.println("Syötä jotakin: ");
        //String syote = lukija.nextLine(); //Tallentaa syötteen muuttujaan. next lukee välilyöntiin, nextline enteriin.

        //System.out.println("Syöte on: " + syote);

        int kokonaisluku = 4;
        double likuluku = 3.68;
        boolean totuusarvo = true;
        boolean epatosi = false;
        String merkkijono = "merkkijono"; //koostuu useammasta char-tyypin muuttujasta
        //System.out.println("Syötä totuusarvo: ");
        //boolean totuusarvosyote = Boolean.valueOf(lukija.nextLine()); (miten voi syöttää?)
        //double liukulukusyote = Double.valueOf(lukija.nextLine());
        //System.out.println("Syötä luku: ");
        //int lukusyote = Integer.valueOf(lukija.nextLine());
        //System.out.println(totuusarvosyote);


        // Muuttujien nimet oltava uniikkeja lohkossa eli aliohjelman muuttujat eivät näy ulkopuolelle (näkyvyysmääre).
        // Javassa käytetään camelCasea.
        // operaattorit: + - / * %
        // vertailuoperaattorit samat kuin pythonissa, paitsi merkkijonot, joissa vertailu tapahtuu "equals"-metodilla.
        //if (syote.equals("neljä"))...
        //Loogiset operaattorit: tai: ||, ja: &&, ei: !

        /*
        if (lukusyote > 5) {
            System.out.println("Luku on isompi kuin 5.");
        } else if (lukusyote < 5) {
            System.out.println("Luku on pienempi kuin 5.");
        } else {
            System.out.println("Luku on 5.");
        }

        while (true) {
            System.out.println("Syötä positiivisia lukuja: ");
            int luku = Integer.valueOf(lukija.nextLine());
            if (luku == 0) {
                break;
            }
            if (luku <= 0) {
                System.out.print(luku);
            }
        }

        //do while toteutetaan aina vähintään kerran
        int i = 10;
        do {
            System.out.println("tulostetaan i: " + i);
            i++;
        } while (i<10); //tarkistetaan totuusarvo

        for (int j = 0; j < 10; j++) { //alustus, ehto, muutos
            System.out.println("Tulostetaan j: " + j);
        }
*/
        Metodit.tervehdi();
//void ei palauta mitään
        tervehdiMainista();

        //Taulukot: array: aina määrämittainen eli staattinen, ei dynaaminen tietotyyppi vrt. python
        int[] lukutaulukko = new int[3]; // kolme alkiopaikkaa, viimeinen on taulukon koko -1
        String[] merkkijonotaulukko = new String[5]; //alkioiden määräksi määritetään 5, voitaisiin sijoittaa myös esim.käyttäjältä kysytty  muuttuja

        //stringien käsittely erilaista kuin intien: equals, split, contains
        //esim. String mjono = "kukkakauppa", mjono.contains("kauppa") --> true

    }
    //Kirjoita tänne metodit
    public static void tervehdiMainista() {
        System.out.println("Terkkuja mainin metodista");
    }

}