package Employees;

public class Veterinarian extends Employee { //implements Employees.VetWork
    private String specialization;

    public Veterinarian(String name, String jobTitle, int yearsOfExperience, String specialization) {
        super(name, jobTitle, yearsOfExperience);
        this.specialization = specialization;
        super.setEmployeeRole(EmployeeRole.VETERINARIAN);

    }
/*
    public void checkHealth(Dinosaurs.Dinosaur d) {
        d.isHealthy();
        //System.out.println(d.getName() + " is healthy: " + d.isHealthy());
    }

    public void giveMedicine(Dinosaurs.Dinosaur d) {
        d.getHealthy();
        System.out.println(this.getName() + " healed " + d.getName());
        d.isHealthy();
        //System.out.println(d.getName() + " is now healthy " + d.isHealthy());
    }

 */

    @Override
    public String toString() {
        return super.toString() + ", Employees.Veterinarian{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}
