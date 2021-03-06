package com.example.chad.jurassicpark.Locations.Habitats;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Aerial;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Aquatic;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;
import com.example.chad.jurassicpark.Locations.DinoDwelling;

/**
 * Created by chad on 10/11/2017.
 */

public class Lagoon extends DinoDwelling {

    public Lagoon(String name, Integer structuralIntegrity) {
        super(name, structuralIntegrity);
    }

    public Lagoon(String name, int structuralIntegrity, Dinosaur dino) {
        super(name, structuralIntegrity);
        if (dino instanceof Aquatic) {
            introduceDinosaur(dino);
        }
    }


    public String introduceDinosaur(Dinosaur dino) {
        String message = dino.getName() + " has been added to " + getName();
        if (dino instanceof Aquatic) {
            super.introduceDinosaur(dino);
            return message;
        }
        else {
            return rejectDinosaur(dino);
        }
    }
}

