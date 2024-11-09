package backend;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.Map;

public class Circle extends AbstractShape {
   
    /* redraw the shape on the canvas */
    @Override
    public void draw(java.awt.Graphics canvas) {
        Graphics2D canvas2D = (Graphics2D)canvas;
        
        Point position = getPosition();
        Map<String, Double> properties = getProperties();
        Color color = getColor();
        Color fillColor = getFillColor();
        
        if(position != null && properties.containsKey("radius") && color != null) {
            
            double radius = (double)properties.get("radius");
            double x = position.x - radius; // get the top left starting point
            double y = position.y - radius; // get the top left starting point (Graphics y-axis increases downwards)
            double width = radius*2;
            double height = radius*2;
            
            Ellipse2D.Double circle = new Ellipse2D.Double(x, y, width, height);
            
            canvas2D.setColor(color);
            if(fillColor != null) {
                canvas2D.setColor(fillColor);
                canvas2D.fill(circle);
            }
            canvas2D.draw(circle);
        }
    }
}
