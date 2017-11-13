package com.example.chad.jurassicpark.Locations;

import com.example.chad.jurassicpark.ParkLocation;

/**
 * Created by chad on 13/11/2017.
 */

public class SafetyBunker extends ParkLocation {

    private int structuralIntegrity;

    public SafetyBunker() {
        super("Safety Bunker");
        this.structuralIntegrity = 10000;
    }
}
