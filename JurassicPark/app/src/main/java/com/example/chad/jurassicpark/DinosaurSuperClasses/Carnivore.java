package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;

/**
 * Created by chad on 12/11/2017.
 */

public class Carnivore extends Dinosaur {
    public Carnivore(String name, Species type, int age) {
        super(name, type, age);
    }
}