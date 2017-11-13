package com.example.chad.jurassicpark.Locations;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.Staff;
import com.example.chad.jurassicpark.Visitor;

import java.util.ArrayList;

/**
 * Created by chad on 13/11/2017.
 */

public abstract class ParkLocation {
    private String name;
    private ArrayList<Visitor> visitorList;
    private ArrayList<Staff> staffList;
    private ArrayList<Dinosaur> dinosaurList;
    private int structuralIntegrity;

    public ParkLocation(String name) {
        this.name = name;
        this.visitorList = new ArrayList<>();
        this.staffList = new ArrayList<>();
        this.dinosaurList = new ArrayList<>();
        this.structuralIntegrity = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Visitor> getVisitorList() {
        return visitorList;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public ArrayList<Dinosaur> getDinosaurList() {
        return dinosaurList;
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public void setStructuralIntegrity(int structuralIntegrity) {
        this.structuralIntegrity = structuralIntegrity;
    }

    public void addVisitor(Visitor visitor) {
        visitorList.add(visitor);
    }

    public void removeVisitor(Visitor visitor) {
        visitorList.remove(visitor);
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

    public void sustainDamage(int damage) {
        this.structuralIntegrity -= damage;
        if (getStructuralIntegrity() < 0) {
            setStructuralIntegrity(0);
        }
    }

    public void addDinosaur(Dinosaur dino) {
        dinosaurList.add(dino);
    }
}
