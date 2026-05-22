/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Cisneros
 */
// Ventana principal que muestra el menú de navegación para el sistema.
// Desde aquí el usuario puede ir a registrar nuevos médicos o ver los ya registrados.
public class VentanaPrincipal extends JFrame {
    // Lista que almacena los médicos registrados en memoria.
    // Se comparte con las otras ventanas para que todas vean los mismos datos.
    private ArrayList<Medico> listaMedicos;
    
    public VentanaPrincipal(){
        // Crea la lista vacía cuando se abre la aplicación.
        listaMedicos = new ArrayList<Medico>();
        
        // Configuración básica de la ventana principal.
        this.setTitle("Administración del Hospital - Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra toda la app al cerrar esta ventana.
        this.setSize(500, 300);
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        // Organiza los componentes en tres filas con un espacio fijo entre ellos.
        GridLayout gridLayout = new GridLayout(3, 1, 10, 10);
        this.setLayout(gridLayout);
        
        // Título visible en el centro de la ventana.
        JLabel titulo = new JLabel("Sistema de Gestión de Médicos", JLabel.CENTER);
        Font fuente = new Font("Arial", Font.BOLD, 20);
        titulo.setFont(fuente);
        
        // Botones que llevan a cada funcionalidad.
        JButton botonAltas = new JButton("Alta de Médicos");
        JButton botonConsultas = new JButton("Consultar Médicos");
        
        this.add(titulo);
        this.add(botonAltas);
        this.add(botonConsultas);
        
        botonAltas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana de altas usando esta ventana como referencia padre.
                // El padre se usa para regresar aquí después.
                VentanaAltas ventanaAltas = new VentanaAltas(VentanaPrincipal.this, listaMedicos);
                ventanaAltas.setVisible(true);
                // Oculta el menú principal mientras se registra un nuevo médico.
                setVisible(false);
            }
        });
        
        botonConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana de consulta con la lista compartida.
                VentanaConsultas ventanaConsultas = new VentanaConsultas(VentanaPrincipal.this, listaMedicos);
                ventanaConsultas.setVisible(true);
                // Oculta el menú principal mientras se muestra la tabla.
                setVisible(false);
            }
        });
    }
}
