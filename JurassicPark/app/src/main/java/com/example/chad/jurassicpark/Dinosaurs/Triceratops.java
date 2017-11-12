package com.example.chad.jurassicpark.Dinosaurs;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.Herbivore;

/**
 * Created by chad on 12/11/2017.
 */

public class Triceratops extends Herbivore {

    public Triceratops(String name, int age) {
        super(name, Species.TRICERATOPS, age);
    }

}
