import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App2 {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        App2 main = new App2();
        main.start(); //HUOMHUOMHUOM

        //Tehtäväsarja 4 - tehtävän 7 testi
        /*
        Food f1 = new Food("pizza", "yes", 15);
        System.out.println(f1);

        Ticket t1 = new Ticket(10,  "Kake", "12.12.2024");
        System.out.println(t1);

         */

        //Tehtäväsarja 5, osa 2: testit
/*
        Dinosaur dino = new FlyingDinosaur("Dinonen", 123, "Dino", DinosaurType.CARNIVORE);
        dino.getSick();
        Veterinarian vet = new Veterinarian("Kake", "Vet", 123, "Dinot");
        vet.checkHealth(dino);
        vet.giveMedicine(dino);
        dino.isHealthy();


        Dinosaur angryD = new LandDinosaur("Mörkö", 12, "T-Rex", DinosaurType.CARNIVORE);
        //angryD.roar();
*/
        //Tehtäväsarja 7 - tehtävän 2 testi
        //Park park = new Park("Testipark");
        //Dinosaur d = new Dinosaur("Dino", 123, "T-Rex", "land", MainFoodSource.CARNIVORE, DinosaurClass.LAND,123);


        //Tehtäväsarja 7 - tehtävän 5 testi
        /*
        Health health = new Health();
        Dinosaur dvacc = new Dinosaur("Roko", 12, "Tyrannusaurus rex", "land", MainFoodSource.CARNIVORE);
        dvacc.createVaccinationCard(2020, 2020);
        health.dinoParvoVaccination.vaccinate(dvacc);

         */
    }

    public void start() throws FileNotFoundException {
        // This is the main loop of the application. It will keep running until the user decides to exit.
        // New park object, with name
        Park park = new Park("Dinosaur Park in TUAS", "Turku");

        //System.out.println(park);

        // read the files for employees and for dinosaurs
        try {
            park.getEmployeeManager().readEmployeesFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("Työntekijätiedostoa ei löydy. Tarkista tiedostonimi.");
        }
        try {
            park.getDinosaurManager().readDinosaursFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy. Tarkista tiedostonimi.");
        }
        //System.out.println(park);
/*
        while (true) {
            displayMenu(park.getName());
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleMenuChoice(choice, park);
        }

 */

        while (true) {
            displayMenu(park.getName());
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.nextLine();
                continue;
            }
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
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
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

        MainFoodSource mainFoodSource;
        while (true) {
            System.out.println(" Enter the main food source: C(ARNIVORE), H(ERBIVORE), O(MNIVORE): ");
            String foodChoice = scanner.nextLine().toUpperCase();

            switch (foodChoice.charAt(0)) {
                case 'C':
                    mainFoodSource = MainFoodSource.CARNIVORE;
                    break;
                case 'H':
                    mainFoodSource = MainFoodSource.HERBIVORE;
                    break;
                case 'O':
                    mainFoodSource = MainFoodSource.OMNIVORE;
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    continue; // palataan silmukan alkuun
            }
            break;
        }

        Dinosaur dinosaur;
        while (true) {
            System.out.println(" D lives on l(and), w(ater) or s(ky)?");
            String liveOn = scanner.nextLine().toLowerCase();
            switch (liveOn) {
                case "s":
                    dinosaur = new FlyingDinosaur(name, age, species, liveOn, mainFoodSource);
                    break;
                case "w":
                    dinosaur = new AquaticDinosaur(name, age, species, liveOn, mainFoodSource);
                    break;
                case "l":
                    dinosaur = new LandDinosaur(name, age, species, liveOn, mainFoodSource);
                    break;
                default:
                    System.out.println("Please enter a valid type.");
                    continue;
            }
            break;
        }

        return dinosaur;
    }



    public void manageDinosaurs(Park park) {
        System.out.println("All our dinosaurs: ");
        //System.out.println(park.getDinosaurs()); //OMA MUUTOS
        for(Dinosaur d: park.getDinosaurs()) {
            System.out.println(d);
        }


        System.out.println("a(dd) - r(emove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a': //yksittäinen merkki, yksinkertaiset hipsut, mjonoissa kaksinkertaiset

                // Onko tarpeeksi työntekijöitä?
                if (park.getNumberOfDinosaurs() < park.getNumberOfEmployees() / park.getEmployeesToDinosaur() ) {
                    System.out.println("You can add dino. You need " + park.getMinAmountOfEmployees() + " employees.");
                    System.out.println("Dinos: " + park.getNumberOfDinosaurs() + " , employees: " + park.getNumberOfEmployees());
                    Dinosaur d = askDinosaurInfo();

                    // Varmistetaan, ettei samaa dinoa jo ole.

                    if (d != null) {
                        if (park.getDinosaurs().contains(d)) {
                            System.out.println("This dinosaur already exists.");
                        } else {
                            park.addDinosaur(d);
                            System.out.println("Dinosaur added successfully.");
                        }
                    }

                } else {
                    System.out.println("Not enough employees to take care of dino.");
                }


                break;
            case 'r':
                System.out.println("There are currently " + park.getNumberOfDinosaurs() + " dinosaurs in the park.");
                System.out.println("Which dinosaur do you want to remove? Give a name or a number.");
                String toRemove = scanner.nextLine().toLowerCase();

                if (isNumeric(toRemove)) {
                    int numAns = Integer.parseInt(toRemove) -1; //Käyttäjän silmissä numerointi alkaa ykkösestä, ei nollasta: muutetaan indeksiksi
                    park.removeDinosaur(numAns);
                } else {
                    park.removeDinosaur(toRemove);
                }


                //int i = scanner.nextInt() - 1; //Käyttäjän silmissä numerointi luultavasti alkaa ykkösestä, ei nollasta.
                //scanner.nextLine();

                //int index = 3;
                //park.removeDinosaur(i);

                break;
            case 'u':
                System.out.println("Give the name of the dinosaur: ");
                answer = scanner.nextLine();
                Dinosaur dinoToUpdate = park.getDinosaurManager().findDinosaur(answer);
                park.getDinosaurManager().updateDinosaur(dinoToUpdate);

                break;
            case 'c':
                break;
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

        //Employee employee1 = new Employee(name, jobTitle, yearsOfExperience);

        //ParkManager, SecurityOfficer ja Veterinarian?

        System.out.println("Enter employee role: M(ANAGER), S(ECURITY), V(ETERINARIAN) or C(ARETAKER)?");
        String roleAnswer = scanner.nextLine().toUpperCase();
        EmployeeRole employeeRole;
        //EmployeeRole employeeRole = EmployeeRole.valueOf(scanner.nextLine().toUpperCase());


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
                    System.out.println("Care taker specialization: ");
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

                //Employee empToRemove = park.findEmployee(name);
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