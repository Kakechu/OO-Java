import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Park {

    public static Scanner scanner = new Scanner(System.in);

    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<Dinosaur> dinosaurs;

    int maxAmountOfDinosaurs = 12;
    int employeesToDinosaur = 2;

    //ArrayList<Dinosaur> flyingDinosaurs; //tehtäväsarja 5, 6
    private Dinosaur[] flyingDinos = new Dinosaur[5]; //Teht 5_6: 6.	Luo Dinosaur-tyyppinen taulukko. Talleta kaikki lentoliskot tähän taulukkoon
    private ArrayList<Employee> veterinarians = new ArrayList<>();

    private int numberOfEmployees = 0;
    private int numberOfDinosaurs = 0;
    private int numberOfFlyingDinos = 0;

    public Park(String name) {
        this.name = name;
        this.dinosaurs = new ArrayList<Dinosaur>();
        this.employees = new ArrayList<Employee>();
    }

    // park related stuff

    public String getName() {
        return name;
    }

    public int getEmployeesToDinosaur() {
        return employeesToDinosaur;
    }
    public int getMinAmountOfEmployees() {
        return this.employeesToDinosaur * this.numberOfDinosaurs;
    }

    public int getNumberOfDinosaurs() {
        return numberOfDinosaurs;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    // dinosaur related stuff


    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    //Ilman tarkistusta
    /*
    public void readDinosaursFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("dinosaurs.txt"));
        //Scanner FScanner = new Scanner(new File("dinosaurus.txt"));

        while (FScanner.hasNext()) {
            String name = FScanner.nextLine();
            int age = Integer.parseInt(FScanner.nextLine());
            String species = FScanner.nextLine();
            MainFoodSource mainFoodSource = MainFoodSource.valueOf(FScanner.nextLine());
            dinosaurs.add(new Dinosaur(name, age, species, mainFoodSource));
        }
        FScanner.close();
        this.numberOfDinosaurs = dinosaurs.size();
    }

     */

        public void readDinosaursFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("dinosaurs.txt"));

        while (FScanner.hasNext()) {
            try {
                String name = FScanner.nextLine();
                int age = Integer.parseInt(FScanner.nextLine());  // Mahdollinen virhe: int
                String species = FScanner.nextLine();
                MainFoodSource mainFoodSource = MainFoodSource.valueOf(FScanner.nextLine());  // Mahdollinen virhe
                dinosaurs.add(new Dinosaur(name, age, species, mainFoodSource));
            } catch (NumberFormatException e) {
                System.out.println("Error parsing age.");
                // Ohitetaan virheellinen rivi ja siirrytään seuraavaan dinosaurukseen
                if (FScanner.hasNextLine()) FScanner.nextLine();  // Skippaa virheellisen rivin (species)
                if (FScanner.hasNextLine()) FScanner.nextLine();  // Skippaa virheellisen rivin (main food source)
            }
        }
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
// kuormitetaan: indeksin tai nimen perusteella
/*
    public ArrayList<Dinosaur> removeDinosaur(String name) {

        return this.dinosaurs;
    }
*/

    public void removeDinosaur(String name) {
        boolean found = false;
        for (int i = 0; i < this.dinosaurs.size(); i++) {
            Dinosaur d = this.dinosaurs.get(i);
            if (d.getName().toLowerCase().equals(name.toLowerCase())) { // Vertailu nimien suhteen, ei ole case sensitive
                this.dinosaurs.remove(i);
                this.numberOfDinosaurs--;
                System.out.println("Removed " + d.getName());
                found = true;
                break; // Poistutaan silmukasta, kun dinosaurus on löytynyt ja poistettu
            }
        }
        if (!found) {
            System.out.println("no such dino");
        }
    }
        /*
        for (Dinosaur d : this.dinosaurs) {
            if (d.getName().toLowerCase().equals(name)) {
                this.dinosaurs.remove(d);
                this.numberOfDinosaurs--;
                break;
            } else {
                System.out.println("no such dino");
                break;
            }
        }

         */


    public void removeDinosaur(int index) {
        if (this.dinosaurs.size() > index && index >= 0) { //tarkistetaan, ettei indeksi mene yli tai alle listan koon
            if (this.dinosaurs.get(index) != null) {
                // tarkistetaan, että halutaan varmasti poistaa
                System.out.println("Are you sure you want to remove " + this.dinosaurs.get(index).getName() + "? Type yes or no.");
                String answer = scanner.nextLine().toLowerCase();
                if (answer.equals("yes")) {
                    System.out.println("Removing " + this.dinosaurs.get(index));
                    this.dinosaurs.remove(index);
                    this.numberOfDinosaurs--;
                } else {
                    System.out.println("No removing.");
                }
            } else {
                System.out.println("The dinosaur doesn't exist and cannot be removed.");
            }
            } else {
            System.out.println("The dinosaur doesn't exist and cannot be removed.");
        }
    }

/*
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


 */




//jos toimiikin indeksin tai nimen perusteella - metodin kuormitus
    public void updateDinosaur(Dinosaur d) {
        if (!(d == null)) {
            System.out.println("You want to update the dinosaur " + d);
            System.out.println("What would you like to update?");
            System.out.println("n(ame) - a(ge) - c(ancel)");
            System.out.println("w(eight) - e(at) - f(avorite foods)");
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
                    System.out.println("The dino is now " + d.getAge() + " years old.");
                    break;
                // updateDinosaurWeight-testi:
                case 'w':
                    try {
                        System.out.println("Give new weight: ");
                        double weight = scanner.nextDouble();
                        scanner.nextLine();
                        updateDinosaurWeight(d, weight);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    //eat-testi
                case 'e':
                    try {
                        System.out.println("Give new weight: ");
                        double weight = scanner.nextDouble();
                        scanner.nextLine();
                        eatAndUpdateDinosaurWeight(d, weight);
                    } catch (IllegalArgumentException e) {
                        System.out.println("A mistake occurred, cannot update weight.");
                    } finally {
                        d.eat();
                    }
                    //favorite food -testi
                case 'f':
                    printFavoriteFoods();


                    /*

                case 's':
                    System.out.println("Give the new species: ");
                    String species = scanner.nextLine();
                    d.setSpecies(species);
                    System.out.println("The dinosaur's species is now " + d.getSpecies());
                    break;

                case 'm':
                    System.out.println("Give the new main food source of the dinosaur: ");
                    String type = scanner.nextLine();
                    if (type.equals("CARNIVORE") || type.equals("HERBIVORE") || type.equals("OMNIVORE")) { //ei ==
                        d.setMainFoodSource(MainFoodSource.valueOf(type));
                    } else {
                        System.out.println("Enter a valid type.");
                    }
                    break;
                    */
                case 'c':
                    break;

            }

        } else {
            System.out.println("The dinosaur doesn't exist.");
        }
    }



    public void updateDinosaurWeight(Dinosaur d, double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("The weight cannot be negative");
        }
        d.setDinosaurWeight(weight);
    }

    public void eatAndUpdateDinosaurWeight(Dinosaur d, double weight) {
        if (weight < 1000 || weight > 5000) {
            throw new IllegalArgumentException("The weight is not within allowed limits.");
        }
        d.setDinosaurWeight(weight);
    }

    public void printFavoriteFoods() {
        System.out.println("Give your name");
        String name = scanner.nextLine();
        if (isManager(name)) {
            System.out.println("Favorite foods: ");
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("favoriteFoods.txt"));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }


            } catch (FileNotFoundException e) {
                System.out.println("Error: file was not found: " + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("Error in reading the file: " + e.getMessage());
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error closing the file: " + e.getMessage());
                    }
                }
            }

        } else {
            System.out.println("Only the manager has access to favorite foods.");
        }

        //onko manageri?

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
/*
    public void writeEmployeeToFile(Employee e, String filename) {
        try {

        } catch {

        }
    }

 */

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

    public void removeEmployee(String name) {
        boolean found = false;
        for (int i = 0; i < this.employees.size(); i++) {
            Employee e = this.employees.get(i);

            if (e.getName().toLowerCase().equals(name.toLowerCase())) { // Vertailu nimien suhteen, ei ole case sensitive
                if (e instanceof ParkManager) {
                    System.out.println("Cannot remove " + e.getName() + " because they are the park manager.");
                    found = true; // johtaja löytyi
                    break;
                } else {
                    this.employees.remove(i);
                    this.numberOfEmployees--;
                    System.out.println("Removed " + e.getName());
                    found = true;
                    break; // Poistutaan silmukasta, kun työntekijä on löytynyt ja poistettu
                }
            }
        }
        if (!found) {
            System.out.println("no such employee");
        }

    }

    public void removeEmployee(int index) {
        if (this.employees.size() > index && index >= 0) { //tarkistetaan, ettei indeksi mene yli tai alle listan koon
            if (this.employees.get(index) != null) {
                // tarkistetaan, että halutaan varmasti poistaa
                System.out.println("Are you sure you want to remove " + this.employees.get(index).getName() + "? Type yes or no.");
                String answer = scanner.nextLine().toLowerCase();
                if (answer.equals("yes")) {
                    System.out.println("Removing " + this.employees.get(index));
                    this.employees.remove(index);
                    this.numberOfEmployees--;
                } else {
                    System.out.println("No removing.");
                }
            } else {
                System.out.println("The employee doesn't exist and cannot be removed.");
            }
        } else {
            System.out.println("The employee doesn't exist and cannot be removed.");
        }
    }




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

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

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
