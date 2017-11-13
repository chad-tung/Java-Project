package com.example.chad.jurassicpark;

import java.util.ArrayList;

/**
 * Created by chad on 13/11/2017.
 */

public abstract class ParkLocation {
    private String name;
    private ArrayList<Visitor> visitorList;
    private ArrayList<Staff> staffList;

    public ParkLocation(String name, ArrayList<Visitor> visitorList, ArrayList<Staff> staffList) {
        this.name = name;
        this.visitorList = visitorList;
        this.staffList = staffList;
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
}
