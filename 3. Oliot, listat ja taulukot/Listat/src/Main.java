import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //nimetListaan();
        kokonaisluvutListassa();
    }

    public static void nimetListaan() {
        Scanner scan = new Scanner(System.in);
        String input;

        ArrayList<String> nimilista = new ArrayList<>();

        while (true) {
            System.out.println("Anna nimi: ");
            input = scan.nextLine();
            if (input.isEmpty()) {
                break;
            }
            nimilista.add(input);
        }

        //Tulostetaan listan toinen nimi:
        System.out.println(nimilista.get(1));

        /*
        //Testi: tulostetaan kaikki nimet
        for(int i = 0; i < nimilista.size(); i++) {
            System.out.println(nimilista.get(i));
        }
        */
    }

    public static void kokonaisluvutListassa() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numerolista = new ArrayList<>();
        int input;

        while (true) {
            System.out.println("Anna kokonaisluku: ");
            input = scan.nextInt();
            if (input == -99) {
                break;
            }
            numerolista.add(input);
        }

        //Testi: tulostetaan luvut
        /*
        for(int i = 0; i < numerolista.size(); i++) {
            System.out.println(numerolista.get(i));
        }
        */

        int sum = 0;
        int min = numerolista.get(0);
        int max = numerolista.get(0);

        for(int i = 0; i < numerolista.size(); i++) {
            if (numerolista.get(i) < min) {
                min = numerolista.get(i);
            } else if (numerolista.get(i) > max) {
                max = numerolista.get(i);
            }
            sum += numerolista.get(i);
        }

        float keskiarvo = (float) sum / numerolista.size();

        System.out.println("Summa on " + sum);
        System.out.println("Keskiarvo on " + keskiarvo);
        System.out.println("Pienin arvo on " + min);
        System.out.println("Suurin arvo on " + max);



    }
}