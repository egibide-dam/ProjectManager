package com.proyecto.views;

import com.proyecto.Ciudades;
import com.proyecto.Main;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NuevoProyecto extends JFrame {
    JPanel nuevoProyecto;
    private JLabel matchSearchTitle;
    private JComboBox newCiudadProyecto;
    private JButton cancelarNuevoProyecto;
    private JButton guardarNuevoProyecto;
    private JTextField newNameProyecto;


    public void clearForm() {
        newNameProyecto.setEnabled(true);
        newCiudadProyecto.setEnabled(true);
        newNameProyecto.setText("");
        newNameProyecto.setBackground(Main.white);
        newCiudadProyecto.setSelectedIndex(-1);
        newCiudadProyecto.setBackground(Main.white);
        guardarNuevoProyecto.setEnabled(false);
        cancelarNuevoProyecto.setEnabled(true);
    }

    public void disableForm() {
        newNameProyecto.setEnabled(false);
        newCiudadProyecto.setEnabled(false);
        guardarNuevoProyecto.setEnabled(false);
        cancelarNuevoProyecto.setEnabled(false);
    }


    public NuevoProyecto() {

        setContentPane(nuevoProyecto);

        newCiudadProyecto.setModel(new DefaultComboBoxModel<>(Ciudades.values()));
        clearForm();

        newNameProyecto.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarNuevoProyecto.setEnabled(newNameProyecto.getText().length() > 0);
                newNameProyecto.setBackground(Main.white);
            }
        });


        newNameProyecto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(newNameProyecto.getText().length() >= 40) {
                    e.consume();
                    newNameProyecto.setBackground(Main.warn);

                } else {
                    newNameProyecto.setBackground(Main.white);

                }
            }
        });

        newCiudadProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoProyecto.setEnabled(true);
                newCiudadProyecto.setBackground(Main.white);
            }
        });

        cancelarNuevoProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clearForm();
                dispose();
            }
        });

        guardarNuevoProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoProyecto.setEnabled(false);
                cancelarNuevoProyecto.setEnabled(false);

                if (newNameProyecto.getText().length() == 0 || newCiudadProyecto.getSelectedIndex() == -1) {

                    if (newNameProyecto.getText().length() == 0) {
                        newNameProyecto.setBackground(Main.error);
                    }

                    if (newCiudadProyecto.getSelectedIndex() == -1) {
                        newCiudadProyecto.setBackground(Main.error);
                    }

                    cancelarNuevoProyecto.setEnabled(true);

                } else {
                    disableForm();
                    String name = newNameProyecto.getText();
                    Ciudades ciudad = (Ciudades) newCiudadProyecto.getSelectedItem();
                    if (ProyectoController.nuevoProyecto(name, ciudad.toString())){
                        clearForm();
                        JOptionPane.showMessageDialog(null, "Proyecto " + name + " guardado.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar el proyecto " + name + ".", "ERROR", JOptionPane.ERROR_MESSAGE);

                    }
                }

            }
        });


    }
}
