/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Events.TraductorListener;
import Events.TranslationReadyEvent;
import Traductor.TraductorInt;
import Traductor.TraductorThread;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.*;

/**
 *
 * @author MIRKO
 */
public class Main extends javax.swing.JFrame implements TraductorListener{

    final List<String> idiomas;
    
    public Main() throws RemoteException, NotBoundException {
        initComponents();
        
        this.idiomas = Arrays.asList("Chino","Español", "Inglés", "Indi", "Bengalí", "Portugués", "Ruso", "Japonés", "Francés", "Alemán");
        cargarIdiomas(idiomas);
    }
    private void cargarIdiomas(List idiomas){
        DefaultComboBoxModel model_origen = new DefaultComboBoxModel();
        model_origen.addAll(idiomas);
        DefaultComboBoxModel model_destino = new DefaultComboBoxModel();
        model_destino.addAll(idiomas);
        idiomaOrigenSelector.setModel(model_origen);
        idiomaOrigenSelector.setSelectedIndex(0);
        idiomaDestinoSelector.setModel(model_destino);
        idiomaDestinoSelector.setSelectedIndex(0);
    }
    
    private void traducir(){
        String texto_in = entradaTexto.getText();
        String idioma_origen = (String)idiomaOrigenSelector.getSelectedItem();
        String idioma_destino = (String)idiomaDestinoSelector.getSelectedItem();
        if(texto_in.length() == 0 ) return;
        TraductorThread traduct = new TraductorThread(idioma_origen, texto_in, idioma_destino);
        traduct.addTraductorListener(this);
        traduct.start();
        
        salidaText.setText("traduciendo...");
    }
/**
     * Creates new form Main
     */
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        entradaTexto = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        salidaText = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        invertirButton = new javax.swing.JButton();
        traducirButton = new javax.swing.JButton();
        idiomaOrigenSelector = new javax.swing.JComboBox<>();
        idiomaDestinoSelector = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        entradaTexto.setColumns(20);
        entradaTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        entradaTexto.setLineWrap(true);
        entradaTexto.setRows(5);
        jScrollPane4.setViewportView(entradaTexto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 230));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 338));

        salidaText.setColumns(20);
        salidaText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        salidaText.setLineWrap(true);
        salidaText.setRows(5);
        jScrollPane3.setViewportView(salidaText);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 390, 230));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        invertirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/arrows-right-left-32.png"))); // NOI18N
        invertirButton.setBorder(null);
        invertirButton.setContentAreaFilled(false);
        invertirButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/arrows-right-left-35.png"))); // NOI18N
        invertirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertirButtonActionPerformed(evt);
            }
        });

        traducirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/player-play-filled-32.png"))); // NOI18N
        traducirButton.setBorder(null);
        traducirButton.setContentAreaFilled(false);
        traducirButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/player-play-filled-35.png"))); // NOI18N
        traducirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traducirButtonActionPerformed(evt);
            }
        });

        idiomaOrigenSelector.setBackground(new java.awt.Color(255, 255, 255));
        idiomaOrigenSelector.setForeground(new java.awt.Color(102, 102, 102));
        idiomaOrigenSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Ingles", "Ruso", "Aleman", "Chino" }));
        idiomaOrigenSelector.setBorder(null);
        idiomaOrigenSelector.setOpaque(true);
        idiomaOrigenSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idiomaOrigenSelectorActionPerformed(evt);
            }
        });

        idiomaDestinoSelector.setBackground(new java.awt.Color(255, 255, 255));
        idiomaDestinoSelector.setForeground(new java.awt.Color(102, 102, 102));
        idiomaDestinoSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        idiomaDestinoSelector.setToolTipText("Seleccionar idioma");
        idiomaDestinoSelector.setBorder(null);
        idiomaDestinoSelector.setOpaque(true);
        idiomaDestinoSelector.setPreferredSize(new java.awt.Dimension(375, 46));
        idiomaDestinoSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idiomaDestinoSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(idiomaOrigenSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(invertirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(idiomaDestinoSelector, 0, 267, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(traducirButton)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(traducirButton)
                    .addComponent(idiomaDestinoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idiomaOrigenSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invertirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void traducirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traducirButtonActionPerformed
        traducir();
    }//GEN-LAST:event_traducirButtonActionPerformed

    private void invertirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertirButtonActionPerformed
        String texto_out = salidaText.getText();
        int index_in = idiomaOrigenSelector.getSelectedIndex();
        int index_out = idiomaDestinoSelector.getSelectedIndex();
        
        entradaTexto.setText(texto_out);
        salidaText.setText("");
        idiomaOrigenSelector.setSelectedIndex(index_out);
        idiomaDestinoSelector.setSelectedIndex(index_in);
        
        this.repaint();
        traducir();
    }//GEN-LAST:event_invertirButtonActionPerformed

    private void idiomaOrigenSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idiomaOrigenSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idiomaOrigenSelectorActionPerformed

    private void idiomaDestinoSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idiomaDestinoSelectorActionPerformed
        traducir();
    }//GEN-LAST:event_idiomaDestinoSelectorActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea entradaTexto;
    private javax.swing.JComboBox<String> idiomaDestinoSelector;
    private javax.swing.JComboBox<String> idiomaOrigenSelector;
    private javax.swing.JButton invertirButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea salidaText;
    private javax.swing.JButton traducirButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onTranslationReady(TranslationReadyEvent event) {
        salidaText.setText(event.getResultado());
    }
}
