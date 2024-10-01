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


    public static void someMethod() {}
    public static void someMethod(int x) {}
    public static void someMethod(double x) {}
    public static void someMethod(String x) {}
    public static void someMethod(double x, int y) {}
    public static void someMethodXY (int x, double y) {}
    public static void someMethodAB(int a, double b) {}
    public static int someMethodXB(int x, double b) {return 0;}


}