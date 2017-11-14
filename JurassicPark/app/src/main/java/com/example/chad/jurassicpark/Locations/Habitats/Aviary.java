package com.example.chad.jurassicpark.Locations.Habitats;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Aerial;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.Locations.DinoDwelling;

/**
 * Created by chad on 10/11/2017.
 */

public class Aviary extends DinoDwelling {
    public Aviary(String name, Integer structuralIntegrity) {
        super(name, structuralIntegrity);
    }

    public Aviary(String name, Integer structuralIntegrity, Dinosaur dino) {
        super(name, structuralIntegrity);
        if (dino instanceof Aerial) {
            introduceDinosaur(dino);
        }
    }

    public String introduceDinosaur(Dinosaur dino) {
        String message = dino.getName() + " has been added to " + getName();
        if (dino instanceof Aerial) {
            super.introduceDinosaur(dino);
            return message;
        }
        else {
            return rejectDinosaur(dino);
        }
    }
}
