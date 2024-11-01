package HalloweenEsimerkkiMoniperinnasta;

// Base class
class Character {
    protected String name;

    public Character(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("I am " + name + ".");
    }
}

// Scary interface
interface Scary {
    void scare();
}

// Festive interface
interface Festive {
    void celebrate();
}

// Ghost class
class Ghost extends Character implements Scary, Festive {

    public Ghost(String name) {
        super(name);
    }

    @Override
    public void scare() {
        System.out.println(name + " says: Boo! 🎃");
    }

    @Override
    public void celebrate() {
        System.out.println(name + " is floating around haunting houses! 👻");
    }
}

// Witch class
class Witch extends Character implements Scary, Festive {

    public Witch(String name) {
        super(name);
    }

    @Override
    public void scare() {
        System.out.println(name + " says: I'll get you, my pretty! 🧙‍♀️");
    }

    @Override
    public void celebrate() {
        System.out.println(name + " is brewing potions and casting spells! 🧪✨");
    }
}

// Main class
public class HalloweenCharacterDemo {
    public static void main(String[] args) {
        Ghost ghost = new Ghost("Ghost");
        ghost.introduce();
        ghost.scare();
        ghost.celebrate();

        Witch witch = new Witch("Witch");
        witch.introduce();
        witch.scare();
        witch.celebrate();
    }
}
