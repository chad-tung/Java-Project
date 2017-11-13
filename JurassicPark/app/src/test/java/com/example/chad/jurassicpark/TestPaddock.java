package com.example.chad.jurassicpark;

import com.example.chad.jurassicpark.DinosaurSpecies.Aerials.Pterodactyl;
import com.example.chad.jurassicpark.DinosaurSpecies.Aquatics.Mosasaurus;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Diplodocus;
import com.example.chad.jurassicpark.DinosaurSpecies.Herbivores.Triceratops;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.TyrannosaurusRex;
import com.example.chad.jurassicpark.DinosaurSpecies.Carnivores.Velociraptor;
import com.example.chad.jurassicpark.Locations.Habitats.Paddock;
import com.example.chad.jurassicpark.People.Staff;
import com.example.chad.jurassicpark.People.Visitor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by chad on 12/11/2017.
 */

public class TestPaddock {

    Paddock paddock9;
    Paddock paddock1;
    Paddock paddock2;
    Paddock brokenPaddock;

    Triceratops toppy;
    TyrannosaurusRex rexy;
    TyrannosaurusRex spyRex;
    Velociraptor blue;
    Diplodocus dippy;

    Pterodactyl ptery;
    Mosasaurus mosa;

    Food food;

    Visitor visitor1;
    Visitor spyVisitor;
    Staff staff1;
    Staff spyStaff;

    @Before
    public void before() {
        toppy = new Triceratops("Toppy", 4);
        rexy = new TyrannosaurusRex("Rexy", 11);
        blue = new Velociraptor("Blue", 3);
        dippy = new Diplodocus("Dippy", 15);
        paddock9 = new Paddock("Paddock 9", 5000, rexy);
        paddock1 = new Paddock("Paddock 1", 5000, dippy);
        paddock2 = new Paddock("Paddock 2", 5000);
        food = new Food();

        mosa = new Mosasaurus("Mosa", 4);
        ptery = new Pterodactyl("Ptery", 3);

        visitor1 = new Visitor("Chad");
        staff1 = new Staff("John");

        spyVisitor = new Visitor("Lewis");
        spyStaff = new Staff("Dennis");

        spyRex = Mockito.spy(new TyrannosaurusRex("FakeRex", 10));
        brokenPaddock = new Paddock("Broken paddock", 0);
        brokenPaddock.introduceDinosaur(spyRex);
        brokenPaddock.addVisitor(visitor1);
        brokenPaddock.addStaff(staff1);
    }

    @Test
    public void canCheckVisitors() {
        assertEquals(0, paddock9.getVisitorList().size());
    }

    @Test
    public void canGetLocation() {
        assertEquals(paddock9, rexy.getLocation());
        assertEquals(null, blue.getLocation());
    }

    @Test
    public void canCheckForCarnivores() {
        assertTrue(paddock9.hasCarnivore());
        assertFalse(paddock1.hasCarnivore());
    }

    @Test
    public void canAdd() {
        assertEquals(0, paddock2.getDinosaurList().size());
        paddock2.introduceDinosaur(toppy);
        assertEquals(1, paddock2.getDinosaurList().size());
    }

    @Test
    public void canRejectWrongDinosaurs() {
        assertEquals("Ian Malcolm: Sorry, you cannot add this dinosaur to that paddock. You will upset the balance - chaos theory stuff.", paddock2.introduceDinosaur(ptery));
        assertEquals("Ian Malcolm: Sorry, you cannot add this dinosaur to that paddock. You will upset the balance - chaos theory stuff.", paddock2.introduceDinosaur(mosa));

    }

    @Test
    public void canGetAddMessage() {
        assertEquals("Toppy has been added to Paddock 2", paddock2.introduceDinosaur(toppy));
        assertEquals("Ian Malcolm: Sorry, you cannot add this dinosaur to that paddock. You will upset the balance - chaos theory stuff.", paddock9.introduceDinosaur(blue));
        assertEquals(1, paddock9.getDinosaurList().size());
    }

    @Test
    public void canSustainDamage() {
        for (int i=0; 10 > i; i++) {
            rexy.eat(food);
        }
        assertEquals("Rexy got riled up and started a rampage! Paddock 9 has sustained damage!", rexy.rampage());
        assertEquals(0, rexy.getBelly().size());
        assertEquals(3800, paddock9.getStructuralIntegrity());
    }

//    Should probably be done in the raptor test.
    @Test
    public void canCheckCompromised() {
        assertTrue(brokenPaddock.isCompromised());
        assertFalse(paddock1.isCompromised());
    }

    @Test
    public void humanCanBeHunted() {
        assertEquals(0, spyRex.getBelly().size());
        Mockito.when(spyRex.randomHumanGroup()).thenReturn(1);
        assertEquals("Broken paddock's structural integrity is compromised, FakeRex has killed a human!", spyRex.rampage());
        assertEquals(0, brokenPaddock.getStaffList().size());
        assertEquals(1, brokenPaddock.getVisitorList().size());
        assertEquals(1, spyRex.getBelly().size());
    }
}
