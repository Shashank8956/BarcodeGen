
package barcode;

import com.onbarcode.barcode.Code128;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Desktop;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.sql.DriverManager;
import java.text.NumberFormat;
import org.jdesktop.xswingx.PromptSupport;
import java.util.List;
import java.io.IOException;
import com.itextpdf.text.*;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.printing.PDFPageable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.SimpleDoc;
import javax.print.attribute.standard.Copies;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfStamper;
import javax.print.attribute.Attribute;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.*;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.printing.Orientation;


public class MainFrame extends javax.swing.JFrame implements Printable {

    String str1, str2, str3, str, model, info, path1 = new String();
    String driverName = "com.mysql.jdbc.Driver";
    //String driverName = "org.sqlite.JDBC";
    String url = "jdbc:mysql://localhost:3306/mysql";
    //String url = "jdbc:sqlite:sample.db";
    String user = "root";
    String pass = "root";
    String query;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String[] columnNames = {"No", "Model", "Info"};
    String[] columnNames2 = {"No", "Barcode", "Time", "Date"};
    int count=1, make=-1;
    String[] IMAGES;
    JFrame jf = new JFrame();
    ImageIcon printImage;
    
    public MainFrame() {
        initDatabase();
        initComponents();
        createTable();
        createTable2();
        PromptSupport.setPrompt("Month/Year", tfYear);
        PromptSupport.setPrompt("Model", tfModel);
        PromptSupport.setPrompt("Make no", tfNum);
        PromptSupport.setPrompt("Total", tfOfset);
        PromptSupport.setPrompt("Model", tfTab2Model);
        PromptSupport.setPrompt("Model info", tfTab2Corres);
        PromptSupport.setPrompt("Select Output Folder", tfPath);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        tab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lheader = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfOfset = new javax.swing.JFormattedTextField();
        tfInfo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfYear = new javax.swing.JTextField();
        tfModel = new javax.swing.JTextField();
        tfNum = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tfTab2Model = new javax.swing.JTextField();
        tfTab2Corres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        ClearAllBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCode = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        tfPath = new javax.swing.JTextField();
        Savebtn = new javax.swing.JButton();
        btnTab2Print = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Barcode Generator");

        tab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tab.setMinimumSize(new java.awt.Dimension(564, 345));
        tab.setPreferredSize(new java.awt.Dimension(564, 345));

        jPanel3.setOpaque(false);

        lheader.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lheader.setText("BARCODE");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barcode/Raisoni-App-RGI.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barcode/Mahindra-Rise-logo-2560x1440.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(73, 73, 73)
                .addComponent(lheader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lheader)
                .addGap(25, 25, 25))
        );

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btn.setText("Print");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 206, 0, 207);
        jPanel5.add(btn, gridBagConstraints);

        jPanel1.setOpaque(false);
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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 61, 6, 31);
        jPanel1.add(tfOfset, gridBagConstraints);

        tfInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tfInfo.setText("Information");
        tfInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tfInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tfInfo.setMinimumSize(new java.awt.Dimension(85, 26));
        tfInfo.setPreferredSize(new java.awt.Dimension(85, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 207, 0, 0);
        jPanel1.add(tfInfo, gridBagConstraints);

        jLabel8.setText("Count");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 61, 0, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        tfYear.setMinimumSize(new java.awt.Dimension(30, 27));
        tfYear.setPreferredSize(new java.awt.Dimension(30, 27));
        tfYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfYearFocusLost(evt);
            }
        });
        tfYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfYearKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 56, 0, 0);
        jPanel4.add(tfYear, gridBagConstraints);

        tfModel.setMinimumSize(new java.awt.Dimension(30, 27));
        tfModel.setPreferredSize(new java.awt.Dimension(30, 27));
        tfModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfModelFocusLost(evt);
            }
        });
        tfModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfModelKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 62, 0, 0);
        jPanel4.add(tfModel, gridBagConstraints);

        tfNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        tfNum.setMinimumSize(new java.awt.Dimension(14, 23));
        tfNum.setPreferredSize(new java.awt.Dimension(14, 23));
        tfNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNumFocusLost(evt);
            }
        });
        tfNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 83;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 57, 0, 42);
        jPanel4.add(tfNum, gridBagConstraints);

        jLabel4.setText("Year/Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 56, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Model");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 62, 0, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Series");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 57, 0, 0);
        jPanel4.add(jLabel6, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Made by: Shashank Singh, Ashutosh Paliwal and Shivam Singh");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/barcode/home2.png")), jPanel2, ""); // NOI18N

        jPanel7.setLayout(new java.awt.GridBagLayout());

        tfTab2Model.setMinimumSize(new java.awt.Dimension(30, 26));
        tfTab2Model.setPreferredSize(new java.awt.Dimension(30, 26));
        tfTab2Model.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTab2ModelFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 36, 6, 37);
        jPanel7.add(tfTab2Model, gridBagConstraints);

        tfTab2Corres.setMinimumSize(new java.awt.Dimension(30, 26));
        tfTab2Corres.setPreferredSize(new java.awt.Dimension(30, 26));
        tfTab2Corres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTab2CorresFocusLost(evt);
            }
        });
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
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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

        deleteBtn.setText("Delete Selected");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 26, 6, 20);
        jPanel9.add(deleteBtn, gridBagConstraints);

        ClearAllBtn.setText("Clear All");
        ClearAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearAllBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 26, 5, 20);
        jPanel9.add(ClearAllBtn, gridBagConstraints);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        );

        tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/barcode/stack2.png")), jPanel6, "Model Matrix"); // NOI18N

        TableCode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Barcode", "Time", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCode.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableCode);

        jPanel14.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 202;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 56, 0, 0);
        jPanel14.add(tfPath, gridBagConstraints);

        Savebtn.setText("Save Location");
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 69, 0, 56);
        jPanel14.add(Savebtn, gridBagConstraints);

        btnTab2Print.setText("Print Selected");
        btnTab2Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTab2PrintActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 69, 0, 56);
        jPanel14.add(btnTab2Print, gridBagConstraints);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/barcode/rec2.png")), jPanel10); // NOI18N

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

    private void printImg(String dest) throws Exception
    {
        // Input the file
        FileInputStream textStream = null;
        try {
            textStream = new FileInputStream(dest);
        } catch (Exception exp) {
            return;
        }

        DocFlavor myFormat = DocFlavor.INPUT_STREAM.JPEG;
        PageFormat format = new PageFormat();
        format.setOrientation(PageFormat.PORTRAIT);

        Doc myDoc = new SimpleDoc(textStream, myFormat, null);
        // Build a set of attributes
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        // aset.add(new Copies(2));
/******************************************************************************/
//To change image location keep changing the values (10, 10) in the line below
//Don't change anything else. The values must be >=0
/******************************************************************************/
        aset.add(new MediaPrintableArea(10, 10, 300.75f, 500f,
                MediaPrintableArea.INCH));
        aset.add(PrintQuality.HIGH);

        aset.add(new PrinterResolution(900, 1000, PrinterResolution.DPI));
        aset.add(OrientationRequested.PORTRAIT);

        PrintService[] services = PrintServiceLookup.lookupPrintServices(
                myFormat, null);
/******************************************************************************/
//Ashutosh Change the number inside services[] in line 695 and 697
//Make sure they are same and lie between 1 to 5 (inclusive)
//If you get ArrayIndexOutOfBound error, reduce the values by 1
/******************************************************************************/
        if (services.length > 0) {
            DocPrintJob job = services[1].createPrintJob();           
            
            for (Attribute temp : services[1].getAttributes().toArray())
                System.out.println(temp.getName());

            try {
                job.print(myDoc, aset);
            } catch (PrintException pe) {

            }
        }
        
      /*PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));
        PrintService pss[] = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.JPEG, pras);
        if (pss.length == 0)
        throw new RuntimeException("No printer services available.");
        PrintService ps = pss[0];
        pras.add(OrientationRequested.LANDSCAPE);
        System.out.println("Printing to " + ps);
        DocPrintJob job = ps.createPrintJob();
        FileInputStream fin = new FileInputStream(dest);
        Doc doc = new SimpleDoc(fin, DocFlavor.INPUT_STREAM.JPEG, null);
        job.print(doc, pras);
        fin.close();*/
    }
    private void printPdf(String dest) throws Exception
    {
        /*FileInputStream psStream = null;
        try {
            psStream = new FileInputStream(dest);
            } catch (FileNotFoundException ffne) {
              ffne.printStackTrace();
            }
            if (psStream == null) {
                return;
            }
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.PDF;
        Doc myDoc = new SimpleDoc(psStream, psInFormat, null);  
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);
         
        // this step is necessary because I have several printers configured
        PrintService myPrinter = null;
        for (int i = 0; i < services.length; i++){
            
            String svcName = services[i].toString();    
            
            if (svcName.contains("printer closest to me")){
                myPrinter = services[i];
                System.out.println("my printer found: "+svcName);
                break;
            }
        }
         
        if (myPrinter != null) {            
            DocPrintJob job = myPrinter.createPrintJob();
            try {
            job.print(myDoc, aset);
             
            } catch (Exception pe) {pe.printStackTrace();}
        } else {
            JOptionPane.showMessageDialog(jf, "No printer detected!");
        }*/
        
        String filename = dest; 
        PDDocument document = PDDocument.load(new File (filename));

        //takes standard printer defined by OS
        PrintService myPrintService = PrintServiceLookup.lookupDefaultPrintService();
        //new PDPage().setRotation(180);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPageable(new PDFPageable(document , Orientation.LANDSCAPE));
        job.setPrintService(myPrintService);
        if(job.printDialog())
        {
            job.pageDialog(new PageFormat());
            job.print();
        }
        document.close();
    }
    
    private static PrintService findPrintService(String printerName) 
    {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) 
        {
            if (printService.getName().trim().equals(printerName)) 
            {
                return printService;
            }
        }
        return null;
    }  
    
    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        
        try {
            String code, path;
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, user, pass);
            query = "SELECT * from path;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next())
                path1 = rs.getString("Path");
            System.out.println(path1);
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
                            code = str1 + str2 + (make+i);
                            //path = "C:\\Users\\Spongebob\\Desktop\\" + code + ".jpg";
                            path = path1 + code + ".jpg";
                            IMAGES[i] = path;
                            
                            Code128 barcode = new Code128();             //Barcode Type
                            barcode.setData(code);                       //Barcode String
                            barcode.setX(2);                             //Barcode data text to encode
                            //barcode.setBarcodeWidth(-50f);
                            barcode.setLeftMargin(-15);
                            barcode.setRightMargin(-5);
                            barcode.setBarcodeHeight(50f);
                            
