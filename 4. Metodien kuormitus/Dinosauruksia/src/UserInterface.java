import java.util.Scanner;
import Dinosaurs.*;
import Employees.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public UserInterface(App app) {
    }

    // Kysytään käyttäjän rooli
    public UserRole askUserRole() {
        System.out.println("Who is using the application?");
        System.out.println("1. Manager");
        System.out.println("2. Employee");
        System.out.println("3. Veterinarian");
        System.out.println("4. Visitor");
        int choice = getValidInt("Enter the number corresponding to your role: ");

        switch (choice) {
            case 1: return UserRole.MANAGER;
            case 2: return UserRole.EMPLOYEE;
            case 3: return UserRole.VETERINARIAN;
            case 4: return UserRole.VISITOR;
            default:
                System.out.println("Invalid choice, defaulting to visitor.");
                return UserRole.VISITOR;
        }
    }

    // Käsitellään käyttäjäroolin valinta
    public void handleRoleSpecificMenus(Park park, UserRole userRole, App app) {
        switch (userRole) {
            case MANAGER: managerMenu(park, app); break;
            case EMPLOYEE: employeeMenu(park); break;
            case VETERINARIAN: vetMenu(park); break;
            case VISITOR: visitorMenu(park); break;
            default: System.out.println("Invalid role.");
        }
    }

    // User-specific menus
    public void managerMenu(Park park, App app) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nManager Menu");
        System.out.println("1. Manage Employees");
        System.out.println("2. Manage Dinosaurs");
        System.out.println("3. Manage Tickets");
        System.out.println("4. Check Park Status");
        System.out.println("5. Handle Special Events");
        System.out.println("6. Back To Main Menu ");
        System.out.println("7. Exit");

        int choice = getValidInt("Enter your choice: ");

        switch (choice) {
            case 1: app.manageEmployees(park); break; //
            case 2: app.manageDinosaurs(park); break; //siirretään apista??
            //case 3: manageTickets(park); break;
            case 4: checkParkStatus(park); break;
            //case 5: handleSpecialEvents(park); break;
            case 6: return;
            case 7: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    public void employeeMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nEmployee Menu");
        System.out.println("1. Check Park Status");
        System.out.println("2. Update Dinosaur Information");
        System.out.println("3. Back To Main Menu ");
        System.out.println("4. Exit");
        int choice = getValidInt("Enter your choice: ");

        switch (choice) {
            case 1: checkParkStatus(park); break;
            case 2:
                System.out.println("Give the name of the dinosaur to update: ");
                String dinoName = scanner.nextLine();
                Dinosaur dino = park.getDinosaurManager().findDinosaur(dinoName);
                park.getDinosaurManager().updateDinosaur(dino);
                break;
            case 3: return;
            case 4: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    public void vetMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nVeterinarian Menu");
        System.out.println("1. View Dino Health");
        System.out.println("2. Back To Main Menu ");
        System.out.println("3. Exit");
        int choice = getValidInt("Enter your choice: ");

        switch (choice) {
            case 1: break; //viewDinoHealth(park); break;
            case 2: return;
            case 3: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    public void visitorMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nVisitor Menu");
        System.out.println("1. View Park Status");
        System.out.println("2. Buy ticket");
        System.out.println("3. Back To Main Menu ");
        System.out.println("4. Exit");
        int choice = getValidInt("Enter your choice: ");

        switch (choice) {
            case 1: checkParkStatus(park); break;
            case 2: break; //BUY TICKET
            case 3: return;
            case 4: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    //muuta niin, että tulostaa aukioloajat
    public void checkParkStatus(Park park) {
        int openingHour = park.getOpeningHour();
        int closingHour = park.getClosingHour();
        int currentHour = java.time.LocalTime.now().getHour();

        if (currentHour >= openingHour && currentHour < closingHour) {
            System.out.println("The park \"" + park.getName() + "\" is currently open.");
        } else {
            System.out.println("The park \"" + park.getName() + "\" is currently closed.");
        }
    }

    // apumetodit
    public int getValidInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input); // Yritetään muuntaa syöte kokonaisluvuksi.
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

}
