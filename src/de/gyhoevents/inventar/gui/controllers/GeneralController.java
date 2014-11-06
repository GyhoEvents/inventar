/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventar.gui.controllers;

import de.gyhoevents.inventar.gui.LoginGui;
import de.gyhoevents.inventar.listeners.network.NetworkListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Programmieren
 */
public class GeneralController implements NetworkListener{
   
   

    public GeneralController() {
 
    }
    

    @Override
    public void bearbeiteVerbindungsaufbau() {
       // Starte Login 
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGui().setVisible(true);;
            }
        });

    }

    @Override
    public void bearbeiteNachricht(String pNachricht) {

    }

    @Override
    public void bearbeiteVerbindungsende() {
        JOptionPane.showMessageDialog(null, "Verbindung zum Server verloren !");
        System.exit(0);
    }
}
