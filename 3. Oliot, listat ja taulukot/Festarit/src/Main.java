public class Main {
    public static void main(String[] args) {

        Esiintyja esiintyja1 = new Esiintyja("Danny", "Iskelmä");
        Esiintyja esiintyja2 = new Esiintyja("Elvis", "Rock");
        Tyontekija tyontekija1 = new Tyontekija("Kake", "lipunmyyjä",1);

        Festarit pappafest = new Festarit("14:00", "19:00", "Kuopio");


        pappafest.lisaaEsiintyja(esiintyja1);
        pappafest.lisaaEsiintyja(esiintyja2);
        System.out.println(tyontekija1);
        pappafest.lisaaTyontekija(tyontekija1);

        System.out.println(pappafest);
        pappafest.tulostaEsiintyjat();
        pappafest.tulostaTyontekijat();


    }
}