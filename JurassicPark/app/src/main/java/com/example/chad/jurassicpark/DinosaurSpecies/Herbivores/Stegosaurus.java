package com.example.chad.jurassicpark.DinosaurSpecies.Herbivores;

import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;

/**
 * Created by chad on 13/11/2017.
 */

public class Stegosaurus extends Herbivore {
    public Stegosaurus(String name, int age) {
        super(name, Species.STEGOSAURUS, age);
    }
}
