package com.example.chad.jurassicpark.DinoTests;

import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Mosasaurus;
import com.example.chad.jurassicpark.Food;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;
import com.example.chad.jurassicpark.Locations.Habitats.Paddock;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 13/11/2017.
 */

public class TestMosasaurus {
    Mosasaurus mosasaurus;
    Paddock paddock;
    Aviary aviary;
    Food food = new Food();


    @Before
    public void before() {
        mosasaurus = new Mosasaurus("Mosa", 40);
        paddock = new Paddock("paddock", 1000);
        aviary = new Aviary("aviary", 1000);
    }

    @Test
    public void cannotEnterPaddock() {
        assertEquals("Mosa is not compatible in this ecosystem.", paddock.introduceDinosaur(mosasaurus));
        assertEquals(0, paddock.getDinosaurList().size());
    }

    @Test
    public void cannotEnterAviary() {
        assertEquals("Mosa is not compatible in this ecosystem.", aviary.introduceDinosaur(mosasaurus));
        assertEquals(0, aviary.getDinosaurList().size());
    }

    @Test
    public void canEat() {
        mosasaurus.eat(food);
        assertEquals(1, mosasaurus.getBelly().size());
    }

    @Test
    public void canOnlyEat20() {
        for (int i=0; 20 > i; i++) {
            mosasaurus.eat(food);
        }
        assertEquals(20, mosasaurus.getBelly().size());
        assertEquals("Mosa is not hungry...", mosasaurus.eat(food));
        assertEquals(20, mosasaurus.getBelly().size());
    }

    @Test
    public void canCauseDamage() {
        mosasaurus.eat(food);
        assertEquals(200, mosasaurus.causeDamage());
        assertEquals(0, mosasaurus.getBelly().size());
    }



}
