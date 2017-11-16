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
        String rejectionMessage = "Ian Malcolm: Sorry, you cannot add that dinosaur to this paddock. You will upset the balance - chaos theory stuff.";
        if (dino instanceof Herbivore) {
            if (!hasCarnivore() || getDinosaurList().isEmpty()) {
                super.introduceDinosaur(dino);
                return message;
            }
            else {
                return rejectionMessage;
            }
        }

        if (dino instanceof Carnivore) {
            if (getDinosaurList().isEmpty()) {
                super.introduceDinosaur(dino);
                return message;
            }
            Dinosaur inhabitant = getDinosaurList().get(0);
            if (dino.getType().equals(inhabitant.getType())) {
                super.introduceDinosaur(dino);
                return message;
            }
            else {
                return rejectionMessage;
            }
        }
        return rejectDinosaur(dino);
    }

//    @Override
//    public String introduceDinosaur(Dinosaur dino) {
//        String message = dino.getName() + " has been added to " + getName();
//        String rejectionMessage = "Ian Malcolm: Sorry, you cannot add that dinosaur to this paddock. You will upset the balance - chaos theory stuff.";
//        if ((dino instanceof Herbivore) || (dino instanceof Carnivore)) {
//
//            if (getDinosaurList().isEmpty()) {
//                super.introduceDinosaur(dino);
//                dino.setLocation(this);
//                return message;
//            }
//
//            if (dino instanceof Herbivore && !hasCarnivore()) {
//                super.introduceDinosaur(dino);
//                dino.setLocation(this);
//                return message;
//            }
//
//            if (dino instanceof Carnivore) {
//                Dinosaur inhabitant = getDinosaurList().get(0);
//                if (dino.getType().equals(inhabitant.getType())) {
//                    super.introduceDinosaur(dino);
//                    dino.setLocation(this);
//                    return message;
//                }
//                else {
//                    return rejectionMessage;
//                }
//            }
//        }
//        return rejectDinosaur(dino);
//    }

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
