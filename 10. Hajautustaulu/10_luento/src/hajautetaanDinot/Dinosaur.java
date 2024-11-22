package hajautetaanDinot;

import java.util.HashMap;

public class Dinosaur {
    private final String name;
    private final int age;
    private final String species;
    private final String liveOn;
    private String favoriteFood;

    public Dinosaur(String name, int age, String species, String liveOn, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.liveOn = liveOn;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dinosaur{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", liveOn='" + liveOn + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Dinosaur marjukka = new Dinosaur("Marjukka", 83, "T-Rex", "Land", "spiders");
        Dinosaur kaarlo = new Dinosaur("Kaarlo", 155, "Stegosaurus", "Land", "lehmuksen lehdet");
        Dinosaur olavi = new Dinosaur("Olavi", 89, "Oviraptor", "Land", "Dodon munat");

        HashMap<Integer, Dinosaur> dinosaurs = new HashMap<>();
        dinosaurs.put(1, marjukka);
        dinosaurs.put(2, kaarlo);
        dinosaurs.put(3, olavi);

        System.out.println(dinosaurs.get(1));

        DinosaurHashMap dinosaursHash = new DinosaurHashMap();
        dinosaursHash.addDinosaur(1, marjukka);
        dinosaursHash.addDinosaur(2, kaarlo);
        dinosaursHash.addDinosaur(3, olavi);

        System.out.println("From DinosaurHashMap object");
        System.out.println(dinosaursHash.findDino(2));
        System.out.println();
        System.out.println(dinosaursHash.findDino(1));
        System.out.println();
        System.out.println("Etsitään nimellä");
        System.out.println(dinosaursHash.searchDinoWithName("Olavi"));
    }
}
