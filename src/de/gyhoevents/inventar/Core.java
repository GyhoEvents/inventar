/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gyhoevents.inventar;

import de.gyhoevents.inventar.gui.controllers.GeneralController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import me.Niklas.Client.SichererClient;

/**
 *
 * @author Programmieren
 */
public class Core {

    private SichererClient verbindung;
    private GeneralController maincontroller;
    private static Core instance;

    public Core() {
        instance = this;
        maincontroller = new GeneralController();
        verbindung = new SichererClient("localhost", 12345,maincontroller);
       
        loadWindowStyle();
    }

    public static Core getInstance() {
        return instance;
    }

    public static void loadWindowStyle() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public SichererClient getVerbindung() {
        return verbindung;
    }

    
}
