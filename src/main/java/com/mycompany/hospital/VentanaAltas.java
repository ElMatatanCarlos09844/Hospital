/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana para registrar nuevos médicos en el sistema.
 * 
 * Proporciona un formulario con los siguientes campos:
 * - Cédula de identificación
 * - Nombre completo
 * - Sexo
 * - Especialidad médica
 * - Sub-especialidad
 * - Sueldo
 * 
 * Valida todos los campos antes de guardar y notifica al usuario
 * sobre errores de validación o éxito en la operación.
 * 
 * @author Carlos Cisneros
 * @version 1.0
 * @since 2026-05-21
 */
// Ventana para capturar los datos de un nuevo médico y añadirlo al sistema.
public class VentanaAltas extends JFrame {

    // Guarda la referencia de la ventana anterior para poder volver a mostrarla.
    private JFrame ventanaAnterior;
    // Lista compartida de médicos. Todos los cambios aquí se ven en el resto de la app.
    private ArrayList<Medico> listaMedicos;

    // Componentes del formulario.
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtEspecialidad;
    private JTextField txtSubEspecialidad;
    private JTextField txtSueldo;
    private JComboBox<String> comboSexo;

    public VentanaAltas(JFrame ventanaAnterior, ArrayList<Medico> listaMedico) {
        // Recibe la ventana que abrió esta pantalla y la lista actual de médicos.
        this.ventanaAnterior = ventanaAnterior;
        this.listaMedicos = listaMedico;

        this.setTitle("Alta de Médicos");
        // DISPOSE_ON_CLOSE cierra solo esta ventana, no toda la aplicación.
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 450);
        this.setLocationRelativeTo(null); // Centra la ventana.
        // Layout principal con espacio alrededor para separar los paneles.
        BorderLayout border = new BorderLayout(10, 10);
        this.setLayout(border);

        // Panel del formulario (Campos)
        GridLayout layoutCampos = new GridLayout(6, 2, 5, 5);
        JPanel panelCampos = new JPanel(layoutCampos);
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Para cada etiqueta hay un campo de texto junto a ella.
        JLabel labelCedula = new JLabel("Cédula:");
        txtCedula = new JTextField();
        panelCampos.add(labelCedula);
        panelCampos.add(txtCedula);

        JLabel labelNombre = new JLabel("Nombre Completo:");
        txtNombre = new JTextField();
        panelCampos.add(labelNombre);
        panelCampos.add(txtNombre);

        JLabel labelSexo = new JLabel("Sexo:");
        String[] opcionesSexo = {"Seleccionar", "Masculino", "Femenino", "Otro"};
        comboSexo = new JComboBox<>(opcionesSexo);
        panelCampos.add(labelSexo);
        panelCampos.add(comboSexo);

        JLabel labelEspecialidad = new JLabel("Especialidad:");
        txtEspecialidad = new JTextField();
        panelCampos.add(labelEspecialidad);
        panelCampos.add(txtEspecialidad);

        JLabel labelSubEspecialidad = new JLabel("Sub-especialidad:");
        txtSubEspecialidad = new JTextField();
        panelCampos.add(labelSubEspecialidad);
        panelCampos.add(txtSubEspecialidad);

        JLabel labelSueldo = new JLabel("Sueldo ($):");
        txtSueldo = new JTextField();
        panelCampos.add(labelSueldo);
        panelCampos.add(txtSueldo);

        add(panelCampos, BorderLayout.CENTER);

        // Panel de botones en la parte inferior.
        FlowLayout panelLayout = new FlowLayout();
        JPanel panelBotones = new JPanel(panelLayout);
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnRegresar = new JButton("Regresar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnRegresar);
        add(panelBotones, BorderLayout.SOUTH);

        // Listener para guardar el médico.
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarMedico();
            }
        });

        // Listener para limpiar los campos del formulario.
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Listener para volver al menú principal.
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresar();
            }
        });
    }

    private void guardarMedico() {
        // Validación de campos vacíos
        if (txtCedula.getText().trim().isEmpty()
                || txtNombre.getText().trim().isEmpty()
                || comboSexo.getSelectedIndex() == 0
                || txtEspecialidad.getText().trim().isEmpty()
                || txtSubEspecialidad.getText().trim().isEmpty()
                || txtSueldo.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double sueldo = Double.parseDouble(txtSueldo.getText().trim());

            // Creamos el objeto y lo guardamos en el arreglo dinámico
            Medico nuevoMedico = new Medico(
                    txtCedula.getText().trim(),
                    txtNombre.getText().trim(),
                    comboSexo.getSelectedItem().toString(),
                    txtEspecialidad.getText().trim(),
                    txtSubEspecialidad.getText().trim(),
                    sueldo
            );

            listaMedicos.add(nuevoMedico);
            JOptionPane.showMessageDialog(this, "Médico registrado con éxito.");
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El sueldo debe ser un valor numérico válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        // Restablece todos los campos del formulario al estado inicial.
        txtCedula.setText("");
        txtNombre.setText("");
        comboSexo.setSelectedIndex(0);
        txtEspecialidad.setText("");
        txtSubEspecialidad.setText("");
        txtSueldo.setText("");
    }

    private void regresar() {
        // Muestra de nuevo la ventana anterior y libera esta ventana.
        ventanaAnterior.setVisible(true);
        this.dispose();
    }
}
