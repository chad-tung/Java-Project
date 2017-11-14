package com.example.chad.jurassicpark.DinosaurSpecies.Aquatics;

import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Aquatic;

/**
 * Created by chad on 13/11/2017.
 */

public class Plesiosaur extends Aquatic {
    public Plesiosaur(String name, int age) {
        super(name, Species.PLESIOSAUR, age);
    }
}
