package OverridingTest;

public class OverridingTest {

    public static void main(String[] args) {
        Dog dt = new Terrier();
        dt.walk();
        Dog d = dt.run();
        if(d instanceof Terrier) {
            System.out.println("Terrier object!");
        }
    }
}

