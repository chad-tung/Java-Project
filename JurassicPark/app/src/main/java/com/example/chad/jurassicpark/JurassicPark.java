package com.example.chad.jurassicpark;

import android.location.Location;

import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Archaeopteryx;
import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Pterodactyl;
import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Quetzalcoatlus;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Mosasaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Plesiosaur;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Pliosaur;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.IndominousRex;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Spinosaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.TyrannosaurusRex;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Velociraptor;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Diplodocus;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Stegosaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Triceratops;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.Locations.DinoDwelling;
import com.example.chad.jurassicpark.Locations.Entrance;
import com.example.chad.jurassicpark.Locations.GeneticsLab;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;
import com.example.chad.jurassicpark.Locations.Habitats.Lagoon;
import com.example.chad.jurassicpark.Locations.Habitats.Paddock;
import com.example.chad.jurassicpark.Locations.ParkLocation;
import com.example.chad.jurassicpark.Locations.SafetyBunker;
import com.example.chad.jurassicpark.People.Staff;
import com.example.chad.jurassicpark.People.Visitor;

import java.util.ArrayList;
import java.util.Scanner;

import static android.R.attr.name;
import static android.R.attr.type;
import static android.R.id.input;

/**
 * Created by chad on 12/11/2017.
 */

public class JurassicPark {
//    Areas
    private Entrance entrance;
    private SafetyBunker safetyBunker;
    private GeneticsLab geneticsLab;
    private Paddock paddock1;
    private Paddock paddock2;
    private Paddock paddock3;
    private Paddock paddock4;
    private Paddock paddock5;
    private Paddock paddock9;
    private Aviary aviary;
    private Lagoon lagoon;

//    Dinos
    private Velociraptor blue;
    private Velociraptor charlie;
    private Velociraptor delta;
    private Velociraptor echo;

    private TyrannosaurusRex rexy;
    private IndominousRex indoRexy;
    private Spinosaurus spino;

    private Triceratops toppy;
    private Diplodocus dippy;
    private Stegosaurus stego;

    private Pterodactyl ptery;
    private Quetzalcoatlus quetzy;
    private Archaeopteryx archy;

    private Mosasaurus mosa;
    private Plesiosaur plesy;
    private Pliosaur plio;

    private Staff chris;
    private Staff muldoon;

    private Visitor visitor1;
    private Visitor visitor2;
    private Visitor visitor3;
    private Visitor visitor4;
    private Visitor visitor5;


    private ArrayList<Visitor> visitors;
    private ArrayList<Staff> staff;
    private ArrayList<Food> stock;
    private ArrayList<ParkLocation> zones;

    public JurassicPark() {

        this.zones = new ArrayList<>();
        this.stock = new ArrayList<>();
        for (int i = 0; 40 > i; i++) {
            Food food = new Food();
            stock.add(food);
        }
        this.visitors = new ArrayList<>();
        this.staff = new ArrayList<>();

        setupSeeds();
    }

