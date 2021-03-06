/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventar.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Inge
 */
public class HauptGui extends javax.swing.JFrame {

    /**
     * Creates new form HauptGui
     */
    
    
    public HauptGui() {
        initComponents();
        
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setBounds(0,0,screenSize.width, screenSize.height - 40);
      setVisible(true);
      try {
            BufferedImage  img = ImageIO.read(getClass().getResource("/de/gyhoevents/inventar/media/logo.png"));
            Image dimg = img.getScaledInstance(this.jLabel3.getWidth(), this.jLabel3.getHeight(), Image.SCALE_SMOOTH);
            this.jLabel3.setIcon(new ImageIcon(dimg));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
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
        AnfragenAnMich = new javax.swing.JButton();
        Vorhandenes = new javax.swing.JButton();
        AnfragenVonMir = new javax.swing.JButton();
        Geliehenes = new javax.swing.JButton();
        MeinBereich = new javax.swing.JLabel();
        MeineAusleihungen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Abmelden = new javax.swing.JButton();
        Verliehenes = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Material = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Raeume = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        Reservierungen = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Veranstaltungen = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        AnfragenAnMich.setBackground(new java.awt.Color(255, 255, 255));
        AnfragenAnMich.setText("Anfragen");
        AnfragenAnMich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnfragenAnMichActionPerformed(evt);
            }
        });

        Vorhandenes.setBackground(new java.awt.Color(255, 255, 255));
        Vorhandenes.setText("Was haben wir?");

        AnfragenVonMir.setBackground(new java.awt.Color(255, 255, 255));
        AnfragenVonMir.setText("Anfragen");
        AnfragenVonMir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnfragenVonMirActionPerformed(evt);
            }
        });

        Geliehenes.setBackground(new java.awt.Color(255, 255, 255));
        Geliehenes.setText("Aktuell geliehen");

        MeinBereich.setText("Mein Bereich");

        MeineAusleihungen.setText("Meine Ausleihvorgänge");

        jLabel4.setText("Angemeldet als:");

        jLabel5.setText("[Benutzername]");

        Abmelden.setBackground(new java.awt.Color(255, 255, 255));
        Abmelden.setText("Abmelden");

        Verliehenes.setBackground(new java.awt.Color(255, 255, 255));
        Verliehenes.setText("Aktuell verliehen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(MeineAusleihungen, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MeinBereich, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Verliehenes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Abmelden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AnfragenAnMich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Vorhandenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AnfragenVonMir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Geliehenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MeinBereich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnfragenAnMich)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vorhandenes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Verliehenes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MeineAusleihungen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnfragenVonMir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Geliehenes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(Abmelden)
                .addContainerGap())
        );

        Material.setText("Material");

        jMenuItem1.setText("Suchen");
        Material.add(jMenuItem1);

        jMenuItem2.setText("Hinzufügen");
        Material.add(jMenuItem2);

        jMenuItem3.setText("Loschen");
        Material.add(jMenuItem3);

        jMenuBar1.add(Material);

        Raeume.setText("Räume");

        jMenuItem4.setText("Suchen");
        Raeume.add(jMenuItem4);

        jMenuBar1.add(Raeume);

        Reservierungen.setText("Reservierungen");

        jMenuItem5.setText("Überblick");
        Reservierungen.add(jMenuItem5);

        jMenuItem6.setText("Termine");
        Reservierungen.add(jMenuItem6);

        jMenuBar1.add(Reservierungen);

        Veranstaltungen.setText("Veranstaltungen");

        jMenuItem7.setText("Sommerkonzert");
        Veranstaltungen.add(jMenuItem7);

        jMenuItem8.setText("Weihnachtskonzert");
        Veranstaltungen.add(jMenuItem8);

        jMenuItem9.setText("Sportshow");
        Veranstaltungen.add(jMenuItem9);

        jMenuItem10.setText("Sonstige");
        Veranstaltungen.add(jMenuItem10);

        jMenuBar1.add(Veranstaltungen);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 557, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnfragenVonMirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnfragenVonMirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnfragenVonMirActionPerformed

    private void AnfragenAnMichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnfragenAnMichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnfragenAnMichActionPerformed

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
            java.util.logging.Logger.getLogger(HauptGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HauptGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HauptGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HauptGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HauptGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abmelden;
    private javax.swing.JButton AnfragenAnMich;
    private javax.swing.JButton AnfragenVonMir;
    private javax.swing.JButton Geliehenes;
    private javax.swing.JMenu Material;
    private javax.swing.JLabel MeinBereich;
    private javax.swing.JLabel MeineAusleihungen;
    private javax.swing.JMenu Raeume;
    private javax.swing.JMenu Reservierungen;
    private javax.swing.JMenu Veranstaltungen;
    private javax.swing.JButton Verliehenes;
    private javax.swing.JButton Vorhandenes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
