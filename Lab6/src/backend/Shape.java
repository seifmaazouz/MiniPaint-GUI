package backend;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

public interface Shape {
    /* set position */
    public void setPosition(Point position);
    public Point getPosition();
    
    /* set unique name */
    public void setName(String uniqueName);
    public String getName();

    /* update shape specific properties (e.g., radius) */
    public void setProperties(Map<String, Double> properties);
    public Map<String, Double> getProperties();

    /* colorize */
    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();

    /* redraw the shape on the canvas */
    public void draw(java.awt.Graphics canvas);
}