    private void setupSeeds() {
        visitor1 = new Visitor("Visitor1");
        visitor2 = new Visitor("Visitor2");
        visitor3 = new Visitor("Visitor3");
        visitor4 = new Visitor("Visitor4");
        visitor5 = new Visitor("Visitor5");

        entrance = new Entrance();
        safetyBunker = new SafetyBunker();

        blue = new Velociraptor("Blue", 3);
        charlie = new Velociraptor("Charlie", 3);
        delta = new Velociraptor("Delta", 3);
        echo = new Velociraptor("Echo", 3);
        rexy = new TyrannosaurusRex("Rexy", 15);
        indoRexy = new IndominousRex("Indo-Rexy", 4);
        spino = new Spinosaurus("Spino", 10);
        toppy = new Triceratops("Toppy", 8);
        dippy = new Diplodocus("Dippy", 10);
        stego = new Stegosaurus("Stego", 11);
        ptery = new Pterodactyl("Ptery", 4);
        quetzy = new Quetzalcoatlus("Quetzy", 10);
        archy = new Archaeopteryx("Archy", 7);
        mosa = new Mosasaurus("Mosa", 20);
        plesy = new Plesiosaur("Plesy", 10);
        plio = new Pliosaur("Plio", 14);

        paddock1 = new Paddock("Paddock 1", 5000, blue);
        paddock1.introduceDinosaur(charlie);
        paddock1.introduceDinosaur(delta);
        paddock1.introduceDinosaur(echo);
        paddock1.addVisitor(visitor1);

        paddock2 = new Paddock("Paddock 2", 5000, spino);
        paddock2.addVisitor(visitor2);

        paddock3 = new Paddock("Paddock 3", 5000, toppy);
        paddock3.introduceDinosaur(stego);
        paddock4 = new Paddock("Paddock 4", 5000, dippy);
        paddock5 = new Paddock("Paddock 5", 140);
        paddock9 = new Paddock("Paddock 9", 5000, rexy);
        paddock9.addVisitor(visitor3);
        paddock9.addVisitor(visitor4);

        aviary = new Aviary("Aviary", 2000, ptery);
        aviary.introduceDinosaur(quetzy);
        aviary.introduceDinosaur(archy);
        lagoon = new Lagoon("Lagoon", 5000, mosa);
        lagoon.introduceDinosaur(plesy);
        lagoon.introduceDinosaur(plio);
        geneticsLab = new GeneticsLab();
        geneticsLab.introduceDinosaur(indoRexy);
        geneticsLab.addVisitor(visitor5);


        visitors.add(visitor1);
        visitors.add(visitor2);
        visitors.add(visitor3);
        visitors.add(visitor4);
        visitors.add(visitor5);


        staff.add(chris);
        staff.add(muldoon);



        zones.add(paddock1);
        zones.add(paddock2);
        zones.add(paddock3);
        zones.add(paddock4);
        zones.add(paddock5);
        zones.add(paddock9);
        zones.add(aviary);
        zones.add(lagoon);
        zones.add(entrance);
        zones.add(safetyBunker);
        zones.add(geneticsLab);
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public ArrayList<Food> getStock() {
        return stock;
    }

    public ArrayList<ParkLocation> getZones() {
        return zones;
    }

    public String getPaddockDetails() {
        String details = "";
        for (ParkLocation place: getZones()) {
            if (place instanceof Paddock) {
                details += place.getName() + ", structural integrity of " + place.getStructuralIntegrity() + ", " + place.getVisitorList().size() + " visitors, " + place.getStaffList().size() + " staff and " + place.getDinosaurList().size() + " dinosaurs." + '\n';
            }
        }
        return details;
    }

    public boolean parkIsSafe() {
        int counter = 0;
        for (ParkLocation place: this.zones) {
            if (place instanceof DinoDwelling && place.isCompromised()) {
                counter += 1;
            }
        }
        return counter == 0;
    }

    public void admitVisitor(String name) {
        if (parkIsSafe()) {
            Visitor visitor = new Visitor(name);
            visitor.setLocation(entrance);
        }
    }

    public String addPaddock(String name) {
        Paddock paddock = new Paddock(name, 5000);
        zones.add(paddock);
        return "Paddock " + paddock.getName() + " was added successfully!";
    }

    public void addAviary(String name) {
        Aviary aviary = new Aviary(name, 2000);
        zones.add(aviary);
    }

    public void addLagoon(String name) {
        Lagoon lagoon = new Lagoon(name, 5000);
        zones.add(lagoon);
    }

    public String checkVisitorNumber() {
        return "Currently, there are " + visitors.size() + " visitors in the park.";
    }

    public void generateDinosaur(Scanner input) {
        System.out.println("Right now, you can only generate 4 different dinosaurs." + '\n' + "1. Indominus Rex" + '\n' + "2. Tyrannosaurus Rex" + '\n' + "3. Triceratops" + '\n' + "4. Spinosaurus" + '\n' + "Please type in the number of the dinosaur you wish to create.");
        String number = input.nextLine();

        System.out.println("Okay, what do you wish to call your dinosaur?");

        if (number == "1") {

        }
    }

//    public void giveDinosaurName(Scanner input) {
//
//    }

    public void start() {
        System.out.println("Welcome to your park. Here are your location details.");
        System.out.println(getPaddockDetails());
        selectOptions();
    }

    public void dennisNedry() {
        for (ParkLocation place: getZones()) {
            place.setStructuralIntegrity(0);
            for (Dinosaur dino: place.getDinosaurList()) {
                dino.rampage();
            }
        }
    }

    public void selectOptions() {
        System.out.println("What would you like to do?" + '\n' + "1. Add a paddock" + '\n' + "2. Create a new Indominus Rex" + '\n' + "3. Remove dinosaur from paddock from testing" + '\n' + "4. Pull a Dennis Nedry");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input == 1) {
            Scanner name = new Scanner(System.in);
            String newName = name.nextLine();
            addPaddock(newName);
            System.out.println(getPaddockDetails());
        }
        if (input == 2) {

        }
        if (input == 3) {

        }
        if (input == 4) {

        }



    }
}
