import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App2 {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        App2 main = new App2();
        //main.start(); //HUOMHUOMHUOM

        //Tehtäväsarja 4 - tehtävän 7 testi
        Food f1 = new Food("pizza", "yes", 15);
        System.out.println(f1);

        Ticket t1 = new Ticket(10,  "Kake", "12.12.2024");
        System.out.println(t1);







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
                manageEmployees(park);
                break;
            case 3:
                // manageTickets(park);
                break;
            case 4:
                checkParkStatus();
                break;
            case 5:
                // handleSpecialEvents
                break;
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
        }
    }

    public void checkParkStatus() {
        // Assuming the park is open from 8 am to 6 pm.
        int currentHour = java.time.LocalTime.now().getHour();
        if (currentHour >= 5 && currentHour < 8) {
            System.out.println("The park is currently open.");
        } else {
            System.out.println("The park is currently closed.");
        }
    }

    public Dinosaur askDinosaurInfo() {
        System.out.println(" D name: ");
        String name = scanner.nextLine();
        System.out.println(" D age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" D species: ");
        String species = scanner.nextLine();
        System.out.println(" Enter dinosaur type: C, H, O: ");
        DinosaurType dinosaurType = DinosaurType.valueOf(scanner.nextLine());

        return new Dinosaur(name, age, species, dinosaurType);
    }

    public void manageDinosaurs(Park park) {
        System.out.println("All our dinosaurs: ");
        //System.out.println(park.getDinosaurs()); //OMA MUUTOS
        for(Dinosaur d: park.getDinosaurs()) {
            System.out.println(d);
        }


        System.out.println("a(dd) - r(remove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a': //yksittäinen merkki, yksinkertaiset hipsut, mjonoissa kaksinkertaisit
                // voidaanko uusi dino lisätä
                // jos voidaan
                Dinosaur d = askDinosaurInfo();
                //park.dinosaurs.add(d);
                park.addDinosaur(d);
                break;
            case 'r':
                System.out.println("There are currently " + park.getDinosaurs().size() + " dinosaurs in the park.");
                System.out.println("Which dinosaur do you want to remove? Give a number.");
                int i = scanner.nextInt() - 1; //Käyttäjän silmissä numerointi luultavasti alkaa ykkösestä, ei nollasta.
                scanner.nextLine();

                int index = 3;
                park.removeDinosaur(i);

                break;
            case 'u':
                System.out.println("Give the name of the dinosaur: ");
                answer = scanner.nextLine();
                Dinosaur dinoToUpdate = park.findDinosaur(answer);
                park.updateDinosaur(dinoToUpdate);

                break;
            case 'c':
                break;
        }
    }

    public Employee askEmployeeInfo() {
        System.out.println(" E name: ");
        String name = scanner.nextLine();
        System.out.println(" E job title: ");
        String jobTitle = scanner.nextLine();
        System.out.println(" E years of experience: ");
        int yearsOfExperience = scanner.nextInt();
        scanner.nextLine();


        return new Employee(name, jobTitle, yearsOfExperience);
    }

    public void manageEmployees(Park park) {
        System.out.println("All our employees: ");
        for(Employee e: park.getEmployees()) {
            System.out.println(e);
        }

        System.out.println("a(dd) - r(remove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                // voidaanko uusi työntekijä lisätä?
                // jos voidaan
                Employee e = askEmployeeInfo();
                //park.dinosaurs.add(d);
                park.addEmployee(e);
                break;
            case 'r':
                System.out.println("Which employee do you want to remove? Give a name: ");
                String name = scanner.nextLine();
                Employee empToRemove = park.findEmployee(name);
                park.removeEmployee(empToRemove);
                break;
            case 'u':
                System.out.println("Give the name of the employee: ");
                String nameToUpdate = scanner.nextLine();
                Employee empToUpdate = park.findEmployee(nameToUpdate);
                park.updateEmployee(empToUpdate);
                //System.out.println("You want to update the employee " + empToUpdate);
                break;
            case 'c':
                break;
        }

    }

}