import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elokuva chipmunks = new Elokuva("Alvin and the Chipmunks", 2007, "comedy", 0);

        Scanner lukija = new Scanner(System.in);
        System.out.println("Minkä ikäinen olet? ");
        int ika = lukija.nextInt();
        //int ika = Integer.parseInt(lukija.nextLine());

        if (chipmunks.saakoKatsoa(ika)) {
            System.out.println("Saat katsoa elokuvan " + chipmunks.nimi());
        } else {
            System.out.println("Et saa katsoa elokuvaa " + chipmunks.nimi());
        }

        Elokuva parasite = new Elokuva("Parasite", 2019, "Drama", 16);
        System.out.println("Minkä ikäinen olet? ");
        ika = lukija.nextInt();

        if (parasite.saakoKatsoa(ika)) {
            System.out.println("Saat katsoa elokuvan " + parasite.nimi());
        } else {
            System.out.println("Et saa katsoa elokuvaa " + parasite.nimi());
        }


    }
}