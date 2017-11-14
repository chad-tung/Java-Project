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
        String escapeMessage = getName() + " the " + getType() + " escaped " + location.getName() + "!";
        if (location.isCompromised()) {
            escape();
            return escapeMessage;
        }
        else {
            return super.rampage();
        }
    }
}
