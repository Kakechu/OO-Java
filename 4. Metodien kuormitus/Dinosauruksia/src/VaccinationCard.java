public class VaccinationCard {
    private int lastDinoParvoVaccinationYear;
    private int lastPreventExtinctionVaccinationYear;


    public VaccinationCard(int lastDinoParvoVaccinationYear, int lastPreventExtinctionVaccinationYear) {
        this.lastDinoParvoVaccinationYear = lastDinoParvoVaccinationYear;
        this.lastPreventExtinctionVaccinationYear = lastPreventExtinctionVaccinationYear;
    }

    public int getLastVaccinationYear(String vaccinationName) {
        if (vaccinationName.equals("dinoParvoVaccination")) {
            return lastDinoParvoVaccinationYear;
        } else if (vaccinationName.equals("preventExtinctionVaccination")) {
            return lastPreventExtinctionVaccinationYear;
        }
        return 0; // Oletusarvo jos tuntematon rokotus
    }

    public void setLastVaccinationYear(String vaccinationName, int year) {
        if (vaccinationName.equals("dinoParvoVaccination")) {
            lastDinoParvoVaccinationYear = year;
        } else if (vaccinationName.equals("preventExtinctionVaccination")) {
            lastPreventExtinctionVaccinationYear = year;
        }
    }

}
