package com.proyecto.views;

import com.proyecto.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaProveedor extends JFrame{
    JPanel bajaProveedor;
    private JLabel textoBajaProveedor;
    private JLabel idBajaProveedor;
    private JButton cancelarBajaProveedor;
    private JButton guardarBajaProveedor;



    public BajaProveedor(){

        setContentPane(bajaProveedor);

        if (Main.currentProveedor.getAlta() == 1){
            textoBajaProveedor.setText("¿Estás segura de dar de baja el proveedor?");
        } else {
            textoBajaProveedor.setText("¿Estás segura de volver a dar de alta el proveedor?");
        }

        idBajaProveedor.setText("PROVEEDOR-" + Main.currentProveedor.getIdproveedor());

        cancelarBajaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarBajaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
