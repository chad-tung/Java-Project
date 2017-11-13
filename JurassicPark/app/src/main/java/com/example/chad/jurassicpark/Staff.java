package com.example.chad.jurassicpark;

/**
 * Created by chad on 10/11/2017.
 */

public class Staff {

    private String name;
    private ParkLocation location;

    public Staff(String name) {
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
            this.location.removeStaff(this);
        }
        this.location = newLocation;
        newLocation.addStaff(this);
    }

}
