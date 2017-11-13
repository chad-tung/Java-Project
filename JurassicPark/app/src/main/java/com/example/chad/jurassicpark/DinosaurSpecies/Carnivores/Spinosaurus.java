package com.example.chad.jurassicpark.DinosaurSpecies.Carnivores;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;

/**
 * Created by chad on 13/11/2017.
 */

public class Spinosaurus extends Carnivore {
    public Spinosaurus(String name, int age) {
        super(name, Species.SPINOSAURUS, age);
    }
}
