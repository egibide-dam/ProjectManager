package com.proyecto.views;

import com.proyecto.Ciudades;

import javax.swing.*;

public class EditarProyecto {
    JPanel editProyecto;
    private JLabel titleEditarProyecto;
    private JComboBox editCiudadProyecto;
    private JButton cancelarEditarProyecto;
    private JButton guardarEditarProyecto;
    private JTextField editNameProyecto;



    public EditarProyecto(){

        editCiudadProyecto.setModel(new DefaultComboBoxModel<>(Ciudades.values()));


    }
}