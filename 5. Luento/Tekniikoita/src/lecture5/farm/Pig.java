package lecture5.farm;
import lecture5.animals.Dog; //eri paketti, voidaan tuoda koira import-lauseella eri paketista
import lecture5.animals.Cat;

public class Pig {

    void testDog() {
        Dog d = new Dog("Rölli"); //konstruktori public
        //d.pkgPrivate(); //näkyy vain saman paketin sisällä (package private oletusarvoisesti)

    }

    void testCat() {
        //Cat c = new Cat(); //konstruktoria ei määritelty
    }

}
