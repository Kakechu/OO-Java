import java.util.Scanner;

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
            int currentYear;
            while (true) {
                try {
                    System.out.println("Give the current year: ");
                    currentYear = Integer.parseInt(scanner.nextLine());
                    break; // Poistutaan silmukasta, jos syöte on kelvollinen
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid year.");
                }
            }

            int lastParvoVacYear = d.getVaccinationCard().getLastVaccinationYear("dinoParvoVaccination");
            handleVaccination(d, dinoParvoVaccination, lastParvoVacYear, currentYear);
            int lastExtinctionVacYear = d.getVaccinationCard().getLastVaccinationYear("preventExtinctionVaccination");
            handleVaccination(d, preventExtinctionVaccination, lastExtinctionVacYear, currentYear);
        }

        private void handleVaccination(Dinosaur d, Vaccination vaccination, int lastVaccinationYear, int currentYear) {
            String vaccinationName = vaccination.getName();

            if (currentYear - vaccination.getInterval() >= lastVaccinationYear) {
                System.out.println("Dino needs " + vaccination.getName() + " vaccination.");
                System.out.println("Dino was last vaccinated in " + lastVaccinationYear);
                d.getVaccinationCard().setLastVaccinationYear(vaccinationName, currentYear);
                int nextVaccination = lastVaccinationYear + vaccination.getInterval();
                System.out.println("Next vaccination in " + nextVaccination);
            } else {
                System.out.println("Dino does not need the " + vaccination.getName() + " vaccination.");
                System.out.println("Dino was last vaccinated in " + lastVaccinationYear);
            }

        }

    }

}
