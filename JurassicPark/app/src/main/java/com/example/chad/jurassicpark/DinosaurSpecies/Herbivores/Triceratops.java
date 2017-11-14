package com.example.chad.jurassicpark.DinosaurSpecies.Herbivores;

import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;

/**
 * Created by chad on 12/11/2017.
 */

public class Triceratops extends Herbivore {

    public Triceratops(String name, int age) {
        super(name, Species.TRICERATOPS, age);
    }

}
