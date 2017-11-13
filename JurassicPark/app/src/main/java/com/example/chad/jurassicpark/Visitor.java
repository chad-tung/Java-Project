package com.example.chad.jurassicpark;

import java.util.HashMap;

/**
 * Created by chad on 10/11/2017.
 */

public class Visitor {

    private String name;
    private ParkLocation location;

    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ParkLocation getLocation() {
        return location;
    }


    public void changeLocation(ParkLocation newLocation) {
        if (this.location != null) {
            this.location.removeVisitor(this);
        }
        this.location = newLocation;
        newLocation.addVisitor(this);
    }



}
