public class Main {
    public static void main(String[] args) {


        addTogether(2, "Pekka");
        addTogether("Kissa", 3);
        addTogether("Kaali", "mato");
        addTogether(3,4);
    }

    public static void addTogether(int luku1, int luku2) {
        System.out.println(luku1+luku2);
    }

    public static void addTogether(int luku, String mjono) {
        System.out.println(luku+mjono);
    }

    public static void addTogether(String mjono, int luku) {
        System.out.println(mjono+luku);
    }

    public static void addTogether(String mjono1, String mjono2) {
        System.out.println(mjono1+mjono2);
    }


}