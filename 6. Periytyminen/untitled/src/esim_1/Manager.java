package esim_1;

public class Manager extends Employee { // A manager "IS-A" Employee (relaatio)

    private String deptName; // A manager "HAS-A" department

    public Manager(int empId, String name, String deptName) {
        super(empId, name); // call parent constructor
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Manager{" +
                super.toString() +
                "deptName='" + deptName + '\'' +
                '}';
    }
}
