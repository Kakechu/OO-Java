public class AquaticDinosaur extends Dinosaur {
    private boolean canSwim;
    private DinosaurClass dinosaurClass;

    public AquaticDinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource) {
        super(name, age, species, liveOn, mainFoodSource);
        this.canSwim = true;
        this.dinosaurClass = DinosaurClass.AQUATIC;
    }



    @Override
    public DinosaurClass getDinosaurClass() {
        return dinosaurClass;
    }

    @Override
    public String toString() {
        return super.toString() + ", AquaticDinosaur{" +
                "canSwim=" + canSwim +
                '}';
    }
}
