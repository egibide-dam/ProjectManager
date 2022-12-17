package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.ProveedoresEntity;
import com.proyecto.controller.ProveedorController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        editDescripcionPieza.setLineWrap(true);
        editDescripcionPieza.setWrapStyleWord(true);

        titleEditarPieza.setText("Editar PIEZ-" + Main.currentPieza.getIdpieza());
        editProveedorPieza.setSelectedItem(Main.currentPieza.getProveedoresByIdproveedor());
        editPrecioPieza.setValue(Main.currentPieza.getPrecio());
        editNamePieza.setText(Main.currentPieza.getNombre());
        editDescripcionPieza.setText(Main.currentPieza.getDescripcion());


        cancelarEditarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarEditarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

    }
}
