import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Tehtävä 1
        System.out.println("Hello");

        tehtava2ja3();
    }

    public static void tehtava2ja3() {
        int size = 10;
        int i = 0;
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int[] lukutaulukko = new int[size];

        while (i < size) {
            System.out.println("Syötä luku: ");
            try {
                int luku = Integer.valueOf(scan.nextLine());
                lukutaulukko[i] = luku;
                i++;
            }
            catch (Exception e) {
                System.out.println("Virheellinen syöte " + e);
            }
        }


        System.out.println("Kokonaisluvut: " + Arrays.toString(lukutaulukko).replace("[","").replace("]",""));

        String[] mjonotaulukko = new String[size];
        for (int j = 0; j < size; j++) {
            System.out.println("Syötä merkkijono: ");
            String mjono = scan.nextLine();
            mjonotaulukko[j] = mjono;
        }
        System.out.println("Merkkijonot: " + Arrays.toString(mjonotaulukko).replace("[","").replace("]",""));

        int[] satunnainenTaulukko = new int[size];
        for (int j = 0; j < size; j++) {
            int satunnainenLuku = random.nextInt(99)+1; //arvotaan satunnainen luku välillä 1-99
            satunnainenTaulukko[j] = satunnainenLuku;
        }
        System.out.println("Satunnainen taulukko: " + Arrays.toString(satunnainenTaulukko).replace("[","").replace("]",""));

        Arrays.sort(lukutaulukko);
        System.out.println("Järjestetyt luvut: " + Arrays.toString(lukutaulukko).replace("[","").replace("]",""));

        Arrays.sort(mjonotaulukko);
        System.out.println("Järjestetyt merkkijonot: " + Arrays.toString(mjonotaulukko).replace("[","").replace("]",""));

        Arrays.sort(satunnainenTaulukko);
        System.out.println("Järjestetyt satunnaisluvut: " + Arrays.toString(satunnainenTaulukko).replace("[","").replace("]",""));
    }

}
