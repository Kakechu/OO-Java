package Dinosaurs;

import java.util.Scanner;
import java.time.Year;

public class Health {
    Scanner scanner = new Scanner(System.in);

    public Health() {
    }

    Vaccination dinoParvoVaccination = new Vaccination("dinoParvoVaccination", 1);
    Vaccination preventExtinctionVaccination = new Vaccination("preventExtinctionVaccination", 5);

    class Vaccination {
        private String name;
        private int interval;

        public Vaccination(String name, int interval) {
            this.name = name;
            this.interval = interval;
        }

        public int getInterval() {
            return interval;
        }

        public String getName() {
            return name;
        }

        public void vaccinate(Dinosaur d) {
            int currentYear = Year.now().getValue();

            handleVaccination(d, dinoParvoVaccination, currentYear);
            handleVaccination(d, preventExtinctionVaccination, currentYear);
/*
            int lastParvoVacYear = d.getVaccinationCard().getLastVaccinationYear("dinoParvoVaccination");
            handleVaccination(d, dinoParvoVaccination, lastParvoVacYear, currentYear);

            int lastExtinctionVacYear = d.getVaccinationCard().getLastVaccinationYear("preventExtinctionVaccination");
            handleVaccination(d, preventExtinctionVaccination, lastExtinctionVacYear, currentYear);

 */
        }

        private void handleVaccination(Dinosaur d, Vaccination vaccination, int currentYear) {
            String vaccinationName = vaccination.getName();
            int lastVaccinationYear = d.getVaccinationCard().getLastVaccinationYear(vaccination.getName());
            int yearsSinceLastVaccination = currentYear - lastVaccinationYear;

            if (yearsSinceLastVaccination >= vaccination.getInterval()) {
                System.out.println("\n" + d.getName() + " needs the " + vaccination.getName() + " vaccination.");
                System.out.println("Last vaccination was in " + lastVaccinationYear + " (" + yearsSinceLastVaccination + " years ago).");
                d.getVaccinationCard().setLastVaccinationYear(vaccination.getName(), currentYear);
                System.out.println("Ouchie! Dino vaccinated.");// Päivitetään rokotuksen vuosi

                int nextVaccination = lastVaccinationYear + vaccination.getInterval();
                System.out.println("Next vaccination should be in " + nextVaccination + " (" + vaccination.getInterval() + " years interval).");
            } else {
                System.out.println("\n" + d.getName() + " does not need the " + vaccination.getName() + " vaccination.");
                System.out.println("Last vaccination was in " + lastVaccinationYear + " (" + yearsSinceLastVaccination + " years ago).");
                System.out.println("Next vaccination should be in " + (lastVaccinationYear + vaccination.getInterval()) + ".");
            }

        }

    }

}
