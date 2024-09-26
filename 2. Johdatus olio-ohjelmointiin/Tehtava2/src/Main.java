public class Main {
    public static void main(String[] args) {
        //Tee ohjelma, joka luo tilin, jonka saldo on 100.0, panee tilille 20.0 ja tulostaa tilin.
        // Sen jälkeen ohjelma ottaa tililtä 15.0 ja tulostaa tilin uudelleen.
        Tili penanTili = new Tili("Pena", "123-123", 100.0);
        penanTili.pano(20.0);
        System.out.println(penanTili);
        penanTili.otto(15.0);
        System.out.println(penanTili.saldo());

        //Tee sen jälkeen Matin tili, jossa on alkusaldo, josta sen jälkeen otetaan rahaa ja sen jälkeen pannaan lisää rahaa.
        // Tulosta tilin saldot sopivissa väleissä ja lopuksi tulosta vielä tilin tiedot.
        Tili matinTili = new Tili("Matti", "987-654", 20);
        System.out.println(matinTili);
        matinTili.otto(5.9);
        System.out.println(matinTili.saldo());
        matinTili.pano(16.9);
        System.out.println(matinTili.saldo());

        Tili kakenTili = new Tili("Kake", "456-456", 500.0);
        System.out.println(kakenTili);
        kakenTili.otto(550);
        System.out.println(kakenTili.saldo());

    }
}