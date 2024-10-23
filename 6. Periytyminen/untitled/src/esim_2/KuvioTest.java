package esim_2;

public class KuvioTest {
    public static void main(String[] args) {
        Ympyra ympyra = new Ympyra(10, 20, "Ympyrä", 10);

        System.out.println(ympyra);
        System.out.println(ympyra.ala());

        Suorakulmio suorakulmio = new Suorakulmio(1,2,"SK",5,10);
        System.out.println(suorakulmio);
        System.out.println(suorakulmio.ala());

        Kolmio kolmio = new Kolmio(4,4,"Kolmio",3,5);
        System.out.println(kolmio);
        System.out.println(kolmio.ala());
    }
}
