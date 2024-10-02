public class Juoma {
    private String name;
    private Water water;

    public Juoma(String name, Water water) {
        this.name = name;
        this.water = water;
    }

    public String getName() {
        return name;
    }

    public Water getWater() {
        return water;
    }

    @Override
    public String toString() {
        return "Drink name: " + name + '\n' +
                "water type: " + water;
    }
}

