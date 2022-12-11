package com.proyecto.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NuevaPieza {
    JPanel nuevaPieza;
    private JLabel matchSearchTitle;
    private JComboBox newProveedorPieza;
    private JSpinner newPrecioPieza;
    private JButton cancelarNuevoPieza;
    private JButton guardarNuevoPieza;
    private JTextField newNamePieza;
    private JTextArea newDescripcionPieza;



    public NuevaPieza(){

        Border border = BorderFactory.createLineBorder(Color.gray);
        newDescripcionPieza.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

    }
}
