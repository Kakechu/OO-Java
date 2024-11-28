package Events;

import Dinosaurs.*;
import Park.*;

import java.util.ArrayList;

public class DanceShow extends Event {
    ArrayList<Dinosaur> dinosToTransform;
    ArrayList<LandDinosaur> performers;

    public DanceShow(Park park, String name, int availableTickets) {
        super(park, name, availableTickets);
        performers = new ArrayList<>();
        dinosToTransform = park.getDinosaurManager().getDinosaursByType("land");
        for (Dinosaur d : dinosToTransform) {
            performers.add((LandDinosaur) d);
        }
    }

    @Override
    public void performEvent() {
        if (performers.isEmpty()) {
            System.out.println("No dancing dinosaurs available for the flying show.");
            return;
        }
        for (LandDinosaur dino : performers) {
            if (dino.canDance()) {
                System.out.println(dino.getName() + " is dancing! Wohoo!");
            } else {
                System.out.println(dino.getName() + " can't dance, let's teach them!");
            }
        }
    }

}
