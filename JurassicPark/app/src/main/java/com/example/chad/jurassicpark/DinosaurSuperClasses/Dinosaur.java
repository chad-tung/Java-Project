package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.Locations.DinoDwelling;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.Food;

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
    protected DinoDwelling location;


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

    public String rampage() {
        if (belly.isEmpty()) {
            return name + " tried to rampage, but had no energy and slept instead.";
        } else {
            this.location.sustainDamage(causeDamage());
            return name + " got riled up and started a rampage! " + location.getName() + " has sustained damage!";
        }
    }



}
