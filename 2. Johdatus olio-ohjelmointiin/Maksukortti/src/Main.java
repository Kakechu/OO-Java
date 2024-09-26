public class Main {
    public static void main(String[] args) {

        //Tehtävä 9
        Maksukortti kakenKortti = new Maksukortti("Kake", 10);
        System.out.println(kakenKortti);

        kakenKortti.syoEdullisesti();
        System.out.println(kakenKortti);

        kakenKortti.syoMaukkaasti();
        System.out.println(kakenKortti);

        kakenKortti.syoMaukkaasti();
        kakenKortti.syoEdullisesti();

        //Tehtävä 10
        Maksukortti liisanKortti = new Maksukortti("Liisa", 20);
        Maksukortti nuutinKortti = new Maksukortti("Nuutti", 50);

        liisanKortti.syoMaukkaasti();
        nuutinKortti.syoEdullisesti();
        System.out.println(liisanKortti);
        System.out.println(nuutinKortti);
        liisanKortti.lataaRahaa(10);
        nuutinKortti.syoMaukkaasti();
        System.out.println("Liisan saldo: " + liisanKortti.getSaldo());
        System.out.println("Nuutin saldo: " + nuutinKortti.getSaldo());
        liisanKortti.syoMaukkaasti();
        liisanKortti.syoMaukkaasti();
        nuutinKortti.lataaRahaa(50);
        System.out.println("Liisan saldo: " + liisanKortti.getSaldo());
        System.out.println("Nuutin saldo: " + nuutinKortti.getSaldo());
        liisanKortti.syoMaukkaasti();
        liisanKortti.syoEdullisesti();
        nuutinKortti.syoEdullisesti();
        System.out.println("Liisan saldo: " + liisanKortti.getSaldo());
        System.out.println("Nuutin saldo: " + nuutinKortti.getSaldo());
        nuutinKortti.lataaRahaa(-50);
        liisanKortti.lataaRahaa(10);
        System.out.println("Liisan saldo: " + liisanKortti.getSaldo());
        System.out.println("Nuutin saldo: " + nuutinKortti.getSaldo());
    }
}