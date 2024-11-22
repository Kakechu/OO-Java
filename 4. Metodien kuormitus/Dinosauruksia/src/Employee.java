public class Employee {

    private String name;
    private String jobTitle;
    private int yearsOfExperience;
    private EmployeeRole employeeRole;

    public Employee(String name, String jobTitle, int yearsOfExperience) {
        if (name == null || name.length() > 40) {
            throw new IllegalArgumentException("Name cannot be null and must be 40 characters or less.");
        }

        this.name = name;
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // sama viite
        if (obj == null || this.getClass() != obj.getClass()) return false; // eri luokka tai null

        Employee e = (Employee) obj; // tyyppimuunnos
        return this.name.equalsIgnoreCase(e.getName()) &&
                this.jobTitle.equalsIgnoreCase(e.getJobTitle()) &&
                this.yearsOfExperience == e.getYearsOfExperience();
    }

    // Näitä ei virallisessa versiossa
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
