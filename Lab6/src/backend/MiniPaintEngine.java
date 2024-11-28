package backend;

import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

public class MiniPaintEngine implements DrawingEngine {
    private final Map<String, Shape> shapes;
    int circleCount, lineCount, squareCount, rectangleCount;

    public MiniPaintEngine () {
        shapes = new HashMap<>();
        circleCount = lineCount = squareCount = rectangleCount = 0;
    }
    
    /* Manage shapes objects */
    public void addShape(Shape shape) {
        // reset counters if empty
        if(shapes.isEmpty()) {
            circleCount = lineCount = squareCount = rectangleCount = 0; 
        }
        // check for duplicates
        if(shapes.containsValue(shape) || shape == null) 
            return;
        
        String uniqueName = "";
        if (shape instanceof Circle) {
            uniqueName = String.format("circle%02d", ++circleCount);
        }
        else if (shape instanceof LineSegment) {
            uniqueName = (String.format("line%02d", ++lineCount));
        }  
        else if (shape instanceof Square) {
            uniqueName = String.format("square%02d", ++squareCount);
        }
        else if (shape instanceof Rectangle) {
            uniqueName = String.format("rectangle%02d", ++rectangleCount);
        }
        
        if(!uniqueName.isEmpty() && !shapes.containsKey(uniqueName)) {
            shape.setName(uniqueName);
            shapes.put(uniqueName, shape);
        }
    }
    public void removeShape(Shape shape) {
        shapes.remove(shape.getName());
    }
    public void removeAllShapes() {
        shapes.clear();
    }
    
    /* return the created shapes objects */
    public Shape[] getShapes() {
        return shapes.values().toArray(new Shape[shapes.size()]);
    }

    /* redraw all shapes on the canvas */
    public void refresh(java.awt.Graphics canvas) {
        java.awt.Graphics2D canvas2D = (java.awt.Graphics2D)canvas;
        canvas2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // make drawing smoother
        canvas2D.setStroke(new BasicStroke(2)); // make pen thicker
        for(Shape shape : shapes.values()) {
            shape.draw(canvas2D);
        }
    }
}
