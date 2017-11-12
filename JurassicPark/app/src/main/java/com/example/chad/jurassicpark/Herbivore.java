package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.Habitats.Paddock;

/**
 * Created by chad on 12/11/2017.
 */

public class Herbivore extends Dinosaur {
    public Herbivore(String name, Species type, int age) {
        super(name, type, age);
    }

    public String transfer(Paddock habitat) {
        if (!habitat.hasCarnivore()){
            this.setLocation(habitat);
            return getName() + " has been moved to " + habitat.getName() + ".";
        } else {
            return "Carnivore present, moving " + getName() + " there would be heartless!";
        }

    }
}
