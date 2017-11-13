package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.Food;
import com.example.chad.jurassicpark.People.Staff;
import com.example.chad.jurassicpark.People.Visitor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chad on 12/11/2017.
 */

public class Carnivore extends Dinosaur {
    public Carnivore(String name, Species type, int age) {
        super(name, type, age);
    }

    public int randomHumanGroup() {
        Random rand = new Random();
        int humanTypes = 2;
        int random = rand.nextInt(humanTypes);
        return random;
    }

    public void randomStaffVictim(ArrayList<Staff> humans) {
        Random rand = new Random();
        int arraySize = humans.size();
        int random = rand.nextInt(arraySize);
        Staff victim = humans.remove(random);
        victim.perish();
    }

    public void randomVisitorVictim(ArrayList<Visitor> humans) {
        Random rand = new Random();
        int arraySize = humans.size();
        int random = rand.nextInt(arraySize);
        Visitor victim = humans.remove(random);
        victim.perish();
    }

    public String huntHumans() {
        ArrayList<Staff> staff = location.getStaffList();
        ArrayList<Visitor> visitors = location.getVisitorList();
        if (randomHumanGroup() == 1) {
            if (staff.isEmpty()) {
                randomVisitorVictim(visitors);
            } else {
                randomStaffVictim(staff);
            }
        }
        else {
            if (visitors.isEmpty()) {
                randomStaffVictim(staff);
            } else {
                randomVisitorVictim(visitors);
            }
        }
        return location.getName() + "'s structural integrity is compromised, " + getName() + " has killed a human!";
    }

    @Override
    public String rampage() {
        if (location.isCompromised()) {
            Food food = new Food();
            eat(food);
            return huntHumans();
        } else {
            return super.rampage();
        }
    }
}
