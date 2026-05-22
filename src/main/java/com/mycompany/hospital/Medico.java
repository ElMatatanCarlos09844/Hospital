/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

/**
 * Clase modelo que representa la información de un médico.
 * 
 * Esta clase actúa como un DTO (Data Transfer Object) y almacena
 * los datos personales y profesionales de un médico del hospital.
 * 
 * @author Carlos Cisneros
 * @version 1.0
 */
public class Medico {
    public String cedula; // Cédula de identidad del médico.
    public String nombre; // Nombre completo.
    public String sexo; // Sexo seleccionado en el formulario.
    public String especialidad; // Especialidad médica.
    public String subEspecialidad; // Sub-especialidad médica.
    public double sueldo; // Sueldo como número decimal.

    public Medico(String cedula, String nombre, String sexo, String especialidad, String subEspecialidad, double sueldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sexo = sexo;
        this.especialidad = especialidad;
        this.subEspecialidad = subEspecialidad;
        this.sueldo = sueldo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getSubEspecialidad() {
        return subEspecialidad;
    }

    public double getSueldo() {
        return sueldo;
    }
    
    
}
