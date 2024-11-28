package Events;

import Dinosaurs.*;
import Park.*;

import java.util.ArrayList;

public class SwimmingShow extends Event {
    ArrayList<Dinosaur> dinosToTransform;
    ArrayList<AquaticDinosaur> performers;

    public SwimmingShow(Park park, String name, int availableTickets) {
        super(park, name, availableTickets);
        performers = new ArrayList<>();
        dinosToTransform = park.getDinosaurManager().getDinosaursByType("water");
        for (Dinosaur d : dinosToTransform) {
            performers.add((AquaticDinosaur) d);
        }
    }

    @Override
    public void performEvent() {
        if (performers.isEmpty()) {
            System.out.println("No swimming dinosaurs available for the flying show.");
            return;
        }

        for (AquaticDinosaur dino : performers) {
            if (dino.canSwim()) {
                System.out.println(dino.getName() + " is swimming!");
            } else {
                System.out.println(dino.getName() + " can't swim, let's teach them!");
            }
        }
    }

}
