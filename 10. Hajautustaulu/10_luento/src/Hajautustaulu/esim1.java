package Hajautustaulu;

import java.util.HashMap;

public class esim1 {
    public static void main(String[] args) {

        //esimerkki 1a
        HashMap<String, String> postinumerot = new HashMap<>();
        postinumerot.put("00710", "Helsinki");
        postinumerot.put("90014", "Oulu");
        postinumerot.put("21290", "Rusko");
        postinumerot.put("33720", "Tampere");
        postinumerot.put("33014", "Tampere");

        System.out.println(postinumerot.get("00710"));
        System.out.println(postinumerot.get("20100"));
        System.out.println(postinumerot.get("33014"));

        //esimerkki 1b
        HashMap<String, String> dinot = new HashMap<>();
        dinot.put("Marjukka", "T-Rex");
        dinot.put("Kaarlo", "Kentrosaurus");
        dinot.put("Olavi", "Oviraptor");

        System.out.println(dinot);
        System.out.println(dinot.get("Marjukka"));
        dinot.put("Marjukka", "Stegosaurus"); // ylikirjoittaa
        System.out.println(dinot.get("Marjukka"));
    }
}
