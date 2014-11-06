/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gyhoevents.inventar.gui.controllers;

import de.gyhoevents.inventar.Core;
import de.gyhoevents.inventar.gui.LoginGui;
import de.gyhoevents.inventar.listeners.network.NetworkListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Programmieren
 */
public class LoginController implements NetworkListener {

    private LoginGui gui;

    public LoginController(LoginGui gui) {
        this.gui = gui;
        Core.getInstance().getVerbindung().addListener(this);
    }

    public void onLoginKlick() {
        if (!gui.username.getText().isEmpty() && !new String(gui.password.getPassword()).isEmpty()) {
            Core.getInstance().getVerbindung().sendeNachricht("login " + gui.username.getText() + " " + new String(gui.password.getPassword()));
        }else{
            JOptionPane.showMessageDialog(null, "Username und Passwort dürfen nicht leer sein !");
        }
    }

    @Override
    public void bearbeiteVerbindungsaufbau() {
        
    }

    @Override
    public void bearbeiteNachricht(String pNachricht) {
        String[] cmd = pNachricht.split(" ");
        if (cmd[0].equalsIgnoreCase("login")) {
            if (cmd[1].equalsIgnoreCase("ok")) {
                JOptionPane.showMessageDialog(null, "Login ok !");
            } else if (cmd[1].equalsIgnoreCase("failed")) {
                JOptionPane.showMessageDialog(null, "Benutzername oder Passwort falsch !");
            }
        }

    }

    @Override
    public void bearbeiteVerbindungsende() {
    }
}
