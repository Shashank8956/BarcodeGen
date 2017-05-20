
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
import javax.swing.*;
import java.sql.*;
//import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.text.NumberFormat;
import org.jdesktop.xswingx.PromptSupport;

import java.io.IOException;
import com.itextpdf.text.*;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

public class MainFrame extends javax.swing.JFrame {

    String str1, str2, str3, str = new String();
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/record";
    String user = "root";
    String pass = "root";
    String[] columnNames = {"No", "Model", "Info"};
    int count=1, make=-1;
    String[] IMAGES;
    public MainFrame() {
        initComponents();
        PromptSupport.setPrompt("Month/Year", tfYear);
        PromptSupport.setPrompt("Model", tfModel);
        PromptSupport.setPrompt("Make no", tfNum);
        PromptSupport.setPrompt("Total", tfOfset);
        PromptSupport.setPrompt("Model", tfTab2Model);
        PromptSupport.setPrompt("Model info", tfTab2Corres);
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
        jPanel5 = new javax.swing.JPanel();
        btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfOfset = new javax.swing.JFormattedTextField();
        tfInfo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfYear = new javax.swing.JTextField();
        tfModel = new javax.swing.JTextField();
        tfNum = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tfTab2Model = new javax.swing.JTextField();
        tfTab2Corres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab.setMinimumSize(new java.awt.Dimension(564, 345));
        tab.setPreferredSize(new java.awt.Dimension(564, 345));

        jPanel3.setLayout(new java.awt.GridBagLayout());

        lheader.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lheader.setText("BARCODE");
        jPanel3.add(lheader, new java.awt.GridBagConstraints());

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
        tfOfset.setMinimumSize(new java.awt.Dimension(28, 26));
        tfOfset.setPreferredSize(new java.awt.Dimension(28, 26));
        tfOfset.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfOfsetFocusLost(evt);
            }
        });
        tfOfset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOfsetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 55, 20, 7);
        jPanel1.add(tfOfset, gridBagConstraints);

        tfInfo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tfInfo.setText("Information");
        tfInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tfInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tfInfo.setMinimumSize(new java.awt.Dimension(85, 26));
        tfInfo.setPreferredSize(new java.awt.Dimension(85, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 184, 0, 0);
        jPanel1.add(tfInfo, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        tfYear.setMinimumSize(new java.awt.Dimension(30, 27));
        tfYear.setPreferredSize(new java.awt.Dimension(30, 27));
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
        gridBagConstraints.insets = new java.awt.Insets(25, 37, 27, 26);
        jPanel4.add(tfYear, gridBagConstraints);

        tfModel.setMinimumSize(new java.awt.Dimension(30, 27));
        tfModel.setPreferredSize(new java.awt.Dimension(30, 27));
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
        gridBagConstraints.insets = new java.awt.Insets(25, 36, 27, 26);
        jPanel4.add(tfModel, gridBagConstraints);

        tfNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        tfNum.setMinimumSize(new java.awt.Dimension(14, 23));
        tfNum.setPreferredSize(new java.awt.Dimension(14, 23));
        tfNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNumFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 83;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 31, 27, 23);
        jPanel4.add(tfNum, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/barcode/home2.png")), jPanel2, ""); // NOI18N

        jPanel7.setLayout(new java.awt.GridBagLayout());

        tfTab2Model.setMinimumSize(new java.awt.Dimension(30, 26));
        tfTab2Model.setPreferredSize(new java.awt.Dimension(30, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 36, 6, 37);
        jPanel7.add(tfTab2Model, gridBagConstraints);

        tfTab2Corres.setMinimumSize(new java.awt.Dimension(30, 26));
        tfTab2Corres.setPreferredSize(new java.awt.Dimension(30, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 38, 6, 40);
        jPanel7.add(tfTab2Corres, gridBagConstraints);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.", "Model", "Info"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table1.setColumnSelectionAllowed(true);
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);
        table1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table1.getAccessibleContext().setAccessibleName("");

        jPanel8.setLayout(new java.awt.GridBagLayout());

        btnAdd.setText("Add Entry");
        btnAdd.setMaximumSize(new java.awt.Dimension(84, 29));
        btnAdd.setMinimumSize(new java.awt.Dimension(84, 29));
        btnAdd.setName(""); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(84, 29));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 125, 9, 123);
        jPanel8.add(btnAdd, gridBagConstraints);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Delete Selected");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 26, 6, 20);
        jPanel9.add(jButton1, gridBagConstraints);

        jButton2.setText("Clear All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 26, 5, 20);
        jPanel9.add(jButton2, gridBagConstraints);

        jButton3.setText("Edit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 26, 4, 20);
        jPanel9.add(jButton3, gridBagConstraints);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
        );

        tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/barcode/stack2.png")), jPanel6, "Model Matrix"); // NOI18N

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
        JFrame jf = new JFrame();
        String code, path;
        if(str1!=null && str2!=null && str3!=null && make!=-1)
        {
            try {
                int input = JOptionPane.showConfirmDialog(jf
                    , "Print for " + str + "?"
                    ,"Confirm print"
                    ,JOptionPane.YES_NO_OPTION);
        
            if(input == JOptionPane.YES_OPTION)
                {
                    IMAGES = new String[count];
                    for(int i=0; i<count; i++)
                    {   
                        System.out.println(make);
                        code = str1 + str2 + (make+i);
                        path = "C:\\Users\\Spongebob\\Desktop\\" + code + ".jpg";
                        IMAGES[i] = path;
                        System.out.println("hi");
                        Code128 barcode = new Code128();                            //Barcode Type
                        barcode.setData(code);                                      //Barcode String
                        barcode.setX(2);                                            //Barcode data text to encode
                        barcode.setBarcodeWidth(350f);
                        barcode.setBarcodeHeight(50f);
                    
                        // Generate barcode & encode into JPG format
                        barcode.drawBarcode(path);

                        //Append that additional info
                        BufferedImage image = null;
                        image = ImageIO.read(new File(path));
                        Graphics2D g = (Graphics2D) image.getGraphics();
                        g.setFont(new Font("default", Font.PLAIN, 12));
                        g.setColor(Color.BLACK);
                        g.drawString("WSOS", 300, 45);
                        g.dispose();

                        ImageIO.write(image, "jpg", new File(path));
                    }
                    manipulatePdf("C:\\Users\\Spongebob\\Desktop\\BarcodePDF.pdf");
                    System.exit(0);                                             // Replace this by jf.dispose();
                    }
            else {
                jf.dispose();
            }
            } catch (Exception ex) {} 
        }
        else
        {
            JOptionPane.showMessageDialog(jf, "Fill all details!"); 
        }
        
    }//GEN-LAST:event_btnActionPerformed

    private void tfOfsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOfsetActionPerformed

    }//GEN-LAST:event_tfOfsetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        createTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfOfsetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOfsetFocusLost
        String Ofset = tfOfset.getText();
        count = Integer.parseInt(Ofset);
        System.out.println(count);
        
    }//GEN-LAST:event_tfOfsetFocusLost

    private void tfYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfYearFocusLost
        str1 = tfYear.getText();
        str1 = str1.toUpperCase();
        str = str1;
        lheader.setText(str);
    }//GEN-LAST:event_tfYearFocusLost

    private void tfModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfModelFocusLost
        str2 = tfModel.getText();
        str2 = str2.toUpperCase();
        str = str1 + str2;
        lheader.setText(str);
        tfInfo.setText("wsos");
    }//GEN-LAST:event_tfModelFocusLost

    private void tfNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNumFocusLost
        str3 = tfNum.getText();
        make = Integer.parseInt(str3);
        str = str1 + str2 + str3;
        lheader.setText(str);
    }//GEN-LAST:event_tfNumFocusLost

    private void manipulatePdf(String dest) throws Exception {
        Image image = new Image(ImageDataFactory.create(IMAGES[0]));
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc, new PageSize(image.getImageWidth(), image.getImageHeight()));
        
        for (int i = 0; i < IMAGES.length; i++) {
            image = new Image(ImageDataFactory.create(IMAGES[i]));
            //image.setWidthPercent(80);
            pdfDoc.addNewPage(new PageSize(image.getImageWidth(), image.getImageHeight()));
            image.setFixedPosition(i + 1, 0, 0);                                // No need to set image position
            doc.add(image);                                                     //since each image is in new page
            File file = new File(IMAGES[i]);
            file.delete();
        }
        doc.close();
    }
    
    private void createTable()                                                  // Table + Database = Tab2
    {
        try 
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, user, pass);
        } catch(Exception err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lheader;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable table1;
    private javax.swing.JLabel tfInfo;
    private javax.swing.JTextField tfModel;
    private javax.swing.JFormattedTextField tfNum;
    private javax.swing.JFormattedTextField tfOfset;
    private javax.swing.JTextField tfTab2Corres;
    private javax.swing.JTextField tfTab2Model;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables

}
