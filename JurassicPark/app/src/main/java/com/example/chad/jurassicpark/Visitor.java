package com.example.chad.jurassicpark;

import java.util.HashMap;

/**
 * Created by chad on 10/11/2017.
 */

public class Visitor {

    String name;
    int age;
    HashMap<String, Integer> wallet;
    ParkLocation location;

    public Visitor(String name, int age, int card, int cash) {
        this.name = name;
        this.age = age;
        this.wallet = new HashMap<>();
        this.wallet.put("card", card);
        this.wallet.put("cash", cash);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public HashMap<String, Integer> getWallet() {
        return wallet;
    }

    public ParkLocation getLocation() {
        return location;
    }

    public void setLocation(ParkLocation location) {
        this.location = location;
        location.
    }
}
