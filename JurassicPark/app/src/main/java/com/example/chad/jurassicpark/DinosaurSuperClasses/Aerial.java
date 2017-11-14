package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;

/**
 * Created by chad on 12/11/2017.
 */

public class Aerial extends Dinosaur {
    public Aerial(String name, Species type, int age) {
        super(name, type, age);
    }

    public void escape() {
        location.removeDinosaur(this);
        setLocation(null);
    }

    @Override
    public String rampage() {
        if (location.isCompromised()) {
            for (Dinosaur dino: location.getDinosaurList()) {
                Aerial bird = (Aerial) dino;
                bird.escape();
            }
            return location.getName() + "'s structural integrity has been compromised, all the dinosaurs have escaped!";
        }
        else {
            return super.rampage();
        }
    }
}
