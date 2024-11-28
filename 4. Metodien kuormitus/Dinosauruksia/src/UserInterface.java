import java.util.Scanner;
import Dinosaurs.*;
import Park.Park;
import Vehicles.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public UserInterface(App app) {
    }

    // Kysytään käyttäjän rooli
    public UserRole askUserRole() {
        System.out.println("Who is using the application?");
        System.out.println("1. Manager");
        System.out.println("2. Employee");
        System.out.println("3. Visitor");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        int choice = getValidInt("Enter the number corresponding to your role: ");

        switch (choice) {
            case 1: return UserRole.MANAGER;
            case 2: return UserRole.EMPLOYEE;
            case 3: return UserRole.VISITOR;
            case 4: return UserRole.ADMIN;
            case 5: System.out.println("Exiting..."); System.exit(0);
            default:
                System.out.println("Invalid choice, defaulting to visitor.");
                return UserRole.VISITOR;
        }
    }

    // Käsitellään käyttäjäroolin valinta
    public void handleRoleSpecificMenus(Park park, UserRole userRole) {
        switch (userRole) {
            case MANAGER: managerMenu(park); break;
            case EMPLOYEE: employeeMenu(park); break;
            //case VETERINARIAN: vetMenu(park); break;
            case VISITOR: visitorMenu(park); break;
            case ADMIN: adminMenu(park); break;
            default: System.out.println("Invalid role.");
        }
    }

    // User-specific menus
    public void managerMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nManager Menu");
        System.out.println("1. Manage Employees");
        System.out.println("2. Manage Dinosaurs");
        System.out.println("3. Manage Tickets");
        System.out.println("4. Check Park Status");
        System.out.println("5. Manage Favorite Foods");
        System.out.println("6. Handle Special Events");
        System.out.println("7. Back To Main Menu ");
        System.out.println("8. Exit");

        int choice = getValidInt("Enter your choice: ");

        switch (choice) {
            case 1: park.getEmployeeManager().manageEmployees(park); break; // MUUTA
            case 2: park.getDinosaurManager().manageDinosaurs(); break; //siirretään apista??
            //case 3: manageTickets(park); break;
            case 4: checkParkStatus(park); break;
            case 5: manageFavoriteFoods(park); break;//
            case 6: handleSpecialEvents(park); break;
            case 7: return;
            case 8: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    public void manageFavoriteFoods(Park park) {
        System.out.println("Manage Favorite Foods");
        System.out.println("1. Set Favorite Foods");
        System.out.println("2. List All Favorite Foods");
        System.out.println("3. Create Favorite Food Report");
        System.out.println("4. Cancel");
        int choice = getValidInt("Enter your choice: ");
        switch (choice) {
            case 1: park.getDinosaurManager().setFavoriteFood(); break;
            case 2: park.getDinosaurManager().listFavoriteFoods(); break;
            case 3: park.getDinosaurManager().createFavoriteFoodReport(); break;
            case 4: return;
            default: System.out.println("Invalid choice.");
        }
    }

    public void handleSpecialEvents(Park park) {
        System.out.println("Manage Special Events");
        System.out.println("1. Plan an Event");
        System.out.println("2. List All Planned Events");
        System.out.println("3. Start an Event");
        System.out.println("4. Cancel");
        int choice = getValidInt("Enter your choice: ");
        switch (choice) {
            case 1: park.getEventManager().planEvent(park); break;
            case 2: park.getEventManager().listEvents(); break;
            case 3:
                park.getEventManager().listEvents();
                System.out.println("Choose an event: ");
                String eventName = scanner.nextLine();
                park.getEventManager().startEvent(eventName);

            case 4: return;
            default: System.out.println("Invalid choice.");
        }
    }


    public void employeeMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nEmployee Menu");
        System.out.println("\nEnter employee type: ");
        System.out.println("1. Security Officer");
        System.out.println("2. Veterinarian");
        System.out.println("3. Caretaker");
        System.out.println("4. Janitor");

        int choice = getValidInt("Enter your choice: ");
        switch (choice) {
            case 1: securityMenu(park); break;
            case 2: vetMenu(park); break;
            case 3: careTakerMenu(park); break;
            case 4: janitorMenu(park); break;
            default: System.out.println("Invalid choice.");
        }

    }

    public void securityMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nSecurity Officer Menu");
        System.out.println("1. Drive Jeep for Security Check");
        System.out.println("2. Back To Main Menu ");
        System.out.println("3. Exit");

        int choice = getValidInt("Enter your choice: ");
        switch (choice) {
            case 1: vehicleMenu("Jeep"); break; // Ainoastaan Jeep käytössä
            case 2: return;
            case 3: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    public void vetMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nVeterinarian Menu");
        System.out.println("1. Drive Jeep to Vaccinate Dinosaurs");
        System.out.println("2. Use Helicopter to Transport Dino to Hospital");
        System.out.println("3. Back To Main Menu ");
        System.out.println("4. Exit");

        int choice = getValidInt("Enter your choice: ");
        switch (choice) {
            case 1:
                vehicleMenu("Jeep");
                park.getDinosaurManager().vaccinateDinosaur();
                break;
            case 2: vehicleMenu("Helicopter"); break; // Helikopteri käytössä
            case 3: return;
            case 4: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    public void careTakerMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nCare Taker Menu");
        System.out.println("1. Show all dinosaur");
        System.out.println("2. Feed dinosaur");
        System.out.println("3. Back To Main Menu ");
        System.out.println("4. Exit");
        int choice = getValidInt("Enter your choice: ");
    }

    public void janitorMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nJanitor Menu");
        System.out.println("1. Drive Tractor to Clean Enclosure");
        System.out.println("2. Go Fix Stuff");
        System.out.println("2. Back To Main Menu ");
        System.out.println("3. Exit");

        int choice = getValidInt("Enter your choice: ");
        switch (choice) {
            case 1: vehicleMenu("Tractor"); break; // Ainoastaan Tractor käytössä
            case 2: System.out.println("Fixing stuff.");
            case 3: return;
            case 4: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }


    public void visitorMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nVisitor Menu");
        System.out.println("1. View Park Status");
        System.out.println("2. Buy Event Ticket");
        System.out.println("3. Back To Main Menu ");
        System.out.println("4. Exit");
        int choice = getValidInt("Enter your choice: ");

        switch (choice) {
            case 1: checkParkStatus(park); break;
            case 2: park.getEventManager().buyEventTicket(); break;
            case 3: return;
            case 4: System.out.println("Exiting..."); System.exit(0);
            default: System.out.println("Invalid choice.");
        }
    }

    public void adminMenu(Park park) {
        System.out.println("\n\nWelcome to *** " + park.getName() + " *** ");
        System.out.println("\nAdmin Menu");
        System.out.println("1. Manage Employees");
        System.out.println("2. Manage Dinosaurs");
        System.out.println("3. Manage Tickets");
        System.out.println("4. Check Park Status");
        System.out.println("5. Handle Special Events");
        System.out.println("6. Back To Main Menu ");
        System.out.println("7. Exit");

        int choice = getValidInt("Enter your choice: ");

        switch (choice) {
            case 1: park.getEmployeeManager().manageEmployees(park); break; // MUUTA
            case 2: park.getDinosaurManager().manageDinosaurs(); break; //siirretään apista??
            //case 3: manageTickets(park); break;
            case 4: checkParkStatus(park); break;
            //case 5: handleSpecialEvents(park); break;
            case 6: return;
            case 7: System.out.println("Exiting..."); System.exit(0);
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

    public void vehicleMenu(String vehicleType) {
        Vehicle vehicle;
        switch (vehicleType) {
            case "Jeep":
                vehicle = new Jeep();
                break;
            case "Helicopter":
                vehicle = new Helicopter();
                break;
            case "Tractor":
                vehicle = new Tractor();
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }
        vehicle.travel();
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
