package frontend;

import backend.Shape;
import java.awt.Point;
import javax.swing.JOptionPane;

public class MoveDialog extends javax.swing.JDialog {
    private MiniPaintWindow mainWindow;
    private Shape shape;
    public MoveDialog(java.awt.Frame parent, boolean modal, Shape shape) {
        super(parent, modal);
        initComponents();
        mainWindow = (MiniPaintWindow)parent;
        this.shape = shape;
        Point oldPosition = shape.getPosition();
        inputX.setText(String.valueOf(oldPosition.x));
        inputY.setText(String.valueOf(oldPosition.y));
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblY = new javax.swing.JLabel();
        inputX = new javax.swing.JTextField();
        btnMoveShape = new javax.swing.JButton();
        lblX = new javax.swing.JLabel();
        inputY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Move Shape");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        lblY.setBackground(new java.awt.Color(102, 255, 153));
        lblY.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblY.setForeground(new java.awt.Color(0, 0, 0));
        lblY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblY.setText("Enter New Y");
        lblY.setToolTipText("");
        lblY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblY.setOpaque(true);
        lblY.setPreferredSize(new java.awt.Dimension(126, 30));

        inputX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputX.setPreferredSize(new java.awt.Dimension(98, 30));

        btnMoveShape.setBackground(new java.awt.Color(0, 0, 0));
        btnMoveShape.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnMoveShape.setForeground(new java.awt.Color(204, 204, 204));
        btnMoveShape.setText("Move Shape");
        btnMoveShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveShapeActionPerformed(evt);
            }
        });

        lblX.setBackground(new java.awt.Color(102, 255, 153));
        lblX.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblX.setForeground(new java.awt.Color(0, 0, 0));
        lblX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblX.setText("Enter New X");
        lblX.setToolTipText("");
        lblX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblX.setOpaque(true);
        lblX.setPreferredSize(new java.awt.Dimension(126, 30));

        inputY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputY.setPreferredSize(new java.awt.Dimension(98, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputX, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(inputY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnMoveShape)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblY, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoveShape, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void btnMoveShapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveShapeActionPerformed
        String stringX = inputX.getText().strip();
        String stringY = inputY.getText().strip();
        try {
            int x = Integer.parseInt(stringX);
            int y = Integer.parseInt(stringY);
            Point newPosition = new Point(x, y);
            if (mainWindow.isPositionOutOfBounds(newPosition))
                JOptionPane.showMessageDialog(null, "Position is out of bounds!", "Error", JOptionPane.ERROR_MESSAGE);
            else {
                shape.setPosition(newPosition);
                dispose();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Invalid coordinates. Both x and y must be valid integers.", "Error", JOptionPane.ERROR_MESSAGE);    
        }
    }//GEN-LAST:event_btnMoveShapeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoveShape;
    private javax.swing.JTextField inputX;
    private javax.swing.JTextField inputY;
    private javax.swing.JLabel lblX;
    private javax.swing.JLabel lblY;
    // End of variables declaration//GEN-END:variables
}
