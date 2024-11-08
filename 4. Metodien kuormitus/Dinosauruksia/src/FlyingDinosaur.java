public class FlyingDinosaur extends Dinosaur {

    private boolean hasFeathers;
    private DinosaurClass dinosaurClass = DinosaurClass.FLYING;

    public FlyingDinosaur(String name, int age, String species, String liveOn, MainFoodSource mainFoodSource) {
        super(name, age, species, liveOn, mainFoodSource);
        this.hasFeathers = true;
        this.dinosaurClass = DinosaurClass.FLYING;
    }
    /*
    @Override
    public void fly() {
        System.out.println(this.getName() + " is flying.");
    }

    @Override
    public void escape() {
        System.out.println(this.getName() + " escaped!");
    }

    @Override
    public void land() {
        System.out.println(this.getName() + " landed.");
    }
*/
    @Override
    public DinosaurClass getDinosaurClass() {
        return dinosaurClass;
    }


    @Override
    public String toString() {
        return super.toString() +  ", FlyingDinosaur{" +
                "hasFeathers=" + hasFeathers +
                '}';
    }
}
