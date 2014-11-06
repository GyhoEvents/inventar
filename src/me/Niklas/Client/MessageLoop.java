/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.Niklas.Client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Programmieren
 */
public class MessageLoop extends Thread {

    ObjectOutputStream objectOut;
    ObjectInputStream objectIn;
    Socket socket;
    PublicKey server;
    SichererClient client;
    boolean istVerbunden;
    private KeyPair clientKey;
    private SecretKey key;


    public MessageLoop(Socket s, SichererClient client) throws IOException {
        istVerbunden = false;
        
        this.erzeugeKey();
        
        this.client = client;
        socket = s;
        objectOut = new ObjectOutputStream(socket.getOutputStream());
        objectIn = new ObjectInputStream(socket.getInputStream());

    }

    private void erzeugeKey() {
        KeyPairGenerator pairgen;

        try {
            pairgen = KeyPairGenerator.getInstance("RSA");
            pairgen.initialize(1024);
            this.clientKey = pairgen.generateKeyPair();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MessageLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isIstVerbunden() {
        return istVerbunden;
    }

    @Override
    public void run() {
       // System.out.println("ml läuft");
        try {
            this.objectOut.writeObject(this.clientKey.getPublic());
            //System.out.println("key gesendet");
            byte[] b = this.entschluesseleRSA((byte[])this.objectIn.readObject());
            // generiere Key
            key = new SecretKeySpec(b, "AES"); 
            //System.out.println("Key " + new String(key.getEncoded()));
            
            
            this.istVerbunden = true;
            client.bearbeiteVerbindungsaufbau();
            
            while (this.socket.isConnected()) {
                byte[] s = (byte[]) this.objectIn.readObject();
                client.bearbeiteNachricht( this.entschluessele(s));
                //System.out.println(this.entschluessele(s));
            }

        } catch (IOException |ClassNotFoundException ex) {
            if (ex instanceof SocketException || ex instanceof EOFException) {
                try {
                    this.socket.close();
                    client.bearbeiteVerbindungsende();
                } catch (IOException ex1) {
                    Logger.getLogger(MessageLoop.class.getName()).log(Level.SEVERE, null, ex1);
                }

            } else {
                Logger.getLogger(MessageLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
        

    }
    }

    public byte[] entschluesseleRSA(byte[] text) {

        try {
            PrivateKey key = this.clientKey.getPrivate();
            byte[] dectyptedText = null;
            
            // get an RSA cipher object and print the provider
            Cipher cipher = Cipher.getInstance("RSA");

            // decrypt the text using the private key
            cipher.init(Cipher.DECRYPT_MODE, key);
            dectyptedText = cipher.doFinal(text);
            
            
            return dectyptedText;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(MessageLoop.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    public byte[] verschluessele(String text) {

        
        try {
            // Verschluesseln
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(text.getBytes());

            return encrypted;
            
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(MessageLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String entschluessele(byte[] text) {

        
        try {
            // Entschluesseln
            Cipher cipher2 = Cipher.getInstance("AES");
            cipher2.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherData2 = cipher2.doFinal(text);
            return new String(cipherData2);
            
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(MessageLoop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
