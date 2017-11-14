package com.example.chad.jurassicpark.DinosaurSpecies.Carnivores;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;
import com.example.chad.jurassicpark.DinosaurSpeciesEnums.Species;

/**
 * Created by chad on 10/11/2017.
 */

public class Velociraptor extends Carnivore {

    public Velociraptor(String name, int age) {
        super(name, Species.VELOCIRAPTOR, age);
    }
}
