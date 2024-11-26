package frontend;
import backend.*;
import java.awt.Color;
import javax.swing.JColorChooser;

public class ColorDialog extends javax.swing.JDialog {
    private Color penColor;
    private Color fillColor;
    private Shape shape;

    public ColorDialog(java.awt.Frame parent, boolean modal, Shape shape) {
        super(parent, modal);
        initComponents();
        this.shape = shape;
        this.penColor = shape.getColor();
        btnPenColor.setBackground(penColor);
        this.fillColor = shape.getFillColor();
        btnFillColor.setBackground(fillColor);
        lblShapeName.setText(shape.getName());
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPenColor = new javax.swing.JButton();
        lblShapeSelected = new javax.swing.JLabel();
        lblShapeName = new javax.swing.JLabel();
        lblPenColor = new javax.swing.JLabel();
        lblFillColor = new javax.swing.JLabel();
        btnFillColor = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Colorize Selected Shape");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(406, 179));
        setResizable(false);
        setSize(new java.awt.Dimension(406, 179));

        btnPenColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenColorActionPerformed(evt);
            }
        });

        lblShapeSelected.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblShapeSelected.setText("Shape Selected:");

        lblShapeName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblShapeName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblShapeName.setText("Shape Name");

        lblPenColor.setBackground(new java.awt.Color(102, 255, 153));
        lblPenColor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPenColor.setForeground(new java.awt.Color(0, 0, 0));
        lblPenColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenColor.setText("Pen Color");
        lblPenColor.setToolTipText("");
        lblPenColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPenColor.setOpaque(true);
        lblPenColor.setPreferredSize(new java.awt.Dimension(126, 30));

        lblFillColor.setBackground(new java.awt.Color(102, 255, 153));
        lblFillColor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFillColor.setForeground(new java.awt.Color(0, 0, 0));
        lblFillColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFillColor.setText("Fill Color");
        lblFillColor.setToolTipText("");
        lblFillColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFillColor.setOpaque(true);
        lblFillColor.setPreferredSize(new java.awt.Dimension(126, 30));

        btnFillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFillColorActionPerformed(evt);
            }
        });

        btnDone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblShapeSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblShapeName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPenColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPenColor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblShapeName, lblShapeSelected});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShapeName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblShapeSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPenColor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPenColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblShapeName, lblShapeSelected});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPenColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenColorActionPerformed
        penColor = JColorChooser.showDialog(null, "Choose Pen Color", penColor);
        btnPenColor.setBackground(penColor);
    }//GEN-LAST:event_btnPenColorActionPerformed

    private void btnFillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFillColorActionPerformed
        fillColor = JColorChooser.showDialog(null, "Choose Fill Color", fillColor);
        btnFillColor.setBackground(fillColor);
    }//GEN-LAST:event_btnFillColorActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        shape.setColor(penColor);
        shape.setFillColor(fillColor);
        this.dispose();
    }//GEN-LAST:event_btnDoneActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnFillColor;
    private javax.swing.JButton btnPenColor;
    private javax.swing.JLabel lblFillColor;
    private javax.swing.JLabel lblPenColor;
    private javax.swing.JLabel lblShapeName;
    private javax.swing.JLabel lblShapeSelected;
    // End of variables declaration//GEN-END:variables
}
