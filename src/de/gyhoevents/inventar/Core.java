/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventar;

import de.gyhoevents.inventar.listeners.network.NetworkListener;
import de.gyhoevents.inventar.network.GyHoInventarClient;
import javax.swing.JOptionPane;

/**
 *
 * @author Programmieren
 */
public class Core implements NetworkListener{
    private GyHoInventarClient verbindung;
    
    public Core(){
        verbindung = new GyHoInventarClient("localhost", 12345);
        verbindung.addListener(this);
    }

    @Override
    public void bearbeiteVerbindungsaufbau() {
       // Starte Login 
        
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
