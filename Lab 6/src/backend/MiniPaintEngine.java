package backend;

import backend.Shape;
import java.util.ArrayList;
import java.util.List;

public class MiniPaintEngine implements DrawingEngine {
    private List<Shape> shapes;
    
    public MiniPaintEngine () {
        shapes = new ArrayList<>();
    }
    
    /* Manage shapes objects */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
        
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    /* return the created shapes objects */
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[shapes.size()]);
    }

    /* redraw all shapes on the canvas */
    public void refresh(java.awt.Graphics canvas) {
        for(Shape shape : shapes) {
            shape.draw(canvas);
        }
    }
}
