import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Random number is: " + satunnainenLuku());
    }

    public static int satunnainenLuku() {
        Random rand = new Random();
        int luku = rand.nextInt(6) + 1;
        return luku;
    }

}