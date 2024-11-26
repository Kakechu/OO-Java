package Employees;

import Dinosaurs.Dinosaur;

public class CareTaker extends Employee implements Care {
    private String specialization;

    public CareTaker(String name, String jobTitle, int yearsOfExperience, String specialization) {
        super(name, jobTitle, yearsOfExperience);
        this.specialization = specialization;
        super.setEmployeeRole(EmployeeRole.CARETAKER);
    }
    @Override
    public void feedDino(Dinosaur d) {
        System.out.println("Dinosaurs.Dinosaur " + d + " is fed.");
    }

    @Override
    public void petDino(Dinosaur d) {
        System.out.println("Dinosaurs.Dinosaur " + " is purring.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Employees.CareTaker{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}
