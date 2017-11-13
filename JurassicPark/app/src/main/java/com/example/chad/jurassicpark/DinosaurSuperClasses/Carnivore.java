package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.Human;
import com.example.chad.jurassicpark.Staff;
import com.example.chad.jurassicpark.Visitor;

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
        humans.remove(random);
    }

    public void randomVisitorVictim(ArrayList<Visitor> humans) {
        Random rand = new Random();
        int arraySize = humans.size();
        int random = rand.nextInt(arraySize);
        humans.remove(random);
    }

    public void huntHumans() {
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
    }

    public String rampage() {
        if (location.getStructuralIntegrity() == 0) {
            huntHumans();
            return location.getName() + "'s structural integrity is compromised, " + getName() + " has killed a human!";
        }
        if (getBelly().isEmpty()) {
            return getName() + " tried to rampage, but had no energy and slept instead.";
        } else {
            this.location.sustainDamage(causeDamage());
            return getName() + " got riled up and started a rampage! " + location.getName() + " has sustained damage!";
        }
    }
}
