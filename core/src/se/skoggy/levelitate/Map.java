package se.skoggy.levelitate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    protected List<MapLayer> layers;
    protected String name;
    protected HashMap<String, String> properties;

    public Map() {
        name = "<UNTITLED>";
        layers = new ArrayList<MapLayer>();
        properties = new HashMap<String, String>();
    }

    public void addLayer(MapLayer mapLayer) {
        layers.add(mapLayer);
    }
    
    public List<MapLayer> getLayers() {
        return layers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}