/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mail.sockettcp;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 *
 * @author felix
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("servidor iniciado...");

            while (true) {
                Socket clienteConectado = servidor.accept();
                System.out.println("cliente conectado..");
                
                DataInputStream entrada = new DataInputStream(clienteConectado.getInputStream());
                //DataOutputStream salida = new DataOutputStream(clienteConectado.getOutputStream());
                ObjectOutputStream salida = new ObjectOutputStream(clienteConectado.getOutputStream());
                Persona persona = new Persona();
                persona.nombre = "juan";
                salida.writeObject(persona);
                salida.flush();
                
                salida.close();
                entrada.close();
                clienteConectado.close();
                clienteConectado = null;
                break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
