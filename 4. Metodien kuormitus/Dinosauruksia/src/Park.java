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

    // dinosaur related stuff

    public void readDinosaursFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("dinosaurs.txt"));
        System.out.println("The program start reading the information of all dinosaurs from file.");
        String name = FScanner.nextLine();
        int age = Integer.parseInt(FScanner.nextLine());
        String species = FScanner.nextLine();
        dinosaurs.add(new Dinosaur(name, age, species));
        System.out.println("The information of all dinosaurs is read.");
        FScanner.close();
        this.numberOfDinosaurs = dinosaurs.size();
    }

    /*
    public Dinosaur[] addDinosaur(Dinosaur d) {
        if (this.numberOfDinosaurs < dinosaurs.length) {
            this.dinosaurs[this.numberOfDinosaurs] = d;
            this.numberOfDinosaurs++;
        } else {
            System.out.println("Park is full of Dinos.");
        }
        return this.dinosaurs;
    }

     */
/*
    public Dinosaur[] removeDinosaur(int index) {
        // Tarkista vielÃ¤ alkion olemassaolo.
        if (this.numberOfDinosaurs > index && index > 0) {
            this.dinosaurs[index] = null;
            this.numberOfDinosaurs--; // Huom!
        } else {
            System.out.println("No removing.");
        }
        return this.dinosaurs;
    }

 */

    // employee related stuff


    public void readEmployeesFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("employees.txt"));
        String name = FScanner.nextLine();
        String jobTitle = FScanner.nextLine();
        int yearsOfExperience = FScanner.nextInt();
        employees.add(new Employee(name, jobTitle, yearsOfExperience));
        FScanner.close();
        this.numberOfEmployees = employees.size();
    }


    public ArrayList<Employee> removeEmployee(Employee o) {
        // Etsi ensin se olio, joka halutaan poistaa
        //System.out.println("Anna poistettavan tyÃ¶ntekijÃ¤n nimi: ");
        //String name = scanner.nextLine();
        if (this.employees.contains(o)) {
            System.out.println("Haluatko todella poistaa tyÃ¶ntekijÃ¤n " + o.getName());
            String s = scanner.nextLine();
            if (s.equals("kylla")) {
                this.employees.remove(o);
                this.numberOfEmployees--;
            } else {
                System.out.println("No removing.");
            }
        } else {
            System.out.println("KyseistÃ¤ oliota ei ole.");
        }
        return this.employees;

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
