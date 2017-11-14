package com.example.chad.jurassicpark.DinosaurSpeciesEnums;

/**
 * Created by chad on 11/11/2017.
 */

public enum Species {
    VELOCIRAPTOR(50),
    TYRANOSAURUS_REX(120),
    SPINOSAURUS(80),
    INDOMINOUS_REX(140),
    ALLOSAURUS(70),

    STEGOSAURUS(70),
    DIPLODOCUS(50),
    TRICERATOPS(70),
    PARASAUROLOPHUS(40),
    ANKYLOSAURUS(50),

    MOSASAURUS(200),
    PLESIOSAUR(120),
    PLIOSAURUS(100),

    PTERODACTYL(10),
    ARCHAEOPTERYX(20),
    QUETZALCOATLUS(30);

    private int strength;

    Species(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }
}
