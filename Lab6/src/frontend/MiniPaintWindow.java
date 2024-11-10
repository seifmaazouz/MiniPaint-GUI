package frontend;
import backend.*;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;

public class MiniPaintWindow extends javax.swing.JFrame {
    
    private final MiniPaintEngine engine;
    private final Graphics2D graphics;
    private final ShapeDialog shapeDialog;
    private final JComponent[] components;
    private Map<String, Shape> comboBoxItems = new HashMap<>();
    int circleCount, lineCount, squareCount, rectangleCount;
    
    public MiniPaintWindow() {
        initComponents(); 
        engine = new MiniPaintEngine();
        graphics = (Graphics2D)canvas.getGraphics();
        shapeDialog = new ShapeDialog(this, rootPaneCheckingEnabled);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // make drawing smoother
        graphics.setStroke(new BasicStroke(2)); // make pen thicker
        circleCount = lineCount = squareCount = rectangleCount = 0;
        this.components = new JComponent[] {btnCircle, btnColorize, btnDelete, btnLine, btnRectangle, btnSquare, comboBox, drawingPanel};
    }
    
    public Graphics2D getCanvasGraphics() {
        return graphics;
    }
    public MiniPaintEngine getEngine() {
        return engine;
    }
    
    public boolean isPositionOutOfBounds(Point userPosition) {
        if(userPosition.x > canvas.getWidth() || userPosition.x < 0 || userPosition.y > canvas.getWidth() || userPosition.y < 0) {
            return true;
        }
        return false;
    }
    
    public void selectPositionMode() {
        for (JComponent component : components) {
            if(component != drawingPanel)
                component.setEnabled(false);
        }
    }
    
    public void addShape(Shape shape) {
        engine.addShape(shape);
        engine.refresh(graphics);
        addToComboBox(shape);
    }

    public void resetMode() {
        for (JComponent component : components) {
            if(component != drawingPanel)
                component.setEnabled(true);
        }
    }

    private void addToComboBox(Shape shape) {        
        String uniqueName = "";
        
        // reset count
        if(comboBox.getItemCount() == 1)
            circleCount = lineCount = squareCount = rectangleCount = 0;

        if (shape instanceof Circle) {
            uniqueName = String.format("circle%02d", circleCount+1);
            
        }
        else if (shape instanceof LineSegment) {
            uniqueName = (String.format("line%02d", lineCount+1));
        }  
        else if (shape instanceof Square) {
            uniqueName = String.format("square%02d", squareCount+1);
        }
        else if (shape instanceof Rectangle) {
            uniqueName = String.format("rectangle%02d", rectangleCount+1);
        }
        
        if(!comboBoxItems.containsKey(uniqueName)) {
            comboBoxItems.put(uniqueName, shape);
            comboBox.addItem(uniqueName);
            // increment count
            if (shape instanceof Circle) {
                    circleCount++;
            } else if (shape instanceof LineSegment) {
                lineCount++;
            } else if (shape instanceof Square) {
                squareCount++;
            } else if (shape instanceof Rectangle) {
                rectangleCount++;
            }
        }
        
        
        comboBox.setSelectedIndex(0); // Select choose shape
    }
    
    private void removeFromComboBox(String uniqueName) {
        if(!comboBoxItems.containsKey(uniqueName))
            return;
                    
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(uniqueName)) {
                comboBox.removeItemAt(i);
                break;
            }
        }
        comboBoxItems.remove(uniqueName);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawingPanel = new javax.swing.JPanel();
        canvas = new java.awt.Canvas();
        btnRectangle = new javax.swing.JButton();
        btnCircle = new javax.swing.JButton();
        btnLine = new javax.swing.JButton();
        btnSquare = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        javax.swing.JLabel selectShapeLabel = new javax.swing.JLabel();
        btnColorize = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Vector Drawing Application");
        setMinimumSize(new java.awt.Dimension(824, 520));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawingPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));
        drawingPanel.setForeground(new java.awt.Color(0, 0, 0));
        drawingPanel.setMinimumSize(new java.awt.Dimension(587, 272));

        canvas.setMinimumSize(new java.awt.Dimension(593, 436));
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasMousePressed(evt);
            }
        });

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnRectangle.setText("Rectangle");
        btnRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectangleActionPerformed(evt);
            }
        });

        btnCircle.setText("Circle");
        btnCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCircleActionPerformed(evt);
            }
        });

        btnLine.setText("Line Segment");
        btnLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineActionPerformed(evt);
            }
        });

        btnSquare.setText("Square");
        btnSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSquareActionPerformed(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Shape" }));

        selectShapeLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        selectShapeLabel.setLabelFor(comboBox);
        selectShapeLabel.setText("  Select Shape");

        btnColorize.setText("Colorize");
        btnColorize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorizeActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectShapeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnColorize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnLine, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCircle, btnLine, btnRectangle, btnSquare});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBox, selectShapeLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectShapeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnColorize)
                    .addComponent(btnDelete))
                .addGap(250, 250, 250))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLine, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCircle, btnLine, btnRectangle, btnSquare});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = comboBox.getSelectedIndex();
        if(index != 0) {
            Shape shape = engine.getShapes()[index - 1];
            engine.removeShape(shape);
            removeFromComboBox(comboBox.getItemAt(index));
            graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            engine.refresh(graphics);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCircleActionPerformed
        shapeDialog.updateFields("Circle");
    }//GEN-LAST:event_btnCircleActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(shapeDialog.getPositionMode().equals("off"))
              this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineActionPerformed
        shapeDialog.updateFields("Line");
    }//GEN-LAST:event_btnLineActionPerformed

    private void btnSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSquareActionPerformed
        shapeDialog.updateFields("Square");
    }//GEN-LAST:event_btnSquareActionPerformed

    private void btnRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectangleActionPerformed
        shapeDialog.updateFields("Rectangle");
    }//GEN-LAST:event_btnRectangleActionPerformed

    private void canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMousePressed
        if(!shapeDialog.getPositionMode().equals("off")) {
            shapeDialog.setPositionMode(evt.getPoint());
            shapeDialog.resetMode();
            shapeDialog.setModal(true);
            shapeDialog.setVisible(false);
            shapeDialog.setVisible(true);
        }
    }//GEN-LAST:event_canvasMousePressed

    private void btnColorizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorizeActionPerformed
        int index = comboBox.getSelectedIndex();
        if(index != 0) {
            String uniqueName = comboBox.getItemAt(index);
            Shape shape = comboBoxItems.get(uniqueName);
            new ColorDialog(this, true, shape.getColor(), shape.getFillColor(), shape, uniqueName);
        }
    }//GEN-LAST:event_btnColorizeActionPerformed
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiniPaintWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniPaintWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniPaintWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniPaintWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniPaintWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCircle;
    private javax.swing.JButton btnColorize;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLine;
    private javax.swing.JButton btnRectangle;
    private javax.swing.JButton btnSquare;
    private java.awt.Canvas canvas;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JPanel drawingPanel;
    // End of variables declaration//GEN-END:variables
}
