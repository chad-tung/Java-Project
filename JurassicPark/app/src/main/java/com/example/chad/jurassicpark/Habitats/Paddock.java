package com.example.chad.jurassicpark.Habitats;

import com.example.chad.jurassicpark.Aerial;
import com.example.chad.jurassicpark.Aquatic;
import com.example.chad.jurassicpark.Carnivore;
import com.example.chad.jurassicpark.DinoDwelling;
import com.example.chad.jurassicpark.Dinosaur;
import com.example.chad.jurassicpark.Herbivore;

import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */

public class Paddock extends DinoDwelling {

    private ArrayList<Dinosaur> dinosaurResidents;

//    Want a constructor class for paddocks for herbivores
    public Paddock(String name, int structuralIntegrity) {
        super(name, structuralIntegrity);
        this.dinosaurResidents = new ArrayList<>();
    }

    public Paddock(String name, int structuralIntegrity, Dinosaur dino) {
        super(name, structuralIntegrity);
        this.dinosaurResidents = new ArrayList<>();
        this.dinosaurResidents.add(dino);
        dino.setLocation(this);
    }


    public void addDinosaur(Dinosaur dino) {
        if (!(dino instanceof Aerial) && !(dino instanceof Aquatic)) {
            if (dinosaurResidents.size() == 0) {
                dinosaurResidents.add(dino);
                dino.setLocation(this);
            }
            if (dino instanceof Herbivore) {
                if (!hasCarnivore()) {
                    dinosaurResidents.add(dino);
                    dino.setLocation(this);
                }
            }
            if (dino instanceof Carnivore) {
                Dinosaur inhabitant = dinosaurResidents.get(0);
                if (dino.getType() == inhabitant.getType()) {
                    dinosaurResidents.add(dino);
                    dino.setLocation(this);
                }
            }
        }
    }

    public Boolean hasCarnivore() {
        int counter = 0;
        for (Dinosaur dino: dinosaurResidents) {
            if (dino instanceof Carnivore) {
                counter++;
            }
        }
        return counter > 0;
    }
}
