package com.proyecto.views;

import javax.swing.*;

public class DetallePieza extends JFrame{
    JPanel detallePieza;
    private JLabel idDetallePieza;
    private JLabel estadodetallePieza;
    private JLabel piezanombreDetallePieza;
    private JTextArea descripDetallePieza;
    private JLabel precioDetallePieza;


    public DetallePieza(){

        setContentPane(detallePieza);

        descripDetallePieza.setLineWrap(true);
        descripDetallePieza.setWrapStyleWord(true);

    }


}
