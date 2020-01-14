/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.awt.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication7.DispList.FilePath;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hamza
 */
public class ErrorHandle extends javax.swing.JFrame {

    //modify to read an element from rpi files.

    public static String FilePath = "/home/pi/tensorflow1/models/research/object_detection/factures/facture_affichage.txt";
    public File file =  new File(FilePath);
    public int Avocats, Broccoli = 0;
    public int Bananes , Carottes = 0;
    public double Pomme = 0.0;
//RECONFIGURER DOUBLE ET INT EN FONCTION DE LA DETECTION OPTIMALE, FAIRE MODIFS NECESSAIRES SUR LE RESTE DU FICHIER
    public int AvocatsIndex, BananesIndex, PommeIndex, BroccoliIndex, CarottesIndex = 0;
    public double AvocatsPrice = 1.49;
    public double BananesPrice = 1.99;
    public double PommePrice = 2.06;
    public double BroccoliPrice = 2;
    public double CarottesPrice = 2;
    public double AvocatsPriceTTC , BananesPriceTTC, PommePriceTTC, BroccoliPriceTTC, CarottesPriceTTC = 0;
    public String AvocatsType = "piece";
    public String BananesType = "piece";
    public String PommeType = "kg";
    public String BroccoliType = "piece";
    public String CarottesType = "kg";
    /**
     * Creates new form NewJFrame1
     */
    
