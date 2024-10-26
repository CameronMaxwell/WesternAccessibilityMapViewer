package com.cameronmaxwell.westernmapviewer;
import java.util.Arrays;

/**
 * POI class used for storing the metadata of all POIs,
 * either user-defined or built-in to the program.
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */
public class POI { 
    
    /** building name variable */
    public String buildingName;
    /** map name variable */
    public String mapName;
    /** favourite variable */
    public boolean favourite;
    /** short description variable */
    public String description;
    /** x position variable */
    public int xPos;
    /** y position variable */
    public int yPos;
    /** room number variable */
    public int roomNumber;
    /** room name variable */
    public String roomName;
    /** POI name variable */
    public String poiName;
    /** layers variable */
    public String layers;
    /** built-in POI variable */
    public boolean isBuiltIn;

    /**
     * POI constructor. Creates a new POI object and can be used to edit POI data
     * on the fly as its variables are public (like an update function).
     * @param buildingName name of the building
     * @param mapName name of the map
     * @param favourite if the POI is a favourite or not
     * @param description short description of POI
     * @param xPos x position of the POI on the map
     * @param yPos y position of the POI on the map
     * @param roomNumber room number of the POI
     * @param roomName room name of the POI
     * @param poiName name of the POI
     * @param layers layers that the POI belongs to
     * @param isBuiltIn if the POI is built in or not
     */
    public POI(String buildingName, String mapName, boolean favourite, String description, int xPos, int yPos, int roomNumber, String roomName, String poiName, String layers, boolean isBuiltIn) {
        this.buildingName = buildingName;
        this.mapName = mapName;
        this.favourite = favourite;
        this.description = description;
        this.xPos = xPos;
        this.yPos = yPos;
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.poiName = poiName;
        this.layers = layers;
        this.isBuiltIn = isBuiltIn;
    }

    /**
     * POI toString. Allows for easy debugging related to POIs and their metadata.
     * @return String representation of POI's metadata
     */
    @Override
    public String toString() {
        return "POI Name: " + poiName + "\n" +
                "Building Name: " + buildingName + "\n" +
                "Map Name: " + mapName + "\n" +
                "Room Name: " + roomName + "\n" +
                "Room Number: " + roomNumber + "\n" +
                "X Position on Map: " + xPos + "\n" +
                "Y Position on Map: " + yPos + "\n" +
                "Short Description: " + description + "\n" +
                "Favourite: " + favourite + "\n" +
                "Layers: " + layers + "\n" +
                "Is Built-In: " + isBuiltIn + "\n";
    }
}