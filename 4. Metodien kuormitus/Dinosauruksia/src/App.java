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
        } catch (FileNotFoundException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }


        while (true) {
            UserRole userRole = userInterface.askUserRole();
            userInterface.handleRoleSpecificMenus(park, userRole, this);
        }
    }



    // Metodi sen määrittämiseen, onko käyttäjän syöte int vai String. Tarvitaan esim. poistossa.
    private static boolean isNumeric(String answer) {
        try {
            Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public Employee askEmployeeInfo() {
        System.out.println(" E name: ");
        String name = scanner.nextLine();
        System.out.println(" E job title: ");
        String jobTitle = scanner.nextLine().toLowerCase();

        System.out.println(" E years of experience: ");
        int yearsOfExperience = scanner.nextInt();
        scanner.nextLine();

        //Employees.Employee employee1 = new Employees.Employee(name, jobTitle, yearsOfExperience);

        //Employees.ParkManager, Employees.SecurityOfficer ja Employees.Veterinarian?

        System.out.println("Enter employee role: M(ANAGER), S(ECURITY), V(ETERINARIAN) or C(ARETAKER)?");
        String roleAnswer = scanner.nextLine().toUpperCase();
        EmployeeRole employeeRole;
        //Employees.EmployeeRole employeeRole = Employees.EmployeeRole.valueOf(scanner.nextLine().toUpperCase());


        Employee employee;
        while (true) {
            switch (roleAnswer) {
                case "M":
                    System.out.println("Manager bonus: ");
                    double bonus = scanner.nextDouble();
                    scanner.nextLine();
                    employee = new ParkManager(name, jobTitle, yearsOfExperience, bonus);
                    break;
                case "S":
                    System.out.println("Does the security officer have a gun license? true/false");
                    boolean hasGunLicense = scanner.nextBoolean();
                    scanner.nextLine();
                    employee = new SecurityOfficer(name, jobTitle, yearsOfExperience, hasGunLicense);
                    break;
                case "V":
                    System.out.println("Vet specialization: ");
                    String specialization = scanner.nextLine();
                    employee = new Veterinarian(name, jobTitle, yearsOfExperience, specialization);
                    //lisää taulukkoon???
                    break;
                case "C":
                    System.out.println("Employees.Care taker specialization: ");
                    String takesCareOf = scanner.nextLine();
                    employee = new CareTaker(name, jobTitle, yearsOfExperience, takesCareOf);
                    break;
                default:
                    System.out.println("Please enter a valid type.");
                    continue;
            }
            break;
        }
        return employee;

    }

    public void manageEmployees(Park park) {
        System.out.println("All our employees: ");
        for(Employee e: park.getEmployees()) {
            System.out.println(e);
        }

        System.out.println("a(dd) - r(emove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                // voidaanko uusi työntekijä lisätä?
                // jos voidaan


                Employee e = askEmployeeInfo();
                if (e != null) {
                    if (park.getEmployees().contains(e)) {
                        System.out.println("This employee already exists.");
                    } else {
                        park.addEmployee(e);
                        System.out.println("Employee added successfully.");
                    }
                }

                break;
            case 'r':
                System.out.println("Your park needs " + park.getEmployeesToDinosaur() * park.getNumberOfDinosaurs() + " employees.");
                // MIKSI SIZE?? getNumberOfEmployees? park.getEmployees().size()
                if (park.getNumberOfEmployees() < park.getEmployeesToDinosaur() * park.getNumberOfDinosaurs()) { //park.getDinosaurs().size()
                    System.out.println("You can't go below the minimum amount of employees.");
                    break;
                }
                System.out.println("There are currently " + park.getEmployees().size() + " employees in the park.");
                for (Employee employee : park.getEmployees()) {
                    System.out.println(employee);
                }
                System.out.println("Which employee do you want to remove? Give a name or a number.");
                String empToRemove = scanner.nextLine();
                if (isNumeric(empToRemove)) {
                    int empNum = Integer.parseInt(empToRemove) - 1;
                    park.removeEmployee(empNum);
                } else {
                    park.removeEmployee(empToRemove);
                }

                //Employees.Employee empToRemove = park.findEmployee(name);
                //park.removeEmployee(empToRemove);
                break;
            case 'u':
                System.out.println("Give the name of the employee: ");
                String nameToUpdate = scanner.nextLine();
                Employee empToUpdate = park.getEmployeeManager().findEmployee(nameToUpdate);
                park.getEmployeeManager().updateEmployee(empToUpdate);
                //System.out.println("You want to update the employee " + empToUpdate);
                break;
            case 'c':
                break;
        }
    }



}