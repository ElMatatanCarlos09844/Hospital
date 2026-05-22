/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Cisneros
 */
// Ventana que muestra los médicos registrados en una tabla.
// Sólo sirve para leer los datos guardados en memoria.
public class VentanaConsultas extends JFrame {
    // Guarda la referencia de la ventana anterior para poder volver a ella.
    private JFrame ventanaAnterior;
    // Lista compartida de médicos, la misma usada en la ventana principal y de altas.
    private ArrayList<Medico> listaMedico;

    public VentanaConsultas(JFrame ventanaAnterior, ArrayList<Medico> listaMedicos) {
        this.ventanaAnterior = ventanaAnterior;
        this.listaMedico = listaMedicos;
        
        this.setTitle("Consulta de Médicos");
        // DISPOSE_ON_CLOSE cierra solo esta ventana, no toda la aplicación.
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 450);
        this.setLocationRelativeTo(null); // Centra la ventana.
        BorderLayout border = new BorderLayout(10, 10);
        this.setLayout(border);
        
        // Nombres de las columnas de la tabla.
        String[] columnas = {"Cédula", "Nombre", "Sexo", "Especialidad", "Sub-especialidad", "Sueldo"};
        
        // Modelo de datos que alimenta la vista de la tabla.
        // Cada fila será un médico distinto.
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        // Carga cada médico registrado como una fila en el modelo.
        for (Medico m : listaMedicos) {
            Object[] fila = {
                m.getCedula(),
                m.getNombre(),
                m.getSexo(),
                m.getEspecialidad(),
                m.getSubEspecialidad(),
                "$" + m.getSueldo() // Muestra el sueldo con símbolo de dólares.
            };
            modeloTabla.addRow(fila);
        }

        // Crea la tabla con el modelo de datos.
        JTable tabla = new JTable(modeloTabla);
        // Agrega desplazamiento para manejar listas largas de médicos.
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        // Botón inferior para regresar al menú.
        JButton btnRegresar = new JButton("Regresar al Menú");
        FlowLayout layoutInferior = new FlowLayout();
        JPanel panelInferior = new JPanel(layoutInferior);
        panelInferior.add(btnRegresar);
        add(panelInferior, BorderLayout.SOUTH);

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresar();
            }
        });
    }

    private void regresar(){
        // Vuelve a mostrar la ventana anterior (el menú principal).
        ventanaAnterior.setVisible(true);
        // Cierra esta ventana de consulta para liberar memoria.
        this.dispose();
    }
    
}
