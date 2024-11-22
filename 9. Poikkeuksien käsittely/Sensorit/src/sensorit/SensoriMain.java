package sensorit;

public class SensoriMain {
    public static void main(String[] args) {

        // Osan 1 testi: Vakiosensori
        Vakiosensori kymppi = new Vakiosensori(10);
        Vakiosensori miinusViis = new Vakiosensori(-5);

        System.out.println(kymppi.mittaa());
        System.out.println(miinusViis.mittaa());

        System.out.println(kymppi.onPaalla());
        kymppi.poisPaalta();
        System.out.println(kymppi.onPaalla());

        // Osan 2 testi: Lämpömittari
        Sensori kumpula = new Lampomittari();
        kumpula.paalle();
        System.out.println("lämpötila Kumpulassa " + kumpula.mittaa() + " astetta");

        // Osan 3 testi: Keskiarvosensori
        Sensori kaisaniemi = new Lampomittari();
        Sensori helsinkiVantaa = new Lampomittari();

        Keskiarvosensori paakaupunki = new Keskiarvosensori();
        paakaupunki.lisaaSensori(kumpula);
        paakaupunki.lisaaSensori(kaisaniemi);
        paakaupunki.lisaaSensori(helsinkiVantaa);

        //kaisaniemi.poisPaalta(); //testataan, toimiiko päällä olon tarkistus
        //System.out.println("Pääkaupunki on päällä " + paakaupunki.onPaalla());

        paakaupunki.paalle();
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");

        // Osan 4 testi: Kaikki mittaukset
        paakaupunki.paalle();
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");

        System.out.println("mittaukset: " + paakaupunki.mittaukset());

        // Poikkeuksenkäsittelyn testaus
        paakaupunki.poisPaalta();
        try {
            paakaupunki.mittaa();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());;
        }

    }

}
