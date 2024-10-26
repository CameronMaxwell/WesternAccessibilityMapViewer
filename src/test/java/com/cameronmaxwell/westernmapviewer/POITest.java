/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.cameronmaxwell.westernmapviewer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the POI class
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */
public class POITest {

    /**
     * Test of toString method, of class POI
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        // create an example instance of the POI class to use for testing
        POI instance = new POI("Middlesex College", "Floor 1", true, "Men's bathroom on floor 1 of Middlesex College", 100, 200, 100, "Men's Bathroom", "MC100", "Bathrooms", true);
        // define the expected result for the method
        String expResult = "POI Name: MC100\n" +
                "Building Name: Middlesex College\n" +
                "Map Name: Floor 1\n" +
                "Room Name: Men's Bathroom\n" +
                "Room Number: 100\n" +
                "X Position on Map: 100\n" +
                "Y Position on Map: 200\n" +
                "Short Description: Men's bathroom on floor 1 of Middlesex College\n" +
                "Favourite: true\n" +
                "Layers: Bathrooms\n" +
                "Is Built-In: true\n";
        // compare the desired result and the result produced
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}