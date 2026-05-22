/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospital;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Clase principal que arranca la aplicación.
 * Contiene el método main, que es el primer código que se ejecuta.
 */
public class Main {

    public static void main(String[] args) {
        // Inicia la interfaz gráfica en el hilo de eventos de Swing.
        // Esto es importante para que la interfaz responda bien al usuario.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                
                // Crea la ventana principal del sistema y la hace visible.
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }
        });
    }
}
