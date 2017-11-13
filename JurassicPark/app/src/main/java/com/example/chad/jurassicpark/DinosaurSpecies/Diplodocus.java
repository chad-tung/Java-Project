package com.example.chad.jurassicpark.DinosaurSpecies;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;

/**
 * Created by chad on 12/11/2017.
 */

public class Diplodocus extends Herbivore {
    public Diplodocus(String name, int age) {
        super(name, Species.DIPLODOCUS, age);
    }


}
