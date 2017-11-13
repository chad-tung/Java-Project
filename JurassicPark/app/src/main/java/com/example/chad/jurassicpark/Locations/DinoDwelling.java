package com.example.chad.jurassicpark.Locations;

import com.example.chad.jurassicpark.ParkLocation;

import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */


public abstract class DinoDwelling extends ParkLocation {
    private String name;
    private int structuralIntegrity;


    public DinoDwelling(String name, int structuralIntegrity) {
        super(name);
        this.structuralIntegrity = structuralIntegrity;
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public void sustainDamage(int damage) {
        this.structuralIntegrity -= damage;
    }
}
