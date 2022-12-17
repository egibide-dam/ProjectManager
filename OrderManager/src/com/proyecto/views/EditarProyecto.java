package com.proyecto.views;

import com.proyecto.Ciudades;
import com.proyecto.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarProyecto extends JFrame{
    JPanel editProyecto;
    private JLabel titleEditarProyecto;
    private JComboBox editCiudadProyecto;
    private JButton cancelarEditarProyecto;
    private JButton guardarEditarProyecto;
    private JTextField editNameProyecto;



    public EditarProyecto(){

        setContentPane(editProyecto);

        editCiudadProyecto.setModel(new DefaultComboBoxModel<>(Ciudades.values()));

        titleEditarProyecto.setText("Editar PROY-" + Main.currentProyecto.getIdproyecto());
        editCiudadProyecto.setSelectedItem(Main.currentProyecto.getCiudad());
        editNameProyecto.setText(Main.currentProyecto.getNombre());

        cancelarEditarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarEditarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



    }
}