// Generate barcode & encode into JPG format
                            barcode.drawBarcode(path);
                            
//Append that additional info
                            BufferedImage image = null;
                            image = ImageIO.read(new File(path));
                            Graphics2D g = (Graphics2D) image.getGraphics();
                            g.setFont(new Font("default", Font.PLAIN, 12));
                            g.setColor(Color.BLACK);
                            g.drawString(info, 220, 45);
                            g.dispose();
                            
                            ImageIO.write(image, "jpg", new File(path));
//Resize image to 70 x 17
                            /*int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
             
                            BufferedImage resizedBuffImg = new BufferedImage(70, 17, type);
                            g = resizedBuffImg.createGraphics();
                            g.drawImage(image, 0, 0, 70, 17, null);
                            g.dispose();
                            ImageIO.write(resizedBuffImg, "jpg", new File(path));
             
                            System.out.println("File created : "+path);
                            
                            Thumbnails.of(image)
                                    .size(250, 150)
                                    .toFile(path);*/
/***********************************/
                            
                            int hour, min, day, month, year;
                            java.util.Date date = new java.util.Date();
                            Calendar cal= Calendar.getInstance();
                            year = cal.get(Calendar.YEAR);
                            month = cal.get(Calendar.MONTH);      // 0 to 11
                            day = cal.get(Calendar.DAY_OF_MONTH);
                            hour = cal.get(Calendar.HOUR_OF_DAY);
                            min = cal.get(Calendar.MINUTE);
                            
                            try {
                                Class.forName(driverName);
                                //Connection con = DriverManager.getConnection(url, user, pass);
                                query = "INSERT into barcode (BARCODE, TIME, DATE) VALUES ('"
                                        + code + "','" + hour + ":" + min + "','"
                                        + day + "/" + month + "/" + year+ "');";
                                ps = con.prepareStatement(query);
                                ps.execute();
                                
                            }catch(Exception e)
                            {
                                System.out.println(e);
                            }
                            
                        }
                        //manipulatePdf("C:\\Users\\Spongebob\\Desktop\\Barcode.pdf");
                        manipulatePdf(path1 + "Barcode.pdf");
                        //rotatePdf(path1);
                        jf.dispose();
