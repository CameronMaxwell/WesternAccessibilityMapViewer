package com.cameronmaxwell.westernmapviewer;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Layer class.
 * 
 * @author Cameron Maxwell
 */
public class LayerTest {

    /**
     * Test of addPOI method and getPOIs method, of class Layer.
     */
    @Test
    public void testAddPOI() {
        System.out.println("addPOI");
        // create new POI and layer objects
        POI newPOI = new POI("Test Building", "Test Map", true, "Test Description", 0, 0, 0, "Test Room Name", "Test POI Name", "Test Layers", true);
        Layer instance = new Layer("Test Layer Type", null, null);
        // add the new POI to the layer
        instance.addPOI(newPOI);
        // compare the new POI with the object at the first index of the array list returned by the getPOI method
        assertEquals(newPOI, instance.getPOIs().get(0));
    }
    
    /**
     * Test of setType method and getType method, of class Layer.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        // set the new layer type
        String newType = "Test Layer Type";
        // create a new layer object
        Layer instance = new Layer("Test Layer Type", null, null);
        // set the layer type of the new layer object
        instance.setType(newType);
        // compare the new layer type with the string returned by the getType method
        assertEquals(newType, instance.getType());
    }

    /**
     * Test of setToggle method and getToggle method, of class Layer.
     */
    @Test
    public void testSetToggle() {
        System.out.println("setToggle");
        // create a new layer object
        Layer instance = new Layer("Test Layer Type", null, null);
        // set the layer toggle to true (by default is false)
        instance.setToggle();
        // check if the toggle value returned by the getToggle method is true
        assertTrue(instance.getToggle());
    }
    
    /**
     * Test of setBuilding method and getBuilding method, of class Layer.
     */
    @Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        // set the new building
        String newBuilding = "Test Building";
        // create a new layer object
        Layer instance = new Layer("Test Layer Type", null, null);
        // set the building of the new layer object
        instance.setBuilding(newBuilding);
        // compare the new building with the string returned by the getBuilding method
        assertEquals(newBuilding, instance.getBuilding());
    }

    /**
     * Test of setMap method and getMap method, of class Layer.
     */
    @Test
    public void testSetMap() {
        System.out.println("setMap");
        // set the new map
        String newMap = "Test Map";
        // create a new layer object
        Layer instance = new Layer("Test Layer Type", null, null);
        // set the map of the new layer object
        instance.setMap(newMap);
        // compare the new map with the string returned by the getMap method
        assertEquals(newMap, instance.getMap());
    }  
}