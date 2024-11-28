package Events;

import Dinosaurs.*;
import Park.*;
import Vehicles.*;


import java.util.ArrayList;

public class FlyingShow extends Event {
    ArrayList<Dinosaur> dinosToTransform;
    ArrayList<FlyingDinosaur> performers;

    public FlyingShow(Park park, String name, int availableTickets) {
        super(park, name, availableTickets);
        performers = new ArrayList<>();
        dinosToTransform = park.getDinosaurManager().getDinosaursByType("flying");
        for (Dinosaur d : dinosToTransform) {
            performers.add((FlyingDinosaur) d);
        }
    }

    @Override
    public void performEvent() {
        if (performers.isEmpty()) {
            System.out.println("No flying dinosaurs available for the flying show.");
            return;
        }

        for (FlyingDinosaur dino : performers) {
            if (dino.canFly()) {
                System.out.println(dino.getName() + " is flying in the event!");
            } else {
                System.out.println(dino.getName() + " can't fly, calling helicopter!");
                Helicopter helicopter = new Helicopter();
                helicopter.travel();
            }
        }
    }

}
