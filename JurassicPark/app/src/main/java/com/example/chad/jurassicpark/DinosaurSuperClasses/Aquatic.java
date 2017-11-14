package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;

/**
 * Created by chad on 12/11/2017.
 */

public class Aquatic extends Dinosaur {
    public Aquatic(String name, Species type, int age) {
        super(name, type, age);
    }

    @Override
    public String rampage() {
        if (location.isCompromised()) {
            escape();
            return getName() + " the " + getType() + " escaped " + location.getName() + "!";
        }
        else {
            return super.rampage();
        }
    }

    public void escape() {
        location.removeDinosaur(this);
        setLocation(null);
    }
}
