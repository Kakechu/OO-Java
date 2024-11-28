package Employees;

import Dinosaurs.Dinosaur;
import Park.Park;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeManager {
    public static Scanner scanner = new Scanner(System.in);
    private Park park;
    private ArrayList<Employee> employees;
    private ArrayList<Employee> veterinarians = new ArrayList<>();

    private int numberOfEmployees = 0;

    // Konstruktori
    public EmployeeManager(Park park) {
        this.park = park;
        this.employees = new ArrayList<>();
    }

    // Getterit
    public int getNumberOfEmployees() {
        return numberOfEmployees;
        //return this.employees.size();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Reading employees from file

    public void readEmployeesFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("employees.txt"));
        System.out.println("The program starts reading the information of all employees.");
        while(FScanner.hasNextLine()) {
            String name = FScanner.nextLine();
            System.out.println("Name" + name);
            String jobTitle = FScanner.nextLine();
            System.out.println(jobTitle);
            int yearsOfExperience = FScanner.nextInt();
            FScanner.nextLine();
            System.out.println(yearsOfExperience);
            employees.add(new Employee(name, jobTitle, yearsOfExperience));
        }
        //System.out.println("The information of all employees is read.");
        FScanner.close();
        this.numberOfEmployees = employees.size();
    }


//manager


    public void manageEmployees(Park park) {
        System.out.println("All our employees: ");
        for(Employee e: getEmployees()) {
            System.out.println(e);
        }

        System.out.println("a(dd) - r(emove) - u(pdate) - s(how all employees) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                handleAddEmployee();
                break;
            case 'r':
                handleRemoveEmployee();
                break;
            case 'u':
                handleUpdateEmployee();
                break;
            case 's':
                handleShowEmployees();
            case 'c':
                break;
        }
    }


    private void handleAddEmployee() {
        Employee e = askEmployeeInfo();
        if (e != null) {
            if (getEmployees().contains(e)) {
                System.out.println("This employee already exists.");
            } else {
                addEmployee(e);
                System.out.println("Employee added successfully.");
            }
        }
    }

    private void handleRemoveEmployee() {
        int minEmployeesNeeded = park.getEmployeesToDinosaur() * park.getNumberOfDinosaurs();

        // Checking if the park has the minimum amount of employees.
        if (park.getNumberOfEmployees() < minEmployeesNeeded) {
            System.out.println("You can't go below the minimum amount of employees: " + minEmployeesNeeded);
            return;
        }

        // Inform the user of the current number of employees
        System.out.println("There are currently " + getEmployees().size() + " employees in the park.");
        for (Employee employee : getEmployees()) {
            System.out.println(employee);
        }
        // Ask the user which employee they want to remove
        System.out.println("Which employee do you want to remove? Give a name or a number.");
        String empToRemove = scanner.nextLine();

        // If a number was entered, parse it to get the employee index
        if (isNumeric(empToRemove)) {
            int empNum = Integer.parseInt(empToRemove) - 1;  // Convert to 0-based index
            removeEmployee(empNum);
        } else {
            removeEmployee(empToRemove);
        }
    }

    private void handleUpdateEmployee() {
        // Ask for the name of the employee to be updated
        System.out.println("Give the name of the employee to update: ");
        String nameToUpdate = scanner.nextLine();

        Employee empToUpdate = findEmployee(nameToUpdate);

        // Check if the employee was found
        if (empToUpdate != null) {
            updateEmployee(empToUpdate);
        } else {
            System.out.println("Employee not found: " + nameToUpdate);
        }
    }

    private void handleShowEmployees() {
        System.out.println("All our employees: ");
        for (Employee e : getEmployees()) {
            System.out.println(e);
        }
    }

