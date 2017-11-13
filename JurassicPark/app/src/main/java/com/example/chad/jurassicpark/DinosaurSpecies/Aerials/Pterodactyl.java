package com.example.chad.jurassicpark.DinosaurSpecies.Aerials;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Aerial;

/**
 * Created by chad on 13/11/2017.
 */

public class Pterodactyl extends Aerial {
    public Pterodactyl(String name, int age) {
        super(name, Species.PTERODACTYL, age);
    }
}
