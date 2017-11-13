package com.example.chad.jurassicpark.DinosaurSpecies.Carnivores;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;

/**
 * Created by chad on 13/11/2017.
 */

public class Allosaurus extends Carnivore {
    public Allosaurus(String name, int age) {
        super(name, Species.ALLOSAURUS, age);
    }
}
