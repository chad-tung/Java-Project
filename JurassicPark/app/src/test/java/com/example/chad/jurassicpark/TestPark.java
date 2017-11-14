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

}
