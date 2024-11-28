package Park;

import Dinosaurs.DinosaurManager;
import Employees.EmployeeManager;
import Events.EventManager;

import java.util.Scanner;

public class Park {

    public static Scanner scanner = new Scanner(System.in); //LD

    private String name;
    private String location;
    private DinosaurManager dinosaurManager;
    private EmployeeManager employeeManager;
    private EventManager eventManager;
    private int openingHour;
    private int closingHour;

    private int employeesToDinosaur = 2;
    private int numberOfEmployees = 0;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
        this.employeeManager = new EmployeeManager(this);
        this.dinosaurManager = new DinosaurManager(this);
        this.eventManager = new EventManager(this);
    }

    // Park-related getters and setters
    public String getName() {
        return name;
    }

    public DinosaurManager getDinosaurManager() {
        return dinosaurManager;
    }

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public EventManager getEventManager() {
        return eventManager;
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

    public int getNumberOfDinosaurs() {
        return dinosaurManager.getNumberOfDinosaurs();
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }



    @Override
    public String toString() {
        return "Park.Park{" +
                "name='" + name + '\'' +
                //", employees=" + employees +
                //", dinosaurs=" + dinosaurManager.getDinosaurs() + //Siis eikai kaikkia printata?
                ", numberOfEmployees=" + numberOfEmployees +
                ", numberOfDinosaurs=" + getNumberOfDinosaurs() +
                '}';
    }



}
