package hajautetaanDinot;

import java.util.ArrayList;
import java.util.HashMap;

public class DinosaurHashMap {
    private HashMap<Integer, Dinosaur> dinosaurData;

    public DinosaurHashMap() {
        this.dinosaurData = new HashMap<>();
    }

    public void addDinosaur(Integer id, Dinosaur dinosaur) {
        if (this.dinosaurData.containsKey(id)) {
            System.out.println("Dinosaurus already exists in hashmap.");
        } else {
            this.dinosaurData.put(id, dinosaur);
        }
    }

    public Dinosaur findDino(Integer id) {
        return this.dinosaurData.get(id);
    }

    public void removeDino(Integer id) {
        if (this.dinosaurData.containsKey(id)) {
            this.dinosaurData.remove(id);
        } else {
            System.out.println("Dinosaur does not exist and cannot be removed.");
        }
    }

    public ArrayList<Dinosaur> searchDinoWithName(String name) {
        ArrayList<Dinosaur> dinosaursList = new ArrayList<>();
        for (Dinosaur dinosaur : this.dinosaurData.values()) {
            if (!dinosaur.getName().contains(name)) {
                continue;
            }
            dinosaursList.add(dinosaur);
        }
        return dinosaursList;
    }
}
