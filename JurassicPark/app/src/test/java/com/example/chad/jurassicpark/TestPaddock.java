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

    private Paddock paddock9;
    private Paddock paddock1;
    private Paddock paddock2;
    private Paddock brokenPaddock;

    private Triceratops toppy;
    private TyrannosaurusRex rexy;
    private TyrannosaurusRex spyRex;
    private Velociraptor blue;
    private Diplodocus dippy;

    private Pterodactyl ptery;
    private Mosasaurus mosa;

    private Food food;

    private Visitor visitor1;
    private Visitor spyVisitor;
    private Staff staff1;
    private Staff spyStaff;

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

        paddock9.addVisitor(visitor1);
        paddock9.addStaff(staff1);

        spyRex = Mockito.spy(new TyrannosaurusRex("FakeRex", 10));
        brokenPaddock = new Paddock("Broken paddock", 0);
        brokenPaddock.introduceDinosaur(spyRex);
        brokenPaddock.addVisitor(spyVisitor);
        brokenPaddock.addStaff(spyStaff);
    }

    @Test
    public void canCheckHumans() {
        assertEquals(1, paddock9.getVisitorList().size());
        assertEquals(1, paddock9.getStaffList().size());
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
    public void canAddDinosaurs() {
        assertEquals(0, paddock2.getDinosaurList().size());
        paddock2.introduceDinosaur(toppy);
        assertEquals(1, paddock2.getDinosaurList().size());
    }

    @Test
    public void canRejectWrongDinosaurs() {
        assertEquals("Ptery is not compatible in this ecosystem.", paddock2.introduceDinosaur(ptery));
        assertEquals("Mosa is not compatible in this ecosystem.", paddock2.introduceDinosaur(mosa));

    }

    @Test
    public void canGetAddMessage() {
        assertEquals("Toppy has been added to Paddock 2", paddock2.introduceDinosaur(toppy));
        assertEquals("Ian Malcolm: Sorry, you cannot add that dinosaur to this paddock. You will upset the balance - chaos theory stuff.", paddock9.introduceDinosaur(blue));
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

    @Test
    public void canRepairDamage() {
        for (int i=0; 10 > i; i++) {
            rexy.eat(food);
        }
        rexy.rampage();
        paddock9.repairDamage();
        assertEquals(3810, paddock9.getStructuralIntegrity());
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
        spyRex.rampage();
        assertEquals(2, spyRex.getBelly().size());
        assertEquals(0, brokenPaddock.getVisitorList().size());
    }

    @Test
    public void humanPerishes() {
        assertEquals(brokenPaddock, spyStaff.getLocation());
        assertEquals(brokenPaddock, spyVisitor.getLocation());
        spyRex.rampage();
        spyRex.rampage();
        assertEquals(null, spyStaff.getLocation());
        assertEquals(null, spyVisitor.getLocation());
    }
}
