import Dinosaurs.Dinosaur;
import Dinosaurs.DinosaurManager;
import Employees.Employee;
import Employees.EmployeeManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Park {

    public static Scanner scanner = new Scanner(System.in); //LD

    private String name;
    private String location;
    private DinosaurManager dinosaurManager;
    private EmployeeManager employeeManager;
    private int openingHour;
    private int closingHour;


    private ArrayList<Employee> employees;//LE

    int employeesToDinosaur = 2;


    private ArrayList<Employee> veterinarians = new ArrayList<>();

    private int numberOfEmployees = 0;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
        //this.dinosaurs = new ArrayList<Dinosaurs.Dinosaur>(); //MUUTA
        //this.employees = new ArrayList<Employees.Employee>();
        this.dinosaurManager = new DinosaurManager();
        this.employeeManager = new EmployeeManager();

    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public DinosaurManager getDinosaurManager() {
        return dinosaurManager;
    }

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public int getEmployeesToDinosaur() {
        return employeesToDinosaur;
    }

    public int getMinAmountOfEmployees() {
        return this.employeesToDinosaur * dinosaurManager.getNumberOfDinosaurs();
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }

    // dinosaur related stuff

    public void manageDinosaurs() {
        System.out.println("All our dinosaurs: ");
        for (Dinosaur d : dinosaurManager.getDinosaurs()) {
            System.out.println(d);
        }

        System.out.println("a(dd) - r(emove) - u(pdate) - s(how all dinosaurs) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                handleAddDinosaur();
                break;
            case 'r':
                handleRemoveDinosaur();
                break;
            case 'u':
                handleUpdateDinosaur();
                break;
            case 's':
                handleShowDinosaurs();
                break;
            case 'c':
                break;
        }
    }


    private void handleAddDinosaur() {
        if (getNumberOfDinosaurs() < getNumberOfEmployees() / employeesToDinosaur) {
            System.out.println("You can add dino. You need " + getMinAmountOfEmployees() + " employees.");
            Dinosaur d = dinosaurManager.askDinosaurInfo();

            if (d != null) {
                if (getDinosaurs().contains(d)) {
                    System.out.println("This dinosaur already exists.");
                } else {
                    dinosaurManager.addDinosaur(d);
                    System.out.println("Dinosaur added successfully.");
                }
            }
        } else {
            System.out.println("Not enough employees to take care of dino.");
            //printtaa, miten monta työntekijää tarvitaan?
        }
    }

    private void handleRemoveDinosaur() {
        System.out.println("Which dinosaur do you want to remove? Give a name or a number.");
        String toRemove = scanner.nextLine().toLowerCase();
        if (isNumeric(toRemove)) {
            int numAns = Integer.parseInt(toRemove) - 1; // Adjust user input to 0-based index
            dinosaurManager.removeDinosaur(numAns);
        } else {
            dinosaurManager.removeDinosaur(toRemove);
        }
    }

    private void handleUpdateDinosaur() {
        System.out.println("Give the name of the dinosaur: ");
        String answer = scanner.nextLine();
        Dinosaur dinoToUpdate = dinosaurManager.findDinosaur(answer);
        dinosaurManager.updateDinosaur(dinoToUpdate);
    }

    private void handleShowDinosaurs() {
        System.out.println("All our dinosaurs: ");
        for (Dinosaur d : dinosaurManager.getDinosaurs()) {
            System.out.println(d);
        }
    }


    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurManager.getDinosaurs();
    }

    public int getNumberOfDinosaurs() {
        return dinosaurManager.getNumberOfDinosaurs();
    }




    // employee related stuff


    public ArrayList<Employee> getEmployees() {
        return employeeManager.getEmployees();
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void addEmployee(Employee e) {
        employeeManager.addEmployee(e);
    }

    public void removeEmployee(String name) {
        employeeManager.removeEmployee(name);
    }

    public void removeEmployee(int index) {
        employeeManager.removeEmployee(index);
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

    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                //", employees=" + employees +
                //", dinosaurs=" + dinosaurManager.getDinosaurs() + //Siis eikai kaikkia printata?
                ", numberOfEmployees=" + numberOfEmployees +
                ", numberOfDinosaurs=" + dinosaurManager.getNumberOfDinosaurs() +
                '}';
    }


}
