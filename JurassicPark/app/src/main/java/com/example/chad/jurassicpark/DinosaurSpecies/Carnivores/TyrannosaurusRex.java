package com.example.chad.jurassicpark.DinosaurSpecies.Carnivores;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;

/**
 * Created by chad on 12/11/2017.
 */

public class TyrannosaurusRex extends Carnivore {
    public TyrannosaurusRex(String name, int age) {
        super(name, Species.TYRANOSAURUS_REX, age);
    }
}
