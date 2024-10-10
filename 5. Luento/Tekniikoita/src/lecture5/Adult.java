package lecture5;

public class Adult {
    private String name;
    private int age;

    public Adult(String name, int age) {
        this.name = name;
        //this.age = age;
        setAge(age); //set-metodin kautta ikä menee tarkistukseen
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (isAgeOK(age)) {
            this.age = age;
        } else {
            this.age = -1; //error state;
        }
    }


    private boolean isAgeOK(int age) {
        return age >= 18;
    }
}
