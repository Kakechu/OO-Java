public class LandDinosaur extends Dinosaur implements Aggressive {
    private boolean isPredator;
    private DinosaurClass dinosaurClass;

    public LandDinosaur(String name, int age, String species, DinosaurType dinosaurType) {
        super(name, age, species, dinosaurType);
        this.isPredator = true;
        this.dinosaurClass = DinosaurClass.LAND;
    }

    @Override
    public DinosaurClass getDinosaurClass() {
        return dinosaurClass;
    }


    @Override
    public void roar() {
        System.out.println("Rrrrooooaaaarrr");
    }

    @Override
    public void attack() {
        System.out.println("Chaaarrggeee");
    }

    @Override
    public String toString() {
        return super.toString() + ", LandDinosaur{" +
                "isPredator=" + isPredator +
                '}';
    }
}
