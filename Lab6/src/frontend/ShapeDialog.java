package frontend;
import backend.*;
import java.awt.Color;
import java.awt.Point;
import java.util.Map;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ShapeDialog extends javax.swing.JDialog {
    private String positionMode;
    private String shapeSelected;
    private final MiniPaintWindow mainWindow;
    private Color penColor;
    private final JComponent[] components;
    
    public ShapeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        positionMode = "off";
        this.mainWindow = (MiniPaintWindow)parent;
        penColor = Color.BLACK; // Default pen color
        this.components = new JComponent[] {
            btnCreateShape, btnEndPoint, btnPosition, btnStartPoint,
            chooseColor, inputEndPoint, inputHeight, inputPosition,
            inputRadius, inputSideLength, inputStartPoint, inputWidth,
            lblEndPoint, lblHeight, lblPenColor, lblPosition,
            lblRadius, lblSideLength, lblStartPoint, lblWidth
        };
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

        for (JComponent component : components) {
            if(!((component instanceof JLabel) && component != chooseColor))
                component.setEnabled(false);
        }
    }
    
    public void resetMode() {
        mainWindow.resetMode();

        for (JComponent component : components) {
            if(!((component instanceof JLabel) && component != chooseColor))
                component.setEnabled(true);
        }
    }
    
    public void updateFields(String shapeSelected) {
        this.shapeSelected = shapeSelected;
        
        // reset inputs
        positionMode = "off";
        inputEndPoint.setText("");
        inputHeight.setText("");
        inputPosition.setText("");
        inputRadius.setText("");
        inputSideLength.setText("");
        inputStartPoint.setText("");
        inputWidth.setText("");
        penColor = Color.BLACK;
        chooseColor.setBackground(penColor);
        
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
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

    // helper method
    private Point parsePoint(String textPosition, String name) {
        String[] xy = textPosition.split(",\\s*");
        if (xy.length != 2)
            throw new IllegalArgumentException("Incorrect format for " + name + " used. Please enter position points (x, y) formatted.");
        try {
            Point point = new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
            return point;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid " + name + " coordinates. Both x and y must be valid integers.");
        }
    }
    
    private void btnCreateShapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateShapeActionPerformed
        positionMode = "off";
        Shape shape = null;
        Point userPosition = null;
        String textPosition = "";
        
        try {
            switch (shapeSelected) {
                case "Circle":
                    String textRadius = inputRadius.getText().strip();
                    textPosition = inputPosition.getText().strip();
                    if(textRadius.equals("") || textPosition.equals(""))
                        throw new IllegalArgumentException("Some fields are empty!");
                    double radius;
                    try {
                        radius = Double.parseDouble(textRadius);
                        if (radius <= 0) 
                            throw new IllegalArgumentException("Radius must be a positive number.");
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Invalid radius. Please enter a valid number.");
                    }
                    userPosition = parsePoint(textPosition, "Position");
                    shape = new Circle();
                    shape.setProperties(Map.of("radius", radius));
                    break;
                case "Line":
                    String textStartPoint = inputStartPoint.getText().strip();
                    String textEndPoint = inputEndPoint.getText().strip();
                    if(textStartPoint.equals("") || textEndPoint.equals(""))
                        throw new IllegalArgumentException("Some fields are empty!");
                    userPosition = parsePoint(textStartPoint, "Start Point");
                    Point endPoint = parsePoint(textEndPoint, "End Point");
                    shape = new LineSegment();
                    shape.setProperties(Map.of("endX", (double)(endPoint.x), "endY", (double)(endPoint.y)));
                    break;
                case "Square":
                    String textSideLength = inputSideLength.getText().strip();
                    textPosition = inputPosition.getText().strip();
                    if(textSideLength.equals("") || textPosition.equals(""))
                        throw new IllegalArgumentException("Some fields are empty!");
                    double sideLength; 
                    try {
                        sideLength = Integer.parseInt(textSideLength);
                        if(sideLength<=0)
                            throw new IllegalArgumentException("Side Length must be a positive number.");
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Invalid side length. Please enter valid numbers.");
                    }
                    userPosition = parsePoint(textPosition, "Position");
                    shape = new Square();
                    shape.setProperties(Map.of("sideLength", sideLength));
                    break;
                case "Rectangle":
                    String textWidth = inputWidth.getText().strip();
                    String textHeight = inputHeight.getText().strip();
                    textPosition = inputPosition.getText().strip();
                    if(textWidth.equals("") || textHeight.equals(""))
                        throw new IllegalArgumentException("Some fields are empty!");
                    double width;
                    double height;
                    try {
                        width = Double.parseDouble(textWidth);
                        height = Double.parseDouble(textHeight);
                        if (width <= 0 || height <= 0) 
                            throw new IllegalArgumentException("Width and Height must be positive numbers.");
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Invalid width or height. Please enter valid numbers.");
                    }
                    if(width<=0 || height<=0)
                        throw new IllegalArgumentException("Width and Height must be positive numbers.");
                    shape = new Rectangle();
                    userPosition = parsePoint(textPosition, "Position");
                    shape.setProperties(Map.of("width", width, "height", height));
                    break;
            }


            // for all shapes
            if (shape != null && userPosition != null) {
                // position out of bounds
                if (mainWindow.isPositionOutOfBounds(userPosition))
                    throw new Exception("Position is out of bounds!");
                shape.setPosition(userPosition);
                shape.setColor(penColor);
                mainWindow.addShape(shape);
                this.setVisible(false);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "  + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        resetMode();
        positionMode = "off";
        dispose();
    }//GEN-LAST:event_formWindowClosing


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
