/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.Niklas.Client;

import de.gyhoevents.inventar.listeners.network.NetworkListener;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programmieren
 */
public class SichererClient {
    
    private Socket client;
    private List<NetworkListener> listeners;
    public  MessageLoop ml;
    
    
    public SichererClient(String pAdresse, int pPort, NetworkListener nl) {
        listeners = new ArrayList<>();
        listeners.add(nl);
        
        try {
            client = new Socket(pAdresse,pPort);
            ml = new MessageLoop(client,this);
            ml.start();
        } catch (IOException ex) {
            bearbeiteVerbindungsende();
        }
    }
  
    
    public void bearbeiteNachricht(String pNachricht) {
       // System.out.println("Empfangen: " + pNachricht);
        for (int i = 0, size = listeners.size(); i < size; i++) {
            listeners.get(i).bearbeiteNachricht(pNachricht);
        }

    }

    
    public void bearbeiteVerbindungsende() {
        
        for (int i = 0, size = listeners.size(); i < size; i++) {
            listeners.get(i).bearbeiteVerbindungsende();
        }
    }

    
    public void bearbeiteVerbindungsaufbau() {

        for (int i = 0, size = listeners.size(); i < size; i++) {
            listeners.get(i).bearbeiteVerbindungsaufbau();
        }
    }

    public void addListener(NetworkListener listener) {
        listeners.add(listener);
    }
    public void removeListener(NetworkListener listener){
        listeners.remove(listener);
    }
  
    
    public void beendeVerbindung(){
        try {
            this.client.close();
            this.ml.istVerbunden = false;
            this.bearbeiteVerbindungsende();
        } catch (IOException ex) {
            Logger.getLogger(SichererClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void sendeNachricht(String Nachricht){
        while(!this.ml.istVerbunden){
            
        }
        
        try {
            this.ml.objectOut.writeObject(this.ml.verschluessele(Nachricht));
            System.out.println(Nachricht);
        } catch (IOException ex) {
            this.bearbeiteVerbindungsende();
            try {
                this.ml.socket.close();
            } catch (IOException ex1) {
                Logger.getLogger(SichererClient.class.getName()).log(Level.SEVERE, null, ex1);
            }
            this.ml.stop();
           // Logger.getLogger(SichererClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
