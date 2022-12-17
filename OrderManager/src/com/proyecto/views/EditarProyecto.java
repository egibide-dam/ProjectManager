package com.proyecto.views;

import com.proyecto.Ciudades;
import com.proyecto.Main;
import com.proyecto.ProveedoresEntity;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

public class EditarProyecto extends JFrame{
    JPanel editProyecto;
    private JLabel titleEditarProyecto;
    private JComboBox editCiudadProyecto;
    private JButton cancelarEditarProyecto;
    private JButton guardarEditarProyecto;
    private JTextField editNameProyecto;


    public void fillForm() {
        editNameProyecto.setEnabled(true);
        editNameProyecto.setText(Main.currentProyecto.getNombre());
        editNameProyecto.setBackground(Main.white);
        editCiudadProyecto.setEnabled(true);
        editCiudadProyecto.setSelectedItem(Ciudades.valueOf(Main.currentProyecto.getCiudad()));
        editCiudadProyecto.setBackground(Main.white);
        guardarEditarProyecto.setEnabled(false);
        cancelarEditarProyecto.setEnabled(true);
    }


    public void disableForm() {
        editNameProyecto.setEnabled(false);
        editCiudadProyecto.setEnabled(false);
        guardarEditarProyecto.setEnabled(false);
        cancelarEditarProyecto.setEnabled(false);
    }

    public EditarProyecto(){

        setContentPane(editProyecto);

        titleEditarProyecto.setText("Editar PROY-" + Main.currentProyecto.getIdproyecto());
        editCiudadProyecto.setModel(new DefaultComboBoxModel<>(Ciudades.values()));
        fillForm();

        editNameProyecto.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updated();
            }

            public void removeUpdate(DocumentEvent e) {
                updated();
            }

            public void insertUpdate(DocumentEvent e) {
                updated();
            }

            public void updated() {
                guardarEditarProyecto.setEnabled(editNameProyecto.getText().length() > 0);
                editNameProyecto.setBackground(Main.white);
            }
        });


        editNameProyecto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(editNameProyecto.getText().length() >= 40) {
                    e.consume();
                    editNameProyecto.setBackground(Main.warn);

                } else {
                    editNameProyecto.setBackground(Main.white);

                }
            }
        });

        editCiudadProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEditarProyecto.setEnabled(true);
                editCiudadProyecto.setBackground(Main.white);
            }
        });

        cancelarEditarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        guardarEditarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEditarProyecto.setEnabled(false);
                cancelarEditarProyecto.setEnabled(false);

                if (editNameProyecto.getText().length() == 0 || editCiudadProyecto.getSelectedIndex() == -1) {

                    if (editNameProyecto.getText().length() == 0) {
                        editNameProyecto.setBackground(Main.error);
                    }

                    if (editCiudadProyecto.getSelectedIndex() == -1) {
                        editCiudadProyecto.setBackground(Main.error);
                    }

                    cancelarEditarProyecto.setEnabled(true);

                } else {
                    disableForm();
                    int id = Main.currentProyecto.getIdproyecto();
                    String name = editNameProyecto.getText();
                    Ciudades ciudad = (Ciudades) editCiudadProyecto.getSelectedItem();
                    if (ProyectoController.editarProyecto(id, name, ciudad.toString())){
                        Main.currentProyecto = ProyectoController.leerProyecto(id);
                        fillForm();
                        JOptionPane.showMessageDialog(null, "Proyecto " + name + " actualizado.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar el proyecto " + Main.currentProyecto.getNombre() + ".", "ERROR", JOptionPane.ERROR_MESSAGE);

                    }
                }

            }
        });



    }
}
