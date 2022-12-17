package com.proyecto.views;

import javax.swing.*;

public class EditarPieza extends JFrame{
    JPanel editarPieza;
    private JLabel titleEditarPieza;
    private JComboBox editProveedorPieza;
    private JSpinner editPrecioPieza;
    private JButton cancelarEditarPieza;
    private JButton guardarEditarPieza;
    private JTextField editNamePieza;
    private JTextArea editDescripcionPieza;


    public EditarPieza(){

        setContentPane(editarPieza);

        editDescripcionPieza.setLineWrap(true);
        editDescripcionPieza.setWrapStyleWord(true);

    }
}
