package frontend;
import backend.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class ShapeDialog extends javax.swing.JDialog {
    private String positionMode;
    private String shapeSelected;
    private MiniPaintWindow mainWindow;
    private Graphics canvas;
    private Color penColor;
    private MiniPaintEngine engine;
    
    public ShapeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        positionMode = "off";
        this.mainWindow = (MiniPaintWindow)parent;
        canvas = mainWindow.getGraphics();
        penColor = Color.BLACK; // Default pen color
        engine = mainWindow.getEngine();
    }

    public String getPositionMode() {
        return positionMode;
    }
    public void setPositionMode(Point position) {
        if(!positionMode.equals("off")) {
            switch (positionMode) {
                case "position":
                inputPosition.setText(position.x + ", " + position.y);
                break;
                case "startPoint":
                inputStartPoint.setText(position.x + ", " + position.y);
                break;
                case "endPoint":
                inputEndPoint.setText(position.x + ", " + position.y); 
                break;
            }
        }
    }

    public String getShapeSelected() {
        return shapeSelected;
    }
    public void setShapeSelected(String shapeSelected) {
        this.shapeSelected = shapeSelected;
    }
    
    private void selectPositionMode(String mode) {
         positionMode = mode;
         mainWindow.selectPositionMode();
         this.setModal(false);
         this.setVisible(false);
         this.setVisible(true);

         btnCreateShape.setEnabled(false);
         btnEndPoint.setEnabled(false);
         btnPosition.setEnabled(false);
         btnStartPoint.setEnabled(false);
         chooseColor.setEnabled(false);
         inputEndPoint.setEnabled(false);
         inputHeight.setEnabled(false);
         inputPosition.setEnabled(false);
         inputRadius.setEnabled(false);
         inputSideLength.setEnabled(false);
         inputStartPoint.setEnabled(false);
         inputWidth.setEnabled(false);
    }
    
    protected void resetMode() {
         btnCreateShape.setEnabled(true);
         btnEndPoint.setEnabled(true);
         btnPosition.setEnabled(true);
         btnStartPoint.setEnabled(true);
         chooseColor.setEnabled(true);
         inputEndPoint.setEnabled(true);
         inputHeight.setEnabled(true);
         inputPosition.setEnabled(true);
         inputRadius.setEnabled(true);
         inputSideLength.setEnabled(true);
         inputStartPoint.setEnabled(true);
         inputWidth.setEnabled(true);
    }
    
    protected void updateFields(String shapeSelected) {
         lblRadius.setVisible("Circle".equals(shapeSelected));
         inputRadius.setVisible("Circle".equals(shapeSelected));

         lblStartPoint.setVisible("Line".equals(shapeSelected));
         inputStartPoint.setVisible("Line".equals(shapeSelected));
         btnStartPoint.setVisible("Line".equals(shapeSelected));
         lblEndPoint.setVisible("Line".equals(shapeSelected));
         inputEndPoint.setVisible("Line".equals(shapeSelected));
         btnEndPoint.setVisible("Line".equals(shapeSelected));


         lblWidth.setVisible("Rectangle".equals(shapeSelected));
         inputWidth.setVisible("Rectangle".equals(shapeSelected));
         lblHeight.setVisible("Rectangle".equals(shapeSelected));
         inputHeight.setVisible("Rectangle".equals(shapeSelected));

         lblSideLength.setVisible("Square".equals(shapeSelected));
         inputSideLength.setVisible("Square".equals(shapeSelected));

         lblPosition.setVisible(!"Line".equals(shapeSelected));
         inputPosition.setVisible(!"Line".equals(shapeSelected));   
         btnPosition.setVisible(!"Line".equals(shapeSelected));  

         this.setTitle("Enter " + shapeSelected + " Properties");
         this.setModal(true);
         this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblRadius = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        inputRadius = new javax.swing.JTextField();
        btnCreateShape = new javax.swing.JButton();
        lblPenColor = new javax.swing.JLabel();
        inputPosition = new javax.swing.JTextField();
        chooseColor = new javax.swing.JLabel();
        btnPosition = new javax.swing.JButton();
        lblStartPoint = new javax.swing.JLabel();
        inputStartPoint = new javax.swing.JTextField();
        btnStartPoint = new javax.swing.JButton();
        lblEndPoint = new javax.swing.JLabel();
        inputEndPoint = new javax.swing.JTextField();
        btnEndPoint = new javax.swing.JButton();
        lblWidth = new javax.swing.JLabel();
        inputWidth = new javax.swing.JTextField();
        inputHeight = new javax.swing.JTextField();
        lblHeight = new javax.swing.JLabel();
        lblSideLength = new javax.swing.JLabel();
        inputSideLength = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enter Shape Properties");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(320, 300));
        setPreferredSize(new java.awt.Dimension(320, 300));
        setSize(new java.awt.Dimension(320, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblRadius.setBackground(new java.awt.Color(102, 255, 153));
        lblRadius.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRadius.setForeground(new java.awt.Color(0, 0, 0));
        lblRadius.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRadius.setText("Radius");
        lblRadius.setToolTipText("");
        lblRadius.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRadius.setOpaque(true);
        lblRadius.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        getContentPane().add(lblRadius, gridBagConstraints);

        lblPosition.setBackground(new java.awt.Color(102, 255, 153));
        lblPosition.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPosition.setForeground(new java.awt.Color(0, 0, 0));
        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPosition.setText("Position");
        lblPosition.setToolTipText("");
        lblPosition.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPosition.setOpaque(true);
        lblPosition.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(lblPosition, gridBagConstraints);

        inputRadius.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputRadius.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 18, 0, 6);
        getContentPane().add(inputRadius, gridBagConstraints);

        btnCreateShape.setBackground(new java.awt.Color(0, 0, 0));
        btnCreateShape.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCreateShape.setForeground(new java.awt.Color(204, 204, 204));
        btnCreateShape.setText("Create Shape");
        btnCreateShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateShapeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 88, 20, 0);
        getContentPane().add(btnCreateShape, gridBagConstraints);

        lblPenColor.setBackground(new java.awt.Color(102, 255, 153));
        lblPenColor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPenColor.setForeground(new java.awt.Color(0, 0, 0));
        lblPenColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenColor.setText("Pen Color");
        lblPenColor.setToolTipText("");
        lblPenColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPenColor.setOpaque(true);
        lblPenColor.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(lblPenColor, gridBagConstraints);

        inputPosition.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputPosition.setPreferredSize(new java.awt.Dimension(98, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(inputPosition, gridBagConstraints);

        chooseColor.setBackground(new java.awt.Color(0, 0, 0));
        chooseColor.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        chooseColor.setForeground(new java.awt.Color(204, 204, 204));
        chooseColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseColor.setText("(Press to Change Color)");
        chooseColor.setOpaque(true);
        chooseColor.setPreferredSize(new java.awt.Dimension(126, 30));
        chooseColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseColorMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 6);
        getContentPane().add(chooseColor, gridBagConstraints);

        btnPosition.setText("...");
        btnPosition.setToolTipText("Press to select position by clicking on canvas.");
        btnPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPositionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = -5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 4, 0, 0);
        getContentPane().add(btnPosition, gridBagConstraints);

        lblStartPoint.setBackground(new java.awt.Color(102, 255, 153));
        lblStartPoint.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStartPoint.setForeground(new java.awt.Color(0, 0, 0));
        lblStartPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStartPoint.setText("Start Point");
        lblStartPoint.setToolTipText("");
        lblStartPoint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblStartPoint.setOpaque(true);
        lblStartPoint.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(lblStartPoint, gridBagConstraints);

        inputStartPoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputStartPoint.setPreferredSize(new java.awt.Dimension(98, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(inputStartPoint, gridBagConstraints);

        btnStartPoint.setText("...");
        btnStartPoint.setToolTipText("Press to select position by clicking on canvas.");
        btnStartPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartPointActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 4, 0, 0);
        getContentPane().add(btnStartPoint, gridBagConstraints);

        lblEndPoint.setBackground(new java.awt.Color(102, 255, 153));
        lblEndPoint.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEndPoint.setForeground(new java.awt.Color(0, 0, 0));
        lblEndPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndPoint.setText("End Point");
        lblEndPoint.setToolTipText("");
        lblEndPoint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblEndPoint.setOpaque(true);
        lblEndPoint.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(lblEndPoint, gridBagConstraints);

        inputEndPoint.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputEndPoint.setPreferredSize(new java.awt.Dimension(98, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(inputEndPoint, gridBagConstraints);

        btnEndPoint.setText("...");
        btnEndPoint.setToolTipText("Press to select position by clicking on canvas.");
        btnEndPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndPointActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = -5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(20, 4, 0, 0);
        getContentPane().add(btnEndPoint, gridBagConstraints);

        lblWidth.setBackground(new java.awt.Color(102, 255, 153));
        lblWidth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblWidth.setForeground(new java.awt.Color(0, 0, 0));
        lblWidth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWidth.setText("Width");
        lblWidth.setToolTipText("");
        lblWidth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblWidth.setOpaque(true);
        lblWidth.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(lblWidth, gridBagConstraints);

        inputWidth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputWidth.setMaximumSize(new java.awt.Dimension(68, 26));
        inputWidth.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 6);
        getContentPane().add(inputWidth, gridBagConstraints);

        inputHeight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputHeight.setMaximumSize(new java.awt.Dimension(68, 26));
        inputHeight.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 6);
        getContentPane().add(inputHeight, gridBagConstraints);

        lblHeight.setBackground(new java.awt.Color(102, 255, 153));
        lblHeight.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHeight.setForeground(new java.awt.Color(0, 0, 0));
        lblHeight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeight.setText("Height");
        lblHeight.setToolTipText("");
        lblHeight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHeight.setOpaque(true);
        lblHeight.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(lblHeight, gridBagConstraints);

        lblSideLength.setBackground(new java.awt.Color(102, 255, 153));
        lblSideLength.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSideLength.setForeground(new java.awt.Color(0, 0, 0));
        lblSideLength.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSideLength.setText("Side Length");
        lblSideLength.setToolTipText("");
        lblSideLength.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblSideLength.setOpaque(true);
        lblSideLength.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(lblSideLength, gridBagConstraints);

        inputSideLength.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputSideLength.setMaximumSize(new java.awt.Dimension(68, 26));
        inputSideLength.setPreferredSize(new java.awt.Dimension(126, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 6);
        getContentPane().add(inputSideLength, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCreateShapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateShapeActionPerformed
        positionMode = "off";
        Shape shape = null;
        Point userPosition = null;
        String textPosition;
        switch (shapeSelected) {
            case "Circle":
            String textRadius = inputRadius.getText().strip();
            textPosition = inputPosition.getText().strip();
            if(textRadius.equals("") || textPosition.equals("")) {
                JOptionPane.showMessageDialog(null, "Some fields are Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                try {
                    double radius = Double.parseDouble(textRadius);
                    if(radius<=0)
                    throw new NumberFormatException();
                    else {
                        shape = new Circle();
                        try {
                            String[] xy = textPosition.split(",\\s*");
                            if(xy.length > 2 || xy.length == 0)
                            throw new ArrayIndexOutOfBoundsException();
                            userPosition = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
                            shape.setProperties(Map.of("radius", radius));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            JOptionPane.showMessageDialog(null, "Incorrect format for position used. Please enter position (x, y) formatted.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter positive radius and position number values.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            break;
            case "Line":
            String textStartPoint = inputStartPoint.getText().strip();
            String textEndPoint = inputEndPoint.getText().strip();
            if(textStartPoint.equals("") || textEndPoint.equals("")) {
                JOptionPane.showMessageDialog(null, "Some fields are Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                shape = new LineSegment();
                try {
                    String[] xy;
                    xy = textStartPoint.split(",\\s*");
                    if(xy.length > 2 || xy.length == 0)
                    throw new ArrayIndexOutOfBoundsException();
                    userPosition = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));

                    xy = textEndPoint.split(",\\s*");
                    if(xy.length > 2 || xy.length == 0)
                    throw new ArrayIndexOutOfBoundsException();
                    shape.setProperties(Map.of("endX", Double.parseDouble(xy[0])));
                    shape.setProperties(Map.of("endY", Double.parseDouble(xy[1])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Incorrect format for points used. Please enter position points (x, y) formatted.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number for start and end point values.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            break;
            case "Square":
            String textSideLength = inputSideLength.getText().strip();
            textPosition = inputPosition.getText().strip();
            if(textSideLength.equals("") || textPosition.equals("")) {
                JOptionPane.showMessageDialog(null, "Some fields are Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                try {
                    double sideLength = Integer.parseInt(textSideLength);
                    if(sideLength<=0)
                    throw new NumberFormatException();
                    else {
                        shape = new Square();
                        try {
                            String[] xy = textPosition.split(",\\s*");
                            if(xy.length > 2 || xy.length == 0)
                            throw new ArrayIndexOutOfBoundsException();
                            userPosition = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
                            shape.setProperties(Map.of("sideLength", sideLength));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            JOptionPane.showMessageDialog(null, "Incorrect format for position used. Please enter position (x, y) formatted.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter positive side length and position number values.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            break;
            case "Rectangle":
            String textWidth = inputWidth.getText().strip();
            String textHeight = inputHeight.getText().strip();
            textPosition = inputPosition.getText().strip();
            if(textWidth.equals("") || textHeight.equals("")) {
                JOptionPane.showMessageDialog(null, "Some fields are Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else {
                try {
                    double width = Integer.parseInt(textWidth);
                    double height = Integer.parseInt(textHeight);
                    if(width<=0 || height<=0)
                    throw new NumberFormatException();
                    else {
                        shape = new Rectangle();
                        try {
                            String[] xy = textPosition.split(",\\s*");
                            if(xy.length > 2 || xy.length == 0)
                            throw new ArrayIndexOutOfBoundsException();
                            userPosition = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
                            shape.setProperties(Map.of("width", width, "height", height));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            JOptionPane.showMessageDialog(null, "Incorrect format for position used. Please enter position (x, y) formatted.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter positive width, height and position number values.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            break;
        }

        // position out of bounds
        if (mainWindow.isPositionOutOfBounds(userPosition)) {
            JOptionPane.showMessageDialog(null, "Position is out of bounds!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // for all shapes
        if (shape != null && userPosition != null) {
            shape.setPosition(userPosition);
            shape.setColor(penColor);
            engine.addShape(shape);
            engine.refresh(canvas);
            this.dispose();
            mainWindow.updateComboBox();
        }
    }//GEN-LAST:event_btnCreateShapeActionPerformed

    private void chooseColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseColorMouseClicked
        if(chooseColor.isEnabled()) {
            penColor = JColorChooser.showDialog(null, "Choose a Color", penColor);
            chooseColor.setBackground(penColor);
        }
    }//GEN-LAST:event_chooseColorMouseClicked

    private void btnPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPositionActionPerformed
        selectPositionMode("position");
    }//GEN-LAST:event_btnPositionActionPerformed

    private void btnStartPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartPointActionPerformed
        selectPositionMode("startPoint");
    }//GEN-LAST:event_btnStartPointActionPerformed

    private void btnEndPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndPointActionPerformed
        selectPositionMode("endPoint");
    }//GEN-LAST:event_btnEndPointActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateShape;
    private javax.swing.JButton btnEndPoint;
    private javax.swing.JButton btnPosition;
    private javax.swing.JButton btnStartPoint;
    private javax.swing.JLabel chooseColor;
    private javax.swing.JTextField inputEndPoint;
    private javax.swing.JTextField inputHeight;
    private javax.swing.JTextField inputPosition;
    private javax.swing.JTextField inputRadius;
    private javax.swing.JTextField inputSideLength;
    private javax.swing.JTextField inputStartPoint;
    private javax.swing.JTextField inputWidth;
    private javax.swing.JLabel lblEndPoint;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblPenColor;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblRadius;
    private javax.swing.JLabel lblSideLength;
    private javax.swing.JLabel lblStartPoint;
    private javax.swing.JLabel lblWidth;
    // End of variables declaration//GEN-END:variables
}
