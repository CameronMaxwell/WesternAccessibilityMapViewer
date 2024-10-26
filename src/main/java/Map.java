package com.cameronmaxwell.westernmapviewer;
import java.util.ArrayList;

/**
 * The map class is used to store a collection of layers specific to a floor.
 * Every map has at least three layers: accessibility, washroom, and map legend.
 * A map is unique to a building. 
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */

public class Map {
    
    /** building name variable */
    private String bName;
    /** height of map variable */
    private int height;
    /** width of map variable */
    private int width;
    /** the dynamically-stored collection of all POIs in this layer */
    private ArrayList<Layer> layersInMap;
    
    /**
     * Defines a map containing layers that belongs to a specific building.
     * @param bName the building the map belongs to
     * @param height the height of the map PNG
     * @param width the width of the map PNG
     */
    public Map(String bName, int height, int width){
        this.bName = bName;
        this.height = height;
        this.width = width;
        // empty by default (accessibility, washroom, and map legend layers to be added)
        layersInMap = new ArrayList<>();
    }
    
    /**
     * Gets all layers belonging to this map.
     * @return list of layers on the map
     */
    public ArrayList<Layer> getLayers(){
        return layersInMap;
    }
    
    /**
     * Adds a new layer to belong to this map.
     * @param newLayer a new layer unique to this map
     */
    public void addLayer(Layer newLayer){
        layersInMap.add(newLayer);
    }

    /**
     * Returns the name of the building the map belongs to.
     * @return name of building map belongs to
     */
    public String getBuildingName(){
        return bName;
    }
    
    /**
     * Returns the height of map.
     * @return height
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Returns the width of map.
     * @return width
     */
    public int getWidth(){
        return width;
    }
}