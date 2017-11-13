package com.example.chad.jurassicpark.People;

import com.example.chad.jurassicpark.Locations.ParkLocation;

/**
 * Created by chad on 13/11/2017.
 */

public class Human {

    private String name;
    protected ParkLocation location;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ParkLocation getLocation() {
        return location;
    }

}
