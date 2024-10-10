package lecture5.animals;

public class Cat {
    Cat(){}

    public void testDogAccess() {
        Dog d = new Dog("Rex");
        //d.dogName = "Rölli";
        System.out.println(d.getDogName());
        d.setDogName("Angie");
        //System.out.println(d.dogName);
        d.age = 2; //saman paketin sisällä protected, pääsen käsiksi
        d.pkgPrivate();
    }

}
