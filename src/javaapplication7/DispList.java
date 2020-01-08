/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hamza
 */
public class DispList extends javax.swing.JFrame {

    //modify to read an element from rpi files.
    public static String FilePath = "/home/pi/tensorflow1/models/research/object_detection/factures/facture_affichage.txt";
    public File file =  new File(FilePath);
    /**
     * Creates new form NewJFrame1
     */
    public DispList() {
        initComponents();
        try {
                
                BufferedReader br = new BufferedReader(new FileReader(FilePath));
                String firstLine = br.readLine().trim();
                String[] columnsName = firstLine.split("\\t");
                DefaultTableModel model;
                model = (DefaultTableModel)jTable1.getModel();
                model.setColumnIdentifiers(columnsName);
                
                Object[] tableLines = br.lines().toArray();
                
                for (Object tableLine : tableLines) {
                    String line = tableLine.toString().trim();
                    String[] dataRow = line.split("\\t");
                    model.addRow(dataRow);
                }
            } catch (IOException ex) {
                Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(493, 330, 220, 110);

        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(80, 330, 220, 110);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(330, 40, 430, 190);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/ecran_select.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // BOUTON QUITTER LE LOGICIEL
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");  
        Date date = new Date();  
        
        System.out.println(formatter.format(date));  
        
        File afile = new File(FilePath);

        if(afile.renameTo(new File("/home/pi/tensorflow1/models/research/object_detection/factures/archives/facture_of " + date))){
            System.out.println("File is moved successful!");
        }
        else{
            System.out.println("File is failed to move!");
        }
        
        FileWriter myWriterClose = null;
        try {
            myWriterClose = new FileWriter("/home/pi/tensorflow1/models/research/object_detection/ordres/filenameerror.txt");
        } catch (IOException ex) {
            Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myWriterClose.write("1");
        } catch (IOException ex) {
            Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myWriterClose.close();
        } catch (IOException ex) {
            Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);  
        new EndType().setVisible(true);
              // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("/home/pi/tensorflow1/models/research/object_detection/ordres/filename.txt");
        } catch (IOException ex) {
            Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myWriter.write("1");
        } catch (IOException ex) {
            Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Successfully wrote to the file.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(DispList.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("WAIT 1 SEC DONE");
        new DispList().setVisible(true);
        this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DispList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DispList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DispList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DispList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DispList().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
