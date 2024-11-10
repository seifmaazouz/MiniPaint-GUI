package backend;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

public class Rectangle extends AbstractShape {
    
    /* redraw the shape on the canvas */
    @Override
    public void draw(java.awt.Graphics canvas) {
        Graphics2D canvas2D = (Graphics2D)canvas;
        
        Point position = getPosition();
        Map<String, Double> properties = getProperties();
        Color color = getColor();
        Color fillColor = getFillColor();
        
        if(position != null && properties.containsKey("width") && properties.containsKey("height") && color != null) {
           
            double width = properties.get("width");
            double height = properties.get("height");
            
            canvas2D.setColor(color);
            if(fillColor != null) {
                canvas2D.setColor(fillColor);
                canvas2D.fillRect((int)(position.x - width/2), (int)(position.y - height/2), (int)width, (int)height);
            }
            canvas2D.setColor(color);
            canvas2D.drawRect((int)(position.x - width/2), (int)(position.y - height/2), (int)width, (int)height);
        }
    }
}
