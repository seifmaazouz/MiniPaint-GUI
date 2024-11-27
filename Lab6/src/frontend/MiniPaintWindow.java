package frontend;
import backend.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MiniPaintWindow extends javax.swing.JFrame {
    
    private final MiniPaintEngine engine;
    private final ShapeDialog shapeDialog;
    private final JComponent[] components;
    private final File saveDirectory;
    
    public MiniPaintWindow() {
        initComponents(); 
        engine = new MiniPaintEngine();
        shapeDialog = new ShapeDialog(this, rootPaneCheckingEnabled);
        this.components = new JComponent[] {btnCircle, btnColorize, btnDelete, btnLine, btnRectangle, btnSquare, comboBox, drawingPanel, btnMove, btnResize, btnSave, btnLoad, btnUndo, btnRedo};
        saveDirectory = new File(System.getProperty("user.dir") + File.separator + "Saved Paintings"); // FIle.separator puts '\' or '/' according to OS
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt")); // Show only text files;
    }
    
    public boolean isPositionOutOfBounds(Point userPosition) {
        if(userPosition.x > drawingPanel.getWidth() || userPosition.x < 0 || userPosition.y > drawingPanel.getHeight()|| userPosition.y < 0) {
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
        addToComboBox(shape);
        drawingPanel.repaint();
    }

    public void resetMode() {
        for (JComponent component : components) {
            if(component != drawingPanel)
                component.setEnabled(true);
        }
    }

    private Shape getSelectedShape(String uniqueName) {
        Shape selectedShape = null;
        for(Shape shape : engine.getShapes()) {
            if(shape.getName().equals(uniqueName)) {
                selectedShape = shape;
                break;
            }
        }
        return selectedShape;
    }
    private void addToComboBox(Shape shape) {
        String uniqueName = shape.getName();
        if(uniqueName != null)
            comboBox.addItem(uniqueName);
//        comboBox.setSelectedIndex(0); // Select choose shape
    }
    
    private void removeFromComboBox(Shape shape) {
        String uniqueName = shape.getName();
        for (int i = 1; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(uniqueName)) {
                comboBox.removeItemAt(i);
                engine.removeShape(shape);
                break;
            }
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        drawingPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                engine.refresh(g);
            }
        };
        btnRectangle = new javax.swing.JButton();
        btnCircle = new javax.swing.JButton();
        btnLine = new javax.swing.JButton();
        btnSquare = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        javax.swing.JLabel selectShapeLabel = new javax.swing.JLabel();
        btnColorize = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnResize = new javax.swing.JButton();
        btnMove = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnRedo = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);

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
        drawingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawingPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
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

        btnResize.setText("Resize");
        btnResize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResizeActionPerformed(evt);
            }
        });

        btnMove.setText("Move");
        btnMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveActionPerformed(evt);
            }
        });

        btnUndo.setText("Undo");

        btnRedo.setText("Redo");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnResize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnColorize, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectShapeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnColorize, btnDelete, btnRedo, btnSave, btnUndo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRectangle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLine, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRedo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoad))
                        .addGap(73, 73, 73)
                        .addComponent(selectShapeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnColorize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnResize)
                            .addComponent(btnMove))
                        .addGap(217, 217, 217))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCircle, btnLine, btnRectangle, btnSquare});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = comboBox.getSelectedIndex();
        if(index != 0) {
            String uniqueName = comboBox.getItemAt(index);
            Shape selectedShape = getSelectedShape(uniqueName);
            // Check if the shape exists
            if(selectedShape == null) return;
            removeFromComboBox(selectedShape);
            drawingPanel.repaint();
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

    private void btnColorizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorizeActionPerformed
        int index = comboBox.getSelectedIndex();
        if(index != 0) {
            String uniqueName = comboBox.getItemAt(index);
            Shape selectedShape = getSelectedShape(uniqueName);
            // Check if the shape exists
            if(selectedShape == null) return;
            ColorDialog colorDialog = new ColorDialog(this, true, selectedShape);
            colorDialog.dispose();
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_btnColorizeActionPerformed

    private void drawingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMousePressed
        if(!shapeDialog.getPositionMode().equals("off")) {
            shapeDialog.setPositionMode(evt.getPoint());
            shapeDialog.resetMode();
            shapeDialog.setModal(true);
            shapeDialog.setVisible(false);
            shapeDialog.setVisible(true);
        }
    }//GEN-LAST:event_drawingPanelMousePressed

    private void btnResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResizeActionPerformed
        // TODO
    }//GEN-LAST:event_btnResizeActionPerformed

    private void btnMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveActionPerformed
        int index = comboBox.getSelectedIndex();
        if(index != 0) {
            String uniqueName = comboBox.getItemAt(index);
            Shape selectedShape = getSelectedShape(uniqueName);
            // Check if the shape exists
            if(selectedShape == null) return;
            MoveDialog moveDialog = new MoveDialog(this, true, selectedShape);
            moveDialog.dispose();
            drawingPanel.repaint();
        }
    }//GEN-LAST:event_btnMoveActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        fileChooser.setDialogTitle("Save Shapes");
        fileChooser.setCurrentDirectory(saveDirectory); 
        int choice = fileChooser.showSaveDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            // Make sure the file ends with .txt
            if(!filePath.toLowerCase().endsWith(".txt")) {
                selectedFile = new File(filePath + ".txt");
            }
            // Check if file already exists
            if(selectedFile.exists()) {
                int overwrite = JOptionPane.showConfirmDialog(this, "File already exists. Do you want to override it?", "File Exists", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if(overwrite != JOptionPane.YES_OPTION) {
                    System.out.println("Cancel Overwrite"); // for debugging
                    return;
                }
            }
            // Write content to the file
            // each line will be a shape format: className,posX-posY,color,fillColor,property1:value-property2:value [or] className,posX-posY,color,fillColor,property1:value 
            try (FileWriter fwrite = new FileWriter(selectedFile)) {
                fwrite.write(""); // clear file
                Shape[] shapes = engine.getShapes();
                for(Shape shape : shapes) {
                    Point position = shape.getPosition();
                    Color color = shape.getColor();
                    Color fillColor = shape.getFillColor();
                    if(fillColor != null)
                        fwrite.append(String.format("%s,%d-%d,%d,%d", shape.getClass().getName(), position.x, position.y, color.getRGB(), fillColor.getRGB()));
                    else
                        fwrite.append(String.format("%s,%d-%d,%d,null", shape.getClass().getName(), position.x, position.y, color.getRGB()));
                    Map<String, Double> properties = shape.getProperties();
                    String strProperties = ",";
                    for(Map.Entry<String, Double> entry : properties.entrySet()) {
                        strProperties += String.format("%s:%f-", entry.getKey(), entry.getValue());
                    }
                    fwrite.append(strProperties.substring(0, strProperties.length()-1));
                    fwrite.append("\n"); // new line for next shape
                }
                JOptionPane.showMessageDialog(null, "Shapes saved successfully!");
                System.out.println(selectedFile.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error: "  + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }  
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        fileChooser.setDialogTitle("Load Shapes");
        fileChooser.setCurrentDirectory(saveDirectory);
        int choice = fileChooser.showOpenDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            // Make sure the file ends with .txt
            if(!filePath.toLowerCase().endsWith(".txt")) {
                selectedFile = new File(filePath + ".txt");
            }
            // Check if selected file exists
            if(!selectedFile.exists()) {
                JOptionPane.showMessageDialog(null, "Error: \"" + selectedFile.getName() + "\" file does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Check if you have permission to read from file
            if(!selectedFile.canRead())
                System.out.println("Error: You don't have permission to read from this file.");
            // Load shapes from file
            try (BufferedReader fread = new BufferedReader(new FileReader(filePath))) {
                List<Shape> shapes = new ArrayList<>();
                for(String line : fread.lines().toList()) {
                    //skip empty line
                    if(line.isEmpty())
                        continue;
                    // decode data in each line
                    String[] data = line.split(",");
                    // check if line format is correct
                    if(data.length != 5)
                        throw new IOException("File does not use correct format or was corrupted.");
                    String[] xyPosition = data[1].split("-");
                    Color color = new Color(Integer.parseInt(data[2]));
                    Color fillColor = null;
                    if(!data[3].equals("null"))
                        fillColor = new Color(Integer.parseInt(data[3]));
                    Map<String, Double> properties = new HashMap<>();
                    String[] strProperties = data[4].split("-"); // property1:value
                    for(String strProperty : strProperties) {
                        String[] keyValue = strProperty.split(":");
                        properties.put(keyValue[0], Double.valueOf(keyValue[1]));
                    }
                    Shape shape = null;
                    String[] className = data[0].split("\\."); // Backend.Class
                    switch (className[1]) {
                        case "Circle":
                            shape = new Circle();
                            break;
                        case "LineSegment":
                            shape = new LineSegment();
                            break;
                        case "Square":
                            shape = new Square();
                            break;
                        case "Rectangle":
                            shape = new Rectangle();
                            break;
                        default:
                            System.out.println("Error occured when deciding which shape to create"); // for debugging
                    }
                    if(shape != null) {
                        shape.setPosition(new Point(Integer.parseInt(xyPosition[0]), Integer.parseInt(xyPosition[1])));
                        shape.setColor(color);
                        shape.setFillColor(fillColor);
                        shape.setProperties(properties);
                        shapes.add(shape);
                    }
                }
                // all shapes have been read from files successfully without corruption
                // first remove old shapes
                engine.removeAllShapes();
                comboBox.removeAllItems();
                comboBox.addItem("Choose Shape");
                // now load the shapes into engine and draw them
                for(Shape addShape : shapes) {
                    engine.addShape(addShape);
                    addToComboBox(addShape);
                }
                comboBox.setSelectedIndex(0);
                drawingPanel.repaint();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error: "  + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
          catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error: Coudn't draw shapes as some lines in files were corrupted", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLoadActionPerformed
    
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
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMove;
    private javax.swing.JButton btnRectangle;
    private javax.swing.JButton btnRedo;
    private javax.swing.JButton btnResize;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSquare;
    private javax.swing.JButton btnUndo;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JPanel drawingPanel;
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
}
