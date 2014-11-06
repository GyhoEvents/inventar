/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.gyhoevents.inventar.listeners.network;

/**
 *
 * @author Programmieren
 */
public interface NetworkListener {
    public void bearbeiteVerbindungsaufbau();
    public void bearbeiteNachricht(String pNachricht);
    public void bearbeiteVerbindungsende();
}
