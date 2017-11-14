package com.example.chad.jurassicpark.DinoTests;

import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Quetzalcoatlus;
import com.example.chad.jurassicpark.Food;
import com.example.chad.jurassicpark.Locations.Habitats.Lagoon;
import com.example.chad.jurassicpark.Locations.Habitats.Paddock;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 14/11/2017.
 */

public class TestQuetzalcoatlus {
    Quetzalcoatlus quetzy;
    Paddock paddock;
    Lagoon lagoon;
    Food food = new Food();

    @Before
    public void before() {
        quetzy = new Quetzalcoatlus("Quetzy", 10);
        paddock = new Paddock("Paddock", 100);
        lagoon = new Lagoon("Lagoon", 100);
    }

    @Test
    public void canEat() {
        assertEquals(0, quetzy.getBelly().size());
        quetzy.eat(food);
        assertEquals(1, quetzy.getBelly().size());
    }

    @Test
    public void canOnlyEat3() {
        for (int i=0; i < 3; i++) {
            quetzy.eat(food);
        }
        assertEquals(3, quetzy.getBelly().size());
        assertEquals("Quetzy is not hungry...", quetzy.eat(food));
        assertEquals(3, quetzy.getBelly().size());
    }

    @Test
    public void hasType() {
        assertEquals("quetzalcoatlus", quetzy.getType());
    }

    @Test
    public void canCauseDamage() {
        quetzy.eat(food);
        assertEquals(30, quetzy.causeDamage());
    }
}
