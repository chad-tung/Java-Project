package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.DinosaurSpecies.Diplodocus;
import com.example.chad.jurassicpark.DinosaurSpecies.Triceratops;
import com.example.chad.jurassicpark.DinosaurSpecies.TyrannosaurusRex;
import com.example.chad.jurassicpark.DinosaurSpecies.Velociraptor;
import com.example.chad.jurassicpark.Habitats.Paddock;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 12/11/2017.
 */

public class TestPaddock {

    Paddock paddock9;
    Paddock paddock1;
    Paddock paddock2;

    Triceratops toppy;
    TyrannosaurusRex rexy;
    Velociraptor blue;
    Diplodocus dippy;

    @Before
    public void before() {
        toppy = new Triceratops("Toppy", 4);
        rexy = new TyrannosaurusRex("Rexy", 11);
        blue = new Velociraptor("Blue", 3);
        dippy = new Diplodocus("Dippy", 15);
        paddock9 = new Paddock("Paddock 9", 5000, rexy);
        paddock1 = new Paddock("Paddock 1", 5000, dippy);
        paddock2 = new Paddock("Paddock 2", 5000);
    }

    @Test
    public void canGetLocation() {
        assertEquals(paddock9, rexy.getLocation());
        assertEquals(null, blue.getLocation());
    }

    @Test
    public void canCheckForCarnivores() {
        assertTrue(paddock9.hasCarnivore());
        assertFalse(paddock1.hasCarnivore());
    }

    @Test
    public void canAdd() {
        assertEquals(0, paddock2.getDinosaurResidents().size());
        paddock2.addDinosaur(toppy);
        assertEquals(1, paddock2.getDinosaurResidents().size());
    }

    @Test
    public void canGetAddMessage() {
        assertEquals("Toppy has been added to Paddock 2", paddock2.addDinosaur(toppy));
        assertEquals("Sorry, you cannot add this dinosaur to that paddock. You will upset the balance, and Ian Malcolm won't be pleased.", paddock9.addDinosaur(blue));
        assertEquals(1, paddock9.getDinosaurResidents().size());
    }

}
