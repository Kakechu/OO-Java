package lecture5;

public class AdvancedEncapsulation {
    public static void main(String[] args) {
        Seniors seniors = new Seniors();

        int num = seniors.getNum();
        System.out.println(num);
        num = -100;
        System.out.println(num);
        System.out.println(seniors.getNum());

        int[] copyAges = seniors.getAges();
        System.out.println(copyAges[0] + ", " + copyAges[1]);
        copyAges[0] = -9;
        copyAges[1] = -19;
        System.out.println("copyAges muutoksen jälkeen: " + copyAges[0] + ", " + copyAges[1]);
        int[] copyAges2 = seniors.getAges();
        System.out.println("copyAges2: " + copyAges2[0] + ", " + copyAges2[1]);
    }
}
