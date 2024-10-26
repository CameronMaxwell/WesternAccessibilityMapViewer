package com.cameronmaxwell.westernmapviewer;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Building class.
 * 
 * @author Cameron Maxwell
 */
public class BuildingTest {
    
    /**
     * Test of addFloor method and getFloors method, of class Building.
     */
    @Test
    public void testAddFloor() {
        System.out.println("addFloor");
        // create new floor and building objects
        Map newFloor = new Map("Test Building", 0, 0);
        Building instance = new Building("Test Building");
        // add new floor to the building object
        instance.addFloor(newFloor);
        // compare the new floor object with the object at the first index of the array list returned from the getFloors method
        assertEquals(newFloor, instance.getFloors().get(0));
    }
    
    /**
     * Test of getName method, of class Building.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        // create a new building object
        Building instance = new Building("Test Building");
        // set expected result
        String expResult = "Test Building";
        // compare the expected result with the string returned from the getName method
        assertEquals(expResult, instance.getName());
    }
}
