package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.Locations.Habitats.Paddock;
import com.example.chad.jurassicpark.People.Visitor;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by chad on 13/11/2017.
 */

public class TestVisitor {

    private Visitor visitor1;
    private Paddock paddock1;
    private Paddock paddock2;

    @Before
    public void before() {
        visitor1 = new Visitor("Chad");
        paddock1 = new Paddock("Paddock 1", 5000);
        paddock2 = new Paddock("Paddock 2", 5000);
    }


// Don't like this, but going to have to set location first, as changing location causes an error when there hasn't been a location assigned.

    @Test
    public void canSetLocation() {
        assertNull(visitor1.getLocation());
        visitor1.changeLocation(paddock1);
        assertEquals(paddock1, visitor1.getLocation());
        assertEquals(1, paddock1.getVisitorList().size());
    }

    @Test
    public void changeLocationRemovesPrevious() {
        visitor1.changeLocation(paddock1);
        visitor1.changeLocation(paddock2);
        assertEquals(paddock2, visitor1.getLocation());
        assertEquals(0, paddock1.getVisitorList().size());
        assertEquals(1, paddock2.getVisitorList().size());
    }

    @Test
    public void canLeave() {
        visitor1.changeLocation(paddock1);
        visitor1.exitPark();
        assertNull(visitor1.getLocation());
    }
}
