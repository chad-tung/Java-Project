package com.example.chad.jurassicpark.Locations.Habitats;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Carnivore;
import com.example.chad.jurassicpark.Locations.DinoDwelling;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;

import java.util.ArrayList;

/**
 * Created by chad on 10/11/2017.
 */

public class Paddock extends DinoDwelling {

    public Paddock(String name, int structuralIntegrity) {
        super(name, structuralIntegrity);

    }

    public Paddock(String name, int structuralIntegrity, Dinosaur dino) {
        super(name, structuralIntegrity);
        if (dino instanceof Herbivore || dino instanceof Carnivore) {
            introduceDinosaur(dino);
        }
    }

//Could probably be made cleaner.

    @Override
    public String introduceDinosaur(Dinosaur dino) {
        String message = dino.getName() + " has been added to " + getName();
        if ((dino instanceof Herbivore) || (dino instanceof Carnivore)) {
            if (getDinosaurList().isEmpty()) {
                super.introduceDinosaur(dino);
                dino.setLocation(this);
                return message;
            }
            if (dino instanceof Herbivore) {
                if (!hasCarnivore()) {
                    super.introduceDinosaur(dino);
                    dino.setLocation(this);
                    return message;
                }
            }
            if (dino instanceof Carnivore) {
                Dinosaur inhabitant = getDinosaurList().get(0);
                if (dino.getType() == inhabitant.getType()) {
                    super.introduceDinosaur(dino);
                    dino.setLocation(this);
                    return message;
                }
            }
        }
        return "Ian Malcolm: Sorry, you cannot add this dinosaur to that paddock. You will upset the balance - chaos theory stuff.";
    }

    public Boolean hasCarnivore() {
        int counter = 0;
        for (Dinosaur dino: getDinosaurList()) {
            if (dino instanceof Carnivore) {
                counter++;
            }
        }
        return counter > 0;
    }


}
