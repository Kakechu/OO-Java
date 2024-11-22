import java.util.ArrayList;
import java.util.Scanner;

public class ManageDinosaurs {
    public static Scanner scanner = new Scanner(System.in);

    private ArrayList<Dinosaur> dinosaurs;
    //Teht 5_6: 6.	Luo Dinosaur-tyyppinen taulukko. Talleta kaikki lentoliskot tähän taulukkoon
    private Dinosaur[] flyingDinos = new Dinosaur[5];


    int maxAmountOfDinosaurs = 12; // Tarkista, onko tarpeen.
    private int numberOfDinosaurs = 0;
    private int numberOfFlyingDinos = 0;

    // Getterit
    public int getNumberOfDinosaurs() {
        return numberOfDinosaurs;
    }

    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

}
