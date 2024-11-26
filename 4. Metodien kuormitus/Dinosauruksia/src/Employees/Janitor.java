package Employees;

public class Janitor extends Employee {

    public Janitor(String name, String jobTitle, int yearsOfExperience) {
        super(name, jobTitle, yearsOfExperience);
    }


    @Override
    public String toString() {
        return super.toString() +  "Janitor{}";
    }
}
