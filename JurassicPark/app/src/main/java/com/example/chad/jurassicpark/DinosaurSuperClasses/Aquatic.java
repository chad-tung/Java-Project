package com.example.chad.jurassicpark.DinosaurSuperClasses;

import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.DinosaurInterfacesEnums.Species;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * Created by chad on 12/11/2017.
 */

public class Aquatic extends Dinosaur {
    public Aquatic(String name, Species type, int age) {
        super(name, type, age);
    }

    @Override
    public String rampage() {
        if (location.isCompromised()) {
            setLocation(null);
            return getName() + " the " + getType() + " escaped " + location.getName() + "!";
        }
        else {
            return super.rampage();
        }
    }
}
