package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.Locations.Habitats.Paddock;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by chad on 14/11/2017.
 */

public class TestPark {

    JurassicPark park;
    @Before
    public void before() {
        park = new JurassicPark();
    }

    @Test
    public void checkSafety() {
        assertEquals(true, park.parkIsSafe());
    }

    @Test
    public void checkDinosaurList() {
        assertEquals(16, park.getDinosaurs().size());
    }

    @Test
    public void canAddPaddock() {
        assertEquals(11, park.getZones().size());
        park.addPaddock("testPaddock");
        assertEquals(12, park.getZones().size());
        assertEquals("testPaddock", park.getZones().get(11).getName());
    }

    @Test
    public void canAddAviary() {
        park.addAviary("testAviary");
        assertEquals(12, park.getZones().size());
        assertEquals("testAviary", park.getZones().get(11).getName());
    }

    @Test public void canAddLagoon() {
        park.addLagoon("testLagoon");
        assertEquals(12, park.getZones().size());
        assertEquals("testLagoon", park.getZones().get(11).getName());
    }


//    THIS WORKS! But I really don't want to type out everything, as I'm going to make it so it returns ALL location data.
//    @Test public void canGetPaddockNames() {
//
//        String expected = "Paddock 1, structural integrity of 5000, 1 visitors, 0 staff and 1 dinosaurs.\n" +
//                "Paddock 2, structural integrity of 5000, 1 visitors, 0 staff and 1 dinosaurs.\n" +
//                "Paddock 3, structural integrity of 5000, 0 visitors, 0 staff and 2 dinosaurs.\n" +
//                "Paddock 4, structural integrity of 5000, 0 visitors, 0 staff and 1 dinosaurs.\n" +
//                "Paddock 5, structural integrity of 140, 0 visitors, 0 staff and 0 dinosaurs.\n" +
//                "Paddock 9, structural integrity of 5000, 0 visitors, 0 staff and 1 dinosaurs.\n";
//
//        assertEquals(expected, park.getPaddockDetails());
//    }

}
