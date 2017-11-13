package com.example.chad.jurassicpark;

import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */


public abstract class DinoDwelling extends ParkLocation {
    private String name;
    private int structuralIntegrity;
    private ArrayList<Visitor> visitorList;
    private ArrayList<Staff> staffList;

    public DinoDwelling(String name, int structuralIntegrity) {
        this.structuralIntegrity = structuralIntegrity;
        this.name = name;
        this.visitorList = new ArrayList<>();
        this.staffList = new ArrayList<>();
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public void sustainDamage(int damage) {
        this.structuralIntegrity -= damage;
    }
}
