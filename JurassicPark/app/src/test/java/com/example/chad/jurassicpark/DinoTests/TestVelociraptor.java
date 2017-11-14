package com.example.chad.jurassicpark.DinoTests;

import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Velociraptor;
import com.example.chad.jurassicpark.Food;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;
import com.example.chad.jurassicpark.Locations.Habitats.Lagoon;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 11/11/2017.
 */

public class TestVelociraptor {

    Velociraptor blue;
    Food pig;
    Aviary aviary;
    Lagoon lagoon;

    @Before
    public void before() {
        blue = new Velociraptor("Blue", 4);
        pig = new Food();
        for (int i=0; i < 4; i++) {
            blue.eat(pig);
        }
        aviary = new Aviary("Aviary 1", 5000);
        lagoon = new Lagoon("Lagoon 1", 5000);
    }

    @Test
    public void hasName() {
        assertEquals("Blue", blue.getName());
    }

    @Test
    public void canGetType() {
        assertEquals("velociraptor", blue.getType());
    }

    @Test
    public void canGetAge() {
        assertEquals(4, blue.getAge());
    }

    @Test
    public void canEat() {
        assertEquals(4, blue.getBelly().size());
        assertEquals("Blue ate the food.", blue.eat(pig));
        assertEquals(5, blue.getBelly().size());
    }

    @Test
    public void canOnlyEat5() {
        blue.eat(pig);
        assertEquals("Blue is not hungry...", blue.eat(pig));
        assertEquals(5, blue.getBelly().size());
    }

    @Test
    public void canCauseDamage() {
        assertEquals(200, blue.causeDamage());
        assertEquals(0, blue.getBelly().size());
    }

    @Test
    public void cannotEnterAviary() {
        assertEquals("Blue is not compatible with this ecosystem.", aviary.introduceDinosaur(blue));
        assertEquals(0, aviary.getDinosaurList().size());
    }

    @Test
    public void cannotEnterLagoon() {
        assertEquals("Blue is not compatible with this ecosystem.", lagoon.introduceDinosaur(blue));
        assertEquals(0, lagoon.getDinosaurList().size());
    }

}
