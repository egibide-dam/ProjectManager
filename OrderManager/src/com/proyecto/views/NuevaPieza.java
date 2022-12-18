package com.proyecto.views;

import com.proyecto.Ciudades;
import com.proyecto.Main;
import com.proyecto.ProveedoresEntity;
import com.proyecto.TableModels.PiezasTableModel;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class NuevaPieza extends JFrame{
    JPanel nuevaPieza;
    private JLabel matchSearchTitle;
    private JComboBox newProveedorPieza;
    private JSpinner newPrecioPieza;
    private JButton cancelarNuevoPieza;
    private JButton guardarNuevoPieza;
    private JTextField newNamePieza;
    private JTextArea newDescripcionPieza;



    public void clearForm() {
        newNamePieza.setEnabled(true);
        newDescripcionPieza.setEnabled(true);
        newPrecioPieza.setEnabled(true);
        newProveedorPieza.setEnabled(true);
        newNamePieza.setText("");
        newNamePieza.setBackground(Main.white);
        newDescripcionPieza.setText("");
        newDescripcionPieza.setBackground(Main.white);
        newPrecioPieza.setValue(0.00);
        newPrecioPieza.getEditor().getComponent(0).setBackground(Main.white);
        newProveedorPieza.setSelectedIndex(-1);
        newProveedorPieza.setBackground(Main.white);
        guardarNuevoPieza.setEnabled(false);
        cancelarNuevoPieza.setEnabled(true);
    }

    public void disableForm() {
        newNamePieza.setEnabled(false);
        newDescripcionPieza.setEnabled(false);
        newPrecioPieza.setEnabled(false);
        newProveedorPieza.setEnabled(false);
        guardarNuevoPieza.setEnabled(false);
        cancelarNuevoPieza.setEnabled(false);
    }

    public void listaProveedores(JComboBox<ProveedoresEntity> select) {
        DefaultComboBoxModel<ProveedoresEntity> proveedoresListModel = new DefaultComboBoxModel<>();

        proveedoresListModel.removeAllElements();

        List<ProveedoresEntity> proves = ProveedorController.filtrarProveedores(1);

        for (ProveedoresEntity p : proves) {
            proveedoresListModel.addElement(p);
        }

        select.setModel(proveedoresListModel);

    }


    public NuevaPieza(JTable tabla, JButton ver, JButton editar, JButton eliminar){

        setContentPane(nuevaPieza);

        newDescripcionPieza.setLineWrap(true);
        newDescripcionPieza.setWrapStyleWord(true);
        SpinnerNumberModel spinnermodel = new SpinnerNumberModel(0.00,0.00,1000.00,0.05);
        newPrecioPieza.setModel(spinnermodel);
        listaProveedores(newProveedorPieza);
        clearForm();

        newNamePieza.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarNuevoPieza.setEnabled(newNamePieza.getText().length() > 0);
                newNamePieza.setBackground(Main.white);
            }
        });


        newNamePieza.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(newNamePieza.getText().length() >= 40) {
                    e.consume();
                    newNamePieza.setBackground(Main.warn);

                } else {
                    newNamePieza.setBackground(Main.white);

                }
            }
        });

        newDescripcionPieza.getDocument().addDocumentListener(new DocumentListener() {
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
                guardarNuevoPieza.setEnabled(newDescripcionPieza.getText().length() > 0);
                newDescripcionPieza.setBackground(Main.white);
            }
        });


        newDescripcionPieza.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(newDescripcionPieza.getText().length() >= 200) {
                    e.consume();
                    newDescripcionPieza.setBackground(Main.warn);

                } else {
                    newDescripcionPieza.setBackground(Main.white);

                }
            }
        });

        newPrecioPieza.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((double)newPrecioPieza.getValue() > 0.0){
                    guardarNuevoPieza.setEnabled(true);
                    newPrecioPieza.getEditor().getComponent(0).setBackground(Main.white);
                }

            }

        });

        newProveedorPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoPieza.setEnabled(true);
                newProveedorPieza.setBackground(Main.white);
            }
        });


        cancelarNuevoPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clearForm();
                dispose();
            }
        });



        guardarNuevoPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoPieza.setEnabled(false);
                cancelarNuevoPieza.setEnabled(false);

                if (newNamePieza.getText().length() == 0 || (double)newPrecioPieza.getValue() == 0.00 || newProveedorPieza.getSelectedIndex() == -1) {

                    if (newNamePieza.getText().length() == 0) {
                        newNamePieza.setBackground(Main.error);
                    }

                    if ((double)newPrecioPieza.getValue() == 0.00) {
                        newPrecioPieza.getEditor().getComponent(0).setBackground(Main.error);
                    }

                    if (newProveedorPieza.getSelectedIndex() == -1) {
                        newProveedorPieza.setBackground(Main.error);
                    }

                    cancelarNuevoPieza.setEnabled(true);

                } else {

                    disableForm();
                    String name = newNamePieza.getText();
                    String descrip;
                    if (newDescripcionPieza.getText().length() == 0){
                        descrip = "-";
                    } else {
                        descrip = newDescripcionPieza.getText();
                    }
                    float precio = (float) ((double) newPrecioPieza.getValue());
                    int proveedor = ((ProveedoresEntity) newProveedorPieza.getSelectedItem()).getIdproveedor();
                    if (PiezaController.nuevaPieza(name, precio, descrip, proveedor)){
                        clearForm();
                        tabla.setModel(new PiezasTableModel(PiezaController.leerTodosPiezas()));
                        ver.setEnabled(false);
                        editar.setEnabled(false);
                        eliminar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Pieza " + name + " guardada.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar la pieza " + name + ".", "ERROR", JOptionPane.ERROR_MESSAGE);

                    }
                }


            }
        });
    }
}
