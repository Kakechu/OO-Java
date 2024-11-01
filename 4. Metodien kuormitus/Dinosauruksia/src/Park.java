import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Park {

    public static Scanner scanner = new Scanner(System.in);

    String name;
    ArrayList<Employee> employees;
    ArrayList<Dinosaur> dinosaurs;
    //ArrayList<Dinosaur> flyingDinosaurs; //tehtäväsarja 5, 6
    Dinosaur[] flyingDinos = new Dinosaur[5]; //Teht 5_6: 6.	Luo Dinosaur-tyyppinen taulukko. Talleta kaikki lentoliskot tähän taulukkoon
    ArrayList<Employee> veterinarians = new ArrayList<>();

    int numberOfEmployees = 0;
    int numberOfDinosaurs = 0;
    int numberOfFlyingDinos = 0;

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

    public Dinosaur findDinosaur(String name) {
        for (Dinosaur d : this.dinosaurs) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    public ArrayList<Dinosaur> addDinosaur(Dinosaur d) {
        //Tässä ei vielä maksimimäärän tarkistusta
        this.dinosaurs.add(d);
        this.numberOfDinosaurs++;
        //
        // tarkista, lentääkö ja mahtuuko, mitä tapahtuu jos ei mahdu??
        if (d.getDinosaurClass() == DinosaurClass.FLYING && numberOfFlyingDinos < flyingDinos.length) {
            this.flyingDinos[this.numberOfFlyingDinos] = d;
            numberOfFlyingDinos++;
            System.out.println("lentolisko lisätty");
        }

        // testiprintti
        /*
        for (Dinosaur dino : flyingDinos) {
            if (dino != null) {
                System.out.println(dino);
            }
        }

         */
        return this.dinosaurs;
    }

    public ArrayList<Dinosaur> removeDinosaur(int index) {
        if (this.dinosaurs.size() > index && index >= 0) {
            System.out.println("Are you sure you want to remove " + this.dinosaurs.get(index).getName());
            String answer = scanner.nextLine();
            if (answer.equals("yes")) {
                this.dinosaurs.remove(index);
            } else {
                System.out.println("No removing.");
            }


        } else {
            System.out.println("The dinosaur doesn't exist and cannot be removed.");
        }
        return this.dinosaurs;


    }

    public void updateDinosaur(Dinosaur d) {
        if (!(d == null)) {
            System.out.println("You want to update the dinosaur " + d);
            System.out.println("What would you like to update?");
            System.out.println("n(ame) - a(ge) - s(pecies) - t(type) - c(ancel)");
            String answer = scanner.nextLine();

            switch (answer.charAt(0)) {
                case 'n':
                    System.out.println("Give a new name: ");
                    String name = scanner.nextLine();
                    d.setName(name);
                    System.out.println("The dinosaur's name is now " + d.getName());
                    break;
                case 'a':
                    System.out.println("Give new age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    d.setAge(age);
                    System.out.println("The dino is no " + d.getAge() + " years old.");
                    break;
                case 's':
                    System.out.println("Give the new species: ");
                    String species = scanner.nextLine();
                    d.setSpecies(species);
                    System.out.println("The dinosaur's species is now " + d.getSpecies());
                    break;
                case 't':
                    System.out.println("Give the new type of the dinosaur: ");
                    String type = scanner.nextLine();
                    if (type.equals("CARNIVORE") || type.equals("HERBIVORE") || type.equals("OMNIVORE")) { //ei ==
                        d.setDinosaurType(DinosaurType.valueOf(type));
                    } else {
                        System.out.println("Enter a valid type.");
                    }
                    break;
                case 'c':
                    break;

            }

        } else {
            System.out.println("The dinosaur doesn't exist.");
        }
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
        //System.out.println("The program starts reading the information of all employees.");
        while(FScanner.hasNext()) {
            String name = FScanner.nextLine();
            String jobTitle = FScanner.nextLine();
            int yearsOfExperience = FScanner.nextInt();
            FScanner.nextLine();
            employees.add(new Employee(name, jobTitle, yearsOfExperience));
        }
        //System.out.println("The information of all employees is read.");
        FScanner.close();
        this.numberOfEmployees = employees.size();
    }

    public Employee findEmployee(String name) {
        for (Employee e : this.employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Employee> addEmployee(Employee e) {
        //Tässä ei vielä maksimimäärän tarkistusta
        this.employees.add(e);
        this.numberOfEmployees++;

        //TÄHÄN LISTAAN LISÄYS
        if (e.getEmployeeRole() == EmployeeRole.VETERINARIAN) {
            this.veterinarians.add(e);
            System.out.println("Eläinlääkäri lisätty");
        }

        /*
        for (Employee emp : this.veterinarians) {
            System.out.println(emp);
        }

         */

        return this.employees;
    }


    public ArrayList<Employee> removeEmployee(Employee o) {
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

    public void updateEmployee(Employee e) {
        if (!(e == null)) {
            System.out.println("You want to update the employee " + e);
            System.out.println("What would you like to update?");
            System.out.println("n(ame) - j(ob title) - y(ears of experience) - c(ancel)");
            String answer = scanner.nextLine();

            switch (answer.charAt(0)) {
                case 'n':
                    System.out.println("Give a new name: ");
                    String name = scanner.nextLine();
                    e.setName(name);
                    System.out.println("The employee's name is now " + e.getName());
                    break;
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

    public ArrayList<Employee> getEmployees() {
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
