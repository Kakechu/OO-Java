package esim_1;

public class Director extends Manager {

    private double budget;

    public Director(int empId, String name, String deptName, double budget) {
        super(empId, name, deptName);
        this.budget = budget;
    }

    @Override
    public String toString() {
        return super.toString() + ", Budget: " + budget ;
    }
}
