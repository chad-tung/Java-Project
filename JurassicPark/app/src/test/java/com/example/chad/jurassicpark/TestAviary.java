package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Pterodactyl;
import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Quetzalcoatlus;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Pliosaur;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Spinosaurus;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;

import org.junit.Before;

/**
 * Created by chad on 14/11/2017.
 */

public class TestAviary {
    Aviary aviary;
    Spinosaurus spino;
    Pliosaur pliars;
    Pterodactyl ptery;
    Quetzalcoatlus quetzy;

    Aviary brokenAviary;

    @Before
    public void before() {
        aviary = new Aviary ("Aviary 1", 5000);
        brokenAviary = new Aviary("Broken Aviary", 0);

    }
}
