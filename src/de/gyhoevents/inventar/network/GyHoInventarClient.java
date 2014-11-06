/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventar.network;

import de.gyhoevents.inventar.listeners.network.NetworkListener;
import java.util.ArrayList;
import java.util.List;
import me.Niklas.Client.SichererClient;

/**
 *
 * @author Programmieren
 */
public class GyHoInventarClient extends SichererClient{
    
     private List<NetworkListener> listeners;

    public GyHoInventarClient(String pAdresse, int pPort) {
        super(pAdresse, pPort);
        listeners = new ArrayList<>();
    }
    @Override
    public void bearbeiteNachricht(String pNachricht) {
       // System.out.println("Empfangen: " + pNachricht);
        for (int i = 0, size = listeners.size(); i < size; i++) {
            listeners.get(i).bearbeiteNachricht(pNachricht);
        }

    }

    @Override
    protected void bearbeiteVerbindungsende() {
        for (int i = 0, size = listeners.size(); i < size; i++) {
            listeners.get(i).bearbeiteVerbindungsende();
        }
    }

    @Override
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
}
