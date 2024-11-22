public class Dinot {
    private final String name;
    private final int age;
    private final String species;
    private final String liveOn;
    private final String favoriteFood;

    public Dinot(String name, int age, String species, String liveOn, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.liveOn = liveOn;
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return "Dinot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", liveOn='" + liveOn + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}
