package com.proyecto.views;

import com.proyecto.Main;

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

        idDetallePieza.setText("PIEZ-" + Main.currentPieza.getIdpieza());
        if (Main.currentPieza.getAlta() == 1){
            estadodetallePieza.setText("ALTA");
        } else {
            estadodetallePieza.setText("BAJA");
        }
        piezanombreDetallePieza.setText(Main.currentPieza.getNombre());
        descripDetallePieza.setText(Main.currentPieza.getDescripcion());
        precioDetallePieza.setText("Precio/ud. : " + Main.currentPieza.getPrecio() + " €");


    }


}
