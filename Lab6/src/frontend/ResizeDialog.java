package frontend;

import backend.*;
import java.awt.Point;
import java.util.Map;
import javax.swing.JOptionPane;

public class ResizeDialog extends javax.swing.JDialog {
    private Shape shape;
    private String type;
    private Map<String, Double> properties;
    private MiniPaintWindow mainWindow;
    
    public ResizeDialog(java.awt.Frame parent, boolean modal, Shape shape) {
        super(parent, modal);
        initComponents();
        mainWindow = (MiniPaintWindow)parent;
        this.shape = shape;
        type = "";
        properties = shape.getProperties();
        setupDialog();
        setVisible(true);
    }
    
    private void setupDialog() {
        lbl1.setVisible(true);
        lbl2.setVisible(true);
        input1.setVisible(true);
        input2.setVisible(true);
        if (shape instanceof Circle) {
            type = "Circle";
            lbl1.setText("Enter New Radius");
            input1.setText(String.valueOf(Math.round(properties.get("radius"))));
            lbl2.setVisible(false);
            input2.setVisible(false);
        }
        else if (shape instanceof LineSegment) {
            type = "Line Segment";
            lbl1.setText("Enter New X2");
            input1.setText(String.valueOf(Math.round(properties.get("endX"))));
            lbl2.setText("Enter New Y2");
            input2.setText(String.valueOf(Math.round(properties.get("endY"))));
        }  
        else if (shape instanceof Square) {
            type = "Square";
            lbl1.setText("Enter New Side Length");
            input1.setText(String.valueOf(Math.round(properties.get("sideLength"))));
            lbl2.setVisible(false);
            input2.setVisible(false);
        }
        else if (shape instanceof Rectangle) {
            type = "Rectangle";
            lbl1.setText("Enter New Width");
            input1.setText(String.valueOf(Math.round(properties.get("width"))));
            lbl2.setText("Enter New Height");
            input2.setText(String.valueOf(Math.round(properties.get("height"))));
        }
        
        setTitle("Resize " + type);
        btnResize.setText("Resize " + type);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnResize = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        input1 = new javax.swing.JTextField();
        input2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        btnResize.setBackground(new java.awt.Color(0, 0, 0));
        btnResize.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnResize.setForeground(new java.awt.Color(204, 204, 204));
        btnResize.setText("Resize Shape");
        btnResize.setAlignmentY(0.0F);
        btnResize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResizeActionPerformed(evt);
            }
        });

        lbl1.setBackground(new java.awt.Color(102, 255, 153));
        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl1.setForeground(new java.awt.Color(0, 0, 0));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Input 1");
        lbl1.setToolTipText("");
        lbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl1.setMinimumSize(new java.awt.Dimension(43, 18));
        lbl1.setOpaque(true);
        lbl1.setPreferredSize(new java.awt.Dimension(43, 18));

        lbl2.setBackground(new java.awt.Color(102, 255, 153));
        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl2.setForeground(new java.awt.Color(0, 0, 0));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("Input 2");
        lbl2.setToolTipText("");
        lbl2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl2.setOpaque(true);
        lbl2.setPreferredSize(new java.awt.Dimension(43, 18));

        input1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input1.setMaximumSize(new java.awt.Dimension(68, 26));

        input2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input2.setMaximumSize(new java.awt.Dimension(68, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnResize)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnResize, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResizeActionPerformed
        String strInput1 = input1.getText().strip();
        String strInput2 = input2.getText().strip();
        try {
            int intInput1 = -1;
            int intInput2 = -1;
                if(strInput1.isEmpty() && strInput2.isEmpty())
                    throw new IllegalArgumentException("Some fields are empty!");
                intInput1 = Integer.parseInt(strInput1);
                if(!strInput2.isEmpty())
                    intInput2 = Integer.parseInt(strInput2);
            switch (type) {
                case "Circle":
                    if(intInput1 <= 0)
                        throw new IllegalArgumentException("Please enter positive integer radius value.");
                    properties.replace("radius", (double)intInput1);
                    break;
                case "Line Segment":
                    if(intInput1 < 0 || intInput2 < 0 || mainWindow.isPositionOutOfBounds(new Point(intInput1, intInput2)))
                        throw new IllegalArgumentException("Please enter integer point values inside range.");
                    properties.replace("endX", (double)intInput1);
                    properties.replace("endY", (double)intInput2);
                    break;
                case "Square":
                    if(intInput1 <= 0)
                        throw new IllegalArgumentException("Please enter positive integer side length value.");
                    properties.replace("sideLength", (double)intInput1);
                    break;
                case "Rectangle":
                    if(intInput1 <= 0 || intInput2 <= 0)
                        throw new IllegalArgumentException("Please enter positive integer width & height values.");
                    properties.replace("width", (double)intInput1);
                    properties.replace("height", (double)intInput2);
                    break;
                default:
                    throw new AssertionError();
            }
            shape.setProperties(properties);
            mainWindow.updateUndoState();
            mainWindow.updateCanvas();
            this.dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnResizeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResize;
    private javax.swing.JTextField input1;
    private javax.swing.JTextField input2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    // End of variables declaration//GEN-END:variables
}
