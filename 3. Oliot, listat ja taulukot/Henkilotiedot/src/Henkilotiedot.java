import java.util.ArrayList;
import java.util.Scanner;

public class Henkilotiedot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Henkilotieto> henkilolista = new ArrayList<>();

        while (true) {
            System.out.println("Anna etunimi: ");
            String etunimi = scan.nextLine();
            if (etunimi.isEmpty()) {
                break;
            }
            System.out.println("Anna sukunimi: ");
            String sukunimi = scan.nextLine();
            System.out.println("Anna ikä: ");
            int ika = scan.nextInt();
            scan.nextLine();
            System.out.println("Anna ammatti: ");
            String ammatti = scan.nextLine();
            henkilolista.add(new Henkilotieto(etunimi, sukunimi, ika, ammatti));
        }

        for(Henkilotieto hlo: henkilolista) {
            System.out.println(hlo.getEtunimi() + " " + hlo.getSukunimi());
        }
    }
}