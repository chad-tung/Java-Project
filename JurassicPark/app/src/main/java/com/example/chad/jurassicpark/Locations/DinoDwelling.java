package com.example.chad.jurassicpark.Locations;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;

/**
 * Created by chad on 10/11/2017.
 */


public abstract class DinoDwelling extends ParkLocation {
    private String name;
    private int structuralIntegrity;


    public DinoDwelling(String name, int structuralIntegrity) {
        super(name);
        setStructuralIntegrity(structuralIntegrity);
        this.structuralIntegrity = getStructuralIntegrity();
    }

    public String rejectDinosaur(Dinosaur dino) {
        return dino.getName() + " is not compatible in this ecosystem.";
    }

}
