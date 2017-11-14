package com.example.chad.jurassicpark.DinoTests;

import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.TyrannosaurusRex;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Diplodocus;
import com.example.chad.jurassicpark.Food;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;
import com.example.chad.jurassicpark.Locations.Habitats.Lagoon;
import com.example.chad.jurassicpark.Locations.Habitats.Paddock;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 14/11/2017.
 */

public class TestDiplodocus {

    Diplodocus dippy;
    Paddock paddock;
    TyrannosaurusRex trex = new TyrannosaurusRex("TREX", 10);
    Food food = new Food();
    Paddock paddock9;
    Paddock paddock2;
    Aviary aviary;
    Lagoon lagoon;

    @Before
    public void before() {
        dippy = new Diplodocus("Dippy", 27);
        dippy.eat(food);
        paddock = new Paddock("Dippy's Dwelling", 3000);
        paddock2 = new Paddock("Dippy's new Dwelling", 4000);
        paddock9 = new Paddock("Paddock 9", 5000, trex);
        aviary = new Aviary("Aviary", 1000);
        lagoon = new Lagoon("Lagoon", 2000);
    }

    @Test
    public void cannotEnterAviary() {
        assertEquals("Dippy is not compatible with this ecosystem.", aviary.introduceDinosaur(dippy));
        assertEquals(null, dippy.getLocation());
        assertEquals(0, aviary.getDinosaurList().size());
    }

    @Test
    public void cannotEnterLagoon() {
        assertEquals("Dippy is not compatible with this ecosystem.", lagoon.introduceDinosaur(dippy));
        assertEquals(null, dippy.getLocation());
        assertEquals(0, lagoon.getDinosaurList().size());
    }

    @Test
    public void canCauseDamage() {
        assertEquals(50, dippy.causeDamage());
        assertEquals(0, dippy.getBelly().size());
        assertEquals(0, dippy.causeDamage());
    }

    @Test
    public void canIntroduceToPaddock() {
        paddock.introduceDinosaur(dippy);
        assertEquals(paddock, dippy.getLocation());
        assertEquals(dippy, paddock.getDinosaurList().get(0));
    }

    @Test
    public void canTransfer() {

    }
}