//Calls the print function
                        //printPdf(path1+"Barcode.pdf");
                        /*File file = new File(path1 + "Barcode.pdf");
//Next few lines open the PDF to print
                            if(!Desktop.isDesktopSupported()){
                                System.out.println("Desktop is not supported");
                                return;
                            }
                            else
                                System.out.println("Supported");
                            Desktop desktop = Desktop.getDesktop();
                            if(file.exists()) 
                                desktop.open(file);*/
                            
                        createTable2();
                    }
                    else {
                        jf.dispose();
                        createTable2();
                    }
                } catch (Exception ex) {}
            }
            else
            {
                JOptionPane.showMessageDialog(jf, "Fill all details!");
            }
        } catch (Exception ex) { 
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnActionPerformed
    
    private void tfOfsetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOfsetActionPerformed

    }//GEN-LAST:event_tfOfsetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(model!=null && info!=null)
        {
            try 
            {
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, user, pass);
                model=model.toUpperCase();
                info=info.toUpperCase();
                query = "INSERT into Model (Model, Info) VALUES ('" 
                        + model + "','" + info + "');"; 
                ps = con.prepareStatement(query);
                ps.execute();
                JOptionPane.showMessageDialog(null, "Entry Added!", "Successful!", JOptionPane.INFORMATION_MESSAGE);
            
            } catch(Exception err)
            {
                JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally
            {
                System.out.println(model + " " + info);
                createTable();
            }
        }
            else if(model==null || info==null)
            {
                JOptionPane.showMessageDialog(jf, "Fill all details!");
            }
    }//GEN-LAST:event_btnAddActionPerformed

    private void ClearAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearAllBtnActionPerformed
        try 
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, user, pass);
            query = "DROP TABLE Model;";
            ps = con.prepareStatement(query);
            ps.execute();
            
        } catch(Exception err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally
        {
            try 
            {
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, user, pass);
                query = "CREATE TABLE Model ("
                        +"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                        +"Model varchar(3) UNIQUE,"
                        +"Info varchar(15));";
                ps = con.prepareStatement(query);
                ps.execute();
                JOptionPane.showMessageDialog(null, "All data cleared!", "Clear All!", JOptionPane.INFORMATION_MESSAGE);
                
            } catch(Exception err)
            {
                JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }finally
            {
                createTable();
            }
        }
    }//GEN-LAST:event_ClearAllBtnActionPerformed

    private void tfOfsetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfOfsetFocusLost
        String Ofset = tfOfset.getText();
        count = Integer.parseInt(Ofset);
        System.out.println(count);
        
    }//GEN-LAST:event_tfOfsetFocusLost

    private void tfYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfYearFocusLost
        str1 = tfYear.getText();
        if(str1.length()==2)
            {
                str1 = str1.toUpperCase();
                str = str1;
                lheader.setText(str);
            }
        else
        {
            str1=null;
            tfYear.setText(null);
        }
    }//GEN-LAST:event_tfYearFocusLost

    private void tfModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfModelFocusLost
        info = null;
        str2 = tfModel.getText();
        if(str2.length()==3)
        {
            str2 = str2.toUpperCase();
            str = str1 + str2;
            lheader.setText(str);
            try 
            {
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, user, pass);
                query = "SELECT Info from Model where Model ='" 
                        + str2 + "'";
                //System.out.println(query);
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                if(rs.next())
                    info = rs.getString("Info");
                //System.out.println("********"+info);
                if(info==null)
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid model no!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    createTable();
                    tfInfo.setText(info);

                }
            
            } catch(Exception err)
            {
                JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            tfModel.setText(null);
    }//GEN-LAST:event_tfModelFocusLost

    private void tfNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNumFocusLost
        str3 = tfNum.getText();
        if(str3.length()==4)
        {
            make = Integer.parseInt(str3);
            str = str1 + str2 + str3;
            lheader.setText(str);
        }
        else
            tfNum.setText(null);
    }//GEN-LAST:event_tfNumFocusLost

    private void tfTab2ModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTab2ModelFocusLost
        model = tfTab2Model.getText();
        if(model.length()<3)
        {
            model = null;
            tfTab2Model.setText(null);
        }
    }//GEN-LAST:event_tfTab2ModelFocusLost

    private void tfTab2CorresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTab2CorresFocusLost
        info = tfTab2Corres.getText();
    }//GEN-LAST:event_tfTab2CorresFocusLost

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = table1.getSelectedRow();
        String idSel = (String)table1.getValueAt(row, 0);
        if(idSel!=null)
        {
        System.out.print(idSel);
        try 
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, user, pass);
            query = "Delete from Model where id = "  + idSel + ";";
            ps = con.prepareStatement(query);
            ps.execute();
            createTable();
            
        } catch(Exception err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        else
            createTable();
    }//GEN-LAST:event_deleteBtnActionPerformed
