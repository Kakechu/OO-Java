public class Dinosaur {
    private String name;
    private int age;
    private String species;
    private String liveOn; // UML-lisäys
    private MainFoodSource mainFoodSource;

    private DinosaurClass dinosaurClass; //Ei virallisessa versiossa
    //private boolean isHealthy; //Ei virallisessa versiossa

    public Dinosaur() { // UML-lisäys
    }

    // tämä konstruktori tiedostosta lukemista varten
    public Dinosaur(String name, int age, String species, MainFoodSource mainFoodSource) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.liveOn = "Land";
        this.mainFoodSource = mainFoodSource;
        this.dinosaurClass = DinosaurClass.LAND; //maalisko oletusarvoksi
        //this.isHealthy = true; //oletusarvoisesti dinot terveitä


    }
    // tämä konstruktori
    public Dinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.liveOn = liveOn;
        this.mainFoodSource = mainFoodSource;
    }

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

    /*
    public MainFoodSource getMainFoodSource() {
        return mainFoodSource;
    }

     */

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

    /*
    public void getSick() {
        this.isHealthy = false;
    }

    public void getHealthy() {
        this.isHealthy = true;
    }

    public void isHealthy() {

        if (this.isHealthy == true) {
            System.out.println(this.getName() + " is healthy.");
        } else {
            System.out.println(this.getName() + " is sick.");
        }

    }

     */

    @Override
    public String toString() {
        return "Dinosaur{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", mainFoodSource=" + mainFoodSource +
                '}';
    }
}
