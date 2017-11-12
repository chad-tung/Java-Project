package com.example.chad.jurassicpark.Habitats;

import com.example.chad.jurassicpark.DinoDwelling;
import com.example.chad.jurassicpark.Dinosaur;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Aquaticable;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Carnivoreable;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Flyable;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Herbivoreable;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */

public class Paddock<T> extends DinoDwelling {

    private ArrayList<Dinosaur> dinosaurResidents;

//    Want a constructor class for paddocks for herbivores
    public Paddock(String name, Integer structuralIntegrity) {
        super(name, structuralIntegrity);
        this.dinosaurResidents = new ArrayList<>();
    }


    public void addDinosaur(Dinosaur dino) {
        if (!(dino instanceof Flyable) && !(dino instanceof Aquaticable)) {
            if (dinosaurResidents.size() == 0) {
                dinosaurResidents.add(dino);
                dino.setLocation(this);
            }
            if (dino instanceof Herbivoreable) {
                Dinosaur inhabitant = dinosaurResidents.get(0);
                if (inhabitant instanceof Herbivoreable) {
                    dinosaurResidents.add(dino);
                    dino.setLocation(this);
                }
            }
            if (dino instanceof Carnivoreable) {
                Dinosaur inhabitant = dinosaurResidents.get(0);
                if (dino.getType() == inhabitant.getType()) {
                    dinosaurResidents.add(dino);
                    dino.setLocation(this);
                }
            }
        }
    }

    public void addDinosaur(Carnivoreable dinosaur) {

    }
}
