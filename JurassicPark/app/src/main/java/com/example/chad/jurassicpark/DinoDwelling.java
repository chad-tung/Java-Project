package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.HumanInterfaces.Ranger;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */


public abstract class DinoDwelling {
    private String name;
    private int structuralIntegrity;
    private ArrayList<VisitorGroup> visitorList;
    private ArrayList<Ranger> rangerList;

    public DinoDwelling(String name, int structuralIntegrity) {
        this.structuralIntegrity = structuralIntegrity;
        this.name = name;
        this.visitorList = visitorList;
        this.rangerList = rangerList;
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<VisitorGroup> getVisitorList() {
        return visitorList;
    }

    public ArrayList<Ranger> getRangerList() {
        return rangerList;
    }
}
