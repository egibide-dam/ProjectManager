package com.proyecto.views;

import com.proyecto.ProveedoresEntity;
import com.proyecto.controller.ProveedorController;

import javax.swing.*;
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



    public void listaProveedores(JComboBox<ProveedoresEntity> select) {
        DefaultComboBoxModel<ProveedoresEntity> proveedoresListModel = new DefaultComboBoxModel<>();

        proveedoresListModel.removeAllElements();

        List<ProveedoresEntity> proves = ProveedorController.leerTodosProveedores();

        for (ProveedoresEntity p : proves) {
            proveedoresListModel.addElement(p);
        }

        select.setModel(proveedoresListModel);

    }


    public NuevaPieza(){

        setContentPane(nuevaPieza);

        newDescripcionPieza.setLineWrap(true);
        newDescripcionPieza.setWrapStyleWord(true);
        listaProveedores(newProveedorPieza);


    }
}
