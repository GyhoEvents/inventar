/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.Niklas.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programmieren
 */
public class SichererClient {
    
    private Socket client;
    public  MessageLoop ml;
    
    
    public SichererClient(String pAdresse, int pPort) {
        try {
            client = new Socket(pAdresse,pPort);
            ml = new MessageLoop(client,this);
            
        } catch (IOException ex) {
            Logger.getLogger(SichererClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        ml.start();
        
    }
    protected void bearbeiteNachricht( String pNachricht){
        
    }
    
    protected void bearbeiteVerbindungsaufbau(){
        
    }
    
    protected void bearbeiteVerbindungsende() {}
  
    
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
