package com.cameronmaxwell.westernmapviewer;
import java.util.ArrayList;

/**
 * The building class is used to organize the maps of all its floors. Each
 * building has at least one map.
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */

public class Building {
    
    /** variable for building name */
    private String name;
    /** the dynamically-stored collection of all floors in this building */
    private ArrayList<Map> floors;
    
    /**
     * Defines a building with at least one floor to be specified.
     * @param name the name of this building
     */
    public Building(String name){
        this.name = name;
        // empty by default (at least one map to be added)
        floors = new ArrayList<>();
    }
    
    /**
     * Gets all floors in this building.
     * @return a list of maps of this building's floors
     */
    public ArrayList<Map> getFloors(){
        return floors;
    }
    
    /**
     * Defines a new floor in this building.
     * @param newFloor a map of this new floor of the building
     */
    public void addFloor(Map newFloor){
        floors.add(newFloor);
    }
    
    /**
     * Returns the name of the building.
     * @return building name
     */
    public String getName(){
        return name;
    }
}
