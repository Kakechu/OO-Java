public class Main {
    public static void main(String[] args) {

        Unilelu lelu1 = new Unilelu("Pupu", "pupu", 1);
        Unilelu lelu2 = new Unilelu("Pupu");
        Unilelu lelu3 = new Unilelu("Pupu", "pupu");

        System.out.println(lelu1);
        System.out.println(lelu2);
        System.out.println(lelu3);
    }
}