package com.example.chad.jurassicpark.Locations;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.People.Staff;
import com.example.chad.jurassicpark.People.Visitor;

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

//    getters
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

//    setter
    public void setStructuralIntegrity(int structuralIntegrity) {
        this.structuralIntegrity = structuralIntegrity;
    }

//    adding and removing people/dinosaurs
    public void addVisitor(Visitor visitor) {
        visitorList.add(visitor);
        visitor.setLocation(this);
    }

    public void removeVisitor(Visitor visitor) {
        visitorList.remove(visitor);
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
        staff.setLocation(this);
    }

    public void removeStaff(Staff staff) {
        staffList.remove(staff);
    }

    public String introduceDinosaur(Dinosaur dino) {
        if (dino.getLocation() != null) {
            dino.getLocation().removeDinosaur(dino);
        }
        dinosaurList.add(dino);
        dino.setLocation(this);
        return "Dino has been added";
    }

    public void removeDinosaur(Dinosaur dino) {
        dinosaurList.remove(dino);
    }


//    would be nice if the park had funds and would run repairs...

    public void repairDamage() {
        this.structuralIntegrity += staffList.size() * 10;
    }

    public void sustainDamage(int damage) {
        this.structuralIntegrity -= damage;
        if (getStructuralIntegrity() < 0) {
            setStructuralIntegrity(0);
        }
    }

    public boolean isCompromised() {
        return structuralIntegrity <= 0;
    }

    public void clearDinosaurs() {
        for (Dinosaur dino: getDinosaurList()) {
            dino.setLocation(null);
        }
        this.getDinosaurList().clear();
    }
}
