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
import com.example.chad.jurassicpark.DinosaurSuperClasses.Aerial;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Dinosaur;
import com.example.chad.jurassicpark.DinosaurSuperClasses.Herbivore;
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
import java.util.Random;
import java.util.Scanner;

import static android.R.attr.name;
import static android.R.attr.type;
import static android.R.id.input;
import static android.R.id.message;

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
    private ArrayList<Dinosaur> dinosaurs;

    public JurassicPark() {

        this.zones = new ArrayList<>();
        this.stock = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.dinosaurs = new ArrayList<>();

        setupSeeds();

    }

    private void setupSeeds() {
        zones.clear();
        stock.clear();
        visitors.clear();
        staff.clear();
        dinosaurs.clear();


        for (int i = 0; 400 > i; i++) {
            Food food = new Food();
            stock.add(food);
        }
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

        paddock1 = new Paddock("Paddock 1", 5000);
        paddock1.introduceDinosaur(blue);
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
        lagoon = new Lagoon("Lagoon", 10000, mosa);
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

        for (ParkLocation place: getZones()) {
            for (Dinosaur dino: place.getDinosaurList()) {
                dinosaurs.add(dino);
                for (int i=0; 20 > i; i++) {
                    dino.eat(new Food());
                }
            }
        }
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

    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public String getDinosaurNames() {
        int counter = 1;
        String message = "Here are the list of the dinosaurs: " + '\n';
        for (Dinosaur dino: getDinosaurs()) {
            message += counter + ". " + dino.getName() + ", " + dino.getType() + ", " + dino.getLocation().getName() + '\n';
            counter ++;
        }
        return message;
    }

    public ArrayList<ParkLocation> getZones() {
        return zones;
    }

    public String getParkDetails() {
        String details = "";
        for (ParkLocation place: getZones()) {
            details += place.getName() + ", structural integrity of " + place.getStructuralIntegrity() + ", " + place.getVisitorList().size() + " visitors, " + place.getStaffList().size() + " staff and " + place.getDinosaurList().size() + " dinosaurs." + '\n';
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

    public void createIndominus(String name) {
        IndominousRex dino = new IndominousRex(name, 0);
        geneticsLab.introduceDinosaur(dino);
        dinosaurs.add(dino);
    }

//    public void giveDinosaurName(Scanner input) {
//
//    }

    public void start() {
        rampageEveryTurn();
        feedEveryTurn();
        System.out.println("Welcome to your park. Here are your location details.");
        System.out.println(getParkDetails());
        System.out.println(checkVisitorNumber());

        System.out.println("You have got food supplies of: " + stock.size());
        selectOptions();
    }

    public void dennisNedry() {
        for (ParkLocation place: getZones()) {
            place.setStructuralIntegrity(0);
        }
        ptery.rampage();
        for (Dinosaur dino: getDinosaurs()) {
            if (!(dino instanceof Aerial)) {
                dino.rampage();
            }
        }
    }

    public ArrayList<Herbivore> herbivoreList() {
        ArrayList herbArray = new ArrayList();
        for (Dinosaur dino: getDinosaurs()) {
            if (dino instanceof Herbivore) {
                herbArray.add((Herbivore) dino);
            }
        }
        return herbArray;
    }



    public String getHerbivores() {
        int counter = 1;
        String message = "Here is the list of the herbivores: " + '\n';
        for (Dinosaur dino: herbivoreList()) {
            message += counter + ". " + dino.getName() + ", " + dino.getType() + ", " + dino.getLocation().getName() + '\n';
            counter ++;
        }
        return message;
    }

    public ArrayList<Paddock> paddockList() {
        ArrayList paddockList = new ArrayList();
        for (ParkLocation place: getZones()) {
            if (place instanceof Paddock) {
                paddockList.add(place);
            }
        }
        return paddockList;
    }

    public String getPaddocks() {
        String message = "Here is the list of paddocks:" + '\n';
        int counter = 1;
        for (ParkLocation place: paddockList()) {
            message += counter + ". " + place.getName() + '\n';
            counter ++;
        }
        return message;
    }

    public String moveHerbivore(int dinoIndex, int paddockIndex) {
        return herbivoreList().get(dinoIndex).transfer(paddockList().get(paddockIndex));
    }

    public void randomRampageGenerator() {
        Random rand = new Random();
        int arraySize = getDinosaurs().size();
        int random = rand.nextInt(arraySize);
        getDinosaurs().get(random).rampage();
    }

    public void rampageEveryTurn() {
        for (int i=0; 5 > i; i++) {
            randomRampageGenerator();
        }
    }

    public void feedEveryTurn() {
        for (Dinosaur dino: getDinosaurs()) {
            for (int i=0; 3 > i; i++) {
                dino.eat(new Food());
                stock.remove(0);
            }
        }
    }



    public void selectOptions() {
        System.out.println("What would you like to do?" + '\n' + "1. Add a paddock" + '\n' + "2. Create a new Indominus Rex" + '\n' + "3. Remove dinosaur from habitat for testing" + '\n' + "4. Move a Herbivore" + '\n' + "5. See a list of dinosaurs" + '\n' + "6. Restock food" + '\n' + "7. Pull a Dennis Nedry");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input == 1) {
            System.out.println("Name your paddock:");
            Scanner name = new Scanner(System.in);
            String newName = name.nextLine();
            addPaddock(newName);
            start();
        }
        if (input == 2) {
            System.out.println("Name your new abomination:");
            Scanner name = new Scanner(System.in);
            String newName = name.nextLine();
            createIndominus(newName);
            start();
        }
        if (input == 3) {
            System.out.println(getDinosaurNames());
            Scanner number = new Scanner(System.in);
            int index = number.nextInt() - 1;
            geneticsLab.introduceDinosaur(getDinosaurs().get(index));
            System.out.println("Dinosaur has been transferred.");
            start();
        }
        if (input == 4) {
            System.out.println(getHerbivores());
            Scanner number = new Scanner(System.in);
            int index = number.nextInt() - 1;
            System.out.println(getPaddocks());
            Scanner number2 = new Scanner(System.in);
            int index2 = number2.nextInt() - 1;
            System.out.println(moveHerbivore(index, index2));
            start();
        }
        if (input == 5) {
            System.out.println(getDinosaurNames());
            start();
        }
        if (input == 6) {
            for (int i=0; 300 > i; i++) {
                stock.add(new Food());
            }
        }
        if (input == 7) {
            dennisNedry();
            System.out.println("You switch off all the power to the park, and you get away with dinosaur eggs. This is the state of the park.");
            System.out.println(getParkDetails());
            System.out.println("The movie got it wrong, the programmer always wins!");
            chrisPratt();
        }
    }

    public void chrisPratt() {
        System.out.println("Would you like to call Chris Pratt for help? (y/n)");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input == "y") {
            System.out.println("Chris Pratt talked to the velociraptors - it's all good. They said 'It was just a prank, bro.' Park has been restored to a pristine condition.");
            setupSeeds();
            start();
        }
        else {
            System.out.println("Cue fail recorder Jurassic Park music...");
        }
    }
}
