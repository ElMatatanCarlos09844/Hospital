/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospital;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Clase principal que inicia la aplicación del Sistema de Gestión de Médicos.
 * 
 * Esta clase contiene el método main que arranca la interfaz gráfica de Swing
 * en el hilo de eventos apropiado para garantizar que la GUI sea thread-safe.
 * 
 * @author Carlos Cisneros
 * @version 1.0
 * @since 2026-05-21
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
