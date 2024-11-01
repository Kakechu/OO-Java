package UpcastingAndDowncastingEsim1;

class Machine {
    void on(){ System.out.println("Machine::on()"); }
}

class Tractor extends Machine {
    @Override
    void on() { System.out.println("Tractor::on()"); }
    void drive() { System.out.println("Tractor::drive()"); }
}


public class UpcastingAndDowncasting {

    // mt viittaus(reference) kopio Machine-viittaukseen (reference) nimellä machine.
    // Huom! mainin mt ja machine osoittavat yhteen ja samaan objektiin eli olioon.

    public static void doAction(Machine machine){
        machine.on();
    }
        // upcasting
        // Kääntäjä on tyytyväinen, sillä machine-viittauksen (reference) tyyppi Machinella on on()-metodi.

    public static void main(String[] args) {

        // upcasting
        // implicit upcast: every Tractor "is-a" Machine
        // Huom! Lukusuunta: Machine viittaus Tractor-objektiin
        Machine mt = new Tractor(); // upcasting
        doAction(mt);               // polymorfism, Tractor::on() OK
        doAction(new Tractor());    // polymorfism, Tractor::on() OK
    }
}