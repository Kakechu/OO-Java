package esim_1;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emplEMP = new Employee(75, "Anne");

        System.out.println(emplEMP);

        Employee emplMan = new Manager(100, "Annukka", "SEPM");
        System.out.println(emplMan);

        Employee emplDir = new Director(200, "Tero", "ICT", 1000.0);
        System.out.println(emplDir);


    }
}
