package Dinosaurs;

import java.util.Random;

public class LandDinosaur extends Dinosaur {
    private boolean isPredator;
    private boolean canDance;
    private DinosaurClass dinosaurClass;


    public LandDinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource) {
        super(name, age, species, liveOn, mainFoodSource);
        this.isPredator = false;
        this.canDance = new Random().nextBoolean();
        this.dinosaurClass = DinosaurClass.LAND;
    }

    @Override
    public DinosaurClass getDinosaurClass() {
        return dinosaurClass;
    }

    public boolean canDance() {
        return canDance;
    }

    public boolean isPredator() {
        return isPredator;
    }

    /*
    @Override
    public void roar() {
        System.out.println("Rrrrooooaaaarrr");
    }

    @Override
    public void attack() {
        System.out.println("Chaaarrggeee");
    }

 */

    @Override
    public String toString() {
        return super.toString() + ", Dinosaurs.LandDinosaur{" +
                "isPredator=" + isPredator +
                '}';
    }
}
