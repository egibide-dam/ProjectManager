package com.proyecto.views;

import com.proyecto.Ciudades;
import com.proyecto.Main;
import com.proyecto.TableModels.ProveedoresTableModel;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NuevoProveedor extends JFrame{
    JPanel nuevoProveedor;
    private JLabel matchSearchTitle;
    private JButton cancelarNuevoProveedor;
    private JButton guardarNuevoProveedor;
    private JTextField newNameProveedor;
    private JTextField newApellidosProveedor;
    private JTextField newDireccionProveedor;

    public void clearForm() {
        newNameProveedor.setEnabled(true);
        newApellidosProveedor.setEnabled(true);
        newDireccionProveedor.setEnabled(true);
        newNameProveedor.setText("");
        newNameProveedor.setBackground(Main.white);
        newApellidosProveedor.setText("");
        newApellidosProveedor.setBackground(Main.white);
        newDireccionProveedor.setText("");
        newDireccionProveedor.setBackground(Main.white);
        guardarNuevoProveedor.setEnabled(false);
        cancelarNuevoProveedor.setEnabled(true);
    }

    public void disableForm() {
        newNameProveedor.setEnabled(false);
        newApellidosProveedor.setEnabled(false);
        newDireccionProveedor.setEnabled(false);
        guardarNuevoProveedor.setEnabled(false);
        cancelarNuevoProveedor.setEnabled(false);
    }


    public NuevoProveedor(JTable tabla, JButton ver, JButton editar, JButton eliminar){

        setContentPane(nuevoProveedor);

        clearForm();

        newNameProveedor.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarNuevoProveedor.setEnabled(newNameProveedor.getText().length() > 0);
                newNameProveedor.setBackground(Main.white);
            }
        });


        newNameProveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(newNameProveedor.getText().length() >= 20)
                {
                    e.consume();
                    newNameProveedor.setBackground(Main.warn);

                } else {
                    newNameProveedor.setBackground(Main.white);

                }
            }
        });

        newApellidosProveedor.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarNuevoProveedor.setEnabled(newApellidosProveedor.getText().length() > 0);
                newApellidosProveedor.setBackground(Main.white);
            }
        });


        newApellidosProveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(newApellidosProveedor.getText().length() >= 30)
                {
                    e.consume();
                    newApellidosProveedor.setBackground(Main.warn);

                } else {
                    newApellidosProveedor.setBackground(Main.white);

                }
            }
        });

        newDireccionProveedor.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarNuevoProveedor.setEnabled(newDireccionProveedor.getText().length() > 0);
                newDireccionProveedor.setBackground(Main.white);
            }
        });


        newDireccionProveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(newDireccionProveedor.getText().length() >= 40)
                {
                    e.consume();
                    newDireccionProveedor.setBackground(Main.warn);

                } else {
                    newDireccionProveedor.setBackground(Main.white);

                }
            }
        });



        cancelarNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clearForm();
                dispose();
            }
        });

        guardarNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoProveedor.setEnabled(false);
                cancelarNuevoProveedor.setEnabled(false);

                if (newNameProveedor.getText().length() == 0 || newApellidosProveedor.getText().length() == 0 || newDireccionProveedor.getText().length() == 0) {

                    if (newNameProveedor.getText().length() == 0) {
                        newNameProveedor.setBackground(Main.error);
                    }

                    if (newApellidosProveedor.getText().length() == 0) {
                        newApellidosProveedor.setBackground(Main.error);
                    }

                    if (newDireccionProveedor.getText().length() == 0) {
                        newDireccionProveedor.setBackground(Main.error);
                    }


                    cancelarNuevoProveedor.setEnabled(true);

                } else {
                    disableForm();
                    String name = newNameProveedor.getText();
                    String apellidos = newApellidosProveedor.getText();
                    String direccion = newDireccionProveedor.getText();
                    if (ProveedorController.nuevoProveedor(name, apellidos, direccion)){
                        clearForm();
                        tabla.setModel(new ProveedoresTableModel(ProveedorController.leerTodosProveedores()));
                        ver.setEnabled(false);
                        editar.setEnabled(false);
                        eliminar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Proveedor " + name + " " + apellidos + " guardado.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar el proveedor " + name + " " + apellidos + ".", "ERROR", JOptionPane.ERROR_MESSAGE);

                    }
                }

            }
        });


    }
}
