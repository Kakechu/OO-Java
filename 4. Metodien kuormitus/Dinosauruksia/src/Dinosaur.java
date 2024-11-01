public class Dinosaur {
    private String name;
    private int age;
    private String species;
    private DinosaurType dinosaurType;
    private DinosaurClass dinosaurClass;
    private boolean isHealthy;


    public Dinosaur(String name, int age, String species, DinosaurType dinosaurType) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.dinosaurType = dinosaurType;
        this.dinosaurClass = DinosaurClass.LAND; //maalisko oletusarvoksi
        this.isHealthy = true; //oletusarvoisesti dinot terveitä

        //alkaa lisäys
        //this.dinosaurEnvironment =

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

    public DinosaurType getDinosaurType() {
        return dinosaurType;
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

    public void setDinosaurType(DinosaurType dinosaurType) {
        this.dinosaurType = dinosaurType;
    }

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

    @Override
    public String toString() {
        return "Dinosaur{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", dinosaurType=" + dinosaurType +
                '}';
    }
}
