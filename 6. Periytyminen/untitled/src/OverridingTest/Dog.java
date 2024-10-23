package OverridingTest;

import java.io.IOException;

public class Dog {
    public void walk() { System.out.println("Dog::walk()"); };
    public Dog run() { return new Dog(); }
}

class Terrier extends Dog {
    //public String walk() {return "Walk the Dog";} // Vääräpaluuarvo: Dog-luokassa void, tässä String.
    //public void walk(); // Metodissa ei ole runko-osaa, mikä antaisi ymmärtää, että kyseessä on abstrakti metodi.
    // Näin ei kuitenkaan ole, joten tästä pitäisi joko tehdä abstrakti tai lisätä runko-osa.
    //public void walk() throws IOException {} //Tämä on ristiriidassa Dog-luokan metodin kanssa, sillä tässä heitetään poikkeus (Dog-luokassa ei)
    public void walk(int meters) {}
    @Override public void walk() {System.out.println("Terrier::walk()");};
    //@Override public Dog run() {return new Dog();} //Tämä metodi on sama kuin yliluokassa, joten ei ole ylikirjoitettavaa.
    @Override public Terrier run() {return new Terrier();} //Muuten ok, mutta ei voi olla kahta metodia, jotka palauttavat saman Terrier-tyypin.
    //@Override public Dog run() {return new Terrier();} //Muuten ok, mutta ei voi olla kahta metodia, jotka palauttavat saman Terrier-tyypin.
}

/*
public class OverridingTest {

    public static void main(String[] args) {
        Dog dt = new Terrier();
        dt.walk();
        Dog d = dt.run();
        if(d instanceof Terrier) {
            System.out.println("Terrier object!");
        }
    }
}

 */
