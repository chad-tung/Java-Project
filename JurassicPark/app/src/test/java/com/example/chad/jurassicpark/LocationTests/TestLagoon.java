package com.example.chad.jurassicpark.LocationTests;

import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Pterodactyl;
import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Quetzalcoatlus;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Mosasaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Pliosaur;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Spinosaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Triceratops;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;
import com.example.chad.jurassicpark.Locations.Habitats.Lagoon;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 14/11/2017.
 */

public class TestLagoon {

    Lagoon lagoon;
    Pliosaur pliars;
    Mosasaurus mosa;
    Spinosaurus spino;
    Pterodactyl ptery;
    Triceratops toppy;

    Lagoon brokenLagoon;


    @Before
    public void before() {
        lagoon = new Lagoon("Lagoon", 5000);
        brokenLagoon = new Lagoon ("Broken Lagoon", 0);
        pliars = new Pliosaur("Pliars", 14);
        mosa = new Mosasaurus("Mosa", 15);
        spino = new Spinosaurus("Spino", 10);
        ptery = new Pterodactyl("Ptery", 4);
        toppy = new Triceratops("Toppy", 8);
    }

    @Test
    public void canRejectCarnivore() {
        assertEquals("Spino is not compatible with this ecosystem.", lagoon.introduceDinosaur(spino));
        assertEquals(null, spino.getLocation());
        assertEquals(0, lagoon.getDinosaurList().size());
    }

    @Test
    public void canRejectHerbivore() {
        assertEquals("Toppy is not compatible with this ecosystem.", lagoon.introduceDinosaur(toppy));
        assertEquals(null, toppy.getLocation());
        assertEquals(0, lagoon.getDinosaurList().size());
    }

    @Test
    public void canRejectAerial() {
        assertEquals("Ptery is not compatible with this ecosystem.", lagoon.introduceDinosaur(ptery));
        assertEquals(null, ptery.getLocation());
        assertEquals(0, lagoon.getDinosaurList().size());
    }

    @Test
    public void canAddAquatic() {
        lagoon.introduceDinosaur(pliars);
        assertEquals(lagoon, pliars.getLocation());
        assertEquals(pliars, lagoon.getDinosaurList().get(0));
    }

    @Test
    public void canAddDifferentSpecies() {
        lagoon.introduceDinosaur(pliars);
        lagoon.introduceDinosaur(mosa);
        assertEquals(2, lagoon.getDinosaurList().size());
    }

    @Test
    public void dinosaurCanEscape() {
        brokenLagoon.introduceDinosaur(pliars);
        brokenLagoon.introduceDinosaur(mosa);
        assertEquals("Mosa the mosasaurus escaped Broken Lagoon!", mosa.rampage());
        assertEquals(1, brokenLagoon.getDinosaurList().size());
        assertEquals(pliars, brokenLagoon.getDinosaurList().get(0));

    }
}
