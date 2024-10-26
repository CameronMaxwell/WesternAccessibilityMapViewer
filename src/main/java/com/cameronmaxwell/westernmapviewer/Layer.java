package com.cameronmaxwell.westernmapviewer;
import java.util.ArrayList;

/**
 * The layer class is used to store a collection of POIs of a particular 
 * category. A layer is unique to a map and can be either toggled or untoggled. 
 * 
 * @version 1.0
 * @author Cameron Maxwell
 */
public class Layer {
    
    /** layer type variable */
    private String layerType;
    /** toggle variable */
    private boolean toggle;
    /** layer building variable */
    private String layerBuilding;
    /** layer map variable */
    private String layerMap;
    /** the dynamically-stored collection of all POIs in this layer */
    private ArrayList<POI> POIsInLayer;
    
    /**
     * Creates a layer of a specific type that belongs to a single map and 
     * building.
     * @param layerType name of the layer
     * @param layerBuilding the building the layer belongs to
     * @param layerMap the map the layer belongs to
     */
    public Layer(String layerType, String layerBuilding, String layerMap){
        this.layerType = layerType;
        this.layerBuilding = layerBuilding;
        this.layerMap = layerMap;
        toggle = false; // layer is untoggled by default
        POIsInLayer = new ArrayList<>(); // no POIs in layer by default
    }
    
    /**
     * Get all POIs belonging to this layer.
     * @return List of all POIs in layer
     */
    public ArrayList<POI> getPOIs(){
        return POIsInLayer;
    }
    
    /**
     * Adds a new POI to this layer.
     * @param newPOI a new POI to belong in this layer
     */
    public void addPOI(POI newPOI){
        POIsInLayer.add(newPOI);
    }
    
    /**
     * Gets the name of this layer.
     * @return the name of this layer
     */
    public String getType(){
        return layerType;
    }
    
    /**
     * Renames this layer.
     * @param newType a new name for the layer
     */
    public void setType(String newType){
        layerType = newType;
    }
    
    /**
     * Returns the toggle boolean of the layer.
     * @return boolean toggle of layer
     */
    public boolean getToggle(){
        return toggle;
    }
    
    /**
     * Changes the toggle of the layer.
     */
    public void setToggle(){
        toggle = !toggle;
    }
    
    /**
     * Returns the building that the layer belongs to.
     * @return building layer belongs to
     */
    public String getBuilding(){
        return layerBuilding;
    }
    
    /**
     * Sets the building that the layer belongs to.
     * @param newBuilding building layer belongs to
     */
    public void setBuilding(String newBuilding){
        layerBuilding = newBuilding;
    }
    
    /**
     * Returns map that the layer belongs to.
     * @return map that layer belongs to
     */
    public String getMap(){
        return layerMap;
    }
    
    /**
     * Sets the map that the layer belongs to.
     * @param newMap map layer belongs to
     */
    public void setMap(String newMap){
        layerMap = newMap;
    }
}
