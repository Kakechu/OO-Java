public class Main {
    public static void main(String[] args) {

        //Tehtävän 9 testiohjelma:
        /*
        Kassapaate linusJaKisalli = new Kassapaate();

        double vaihtorahaa = linusJaKisalli.syoEdullisesti(10);
        System.out.println("Vaihtorahaa jäi " + vaihtorahaa);

        vaihtorahaa = linusJaKisalli.syoEdullisesti(5);
        System.out.println("Vaihtorahaa jäi " + vaihtorahaa);

        vaihtorahaa = linusJaKisalli.syoMaukkaasti(4.3);
        System.out.println("Vaihtorahaa jäi " + vaihtorahaa);

        System.out.println(linusJaKisalli);
        */

        //Tehtävän 10 testiohjelma 1:
        /*
        Kassapaate linusJaKisalli = new Kassapaate();

        double vaihtorahaa = linusJaKisalli.syoEdullisesti(10);
        System.out.println("vaihtorahaa jäi " + vaihtorahaa);

        Maksukortti annukanKortti = new Maksukortti(7);

        boolean onnistuiko = linusJaKisalli.syoMaukkaasti(annukanKortti);

        System.out.println("riittikö raha: " + onnistuiko);
        onnistuiko = linusJaKisalli.syoMaukkaasti(annukanKortti);
        System.out.println("riittikö raha: " + onnistuiko);
        onnistuiko = linusJaKisalli.syoEdullisesti(annukanKortti);
        System.out.println("riittikö raha: " + onnistuiko);

        System.out.println(linusJaKisalli);
        */

        //Tehtävän 10 testiohjelma 2:

        Kassapaate linusJaKisalli = new Kassapaate();
        System.out.println(linusJaKisalli);

        Maksukortti annukanKortti = new Maksukortti(2);

        System.out.println("kortilla rahaa " + annukanKortti.getSaldo() + " euroa");

        boolean onnistuiko = linusJaKisalli.syoMaukkaasti(annukanKortti);
        System.out.println("riittikö raha: " + onnistuiko);

        linusJaKisalli.lataaRahaaKortille(annukanKortti, 100);

        onnistuiko = linusJaKisalli.syoMaukkaasti(annukanKortti);
        System.out.println("riittikö raha: " + onnistuiko);

        System.out.println("kortilla rahaa " + annukanKortti.getSaldo() + " euroa");

        System.out.println(linusJaKisalli);


    }
}