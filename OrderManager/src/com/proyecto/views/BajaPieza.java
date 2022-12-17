package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.controller.PiezaController;

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
            guardarBajaPieza.setText("Dar de Baja");
        } else {
            textoBajaPieza.setText("¿Estás segura de volver a dar de alta la pieza?");
            guardarBajaPieza.setText("Dar de Alta");
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

                cancelarBajaPieza.setEnabled(false);
                guardarBajaPieza.setEnabled(false);

                if (Main.currentPieza.getAlta() == 1){
                    if(PiezaController.bajaPieza(Main.currentPieza.getIdpieza())){
                        JOptionPane.showMessageDialog(null, "Se ha dado de baja la pieza " + Main.currentPieza.getNombre() + ".", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido dar de baja la pieza " + Main.currentPieza.getNombre() + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if(PiezaController.altaPieza(Main.currentPieza.getIdpieza())){
                        JOptionPane.showMessageDialog(null, "Se ha dado de alta la pieza " + Main.currentPieza.getNombre() + ".", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido dar de alta la pieza " + Main.currentPieza.getNombre() + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }

                dispose();

            }
        });

    }
}
