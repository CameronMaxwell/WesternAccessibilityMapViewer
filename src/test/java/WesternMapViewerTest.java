package com.cameronmaxwell.westernmapviewer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for the Main class.
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */
public class WesternMapViewerTest {
    
    /** set testFile to the file path of a JSON file solely for testing */
    private String testFile = "src/resources/data/testData.json";

    @BeforeEach
    public void setUp() {
        // write to the testData JSON file an empty string to clear the file
        try {
            FileWriter fileWriter = new FileWriter(testFile);
            fileWriter.write("");
            fileWriter.close();
            
        } catch (IOException e) { // catches possible error when using fileWriter
            System.err.println("Error in writing the file.");;
        }
        // clear the array list
        WesternMapViewer.listOfPOIs.clear();
    }

    /**
     * Test of loadPOIs method, of class WesternMapViewer.
     */
    @Test
    public void testLoadPOIs() {
        System.out.println("loadPOIs");
        // create a new instance of the main class
        WesternMapViewer instance = new WesternMapViewer();
        // write to the testData JSON file an example of a POI's metadata
        try {
            FileWriter fileWriter = new FileWriter(testFile);
            fileWriter.write("[{\"buildingName\":\"Middlesex College\",\"mapName\":\"Floor 1\",\"favourite\":true,\"description\":\"Men\\u0027s bathroom on floor 1 of Middlesex College\",\"xPos\":100,\"yPos\":200,\"roomNumber\":100,\"roomName\":\"Men\\u0027s Bathroom\",\"poiName\":\"MC100\",\"layers\":\"Bathrooms\",\"isBuiltIn\":true}]");
            fileWriter.close();
        } catch (IOException e) { // catches possible error when using fileWriter
            System.err.println("Error in writing the file.");;
        }
        // call JSONtoJava method on the instance created
        instance.loadPOIs(testFile);
        // obtain the POI object created by the JSONtoJava class
        POI testPOI = instance.listOfPOIs.get(0);
        // set desired result of one of the POI's data points (building name) and compare to the actual value produced
        String expResult = "Middlesex College";
        String result = testPOI.buildingName;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of savePOIs method, of class Main.
     */
    @Test
    public void testSavePOIs() {
        System.out.println("savePOIs");
        // create a new instance of the main class
        WesternMapViewer instance = new WesternMapViewer();
        // create POI to be sent to JSON
        String layers[] = {"Layer 1", "Layer 2"};
        POI testPOI = new POI("Middlesex College", "Floor 1", true, "Men's bathroom on floor 1 of Middlesex College", 100, 200, 100, "Men's Bathroom", "MC100", "Bathrooms", true);
        // add POI to the arrayList of the JSONReader instance
        instance.listOfPOIs.add(testPOI);
        // call javaToJSON method on the instance created
        instance.savePOIs(testFile);
        // set desired result of the Java to JSON conversion
        String expResult = "[{\"buildingName\":\"Middlesex College\",\"mapName\":\"Floor 1\",\"favourite\":true,\"description\":\"Men\\u0027s bathroom on floor 1 of Middlesex College\",\"xPos\":100,\"yPos\":200,\"roomNumber\":100,\"roomName\":\"Men\\u0027s Bathroom\",\"poiName\":\"MC100\",\"layers\":\"Bathrooms\",\"isBuiltIn\":true}]";
        // read testPOI metadata from test JSON file
        try {
            FileReader fileReader = new FileReader(testFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = bufferedReader.readLine();
            // compare the desired result and the result produced
            assertEquals(expResult, result);
        } catch (FileNotFoundException e ){ // catches possible errors when using FileReader
            System.err.println("File not found.");
        } catch (IOException e) {
            System.err.println("Error in closing the file.");
        } 
    }
    
    /**
     * Test of main method, of class WesternMapViewer.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        // define bool for if the test passes or not, set to false by default
        boolean pass = false;
        // call the main class
        String[] args = null;
        WesternMapViewer.main(args);
        // define array of building names to be compared to
        String[] buildingNames = {"Middlesex College", "Advanced Facility for Avian Research", "Staging Building"};
        // for each building added into the array list, check if their names are what is expected
        for (int i = 0; i < WesternMapViewer.listOfBuildings.size(); i++) {
            if (WesternMapViewer.listOfBuildings.get(i).getName().equals(buildingNames[i])) {
                pass = true;
            }
            else {
                pass = false;
            }
        }
        // check if the test should pass
        assertTrue(pass);
    }
}
