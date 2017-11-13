package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.Locations.Habitats.Paddock;

/**
 * Created by chad on 12/11/2017.
 */

public class Herbivore extends Dinosaur {
    public Herbivore(String name, Species type, int age) {
        super(name, type, age);
    }

//    Unsure about this... Might be better to implement an interface of 'transferable' instead, as a Herbivore shouldn't really be able to transfer itself...
//    Not sure of any way to do this well, as dinosaurs all technically have the ability to set their own locations...
//    Maybe this tracker isn't such a good way to do things...
//    Maybe the dinosaur tracker could be a class in itself, rather than the dinosaurs keeping track of their own locations.
    public String transfer(Paddock habitat) {
        if (!habitat.hasCarnivore()){
            location.removeDinosaur(this);
            this.setLocation(habitat);
            return getName() + " has been moved to " + habitat.getName() + ".";
        } else {
            return "Carnivore present, moving " + getName() + " there would be heartless!";
        }
    }
}
