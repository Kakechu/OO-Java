package Dinosaurs;

import Park.*;
import Employees.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DinosaurManager {
    public static Scanner scanner = new Scanner(System.in);
    private Park park;
    private ArrayList<Dinosaur> dinosaurs;
    private Dinosaur[] flyingDinos = new Dinosaur[5];

    int maxAmountOfDinosaurs = 12; // Tarkista, onko tarpeen.
    private int numberOfDinosaurs = 0;
    private int numberOfFlyingDinos = 0;

    // Konstruktori
    public DinosaurManager(Park park) {
        this.park = park;
        this.dinosaurs = new ArrayList<>();
    }

    // Getterit
    public int getNumberOfDinosaurs() {
        return numberOfDinosaurs;
    }

    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    // Reading dinosaurs from file
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

//manager

    public void manageDinosaurs() {
        System.out.println("All our dinosaurs: ");
        for (Dinosaur d : getDinosaurs()) {
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
        if (getNumberOfDinosaurs() < park.getNumberOfEmployees() / park.getEmployeesToDinosaur()) {
            System.out.println("You can add dino. You need " + park.getMinAmountOfEmployees() + " employees.");
            Dinosaur d = askDinosaurInfo();

            if (d != null) {
                if (getDinosaurs().contains(d)) {
                    System.out.println("This dinosaur already exists.");
                } else {
                    addDinosaur(d);
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
            removeDinosaur(numAns);
        } else {
            removeDinosaur(toRemove);
        }
    }

    private void handleUpdateDinosaur() {
        System.out.println("Give the name of the dinosaur: ");
        String answer = scanner.nextLine();
        Dinosaur dinoToUpdate = findDinosaur(answer);
        updateDinosaur(dinoToUpdate);
    }

    private void handleShowDinosaurs() {
        System.out.println("All our dinosaurs: ");
        for (Dinosaur d : getDinosaurs()) {
            System.out.println(d);
        }
    }

// end of manager

    // Creating dinosaur by asking the user to input info
    public Dinosaur askDinosaurInfo() {
        System.out.println(" D name: ");
        String name = scanner.nextLine();
        System.out.println(" D age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" D species: ");
        String species = scanner.nextLine();

        MainFoodSource mainFoodSource = getMainFoodSource();

        return getDinosaurType(name, age, species, mainFoodSource);
    }
    // Help method to get mainFoodSource
    private MainFoodSource getMainFoodSource() {
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
                    continue;
            }
            break;
        }
        return mainFoodSource;
    }

    // Help method to get dinosaurType and to create the dinosaur
    private Dinosaur getDinosaurType(String name, int age, String species, MainFoodSource mainFoodSource) {
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


    // Helper method to find dinosaur by name
    public Dinosaur findDinosaur(String name) {
        for (Dinosaur d : this.dinosaurs) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
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




    // Dinosaurusten lisäys ja poisto
    public ArrayList<Dinosaur> addDinosaur(Dinosaur d) {
        //Tässä ei vielä maksimimäärän tarkistusta
        this.dinosaurs.add(d);
        this.numberOfDinosaurs++;
        //
        // tarkista, lentääkö ja mahtuuko, mitä tapahtuu jos ei mahdu??
        // LISÄÄ? maaliskoille ja vesiliskoille omansa?
        if (d.getDinosaurClass() == DinosaurClass.FLYING && numberOfFlyingDinos < flyingDinos.length) {
            this.flyingDinos[this.numberOfFlyingDinos] = d;
            numberOfFlyingDinos++;
            System.out.println("lentolisko lisätty");
        }
        return this.dinosaurs;
    }

    // Dinosauruksen poisto nimen perusteella
    public void removeDinosaur(String name) {
        Dinosaur d = findDinosaur(name);
        if (d != null) {
            if (confirmRemoval(d)) {
                this.dinosaurs.remove(d);
                this.numberOfDinosaurs--;
                System.out.println("Removed " + d.getName());
            } else {
                System.out.println("Cancelling removal.");
            }
        } else {
            System.out.println("The dinosaur doesn't exist and cannot be removed.");
        }
    }

    // Dinosauruksen poisto indeksin perusteella
    public void removeDinosaur(int index) {
        if (this.dinosaurs.size() > index && index >= 0) { //tarkistetaan, ettei indeksi mene yli tai alle listan koon
            Dinosaur d = this.dinosaurs.get(index);
            if (d != null) {
                if (confirmRemoval(d)) {
                    this.dinosaurs.remove(index);
                    this.numberOfDinosaurs--;
                    System.out.println("Removed " + d.getName());
                } else {
                    System.out.println("Cancelling removal.");
                }
            } else {
                System.out.println("The dinosaur doesn't exist and cannot be removed.");
            }
        } else {
            System.out.println("Invalid index."); //Tarksita tarvitaanko!!!
        }
    }


    public boolean confirmRemoval(Dinosaur d) {
        System.out.println("Are you sure you want to remove " + d.getName() + "? Type Y/N: ");
        String answer = scanner.nextLine().toUpperCase();
        return answer.equals("Y");
    }

    //
//jos toimiikin indeksin tai nimen perusteella - metodin kuormitus
    public void updateDinosaur(Dinosaur d) {
        if (!(d == null)) {
            System.out.println("You want to update the dinosaur " + d);
            System.out.println("What would you like to update?");
            System.out.println("n(ame) - a(ge) - c(ancel)");
            //System.out.println("w(eight) - e(at) - f(avorite foods)");
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
                /*
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

                 */
                case 'c':
                    break;

            }

        } else {
            System.out.println("The dinosaur doesn't exist.");
        }
    }

    /*
        public void updateDinosaurWeight(Dinosaurs.Dinosaur d, double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("The weight cannot be negative");
        }
        d.setDinosaurWeight(weight);
    }

    public void eatAndUpdateDinosaurWeight(Dinosaurs.Dinosaur d, double weight) {
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
     */




}
