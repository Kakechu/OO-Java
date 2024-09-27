import java.io.FileNotFoundException;

public class App2 {
    public static void main(String[] args) throws FileNotFoundException {
        // This is the main loop of the application. It will keep running until the user decides to exit.
        // New park object, with name
        Park park = new Park("Dinosaur Park in TUAS");

        System.out.println(park);

        // read the files for employees and for dinosaurs
        park.readEmployeesFromFile();
        System.out.println(park);
        park.readDinosaursFromFile();
        System.out.println(park);
    }

}