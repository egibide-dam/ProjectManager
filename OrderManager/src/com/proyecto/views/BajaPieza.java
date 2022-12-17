package com.proyecto.views;

import com.proyecto.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaPieza extends JFrame{
    JPanel bajaPieza;
    private JLabel textoBajaPieza;
    private JLabel idBajaPieza;
    private JButton cancelarBajaPieza;
    private JButton guardarBajaPieza;


    public BajaPieza(){

        setContentPane(bajaPieza);

        if (Main.currentPieza.getAlta() == 1){
            textoBajaPieza.setText("¿Estás segura de dar de baja la pieza?");
        } else {
            textoBajaPieza.setText("¿Estás segura de volver a dar de alta la pieza?");
        }

        idBajaPieza.setText("PIEZA-" + Main.currentPieza.getIdpieza());

        cancelarBajaPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });

        guardarBajaPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
