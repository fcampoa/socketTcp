/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mail.sockettcp;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author felix
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost", 5000);

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            while(true) {
                Persona persona = (Persona) entrada.readObject();
            System.out.println(persona.nombre);            
            entrada.close();
            cliente.close();
            break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