//end of manager

    // Creating employee by asking the user to input info
    public Employee askEmployeeInfo() {
        System.out.println(" E name: ");
        String name = scanner.nextLine();
        System.out.println(" E job title: ");
        String jobTitle = scanner.nextLine().toLowerCase();
        System.out.println(" E years of experience: ");
        int yearsOfExperience = scanner.nextInt();
        scanner.nextLine();

        return getEmployeeRole(name, jobTitle, yearsOfExperience);

    }

    private Employee getEmployeeRole(String name, String jobTitle, int yearsOfExperience) {

        Employee employee;
        while (true) {
            System.out.println("Enter employee role: M(ANAGER), S(ECURITY), V(ETERINARIAN), C(ARETAKER) or J(ANITOR)?");
            String roleAnswer = scanner.nextLine().toUpperCase();

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
                case "J":
                    employee = new Janitor(name, jobTitle, yearsOfExperience);
                    break;
                default:
                    System.out.println("Please enter a valid type.");
                    continue;
            }
            break;
        }
        return employee;
    }


    public void addEmployee(Employee e) {
        this.employees.add(e);
        this.numberOfEmployees++;

        if (e.getEmployeeRole() == EmployeeRole.VETERINARIAN) {
            this.veterinarians.add(e);
            System.out.println("Eläinlääkäri lisätty");
        }

    }

    // Työntekijän poistaminen nimen perusteella
    public void removeEmployee(String name) {
        Employee e = findEmployee(name);
        if (e!= null) {
            if (confirmRemoval(e)) {
                this.employees.remove(e);
                this.numberOfEmployees--;
                System.out.println("Removed " + e.getName());
            } else {
                System.out.println("Cancelling removal.");
            }
        } else {
            System.out.println("The employee doesn't exist and cannot be removed.");
        }
    }
    // Työntekijän poisto indeksin perusteella
    public void removeEmployee(int index) {
        if (this.getNumberOfEmployees() > index && index >= 0) { //tarkistetaan, ettei indeksi mene yli tai alle listan koon
            Employee e = this.employees.get(index);
            if (e != null) {
                if (confirmRemoval(e)) {
                    this.employees.remove(index);
                    this.numberOfEmployees--;
                    System.out.println("Removed " + e.getName());
                } else {
                    System.out.println("Cancelling removal.");
                }
            } else {
                System.out.println("The employee doesn't exist and cannot be removed.");
            }
        } else {
            System.out.println("Invalid index."); //Tarkista tarvitaanko!!!
        }
    }

    // Olisiko järkevää tehdä poisto olion perusteella ja hyödyntää find-metodia?

    public void updateEmployee(Employee e) {
        if (!(e == null)) {
            System.out.println("You want to update the employee " + e);
            System.out.println("What would you like to update?");
            System.out.println("j(ob title) - y(ears of experience) - c(ancel)");
            String answer = scanner.nextLine();

            switch (answer.charAt(0)) {
                case 'j':
                    System.out.println("Give a new job title: ");
                    String title = scanner.nextLine();
                    e.setJobTitle(title);
                    System.out.println("The employee's job title is now " + e.getJobTitle());
                    break;
                case 'y':
                    System.out.println("Give years of experience: ");
                    int years = scanner.nextInt();
                    scanner.nextLine();
                    e.setYearsOfExperience(years);
                    System.out.println("The employee now has " + e.getYearsOfExperience() + " years of experience.");
                    break;
                case 'c':
                    break;
            }

        } else {
            System.out.println("The employee doesn't exist.");
        }
    }


    // Helper methods

    // Helper method for finding employee
    public Employee findEmployee(String name) {
        for (Employee e : this.employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    // Helper method for confirmation
    public boolean confirmRemoval(Employee e) {
        System.out.println("Are you sure you want to remove " + e.getName() + "? Type Y/N: ");
        String answer = scanner.nextLine().toUpperCase();
        return answer.equals("Y");
    }

    // Apumetodi, tarkista tarvitaanko
    public boolean isManager(String name) {

        for (Employee e : this.employees) {
            try {
                if (e.getName().equalsIgnoreCase(name) && e.getEmployeeRole().equals(EmployeeRole.MANAGER)) {
                    return true;
                }
            } catch (NullPointerException ex) {
                System.out.println("Error: no role determined for this employee.");
            }
        }
        return false;
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


    /*
        public boolean isManager(String name) {

        for (Employees.Employee e : this.employees) {
            try {
                if (e.getName().equalsIgnoreCase(name) && e.getEmployeeRole().equals(Employees.EmployeeRole.MANAGER)) {
                    return true;
                }
            } catch (NullPointerException ex) {
                System.out.println("Error: no role determined for this employee.");
            }
        }

        return false;
    }

        public ArrayList<Employees.Employee> removeEmployee(Employees.Employee o) { //ei tarvita objektin perusteella?
        // Etsi ensin se olio, joka halutaan poistaa
        //minimimäärän tarkistus
        //System.out.println("Anna poistettavan tyÃ¶ntekijÃ¤n nimi: ");
        //String name = scanner.nextLine();
        if (this.employees.contains(o)) {
            System.out.println("Are you sure you want to remove " + o.getName());
            String s = scanner.nextLine();
            if (s.equals("yes")) {
                this.employees.remove(o);
                this.numberOfEmployees--;
            } else {
                System.out.println("No removing.");
            }
        } else {
            System.out.println("The employee doesn't exist.");
        }
        return this.employees;
    }

     */


}
