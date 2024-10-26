package com.cameronmaxwell.westernmapviewer;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the main class of the project.
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */
public class WesternMapViewer {
   
    /** establish a static array list of all POIs to be used across the program */
    public static ArrayList<POI> listOfPOIs = new ArrayList<POI>();
    
    /** establish a static array list of all buildings */
    public static ArrayList<Building> listOfBuildings = new ArrayList<Building>();

    /** set the file name for the load and save methods */
    public static String fileName = "src/resources/data/POIs.json";
    
    /**
     * Main method of the main class.
     * @param args args for main method
     */
    public static void main(String[] args) {
        // load in POIs from JSON
        loadPOIs(fileName);
        
        // create new weather object and update global weather data variables
        Weather weather = new Weather();
        weather.updateData();

        // list of layer names
        String[] layerNames = {"Accessibility","Washrooms","Classrooms","Labs","Restaurants","User-Defined","Favourites","Entry Points"};
        
        // BUILDING/MAP/LAYER INITILIZATION:
        // MC initialization
        Building mcBuilding = new Building("Middlesex College");
        for(int i = 0; i < 5; i++) {
            Map mcMap = new Map("Middlesex College", 1384, 2289);
            addLayers(mcMap, layerNames, "Middlesex College", "Floor " + i);
            mcBuilding.addFloor(mcMap);
            
        }
        listOfBuildings.add(mcBuilding);
      
        
        // AFAR initialization
        Building afarBuilding = new Building("Advanced Facility for Avian Research");
        for(int i = 0; i < 3; i++) {
            Map afarMap = new Map("Advanced Facility for Avian Research", 1417, 2343);
            addLayers(afarMap, layerNames, "Advanced Facility for Avian Research", "Floor " + i);
            afarBuilding.addFloor(afarMap);
            
        }
        listOfBuildings.add(afarBuilding);
        
        
        // STAB initialization
        Building stabBuilding = new Building("Staging Building");
        for(int i = 1; i < 3; i++) {
            Map stabMap = new Map("Staging Building", 3001, 2343);
            addLayers(stabMap, layerNames, "Staging Building", "Floor " + i);
            stabBuilding.addFloor(stabMap);
        }
        listOfBuildings.add(stabBuilding);
        
        // launch GUI
        GUIExample.main(args);
    }
    
    /**
     * addLayers method. Adds all required layers to their buildings efficiently.
     * @param map map layer belongs to
     * @param layerNames array of layer names to be added
     * @param buildingName building layer belongs to
     * @param floor floor (map) layer belongs to
     */
    private static void addLayers(Map map, String[] layerNames, String buildingName, String floor) {
        for (int i = 0; i < layerNames.length; i++) {
            String layerName = layerNames[i];
            map.addLayer(new Layer(layerName, buildingName, floor));
        }
    }

    /**
     * loadPOIs method. Converts POI objects from JSON format to Java objects and stores them in an array list.
     * To use, call the method. All POI objects that are in the "POIs.json" file will be made into POI objects
     * and will be stored in the array list "listOfPOIs".
     * @param fileName name of file to load from
     */
    public static void loadPOIs(String fileName) {
        Type type = new TypeToken<ArrayList<POI>>(){}.getType();
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(fileName)) {
            listOfPOIs = gson.fromJson(fileReader, type);
        } catch (IOException e) {
            System.err.println("Error in closing the file.");
        }
    }
   
    /**
     * savePOIs method. Converts POI objects in an array list to JSON format.
     * To use, ensure that all POIs attempting to be added have been added to the array list "listOfPOIs"
     * Then, simply call the method to save all POI objects in the array list to "POIs.json".
     * @param fileName name of file to save to
     */
    public static void savePOIs(String fileName) {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(listOfPOIs, fileWriter); 
        } catch(IOException e) {
            System.err.println("Error in writing the file.");
        }
    }
}