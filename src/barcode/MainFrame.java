
package barcode;

import com.onbarcode.barcode.Code128;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jdesktop.xswingx.PromptSupport;

public class MainFrame extends javax.swing.JFrame {

    String str1, str2, str3, str = new String();
    int count=0;
    public MainFrame() {
        initComponents();
        PromptSupport.setPrompt("Month/Year", tfYear);
        PromptSupport.setPrompt("Model", tfModel);
        PromptSupport.setPrompt("Make no", tfNum);
        PromptSupport.setPrompt("Total", tfOfset);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        tab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lheader = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfYear = new javax.swing.JTextField();
        tfModel = new javax.swing.JTextField();
        tfNum = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfOfset = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab.setMinimumSize(new java.awt.Dimension(564, 345));
        tab.setPreferredSize(new java.awt.Dimension(564, 345));

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lheader.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lheader.setText("BARCODE");
        jPanel3.add(lheader, new java.awt.GridBagConstraints());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        tfYear.setMinimumSize(new java.awt.Dimension(30, 28));
        tfYear.setPreferredSize(new java.awt.Dimension(30, 28));
        tfYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfYearFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 28, 39, 23);
        jPanel4.add(tfYear, gridBagConstraints);

        tfModel.setMinimumSize(new java.awt.Dimension(30, 28));
        tfModel.setPreferredSize(new java.awt.Dimension(30, 28));
        tfModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfModelFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 26, 39, 24);
        jPanel4.add(tfModel, gridBagConstraints);

        tfNum.setMinimumSize(new java.awt.Dimension(30, 28));
        tfNum.setPreferredSize(new java.awt.Dimension(30, 28));
        tfNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNumFocusLost(evt);
            }
        });
        tfNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 26, 39, 24);
        jPanel4.add(tfNum, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        btn.setText("Print");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        jPanel5.add(btn, new java.awt.GridBagConstraints());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        tfOfset.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        tfOfset.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfOfset.setMinimumSize(new java.awt.Dimension(27, 26));
        tfOfset.setPreferredSize(new java.awt.Dimension(27, 26));
        tfOfset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOfsetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 305, 20, 25);
        jPanel1.add(tfOfset, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/barcode/Home.png")), jPanel2, ""); // NOI18N
        tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/barcode/Stack.png")), jScrollPane1); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab.getAccessibleContext().setAccessibleName("tab");
        tab.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        Code128 barcode = new Code128();     //Barcode Type
        barcode.setData(str);                //Barcode String
        barcode.setX(2);                     //Barcode data text to encode
        barcode.setBarcodeWidth(350f);
        barcode.setBarcodeHeight(50f);
        try {
            // Generate barcode & encode into JPG format
            barcode.drawBarcode("C:\\Users\\Spongebob\\Desktop\\barcode-code128.jpg");

            //Append that additional info
            BufferedImage image = null;
            image = ImageIO.read(new File("C:\\Users\\Spongebob\\Desktop\\barcode-code128.jpg"));
            Graphics2D g = (Graphics2D) image.getGraphics();
            g.setFont(new Font("default", Font.PLAIN, 14));
            g.setColor(Color.BLACK);
            g.drawString("wlsos", 310, 45);
            g.dispose();

            ImageIO.write(image, "png", new File("C:\\Users\\Spongebob\\Desktop\\barcode-code128.jpg"));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnActionPerformed

    private void tfModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfModelFocusLost
        str2 = tfModel.getText();
        str = str1 + str2;
        lheader.setText(str);
    }//GEN-LAST:event_tfModelFocusLost

    private void tfYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfYearFocusLost

        str1 = tfYear.getText();
        if(str1!=null)
        {
            str = str1;
            lheader.setText(str1);
        }
        else
        {
            lheader.setText("BARCODE");
        }
    }//GEN-LAST:event_tfYearFocusLost

    private void tfNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNumFocusLost
        str3 = tfNum.getText();
        str = str1 + str2 + str3;
        lheader.setText(str);
    }//GEN-LAST:event_tfNumFocusLost

    private void tfNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumActionPerformed

    private void tfOfsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOfsetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfOfsetActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mf = new MainFrame();
                mf.setResizable(false);
                mf.setLocationRelativeTo(null);
                mf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lheader;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTextField tfModel;
    private javax.swing.JTextField tfNum;
    private javax.swing.JFormattedTextField tfOfset;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables

}
