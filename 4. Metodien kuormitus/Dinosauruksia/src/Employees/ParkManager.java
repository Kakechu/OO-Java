package Employees;

public class ParkManager extends Employee {
    private double bonus;

    public ParkManager(String name, String jobTitle, int yearsOfExperience, double bonus) {
        super(name, jobTitle, yearsOfExperience);
        this.bonus = bonus;
        super.setEmployeeRole(EmployeeRole.MANAGER);
    }

    @Override
    public String toString() {
        return super.toString() + ", Employees.ParkManager{" +
                "bonus=" + bonus +
                '}';
    }
}
