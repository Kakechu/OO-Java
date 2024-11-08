public class LandDinosaur extends Dinosaur {
    private boolean isPredator;
    private DinosaurClass dinosaurClass;

    /*
    public LandDinosaur(String name, int age, String species, MainFoodSource mainFoodSource) {
        super(name, age, species, mainFoodSource);
        this.isPredator = true;
        this.dinosaurClass = DinosaurClass.LAND;
    }

     */

    public LandDinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource) {
        super(name, age, species, liveOn, mainFoodSource);
        this.isPredator = false;
        this.dinosaurClass = DinosaurClass.LAND;
    }

    @Override
    public DinosaurClass getDinosaurClass() {
        return dinosaurClass;
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
        return super.toString() + ", LandDinosaur{" +
                "isPredator=" + isPredator +
                '}';
    }
}
