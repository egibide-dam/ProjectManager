package com.proyecto.views;

import com.proyecto.Ciudades;

import javax.swing.*;

public class NuevoProyecto {
    JPanel nuevoProyecto;
    private JLabel matchSearchTitle;
    private JComboBox newCiudadProyecto;
    private JButton cancelarNuevoProyecto;
    private JButton guardarNuevoProyecto;
    private JTextField newNameProyecto;




    public NuevoProyecto(){

        newCiudadProyecto.setModel(new DefaultComboBoxModel<>(Ciudades.values()));


    }
}