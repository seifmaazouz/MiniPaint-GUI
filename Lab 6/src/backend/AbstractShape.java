package backend;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractShape implements Shape {
    private Point position;
    private Map<String, Double> properties;
    private Color color;
    private Color fillColor;
    
    public AbstractShape() {
        properties = new HashMap<>();
    }
    
    /* set position */
    public void setPosition(Point position) {
        this.position = position;
    }
    public Point getPosition() {
        return position;
    }

    /* update shape specific properties (e.g., radius) */
    public void setProperties(Map<String, Double> properties) {
        this.properties.putAll(properties);
    }
    public Map<String, Double> getProperties() {
        return properties;
    }

    /* colorize */
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setFillColor(Color color) {
        fillColor = color;
    }
    public Color getFillColor() {
        return fillColor;
    }

    /* redraw the shape on the canvas */
    public abstract void draw(java.awt.Graphics canvas);
}
