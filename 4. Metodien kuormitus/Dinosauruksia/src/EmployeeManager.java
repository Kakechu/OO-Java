import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeManager {
    public static Scanner scanner = new Scanner(System.in);
    private ArrayList<Employee> employees;
    private ArrayList<Employee> veterinarians = new ArrayList<>();

    private int numberOfEmployees = 0;

    /**
     * Constructor
     */
    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    /**
     *
     * @return number of employees
     */
    public int getNumberOfEmployees() {
        return numberOfEmployees;
        //return this.employees.size();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Reads employees from file
     * @throws FileNotFoundException
     */

    public void readEmployeesFromFile() throws FileNotFoundException {
        Scanner FScanner = new Scanner(new File("employees.txt"));
        //System.out.println("The program starts reading the information of all employees.");
        while(FScanner.hasNext()) {
            String name = FScanner.nextLine();
            String jobTitle = FScanner.nextLine();
            int yearsOfExperience = FScanner.nextInt();
            FScanner.nextLine();
            employees.add(new Employee(name, jobTitle, yearsOfExperience));
        }
        //System.out.println("The information of all employees is read.");
        FScanner.close();
        this.numberOfEmployees = employees.size();
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
        this.numberOfEmployees++;

        if (e.getEmployeeRole() == EmployeeRole.VETERINARIAN) {
            this.veterinarians.add(e);
            System.out.println("Eläinlääkäri lisätty");
        }
    }

    // Työntekijän poistaminen nimen perusteella
    public void removeEmployee(String name) {
        Employee e = findEmployee(name);
        if (e!= null) {
            if (confirmRemoval(e)) {
                this.employees.remove(e);
                this.numberOfEmployees--;
                System.out.println("Removed " + e.getName());
            } else {
                System.out.println("Cancelling removal.");
            }
        } else {
            System.out.println("The employee doesn't exist and cannot be removed.");
        }
    }
    // Työntekijän poisto indeksin perusteella
    public void removeEmployee(int index) {
        if (this.getNumberOfEmployees() > index && index >= 0) { //tarkistetaan, ettei indeksi mene yli tai alle listan koon
            Employee e = this.employees.get(index);
            if (e != null) {
                if (confirmRemoval(e)) {
                    this.employees.remove(index);
                    this.numberOfEmployees--;
                    System.out.println("Removed " + e.getName());
                } else {
                    System.out.println("Cancelling removal.");
                }
            } else {
                System.out.println("The employee doesn't exist and cannot be removed.");
            }
        } else {
            System.out.println("Invalid index."); //Tarkista tarvitaanko!!!
        }
    }

    // Olisiko järkevää tehdä poisto olion perusteella ja hyödyntää find-metodia?

    public void updateEmployee(Employee e) {
        if (!(e == null)) {
            System.out.println("You want to update the employee " + e);
            System.out.println("What would you like to update?");
            System.out.println("j(ob title) - y(ears of experience) - c(ancel)");
            String answer = scanner.nextLine();

            switch (answer.charAt(0)) {
                case 'j':
                    System.out.println("Give a new job title: ");
                    String title = scanner.nextLine();
                    e.setJobTitle(title);
                    System.out.println("The employee's job title is now " + e.getJobTitle());
                    break;
                case 'y':
                    System.out.println("Give years of experience: ");
                    int years = scanner.nextInt();
                    scanner.nextLine();
                    e.setYearsOfExperience(years);
                    System.out.println("The employee now has " + e.getYearsOfExperience() + " years of experience.");
                    break;
                case 'c':
                    break;
            }

        } else {
            System.out.println("The employee doesn't exist.");
        }
    }


    // Apumetodit

    // Apumetodi työntekijän löytämiseen
    public Employee findEmployee(String name) {
        for (Employee e : this.employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    // Apumetodi vahvistusta varten
    public boolean confirmRemoval(Employee e) {
        System.out.println("Are you sure you want to remove " + e.getName() + "? Type Y/N: ");
        String answer = scanner.nextLine().toUpperCase();
        return answer.equals("Y");
    }

    // Apumetodi, tarkista tarvitaanko
    public boolean isManager(String name) {

        for (Employee e : this.employees) {
            try {
                if (e.getName().equalsIgnoreCase(name) && e.getEmployeeRole().equals(EmployeeRole.MANAGER)) {
                    return true;
                }
            } catch (NullPointerException ex) {
                System.out.println("Error: no role determined for this employee.");
            }
        }
        return false;
    }



    /*
        public boolean isManager(String name) {

        for (Employee e : this.employees) {
            try {
                if (e.getName().equalsIgnoreCase(name) && e.getEmployeeRole().equals(EmployeeRole.MANAGER)) {
                    return true;
                }
            } catch (NullPointerException ex) {
                System.out.println("Error: no role determined for this employee.");
            }
        }

        return false;
    }

        public ArrayList<Employee> removeEmployee(Employee o) { //ei tarvita objektin perusteella?
        // Etsi ensin se olio, joka halutaan poistaa
        //minimimäärän tarkistus
        //System.out.println("Anna poistettavan tyÃ¶ntekijÃ¤n nimi: ");
        //String name = scanner.nextLine();
        if (this.employees.contains(o)) {
            System.out.println("Are you sure you want to remove " + o.getName());
            String s = scanner.nextLine();
            if (s.equals("yes")) {
                this.employees.remove(o);
                this.numberOfEmployees--;
            } else {
                System.out.println("No removing.");
            }
        } else {
            System.out.println("The employee doesn't exist.");
        }
        return this.employees;
    }

     */
}
