package com.example.chad.jurassicpark.LocationTests;

import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Pterodactyl;
import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Quetzalcoatlus;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Pliosaur;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Spinosaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Triceratops;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
    Triceratops toppy;

    @Before
    public void before() {
        aviary = new Aviary ("Aviary 1", 5000);
        brokenAviary = new Aviary("Broken Aviary", 0);
        spino = new Spinosaurus("Spino", 10);
        pliars = new Pliosaur("Pliars", 14);
        ptery = new Pterodactyl("Ptery", 4);
        quetzy = new Quetzalcoatlus("Quetzy", 5);
        toppy = new Triceratops("Toppy", 8);
    }

    @Test
    public void canRejectCarnivore() {
        assertEquals("Spino is not compatible with this ecosystem.", aviary.introduceDinosaur(spino));
        assertEquals(null, spino.getLocation());
        assertEquals(0, aviary.getDinosaurList().size());
    }

    @Test
    public void canRejectAquatic() {
        assertEquals("Pliars is not compatible with this ecosystem.", aviary.introduceDinosaur(pliars));
        assertEquals(null, pliars.getLocation());
        assertEquals(0, aviary.getDinosaurList().size());
    }

    @Test
    public void canRejectHerbivore() {
        assertEquals("Toppy is not compatible with this ecosystem.", aviary.introduceDinosaur(toppy));
        assertEquals(null, toppy.getLocation());
        assertEquals(0, aviary.getDinosaurList().size());
    }

    @Test
    public void canAddAerials() {
        assertEquals("Ptery has been added to Aviary 1", aviary.introduceDinosaur(ptery));
        assertEquals(1, aviary.getDinosaurList().size());
        assertEquals(aviary, ptery.getLocation());
    }
}
