package lecture5;
import java.util.Arrays;


public class Seniors {
    private int[] ages = new int[2];
    private int num;

    Seniors() {//package-private
        num = 2;
        ages[0] = 30;
        ages[1] = 40;
    }

    public int[] getAges() {
        //return ages;
        return Arrays.copyOf(ages,2); //palautetaan kopio, ei viittausta samaan muistipaikkaan

    }

    public int getNum() {
        return num;
    }

}
