import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Juoma> juomat = new ArrayList<>();

    public static void main(String[] args) {
        //Tässä ohjelmassa oletetaan, että jokaiseen juomaan sisältyy vettä.
        start();

    }

    public static void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleChoice(choice);
        }
    }


    public static void displayMenu() {
        System.out.println("*** Welcome ***");
        System.out.println("What would you like to do?");
        System.out.println("1 - Print drink data");
        System.out.println("2 - Add a drink");
        System.out.println("3 - Print all drinks");
        System.out.println("4 - Cancel");
    }

    public static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Give drink name: ");
                String drinkName = scanner.nextLine();
                printDrinkData(drinkName);
                break;
            case 2:
                System.out.println("Give drink name: ");
                String name = scanner.nextLine();
                System.out.println("Give water type (STILL OR SPARKLING): ");
                Water water;
                try {
                    water = Water.valueOf(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid type!");
                    break;
                }
                Juoma juoma = new Juoma(name, water);
                juomat.add(juoma);
                System.out.println("Drink " + juoma.getName() + " added!");
                break;
            case 3:
                printAllDrinks();
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
        }
    }

    public static void printDrinkData(String drinkName) {
        for (Juoma juoma : juomat) {
            if (juoma.getName().equals(drinkName)) {
                System.out.println(juoma);
                return;
            }
        }
        System.out.println("Drink not found.");
    }

    public static void printAllDrinks() {
        for (Juoma juoma : juomat) {
            System.out.println(juoma);
        }
    }

}