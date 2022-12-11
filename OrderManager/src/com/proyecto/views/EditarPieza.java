package com.proyecto.views;

import javax.swing.*;

public class EditarPieza {
    JPanel editarPieza;
    private JLabel titleEditarPieza;
    private JComboBox editProveedorPieza;
    private JSpinner editPrecioPieza;
    private JButton cancelarEditarPieza;
    private JButton guardarEditarPieza;
    private JTextField editNamePieza;
    private JTextArea editDescripcionPieza;


    public EditarPieza(){

        editDescripcionPieza.setLineWrap(true);
        editDescripcionPieza.setWrapStyleWord(true);

    }
}
