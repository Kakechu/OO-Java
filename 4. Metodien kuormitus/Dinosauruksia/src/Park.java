import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Park {

    public static Scanner scanner = new Scanner(System.in); //LD

    private String name;
    private String location;
    private DinosaurManager dinosaurManager;
    private EmployeeManager employeeManager;

    private ArrayList<Employee> employees;//LE

    int employeesToDinosaur = 2;


    private ArrayList<Employee> veterinarians = new ArrayList<>();

    private int numberOfEmployees = 0;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
        //this.dinosaurs = new ArrayList<Dinosaur>(); //MUUTA
        //this.employees = new ArrayList<Employee>();
        this.dinosaurManager = new DinosaurManager();
        this.employeeManager = new EmployeeManager();

    }

    // park related stuff
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





    // dinosaur related stuff
    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurManager.getDinosaurs();
    }

    public int getNumberOfDinosaurs() {
        return dinosaurManager.getNumberOfDinosaurs();
    }

    public void addDinosaur(Dinosaur d) {
        dinosaurManager.addDinosaur(d);
    }

    public void removeDinosaur(String name) {
        dinosaurManager.removeDinosaur(name);
    }

    public void removeDinosaur(int index) {
        dinosaurManager.removeDinosaur(index);
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
