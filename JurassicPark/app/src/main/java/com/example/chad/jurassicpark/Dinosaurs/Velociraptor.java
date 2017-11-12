package com.example.chad.jurassicpark.Dinosaurs;

import com.example.chad.jurassicpark.Dinosaur;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Carnivoreable;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;

/**
 * Created by chad on 10/11/2017.
 */

public class Velociraptor extends Dinosaur implements Carnivoreable {

    public Velociraptor(String name, int age) {
        super(name, Species.VELOCIRAPTOR, age);
    }
}