/**/
    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        path1 = tfPath.getText();
        if(path1!=null)
        {
            try 
            {
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, user, pass);
                query = "DROP table Path"; 
                ps = con.prepareStatement(query);
                ps.execute();
                
                query = "CREATE TABLE path ("
                        +"PATH varchar(250));"; 
                ps = con.prepareStatement(query);
                ps.execute();
                
                query = "INSERT into Path (PATH) VALUES ('" 
                        + path1 + "');";
                ps = con.prepareStatement(query);
                ps.execute();
                createTable();
            
            } catch(Exception err)
            {
                JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(jf, "Fill all details!");
        }
    }//GEN-LAST:event_SavebtnActionPerformed

    private void tfYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfYearKeyTyped
 
        if (tfYear.getText().length() >= 2 ) // limit to 2 characters
            evt.consume();
    }//GEN-LAST:event_tfYearKeyTyped

    private void tfModelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfModelKeyTyped
        if (tfModel.getText().length() >= 3 ) // limit to 3 characters
            evt.consume();
    }//GEN-LAST:event_tfModelKeyTyped

    private void tfNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumKeyTyped
        if (tfNum.getText().length() >= 4 ) // limit to 3 characters
            evt.consume();
    }//GEN-LAST:event_tfNumKeyTyped

    private void btnTab2PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTab2PrintActionPerformed
        int row = TableCode.getSelectedRow();
        String idSel = (String)TableCode.getValueAt(row, 0);
        System.out.println(idSel);
        if(idSel!=null)
        {
            System.out.print(idSel);
            try 
            {
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, user, pass);
                query = "SELECT * from Barcode where id = "  + idSel + ";";
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                String code=null;
                //if(rs.next()==true)
                rs.next();
                code = rs.getString("Barcode");
                System.out.println(code);
                //if(code!=null)
                {
                    Code128 barcode = new Code128();             //Barcode Type
                    barcode.setData(code);                       //Barcode String
                    barcode.setX(2);                             //Barcode data text to encode
                    //barcode.setBarcodeWidth(-50f);
                    barcode.setLeftMargin(-15);
                    barcode.setRightMargin(-5);
                    barcode.setBarcodeHeight(50f);
                    
// Generate barcode & encode into JPG format
                    barcode.drawBarcode(path1 + code + ".jpg");
                    //System.out.println(path1 + code + ".jpg");
                    
                    String filename = path1 + code + ".jpg"; 
                    ImageIcon img = new javax.swing.ImageIcon(filename);
                    PrintService service = PrintServiceLookup.lookupDefaultPrintService();
                    DocPrintJob job = service.createPrintJob();
                    DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
                    SimpleDoc doc = new SimpleDoc(new MainFrame(), flavor, null);
                    job.print(doc, null);
                    System.out.println("Done");
                    
                }
            } catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnTab2PrintActionPerformed

    public int print(Graphics g, PageFormat pf, int pageIndex) 
    {
        Graphics2D g2d = (Graphics2D) g;
        g.translate((int) (pf.getImageableX()), (int) (pf.getImageableY()));
        if (pageIndex == 0) {
            double pageWidth = pf.getImageableWidth();
            double pageHeight = pf.getImageableHeight();
            double imageWidth = printImage.getIconWidth();
            double imageHeight = printImage.getIconHeight();
            double scaleX = pageWidth / imageWidth;
            double scaleY = pageHeight / imageHeight;
            double scaleFactor = Math.min(scaleX, scaleY);
            g2d.scale(scaleFactor, scaleFactor);
            g.drawImage(printImage.getImage(), 0, 0, null);
            return Printable.PAGE_EXISTS;
        }
        return Printable.NO_SUCH_PAGE;
    }
    
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
            printImg(IMAGES[i]);
            file.delete();
        }
        doc.close();
        //System.out.println("Inside manipulatePdf "+ dest);
        
    }
    
    private void rotatePdf(String dest) throws IOException
    {
        //the number of degrees rotation
       int degrees = 90;
       try {
           System.out.println("Rotating all pages by "+ degrees +" degrees.");

           PdfReader reader = new PdfReader(path1 + "Barcode.pdf");
           for (int p = 1; p <= reader.getNumberOfPages(); ++p) {
               reader.getPageN(p).put(PdfName.ROTATE, new PdfNumber(degrees));
           }
           PdfStamper stp = new PdfStamper(reader, new FileOutputStream(path1 + "Barcode1.pdf"));
           stp.close();
          
       }
       catch (DocumentException e) {
           e.printStackTrace();
       }
       catch (IOException e) {
           e.printStackTrace();
       }
    }
    
    private void initDatabase()
    {
        try
        { 
            Class.forName(driverName); 
            Connection con = DriverManager.getConnection(url, user, pass);
            query = "USE mysql";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "CREATE TABLE IF NOT EXISTS Model ("
                        +"id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                        +"Model varchar(3) UNIQUE,"
                        +"Info varchar(15));";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "CREATE TABLE IF NOT EXISTS Barcode ("
                        +"ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                        +"Barcode varchar(9),"
                        +"Time varchar(5),"
                        +"Date varchar(11));";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "CREATE TABLE IF NOT EXISTS path ("
                        +"Path varchar(250));";
            ps = con.prepareStatement(query);
            ps.execute();
            
            query = "SELECT * from Path;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            path1 = rs.getString("Path");
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void createTable2()                                                  // Table + Database = Tab2
    {
        String bar, time, date, id;
        DefaultTableModel tablemod = new DefaultTableModel();
        tablemod.setColumnIdentifiers(columnNames2);
        TableCode.setModel(tablemod);
        TableCode.setRowSelectionAllowed(true);
        TableCode.setColumnSelectionAllowed(false);

        try
        { 
            Class.forName(driverName); 
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select * from Barcode";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i =0;
            while(rs.next()==true)
            {
                id = rs.getString("id");
                bar = rs.getString("barcode");
                time = rs.getString("time");
                date = rs.getString("date");
                tablemod.addRow(new Object[]{id, bar, time, date});
                i++; 
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                JOptionPane.ERROR_MESSAGE);
            }
            if(i==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void createTable()
    {
        String no, mod, info;
        DefaultTableModel tablemod = new DefaultTableModel();
        tablemod.setColumnIdentifiers(columnNames);
        table1.setModel(tablemod);
        table1.setRowSelectionAllowed(true);
        table1.setColumnSelectionAllowed(false);

        try
        { 
            Class.forName(driverName); 
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select * from Model";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i =0;
            while(rs.next()==true)
            {
                
                no = rs.getString("id");
                mod = rs.getString("model");
                info = rs.getString("info");
                tablemod.addRow(new Object[]{no, mod, info});
                i++; 
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",
                JOptionPane.ERROR_MESSAGE);
            }
            if(i==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
            JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JButton ClearAllBtn;
    private javax.swing.JButton Savebtn;
    private javax.swing.JTable TableCode;
    private javax.swing.JButton btn;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnTab2Print;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lheader;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable table1;
    private javax.swing.JLabel tfInfo;
    private javax.swing.JTextField tfModel;
    private javax.swing.JFormattedTextField tfNum;
    private javax.swing.JFormattedTextField tfOfset;
    private javax.swing.JTextField tfPath;
    private javax.swing.JTextField tfTab2Corres;
    private javax.swing.JTextField tfTab2Model;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables

}
