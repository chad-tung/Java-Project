package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Pterodactyl;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Mosasaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Velociraptor;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Triceratops;
import com.example.chad.jurassicpark.Locations.Entrance;
import com.example.chad.jurassicpark.Locations.Habitats.Aviary;
import com.example.chad.jurassicpark.Locations.Habitats.Lagoon;
import com.example.chad.jurassicpark.Locations.Habitats.Paddock;
import com.example.chad.jurassicpark.People.Staff;
import com.example.chad.jurassicpark.People.Visitor;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 14/11/2017.
 */

public class TestLocationChanges {
    Velociraptor velociraptor;
    Mosasaurus mosasaurus;
    Triceratops triceratops;
    Pterodactyl pterodactyl;

    Staff staff;
    Visitor visitor;

    Paddock paddock1;
    Paddock paddock2;
    Paddock paddock3;
    Entrance entrance;

    Aviary aviary;
    Lagoon lagoon;

    @Before
    public void before() {
        velociraptor = new Velociraptor("Blue", 3);
        mosasaurus = new Mosasaurus("Mosa", 4);
        triceratops = new Triceratops("Toppy", 5);
        pterodactyl = new Pterodactyl("Ptery", 17);

        paddock1 = new Paddock("Paddock 1", 5000, triceratops);
        paddock2 = new Paddock("Paddock 2", 5000, velociraptor);
        paddock3 = new Paddock("Paddock 3", 5000);
        lagoon = new Lagoon("Lagoon", 0, mosasaurus);
        aviary = new Aviary("Aviary", 0, pterodactyl);
        entrance = new Entrance();


        staff = new Staff("Terry");
        visitor = new Visitor("Chad");

        entrance.addStaff(staff);
        entrance.addVisitor(visitor);
    }

    @Test
    public void checkLocations() {
        assertEquals(paddock1, triceratops.getLocation());
        assertEquals(triceratops, paddock1.getDinosaurList().get(0));

        assertEquals(paddock2, velociraptor.getLocation());
        assertEquals(velociraptor, paddock2.getDinosaurList().get(0));

        assertEquals(aviary, pterodactyl.getLocation());
        assertEquals(pterodactyl, aviary.getDinosaurList().get(0));

        assertEquals(lagoon, mosasaurus.getLocation());
        assertEquals(mosasaurus, lagoon.getDinosaurList().get(0));

        assertEquals(0, entrance.getDinosaurList().size());
        assertEquals(2, entrance.getStaffList().size() + entrance.getVisitorList().size());
    }

    @Test
    public void triceratopsChangeLocation() {
        triceratops.transfer(paddock3);
        assertEquals(triceratops, paddock3.getDinosaurList().get(0));
        assertEquals(paddock3, triceratops.getLocation());
        assertEquals(0, paddock1.getDinosaurList().size());
    }

    @Test
    public void triceratopsStaysInLocation() {
//        Shows that if there's a failed transfer, triceratops stays in the same location
        triceratops.transfer(paddock2);
        assertEquals(triceratops, paddock1.getDinosaurList().get(0));
        assertEquals(1, paddock2.getDinosaurList().size());
        assertEquals(paddock1, triceratops.getLocation());
    }

    @Test
    public void velociraptorChangesLocation() {
        entrance.introduceDinosaur(velociraptor);
        assertEquals(velociraptor, entrance.getDinosaurList().get(0));
        assertEquals(0, paddock2.getDinosaurList().size());
        assertEquals(entrance, velociraptor.getLocation());
    }

    @Test
    public void velociraptopCanKill() {
        entrance.introduceDinosaur(velociraptor);
        velociraptor.rampage();
        assertEquals(1, entrance.getStaffList().size() + entrance.getVisitorList().size());
        assertEquals(1, velociraptor.getBelly().size());
    }

    @Test
    public void dinosaursChangeLocation() {
        entrance.introduceDinosaur(pterodactyl);
        assertEquals(pterodactyl, entrance.getDinosaurList().get(0));
        assertEquals(0, aviary.getDinosaurList().size());
        assertEquals(entrance, pterodactyl.getLocation());
    }

    @Test
    public void aerialAquaticBreakFree() {
        pterodactyl.rampage();
        mosasaurus.rampage();
        assertEquals(0, aviary.getDinosaurList().size());
        assertEquals(0, lagoon.getDinosaurList().size());
        assertEquals(null, pterodactyl.getLocation());
        assertEquals(null, mosasaurus.getLocation());
    }
}
