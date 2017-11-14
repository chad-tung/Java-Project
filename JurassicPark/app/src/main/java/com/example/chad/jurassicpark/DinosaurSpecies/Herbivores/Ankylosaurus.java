package com.example.chad.jurassicpark.DinosaurSpecies.Herbivores;

import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;

/**
 * Created by chad on 13/11/2017.
 */

public class Ankylosaurus extends Herbivore {
    public Ankylosaurus(String name, Species type, int age) {
        super(name, Species.ANKYLOSAURUS, age);
    }
}
