package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProyectoController;

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
            guardarBajaProyecto.setText("Dar de Baja");

        } else {
            textoBajaProyecto.setText("¿Estás segura de volver a dar de alta el proyecto?");
            guardarBajaProyecto.setText("Dar de Alta");

        }

        idBajaProyecto.setText("PROYECTO-" + Main.currentProyecto.getIdproyecto());

        cancelarBajaProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarBajaProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarBajaProyecto.setEnabled(false);
                guardarBajaProyecto.setEnabled(false);

                if (Main.currentProyecto.getAlta() == 1){
                    ProyectoController.bajaProyecto(Main.currentProyecto.getIdproyecto());
                } else {
                    ProyectoController.altaProyecto(Main.currentProyecto.getIdproyecto());
                }

                dispose();
            }
        });

    }
}
