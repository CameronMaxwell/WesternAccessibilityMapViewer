package com.cameronmaxwell.westernmapviewer;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Map class.
 * 
 * @author Cameron Maxwell
 */
public class MapTest {

    /**
     * Test of addLayer method and getLayer method, of class Map.
     */
    @Test
    public void testAddLayer() {
        System.out.println("addLayer");
        // create new layer and map objects
        Layer newLayer = new Layer("Test Layer Type", null, null);
        Map instance = new Map("Test Building", 0, 0);
        // add the new layer to the map
        instance.addLayer(newLayer);
        // compare the new layer object with the layer object returned from the getLayers method
        assertEquals(newLayer, instance.getLayers().get(0));
    }

    /**
     * Test of getBuildingName method, of class Map.
     */
    @Test
    public void testGetBuildingName() {
        System.out.println("getBuildingName");
        // create new map object
        Map instance = new Map("Test Building", 0, 0);
        // compare the expected result with the string returned by the getBuildingName method
        String expResult = "Test Building";
        assertEquals(expResult, instance.getBuildingName());
    }

    /**
     * Test of getHeight method, of class Map.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        // create new map object
        Map instance = new Map("Test Building", 1234, 0);
        // compare the expected result with the integer returned by the getHeight method
        int expResult = 1234;
        assertEquals(expResult, instance.getHeight());
    }

    /**
     * Test of getWidth method, of class Map.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        // create new map object
        Map instance = new Map("Test Building", 0, 1234);
        // compare the expected result with the integer returned by the getWidth method
        int expResult = 1234;
        assertEquals(expResult, instance.getWidth());
    }  
}