    public ErrorHandle() {
        initComponents();
        //récupérer les élements de la liste python et affichage
        
        int i = 0;
        try {
                
                BufferedReader br = new BufferedReader(new FileReader(FilePath));
                String firstLine = br.readLine().trim();
                String[] columnsName = firstLine.split("\t");
                DefaultTableModel model;
                model = (DefaultTableModel)jTable1.getModel();
                model.setColumnIdentifiers(columnsName);
                
                Object[] tableLines = br.lines().toArray();
                
                for (Object tableLine : tableLines) {
                    String line = tableLine.toString().trim();
                    String[] dataRow = line.split("\t");
                    model.addRow(dataRow);
                    i = i+1;
                }
            } catch (IOException ex) {
                Logger.getLogger(ErrorHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        System.out.println("Nb lignes dans le tableau : "+i);
        
        for (int j=0 ; j < i ; j++){
            System.out.println("STEP : "+j);
            System.out.println("DETECTED : "+jTable1.getModel().getValueAt(j,2));
            if(jTable1.getModel().getValueAt(j,2).equals("Avocat")){
                Avocats = Integer.parseInt((String) jTable1.getModel().getValueAt(j,0));//PASSER EN DOUBLE OU INT SELON LE CAS !!
                AvocatsIndex = j;
                System.out.println("GET AVOCAT");
                //AvocatsType = String.valueOf(jTable1.getModel().getValueAt(j,1));
                System.out.println("Type de vente : " + AvocatsType);
            }
            if(jTable1.getModel().getValueAt(j,2).equals("banane")){
                Bananes = Integer.parseInt((String)jTable1.getModel().getValueAt(j,0)); //PASSER EN DOUBLE OU INT SELON LE CAS !!
                BananesIndex = j;
                System.out.println("GET BANANE");
                //BananesType = String.valueOf(jTable1.getModel().getValueAt(j,1));
                System.out.println("Type de vente : " + BananesType);
            }
            if(jTable1.getModel().getValueAt(j,2).equals("broccoli")){
                Broccoli = Integer.parseInt((String)jTable1.getModel().getValueAt(j,0)); //PASSER EN DOUBLE OU INT SELON LE CAS !!
                BroccoliIndex = j;
                System.out.println("GET BROCCOLI");
                //BananesType = String.valueOf(jTable1.getModel().getValueAt(j,1));
                System.out.println("Type de vente : " + BroccoliType);
            }
            
            //MODIFIER LE CAS OU POIDS OU PIECE !!
            
            if(jTable1.getModel().getValueAt(j,2).equals("pomme")){
                Pomme = Double.parseDouble((String)jTable1.getModel().getValueAt(j,0)); //PASSER EN DOUBLE OU INT SELON LE CAS !!
                PommeIndex = j;
                System.out.println("GET POMME");
                //PommeType = String.valueOf(jTable1.getModel().getValueAt(j,1));
                System.out.println("Type de vente : " + PommeType);
            }
            if(jTable1.getModel().getValueAt(j,2).equals("carotte")){
                Carottes = Integer.parseInt((String)jTable1.getModel().getValueAt(j,0)); //PASSER EN DOUBLE OU INT SELON LE CAS !!
                CarottesIndex = j;
                System.out.println("GET CARROTES");
                //PommeType = String.valueOf(jTable1.getModel().getValueAt(j,1));
                System.out.println("Type de vente : " + CarottesType );
            } 
        }
        
        jLabel1.setText(String.valueOf(Broccoli));
        jLabel4.setText(String.valueOf(Bananes));
        jLabel6.setText(String.valueOf(Pomme));
        AvocatsPriceTTC = Avocats*AvocatsPrice;
        BananesPriceTTC = Bananes*BananesPrice;
        PommePriceTTC   = Pomme*PommePrice;
        BroccoliPriceTTC = Broccoli*BroccoliPrice;
        
        System.out.println("Nb avocats : " +Avocats);
        System.out.println("Nb Bananes : " +Bananes);
        System.out.println("Nb Pomme: "    +Pomme);
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
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jPanel1.setLayout(null);

        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(580, 383, 30, 30);

        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(490, 383, 30, 30);

        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(640, 290, 150, 170);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(540, 380, 50, 40);

        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(190, 380, 30, 30);

        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(270, 383, 30, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 380, 40, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(360, 380, 80, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 380, 80, 30);

        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(60, 413, 70, 30);

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 410, 80, 30);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setFocusable(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setRequestFocusEnabled(false);

        jTable1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(250, 130, 350, 110);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication7/saisie erreur.png"))); // NOI18N
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

    
   // VALIDER CHANGEMENTS DE LA LISTE MANUELLE
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // add button :
        Broccoli = Broccoli+1;
        BroccoliPriceTTC = BroccoliPrice*Broccoli;
        jLabel1.setText(String.valueOf(Broccoli));
        System.out.println("Broccoli : "+Broccoli);
        System.out.println("Prix Broccoli: "+BroccoliPriceTTC);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // del :
        Broccoli = Broccoli - 1;
        if (Broccoli < 0){
            Broccoli = 0;
        }
        BroccoliPriceTTC = BroccoliPrice*Broccoli;
        jLabel1.setText(String.valueOf(Broccoli));
        System.out.println("Broccoli : "+Broccoli);
        System.out.println("Prix Broccoli : "+BroccoliPriceTTC);
     
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    String newFileFacture = "/home/pi/tensorflow1/models/research/object_detection/factures/facture_affichage.txt";
    // create a write
    File f = new File(FilePath);
        if(f.exists() && !f.isDirectory()) { //GESTION D'ERREUR SI KG ET PIECE
            f.delete();
        // do something
        }
    // create a csv writer
    try (PrintWriter writer = new PrintWriter(new File(newFileFacture))){
        StringBuilder header = new StringBuilder();
        header.append("Qte");
        header.append("\t");
        header.append("Type");
        header.append("\t");
        header.append("Design");
        header.append("\t");
        header.append("Prix/u");
        header.append("\t");
        header.append("Prix HT");
        header.append("\n");
        if (Avocats != 0){
            header.append(String.valueOf(Avocats));
            header.append("\t");
            header.append(AvocatsType);
            header.append("\t");
            header.append("avocat");
            header.append("\t");
            header.append(String.valueOf(AvocatsPrice));
            header.append("\t");
            header.append(String.valueOf(AvocatsPriceTTC));
            header.append("\n");
        }
        if (Bananes != 0){
            header.append(String.valueOf(Bananes));
            header.append("\t");
            header.append(BananesType);
            header.append("\t");
            header.append("banane");
            header.append("\t");
            header.append(String.valueOf(BananesPrice));
            header.append("\t");
            header.append(String.valueOf(BananesPriceTTC));
            header.append("\n");
        }
        if (Pomme != 0){
            header.append(String.valueOf(Pomme));
            header.append("\t");
            header.append(PommeType);
            
            header.append("\t");
            header.append("pomme");
            header.append("\t");
            header.append(String.valueOf(PommePrice));
            header.append("\t");
            header.append(String.valueOf(PommePriceTTC));
            header.append("\n");
        }
        if (Broccoli != 0){
            header.append(String.valueOf(Broccoli));
            header.append("\t");
            header.append(BroccoliType);
            
            header.append("\t");
            header.append("broccoli");
            header.append("\t");
            header.append(String.valueOf(BroccoliPrice));
            header.append("\t");
            header.append(String.valueOf(BroccoliPriceTTC));
            header.append("\n");
        }
        writer.write(header.toString());
        writer.close();
        System.out.println("WRITE CORRECTION DONE");
        TimeUnit.MILLISECONDS.sleep(200);
        
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
        
        this.setVisible(false);  
        new EndType().setVisible(true);
        
    }   catch (FileNotFoundException | InterruptedException ex) {
            Logger.getLogger(ErrorHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Bananes = Bananes+1;
        BananesPriceTTC = BananesPrice*Avocats;
        jLabel4.setText(String.valueOf(Bananes));
        System.out.println("Bananes : "+Bananes);
        System.out.println("Prix Bananes: "+BananesPriceTTC);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Bananes = Bananes - 1;
        if (Bananes < 0){
            Bananes = 0;
        }
        BananesPriceTTC = BananesPrice*Bananes;
        jLabel4.setText(String.valueOf(Bananes));
        System.out.println("Bananes : "+Bananes);
        System.out.println("Prix Bananes : "+BananesPriceTTC);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        //  /home/pi/tensorflow1/models/research/object_detection/hx711/temp/pesee_java.txt is the real path.
        
        File f = new File("/home/pi/tensorflow1/models/research/object_detection/hx711/temp/pesee_java.txt");

        while (!(f.isFile())) { 
            System.out.println("entree dans la boucle de verif du fichier 2");
            try {
                // do something
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println("delai de 1 s");
            } catch (InterruptedException ex) {
                Logger.getLogger(ErrorHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String df = null;
        BufferedReader br1 = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            
            while (df == null) {
                br1 = new BufferedReader(new FileReader(f));
                System.out.println("toujours pas eu de pesee");
                line = br1.readLine();
                df = line;
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println(line);
                jLabel6.setText("Pesee en cours");
            }
        } catch (IOException ex) {
            Logger.getLogger(ErrorHandle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
                Logger.getLogger(ErrorHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        jLabel6.setText(df+"g");
        Pomme = Integer.parseInt(df.trim());
        PommePriceTTC = (Pomme*0.001)*PommePrice;
        
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(ErrorHandle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorHandle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorHandle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorHandle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new ErrorHandle().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
