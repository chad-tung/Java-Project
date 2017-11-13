package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.Locations.ParkLocation;

/**
 * Created by chad on 10/11/2017.
 */

public class Staff extends Human{

    String name;

    public Staff(String name) {
        super(name);
    }

    public void changeLocation(ParkLocation newLocation) {
        if (this.location != null) {
            this.location.removeStaff(this);
        }
        this.location = newLocation;
        newLocation.addStaff(this);
    }

}
