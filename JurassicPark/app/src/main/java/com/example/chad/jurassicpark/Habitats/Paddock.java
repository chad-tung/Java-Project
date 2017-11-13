package com.example.chad.jurassicpark.Habitats;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Aerial;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Aquatic;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;
import com.example.chad.jurassicpark.DinoDwelling;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;

import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */

public class Paddock extends DinoDwelling {

    private ArrayList<Dinosaur> dinosaurResidents;

    public Paddock(String name, int structuralIntegrity) {
        super(name, structuralIntegrity);
        this.dinosaurResidents = new ArrayList<>();

    }

    public Paddock(String name, int structuralIntegrity, Dinosaur dino) {
        super(name, structuralIntegrity);
        this.dinosaurResidents = new ArrayList<>();
        this.dinosaurResidents.add(dino);
        dino.setLocation(this);
    }


    public ArrayList<Dinosaur> getDinosaurResidents() {
        return dinosaurResidents;
    }

//Could probably be made cleaner.
    public String addDinosaur(Dinosaur dino) {
        String message = dino.getName() + " has been added to " + getName();
        if ((dino instanceof Herbivore) || (dino instanceof Carnivore)) {
            if (dinosaurResidents.isEmpty()) {
                dinosaurResidents.add(dino);
                dino.setLocation(this);
                return message;
            }
            if (dino instanceof Herbivore) {
                if (!hasCarnivore()) {
                    dinosaurResidents.add(dino);
                    dino.setLocation(this);
                    return message;
                }
            }
            if (dino instanceof Carnivore) {
                Dinosaur inhabitant = dinosaurResidents.get(0);
                if (dino.getType() == inhabitant.getType()) {
                    dinosaurResidents.add(dino);
                    dino.setLocation(this);
                    return message;
                }
            }
        }
        return "Sorry, you cannot add this dinosaur to that paddock. You will upset the balance, and Ian Malcolm won't be pleased.";

    }

    public Boolean hasCarnivore() {
        int counter = 0;
        for (Dinosaur dino: dinosaurResidents) {
            if (dino instanceof Carnivore) {
                counter++;
            }
        }
        return counter > 0;
    }


}
