import java.io.FileNotFoundException;
import java.util.Scanner;

public class App2 {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        App2 main = new App2();
        main.start();
    }

    public void start() throws FileNotFoundException {
        // This is the main loop of the application. It will keep running until the user decides to exit.
        // New park object, with name
        Park park = new Park("Dinosaur Park in TUAS");
        //System.out.println(park);
        // read the files for employees and for dinosaurs
        park.readEmployeesFromFile();
        //System.out.println(park);
        park.readDinosaursFromFile();
        System.out.println(park);

        while (true) {
            displayMenu(park.getName());
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleMenuChoice(choice, park);
        }
    }

    public void displayMenu(String parkName) {
        System.out.println("\n\nWelcome to *** " + parkName + " *** ");
        System.out.println("1. Manage Dinosaur");
        System.out.println("2. Manage Park Employees");
        System.out.println("3. Manage Tickets");
        System.out.println("4. Check Park Status");
        System.out.println("5. Handle Special Events");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
    }

    public void handleMenuChoice(int choice, Park park) {
        switch (choice) {
            case 1:
                manageDinosaurs(park);
                break;

            case 2:
                // manageEmployees(park);
                break;
            case 3:
            case 4:
                checkParkStatus();
                break;
            case 5:
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
        }
    }

    public void manageDinosaurs(Park park){
        System.out.println("All our dinosaur's: ");
        System.out.println(park.getDinosaurs());

        System.out.println("a(dd) - r(emove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)){
            case 'a':
                // is adding ok?
                // if yes then
                Dinosaur d = askDinosaurInfo();
                park.dinosaurs.add(d);
                //park.addDinosaur(d);
                break;
            case 'r':
                // is removing ok?
                // if yes then
                // how to get the index?
                int index = 3; // out of the hat
                //park.removeDinosaur(index);
                break;
            case 'u': break;
            case 'c':
        }

    }

    public Dinosaur askDinosaurInfo(){
        System.out.println(" D name: ");
        String name = scanner.nextLine();
        System.out.println(" D age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" D species: ");
        String species = scanner.nextLine();
        System.out.println("Enter dinosaur type: C, H, O: ");
        DinosaurType dinosaurType = DinosaurType.valueOf(scanner.nextLine());
        return new Dinosaur(name, age, species, dinosaurType);
    }

    public void checkParkStatus(){
        // Assuming the park is open from 8 am to 6 pm.
        int currentHour = java.time.LocalTime.now().getHour();
        if (currentHour >=5 && currentHour < 8){
            System.out.println("The Park is currently open");
        } else {
            System.out.println("The Park is currently closed");
        }
    }

}
