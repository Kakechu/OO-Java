import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maksimiarvo = 0;

        try {
            System.out.println("Anna maksimiarvo: ");
            maksimiarvo = scan.nextInt();

        }
        catch (Exception e) {
            System.out.println("Virheellinen syöte: " + e);
        }

        int termeja = maara(maksimiarvo);
        int lukujono[] = new int[termeja];
        lukujono = muodostaJono(termeja, lukujono);
        int summa = termienSumma(termeja, lukujono);
        int nelioidenSumma = termienNelioidenSumma(termeja, lukujono);


        System.out.println("Lukujono: " + Arrays.toString(lukujono).replace("[","").replace("]",""));
        System.out.println("Lukujonon termien määrä: " + termeja);
        System.out.println("Lukujonon termien summa: " + summa);
        System.out.println("Lukujonon termien neliöiden summa: " + nelioidenSumma);
    }


    public static int maara(int maksimiarvo) {
        int tulos = 0;
        if (maksimiarvo <= 0) {
            return tulos;
        } else {
            tulos = maksimiarvo / 3;
        }
        return tulos;
    }

    public static int[] muodostaJono(int termeja, int[] lukujono) {
        int arvo = 3;
        for (int i = 0; i < termeja; i++) {
            lukujono[i] = arvo;
            arvo = arvo + 3;
        }
        return lukujono;
    }

    public static int termienSumma(int maara, int[] lukujono) {
        int summa = 0;

        if (lukujono.length == 0) {
            return summa;
        } else {
            int a = 3;
            int u = lukujono[lukujono.length - 1];
            summa = maara * (a + u) / 2;

            return summa;
        }
    }

    public static int termienNelioidenSumma(int maara, int[] lukujono) {
        int nelioidenSumma = 0;
        for (int i = 0; i < maara; i++) {
            nelioidenSumma += Math.pow(lukujono[i],2);
        }

        return nelioidenSumma;
    }
}