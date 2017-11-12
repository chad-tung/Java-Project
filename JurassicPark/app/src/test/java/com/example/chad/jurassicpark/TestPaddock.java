package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.Dinosaurs.Diplodocus;
import com.example.chad.jurassicpark.Dinosaurs.Triceratops;
import com.example.chad.jurassicpark.Dinosaurs.TyrannosaurusRex;
import com.example.chad.jurassicpark.Dinosaurs.Velociraptor;
import com.example.chad.jurassicpark.Habitats.Paddock;

import org.junit.Before;
import org.junit.Test;

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
        paddock2 = new Paddock("Paddock 2", 5000, toppy);
    }

    @Test
    public void canGetLocation() {
        assertEquals(paddock9, rexy.getLocation());
        assertEquals(null, blue.getLocation());
    }

    @Test
    public void can

}
