package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Velociraptor;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 11/11/2017.
 */

public class TestVelociraptor {

    Velociraptor blue;
    Food pig;

    @Before
    public void before() {
        blue = new Velociraptor("Blue", 4);
        pig = new Food();
        for (int i=0; i < 4; i++) {
            blue.eat(pig);
        }
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
        assertEquals("Blue is not hungry...", blue.eat(pig));
        assertEquals(5, blue.getBelly().size());
    }

    @Test
    public void canCauseDamage() {
        assertEquals(200, blue.causeDamage());
        assertEquals(0, blue.getBelly().size());
    }

}
