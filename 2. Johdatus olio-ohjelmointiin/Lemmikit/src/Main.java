public class Main {
    public static void main(String[] args) {

        Lemmikit doge = new Lemmikit("koira", "Rölli", 6, "vuh");
        Lemmikit kisu = new Lemmikit("kissa", "Miu", 3, "mau");
        Lemmikit kaarme = new Lemmikit("käärme", "Python", 3, "sssss");

        doge.tulostaLemmikki();
        kisu.tulostaLemmikki();
        kaarme.tulostaLemmikki();

        System.out.println("Rölli sanoo " + doge.aantele());
    }
}

/*
        Aannahtelyt ilahtunut = new Aannahtelyt("Jeee!");
        Aannahtelyt pelastynyt = new Aannahtelyt("Iiiik!");

        ilahtunut.aantele();
        pelastynyt.aantele();


 */