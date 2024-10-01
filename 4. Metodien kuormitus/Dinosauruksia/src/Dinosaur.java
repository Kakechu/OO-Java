public class Dinosaur {
    private String name;
    private int age;
    private String species;
    private DinosaurType dinosaurType;

    public Dinosaur(String name, int age, String species, DinosaurType dinosaurType) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.dinosaurType = dinosaurType;

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
