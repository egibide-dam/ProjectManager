package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.controller.ProveedorController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditarProveedor extends JFrame{
    JPanel editarProveedor;
    private JLabel titleEditarProveedor;
    private JButton cancelarEditarProveedor;
    private JButton guardarEditarProveedor;
    private JTextField editNameProveedor;
    private JTextField editApellidosProveedor;
    private JTextField editDireccionProveedor;



    public void fillForm() {
        editNameProveedor.setEnabled(true);
        editApellidosProveedor.setEnabled(true);
        editDireccionProveedor.setEnabled(true);
        editNameProveedor.setText(Main.currentProveedor.getNombre());
        editNameProveedor.setBackground(Main.white);
        editApellidosProveedor.setText(Main.currentProveedor.getApellidos());
        editApellidosProveedor.setBackground(Main.white);
        editDireccionProveedor.setText(Main.currentProveedor.getDireccion());
        editDireccionProveedor.setBackground(Main.white);
        guardarEditarProveedor.setEnabled(false);
        cancelarEditarProveedor.setEnabled(true);
    }

    public void disableForm() {
        editNameProveedor.setEnabled(false);
        editApellidosProveedor.setEnabled(false);
        editDireccionProveedor.setEnabled(false);
        guardarEditarProveedor.setEnabled(false);
        cancelarEditarProveedor.setEnabled(false);
    }



    public EditarProveedor(){

        setContentPane(editarProveedor);

        titleEditarProveedor.setText("Editar PROV-" + Main.currentProveedor.getIdproveedor());
        fillForm();

        editNameProveedor.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarEditarProveedor.setEnabled(editNameProveedor.getText().length() > 0);
                editNameProveedor.setBackground(Main.white);
            }
        });


        editNameProveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(editNameProveedor.getText().length() >= 20)
                {
                    e.consume();
                    editNameProveedor.setBackground(Main.warn);

                } else {
                    editNameProveedor.setBackground(Main.white);

                }
            }
        });

        editApellidosProveedor.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarEditarProveedor.setEnabled(editApellidosProveedor.getText().length() > 0);
                editApellidosProveedor.setBackground(Main.white);
            }
        });


        editApellidosProveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(editApellidosProveedor.getText().length() >= 30)
                {
                    e.consume();
                    editApellidosProveedor.setBackground(Main.warn);

                } else {
                    editApellidosProveedor.setBackground(Main.white);

                }
            }
        });

        editDireccionProveedor.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarEditarProveedor.setEnabled(editDireccionProveedor.getText().length() > 0);
                editDireccionProveedor.setBackground(Main.white);
            }
        });


        editDireccionProveedor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(editDireccionProveedor.getText().length() >= 40)
                {
                    e.consume();
                    editDireccionProveedor.setBackground(Main.warn);

                } else {
                    editDireccionProveedor.setBackground(Main.white);

                }
            }
        });


        cancelarEditarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });

        guardarEditarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guardarEditarProveedor.setEnabled(false);
                cancelarEditarProveedor.setEnabled(false);

                if (editNameProveedor.getText().length() == 0 || editApellidosProveedor.getText().length() == 0 || editDireccionProveedor.getText().length() == 0) {

                    if (editNameProveedor.getText().length() == 0) {
                        editNameProveedor.setBackground(Main.error);
                    }

                    if (editApellidosProveedor.getText().length() == 0) {
                        editApellidosProveedor.setBackground(Main.error);
                    }

                    if (editDireccionProveedor.getText().length() == 0) {
                        editDireccionProveedor.setBackground(Main.error);
                    }


                    cancelarEditarProveedor.setEnabled(true);

                } else {
                    disableForm();
                    int id = Main.currentProveedor.getIdproveedor();
                    String name = editNameProveedor.getText();
                    String apellidos = editApellidosProveedor.getText();
                    String direccion = editDireccionProveedor.getText();
                    if (ProveedorController.editarProveedor(id, name, apellidos, direccion)){
                        Main.currentProveedor = ProveedorController.leerProveedor(id);
                        fillForm();
                        JOptionPane.showMessageDialog(null, "Proveedor " + name + " " + apellidos + " actualizado.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido actualizar el proveedor " + Main.currentProveedor.getNombre() + " " + Main.currentProveedor.getApellidos() + ".", "ERROR", JOptionPane.ERROR_MESSAGE);

                    }
                }

            }
        });

    }
}
