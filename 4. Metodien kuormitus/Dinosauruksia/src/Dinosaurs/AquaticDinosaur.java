package Dinosaurs;

import java.util.Random;

public class AquaticDinosaur extends Dinosaur {
    private boolean canSwim;
    private DinosaurClass dinosaurClass;

    public AquaticDinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource) {
        super(name, age, species, liveOn, mainFoodSource);
        this.canSwim = new Random().nextBoolean();
        this.dinosaurClass = DinosaurClass.AQUATIC;
    }

    public boolean canSwim() {
        return canSwim;
    }

    @Override
    public DinosaurClass getDinosaurClass() {
        return dinosaurClass;
    }

    @Override
    public String toString() {
        return super.toString() + ", Dinosaurs.AquaticDinosaur{" +
                "canSwim=" + canSwim +
                '}';
    }


}
