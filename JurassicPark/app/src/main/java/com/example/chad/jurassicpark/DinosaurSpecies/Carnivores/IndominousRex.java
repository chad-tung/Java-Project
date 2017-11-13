package com.example.chad.jurassicpark.DinosaurSpecies.Carnivores;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;

/**
 * Created by chad on 13/11/2017.
 */

public class IndominousRex extends Carnivore {
    public IndominousRex(String name, int age) {
        super(name, Species.INDOMINOUS_REX, age);
    }
}
