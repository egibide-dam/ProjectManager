package com.proyecto.views;

import javax.swing.*;

public class NuevaPieza extends JFrame{
    JPanel nuevaPieza;
    private JLabel matchSearchTitle;
    private JComboBox newProveedorPieza;
    private JSpinner newPrecioPieza;
    private JButton cancelarNuevoPieza;
    private JButton guardarNuevoPieza;
    private JTextField newNamePieza;
    private JTextArea newDescripcionPieza;



    public NuevaPieza(){

        setContentPane(nuevaPieza);

        newDescripcionPieza.setLineWrap(true);
        newDescripcionPieza.setWrapStyleWord(true);


    }
}
