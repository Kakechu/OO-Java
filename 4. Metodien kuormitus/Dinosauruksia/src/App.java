import Employees.*;
import Park.Park;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    private UserInterface userInterface;

    // Konstruktori, jossa luodaan userInterface-olio
    public App() {
        userInterface = new UserInterface(this);
    }

    public static void main(String[] args) throws FileNotFoundException {
        App main = new App();
        main.start();

    }

    public void start() throws FileNotFoundException {
        // This is the main loop of the application. It will keep running until the user decides to exit.
        // New park object, with name
        Park park = new Park("Dinosaur Park.Park in TUAS", "Turku");



        // read the files for employees and for dinosaurs
        try {
            park.getEmployeeManager().readEmployeesFromFile();
            park.getDinosaurManager().readDinosaursFromFile();
            park.getEventManager().readEventsFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }


        while (true) {
            UserRole userRole = userInterface.askUserRole();
            userInterface.handleRoleSpecificMenus(park, userRole);
        }
    }



}