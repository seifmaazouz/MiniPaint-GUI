package backend;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class LineSegment extends AbstractShape {

    /* redraw the shape on the canvas */
    @Override
    public void draw(java.awt.Graphics canvas) {
        Graphics2D canvas2D = (Graphics2D)canvas;
        
        Point position = getPosition();
        Map<String, Double> properties = getProperties();
        Color color = getColor();
        Color fillColor = getFillColor();
        
        if(position != null && properties.containsKey("endX") && properties.containsKey("endY") && color != null) {
            double endX = properties.get("endX");
            double endY = properties.get("endY");
            
            if(fillColor != null)
                canvas2D.setColor(fillColor);
            else
                canvas2D.setColor(color);
            canvas2D.drawLine(position.x, position.y, (int)endX, (int)endY);
        }
    }
}
