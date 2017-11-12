package com.example.chad.jurassicpark.Dinosaurs;

import com.example.chad.jurassicpark.Carnivore;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;

/**
 * Created by chad on 10/11/2017.
 */

public class Velociraptor extends Carnivore {

    public Velociraptor(String name, int age) {
        super(name, Species.VELOCIRAPTOR, age);
    }
}
