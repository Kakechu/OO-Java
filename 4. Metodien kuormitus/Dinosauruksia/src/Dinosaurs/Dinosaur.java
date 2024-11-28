package Dinosaurs;

import java.util.Random;

public class Dinosaur {
    private String name;
    private int age;
    private String species;
    private String liveOn; // UML-lisäys
    private MainFoodSource mainFoodSource;
    private String enclosure;
    private String favoriteFood;

    private DinosaurClass dinosaurClass; //Ei virallisessa versiossa
    //private boolean isHealthy; //Ei virallisessa versiossa

    private double dinosaurWeight = 1000; //oletuspaino 1000 kg

    private VaccinationCard vaccinationCard;

    public Dinosaur() { // UML-lisäys
    }

    // tämä konstruktori tiedostosta lukemista varten

    // tämä konstruktori dinon lisäämistä varten
    public Dinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource) {

        if (name == null || name.length() > 40) {
            throw new IllegalArgumentException("Name cannot be null and must be 40 characters or less.");
        }

        if (age < 65 || age > 230) {
            throw new IllegalArgumentException("Dinosaurs.Dinosaur age must be between 65 and 230 million years.");
        }

        this.name = name;
        this.age = age;
        this.species = species;
        this.liveOn = liveOn;
        this.mainFoodSource = mainFoodSource;
        this.vaccinationCard = new VaccinationCard(0,0);
    }

    // Tämä konstruktori luotu updateDinosaurWeight-metodia varten.
    public Dinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource, DinosaurClass dinosaurClass, double dinosaurWeight) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.liveOn = liveOn;
        this.mainFoodSource = mainFoodSource;
        this.dinosaurClass = dinosaurClass;
        this.dinosaurWeight = dinosaurWeight;
        this.enclosure = assignEnclosure(this.liveOn);

        Random random = new Random();
        int randomYear = 2000 + random.nextInt(11); //2000-2010
        this.vaccinationCard = new VaccinationCard(randomYear,randomYear);
    }


    private String assignEnclosure(String liveOn) {
        switch (liveOn.toLowerCase()) {
            case "land":
                return "Desert World";
            case "water":
                return "Water World";
            case "air":
                return "Cloud Castle";
            default:
                throw new IllegalArgumentException("Unknown liveOn type: " + liveOn);
        }
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // sama viite
        if (obj == null || this.getClass() != obj.getClass()) return false; // eri luokka tai null

        Dinosaur d = (Dinosaur) obj; // tyyppimuunnos
        return this.name.equalsIgnoreCase(d.getName()) &&
                this.age == d.getAge() &&
                this.species.equalsIgnoreCase(d.getSpecies()) &&
                this.liveOn.equalsIgnoreCase(d.getLiveOn()) &&
                this.mainFoodSource == d.getMainFoodSource();

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public String getLiveOn() {
        return liveOn;
    }

    public MainFoodSource getMainFoodSource() {
        return mainFoodSource;
    }

    public void createVaccinationCard(int parvoVacYear, int ExtinctionVacYear) {
        this.vaccinationCard = new VaccinationCard(parvoVacYear, ExtinctionVacYear);
    }

    public VaccinationCard getVaccinationCard() {
        return vaccinationCard;
    }


    public DinosaurClass getDinosaurClass() {
        return dinosaurClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setMainFoodSource(MainFoodSource mainFoodSource) {
        this.mainFoodSource = mainFoodSource;
    }

    public double getDinosaurWeight() {
        return dinosaurWeight;
    }

    public void setDinosaurWeight(double dinosaurWeight) {
        this.dinosaurWeight = dinosaurWeight;
    }

    public void eat() {
        System.out.println("Dino is eating.");
    }

    @Override
    public String toString() {
        return "Dinosaurs.Dinosaur{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", mainFoodSource=" + mainFoodSource +
                '}';
    }
}
