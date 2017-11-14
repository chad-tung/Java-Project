package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;
import com.example.chad.jurassicpark.Locations.ParkLocation;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chad on 12/11/2017.
 */

public class Aerial extends Dinosaur {
    public Aerial(String name, Species type, int age) {
        super(name, type, age);
    }



    @Override
    public String rampage() {
        ParkLocation dwelling = location;
        if (location.isCompromised()) {
            location.clearDinosaurs();
            return dwelling.getName() + "'s structural integrity has been compromised, all the dinosaurs have escaped!";
        }
        else {
            return super.rampage();
        }
    }
}
