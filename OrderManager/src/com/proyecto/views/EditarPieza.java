package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.ProveedoresEntity;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class EditarPieza extends JFrame{
    JPanel editarPieza;
    private JLabel titleEditarPieza;
    private JComboBox editProveedorPieza;
    private JSpinner editPrecioPieza;
    private JButton cancelarEditarPieza;
    private JButton guardarEditarPieza;
    private JTextField editNamePieza;
    private JTextArea editDescripcionPieza;


    public void fillForm() {
        editNamePieza.setEnabled(true);
        editDescripcionPieza.setEnabled(true);
        editPrecioPieza.setEnabled(true);
        editProveedorPieza.setEnabled(false);
        editNamePieza.setText(Main.currentPieza.getNombre());
        editNamePieza.setBackground(Main.white);
        editDescripcionPieza.setText(Main.currentPieza.getDescripcion());
        editDescripcionPieza.setBackground(Main.white);
        editPrecioPieza.setValue(Main.currentPieza.getPrecio());
        editPrecioPieza.getEditor().getComponent(0).setBackground(Main.white);
        editProveedorPieza.setSelectedItem(Main.currentPieza.getProveedoresByIdproveedor());
        editProveedorPieza.setBackground(Main.white);
        guardarEditarPieza.setEnabled(false);
        cancelarEditarPieza.setEnabled(true);
    }

    public void disableForm() {
        editNamePieza.setEnabled(false);
        editDescripcionPieza.setEnabled(false);
        editPrecioPieza.setEnabled(false);
        editProveedorPieza.setEnabled(false);
        guardarEditarPieza.setEnabled(false);
        cancelarEditarPieza.setEnabled(false);
    }

    public void listaProveedores(JComboBox<ProveedoresEntity> select) {
        DefaultComboBoxModel<ProveedoresEntity> proveedoresListModel = new DefaultComboBoxModel<>();

        proveedoresListModel.removeAllElements();

        List<ProveedoresEntity> proves = ProveedorController.leerTodosProveedores();

        for (ProveedoresEntity p : proves) {
            proveedoresListModel.addElement(p);
        }

        select.setModel(proveedoresListModel);

    }


    public EditarPieza(){

        setContentPane(editarPieza);
        listaProveedores(editProveedorPieza);

        titleEditarPieza.setText("Editar PIEZ-" + Main.currentPieza.getIdpieza());
        editDescripcionPieza.setLineWrap(true);
        editDescripcionPieza.setWrapStyleWord(true);
        SpinnerNumberModel spinnermodel = new SpinnerNumberModel(0.00,0.00,1000.00,0.05);
        editPrecioPieza.setModel(spinnermodel);
        fillForm();

        editNamePieza.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarEditarPieza.setEnabled(editNamePieza.getText().length() > 0);
                editNamePieza.setBackground(Main.white);
            }
        });


        editNamePieza.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(editNamePieza.getText().length() >= 40) {
                    e.consume();
                    editNamePieza.setBackground(Main.warn);

                } else {
                    editNamePieza.setBackground(Main.white);

                }
            }
        });

        editDescripcionPieza.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarEditarPieza.setEnabled(editDescripcionPieza.getText().length() > 0);
                editDescripcionPieza.setBackground(Main.white);
            }
        });


        editDescripcionPieza.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(editDescripcionPieza.getText().length() >= 200) {
                    e.consume();
                    editDescripcionPieza.setBackground(Main.warn);

                } else {
                    editDescripcionPieza.setBackground(Main.white);

                }
            }
        });

        editPrecioPieza.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((double)editPrecioPieza.getValue() > 0.0){
                    guardarEditarPieza.setEnabled(true);
                    editPrecioPieza.getEditor().getComponent(0).setBackground(Main.white);
                }

            }

        });

        cancelarEditarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarEditarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guardarEditarPieza.setEnabled(false);
                cancelarEditarPieza.setEnabled(false);

                if (editNamePieza.getText().length() == 0 || (double)editPrecioPieza.getValue() == 0.00) {

                    if (editNamePieza.getText().length() == 0) {
                        editNamePieza.setBackground(Main.error);
                    }

                    if ((double)editPrecioPieza.getValue() == 0.00) {
                        editPrecioPieza.getEditor().getComponent(0).setBackground(Main.error);
                    }

                    cancelarEditarPieza.setEnabled(true);

                } else {

                    disableForm();
                    int id = Main.currentPieza.getIdpieza();
                    String name = editNamePieza.getText();
                    String descrip;
                    if (editDescripcionPieza.getText().length() == 0){
                        descrip = "-";
                    } else {
                        descrip = editDescripcionPieza.getText();
                    }
                    float precio = (float) ((double) editPrecioPieza.getValue());
                    PiezaController.editarPieza(id, name, precio, descrip);
                    fillForm();
                    JOptionPane.showMessageDialog(null, "Pieza" + name + " actualizada.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                }

            }
        });

    }
}
