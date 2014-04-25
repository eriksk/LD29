package se.skoggy.levelitate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapLayer {

    protected List<GameObject> objects;
    protected List<Line> lines;
    protected List<RectangleWithProperties> rectangles;
    protected Color color;
    protected String name;
    protected float parallax;
    protected HashMap<String, String> properties;

    public MapLayer() {
        properties = new HashMap<String, String>();
        lines = new ArrayList<Line>();
        objects = new ArrayList<GameObject>();
        rectangles = new ArrayList<RectangleWithProperties>();
        name = "<UNTITLED>";
        color = new Color(1f, 1f, 1f, 1f);
        parallax = 1f;
    }

    public void addObject(GameObject gameObject) {
        objects.add(gameObject);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public List<Line> getLines() {
        return lines;
    }
    
    public List<RectangleWithProperties> getRectangles() {
		return rectangles;
	}
    
    public String getName() {
        return name;
    }

    public MapLayer setName(String name) {
        this.name = name;
        return this;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    public MapLayer setProperty(String key, String value) {
        properties.put(key, value);
        return this;
    }

    public Color getColor() {
        return color;
    }

    public float getParallax() {
		return parallax;
	}
    
    public void setParallax(float parallax) {
		this.parallax = parallax;
	}
    
    public void setColor(float r, float g, float b, float a) {
        this.color.r = r;
        this.color.g = g;
        this.color.b = b;
        this.color.a = a;
    }

    @Override
    public String toString() {
        return name;
    }
}
