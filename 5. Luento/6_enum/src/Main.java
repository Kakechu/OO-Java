public class Main {
    public static void main(String[] args) {

        // a) valueOf()
        // palauttaa merkkijonoa vastaavan enum-arvon, pikemminkin tyyppi
        // https://medium.com/@ali.habibian04/the-secrets-of-enum-in-java-86316d8252ca
        Month m1;
        m1 = Month.valueOf("JAN");
        System.out.println(m1);

        // b) values()
        // palauttaa taulukon, joka sisältää kaikki enum-arvot järjestyksessä
        System.out.println("Months and days");
        for (Month m : Month.values()) {
            System.out.println(m.getName() + ", " + m.getDays() + " days");
        }

        // c) ordinal()
        // palauttaa järjestysnumeron
        System.out.println(Month.APR.ordinal());
        System.out.println(Month.SEP.ordinal());

        // d) name()
        // kutsutaan arvon perusteella, palauttaa nimen
        String nimi = Month.OCT.name();
        System.out.println(nimi);

    }
}