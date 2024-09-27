import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Unilelu> lelut = new ArrayList<>();

        Unilelu lelu1 = new Unilelu("Pupu", "pupu", 1);
        lelut.add(lelu1);
        Unilelu lelu2 = new Unilelu("Pupu");
        lelut.add(lelu2);
        Unilelu lelu3 = new Unilelu("Pupu", "pupu");
        lelut.add(lelu3);
        Unilelu lelu4 = new Unilelu("Topi", "nalle");
        lelut.add(lelu4);


        /*
         //Tässä kutsutaan staattisia metodeja.
        Unilelu lelu2 = Unilelu.nimi("Pupunen");
        lelut.add(lelut2);
        Unilelu lelu3 = Unilelu.tyyppi("nalle");
        lelut.add(lelut3);
         */


        // Tulostetaan lelut
        for(Unilelu lelu : lelut) {
            System.out.println(lelu);
        }

    }
}