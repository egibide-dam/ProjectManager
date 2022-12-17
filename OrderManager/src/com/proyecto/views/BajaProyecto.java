package com.proyecto.views;

import com.proyecto.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaProyecto extends JFrame{
    JPanel bajaProyecto;
    private JLabel textoBajaProyecto;
    private JButton cancelarBajaProyecto;
    private JButton guardarBajaProyecto;
    private JLabel idBajaProyecto;



    public BajaProyecto(){

        setContentPane(bajaProyecto);

        if (Main.currentProyecto.getAlta() == 1){
            textoBajaProyecto.setText("¿Estás segura de dar de baja el proyecto?");
        } else {
            textoBajaProyecto.setText("¿Estás segura de volver a dar de alta el proyecto?");
        }

        idBajaProyecto.setText("PROYECTO-" + Main.currentPieza.getIdpieza());

        cancelarBajaProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarBajaProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
