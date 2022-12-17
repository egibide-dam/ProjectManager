package com.proyecto.views;

import com.proyecto.Ciudades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoProyecto extends JFrame{
    JPanel nuevoProyecto;
    private JLabel matchSearchTitle;
    private JComboBox newCiudadProyecto;
    private JButton cancelarNuevoProyecto;
    private JButton guardarNuevoProyecto;
    private JTextField newNameProyecto;




    public NuevoProyecto(){

        setContentPane(nuevoProyecto);

        newCiudadProyecto.setModel(new DefaultComboBoxModel<>(Ciudades.values()));

        cancelarNuevoProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



    }
}
