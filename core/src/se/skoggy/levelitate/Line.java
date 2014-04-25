package se.skoggy.levelitate;

import java.util.ArrayList;
import java.util.List;

public class Line {

    protected List<Vector2> nodes;
    protected String type;

    public Line() {
        nodes = new ArrayList<Vector2>();
        type = "";
    }

    public void addNode(Vector2 node) {
        nodes.add(node);
    }

    public void removeLast() {
        if (nodes.size() > 0) {
            nodes.remove(nodes.size() - 1);
        }
    }

    public List<Vector2> getNodes() {
        return nodes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

    @Override
    public String toString() {
        return "line (" + nodes.size() + ") " + getType();
    }
}
