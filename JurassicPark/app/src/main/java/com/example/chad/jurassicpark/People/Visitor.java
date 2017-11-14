package com.example.chad.jurassicpark.People;

import com.example.chad.jurassicpark.Locations.ParkLocation;

/**
 * Created by chad on 10/11/2017.
 */

public class Visitor extends Human {

    private String name;

    public Visitor(String name) {
        super(name);
    }

    public void changeLocation(ParkLocation newLocation) {
        if (this.location != null) {
            this.location.removeVisitor(this);
        }
        this.location = newLocation;
        newLocation.addVisitor(this);
    }

    public void exitPark() {
        this.location = null;
    }

    @Override
    public String perish() {
        location.removeVisitor(this);
        return super.perish();
    }

}
