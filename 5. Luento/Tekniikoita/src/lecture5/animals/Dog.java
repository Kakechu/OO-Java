package lecture5.animals;

public class Dog {
    private String dogName;
    protected int age;

    public Dog(String dogName) {
        this.dogName = dogName;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    void pkgPrivate() {

    }

    void testCat() {
        Cat c = new Cat(); //onnistuu, koska package private ja ollaan samassa paketissa
        String mjono = "mjono";
    }
}
