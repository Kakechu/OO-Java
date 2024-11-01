import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Park {

    public static Scanner scanner = new Scanner(System.in);

    String name;
    ArrayList<Employee> employees;
    ArrayList<Dinosaur> dinosaurs;

    int numberOfEmployees = 0;
    int numberOfDinosaurs = 0;

    public Park(String name) {
        this.name = name;
        this.dinosaurs = new ArrayList<Dinosaur>();
        this.employees = new ArrayList<Employee>();
    }

    // park related stuff

    public String getName() {
        return name;
    }


    // dinosaur related stuff


    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void readDinosaursFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("dinosaurs.txt"));
        //System.out.println("The program start reading the information of all dinosaurs from file.");
        while (FScanner.hasNext()) {
            String name = FScanner.nextLine();
            int age = Integer.parseInt(FScanner.nextLine());
            String species = FScanner.nextLine();
            DinosaurType dinosaurType = DinosaurType.valueOf(FScanner.nextLine());
            dinosaurs.add(new Dinosaur(name, age, species, dinosaurType));
        }
        //System.out.println("The information of all dinosaurs is read.");
        FScanner.close();
        this.numberOfDinosaurs = dinosaurs.size();
    }

    /*
    public Dinosaur[] addDinosaur(Dinosaur d) {
        if (this.numberOfDinosaurs < dinosaurs.length) {
            this.dinosaurs[this.numberOfDinosaurs] = d;
            this.numberOfDinosaurs++;
        } else {
            System.out.println("Park is full of Dinosaurs.");
        }
        return this.dinosaurs;
    }

     */
/*
    public Dinosaur[] removeDinosaur(int index) {
        // Check if the object exists?
        if (this.numberOfDinosaurs > index && index > 0) {
            this.dinosaurs[index] = null;
            this.numberOfDinosaurs--; // !!!
        } else {
            System.out.println("No removing.");
        }
        return this.dinosaurs;
    }

 */

    // employee related stuff


    public void readEmployeesFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("employees.txt"));
        //System.out.println("The program start reading the information of all employees from the file");
        while(FScanner.hasNext()) {
            String name = FScanner.nextLine();
            String jobTitle = FScanner.nextLine();
            int yearsOfExperience = FScanner.nextInt();
            FScanner.nextLine();
            employees.add(new Employee(name, jobTitle, yearsOfExperience));
        }
        //System.out.println("The information of all employees is read");
        FScanner.close();
        this.numberOfEmployees = employees.size();
    }




    @Override
    public String toString() {
        return "Park{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                ", dinosaurs=" + dinosaurs +
                ", numberOfEmployees=" + numberOfEmployees +
                ", numberOfDinosaurs=" + numberOfDinosaurs +
                '}';
    }
}
