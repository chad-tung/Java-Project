package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */

public abstract class Dinosaur {
    private String name;
    private int age;
    private Enum type;
    private int strength;
    private ArrayList<Food> belly;
    private DinoDwelling location;


    public Dinosaur(String name, Species type, int age) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.strength = type.getStrength();
        this.belly = new ArrayList<>();
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public DinoDwelling getLocation() {
        return location;
    }

    public void setLocation(DinoDwelling place) {
        this.location = place;
    }

    public int getAge() {
        return age;
    }

    public int causeDamage() {
        int energy = belly.size();
        belly.clear();
        return this.strength * energy;
    }

    public ArrayList<Food> getBelly() {
        return belly;
    }

    public String getType() {
        String species = type.toString().toLowerCase();
        return species;
    }

    public String eat(Food food) {
        if (belly.size() < strength/10){
            belly.add(food);
            return name + " ate the food.";
        } else {
            return name + " is not hungry...";
        }
    }

}
