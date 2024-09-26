import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int negatiiviset = 0;
        int parilliset = 0;
        int kolmellaJaolliset = 0;

        while (true) {
            System.out.println("Syötä kokonaisluku: ");

            try {
                int luku = Integer.valueOf(scan.nextLine());
                if (luku == 0) {
                    break;
                } else {
                    negatiiviset = onkoNegatiivinen(luku, negatiiviset);
                    parilliset = onkoParillinen(luku, parilliset);
                    kolmellaJaolliset = jaollinenKolmella(luku, kolmellaJaolliset);
                }
            }
            catch (Exception e) {
                System.out.println("Virheellinen syote " + e);
            }

        }

        System.out.println("Negatiiviset: " + negatiiviset);
        System.out.println("Parilliset: " + parilliset);
        System.out.println("Kolmella jaollisten positiivisten summa: " + kolmellaJaolliset);

    }

    public static int onkoNegatiivinen(int syote, int negatiiviset) {

        if (syote < 0) {
            negatiiviset++;
        }
        return negatiiviset;
    }

    public static int onkoParillinen(int syote, int parilliset) {
        if (syote % 2 == 0) {
            parilliset++;
        }
        return parilliset;
    }

    public static int jaollinenKolmella(int syote, int kolmellaJaolliset) {
        if (syote % 3 == 0 && syote > 0) {
            kolmellaJaolliset = kolmellaJaolliset + syote;
        }
        return kolmellaJaolliset;
    }
}