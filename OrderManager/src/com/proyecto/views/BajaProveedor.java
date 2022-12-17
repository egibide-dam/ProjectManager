package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;

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
            guardarBajaProveedor.setText("Dar de Baja");

        } else {
            textoBajaProveedor.setText("¿Estás segura de volver a dar de alta el proveedor?");
            guardarBajaProveedor.setText("Dar de Alta");

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
                cancelarBajaProveedor.setEnabled(false);
                guardarBajaProveedor.setEnabled(false);

                if (Main.currentProveedor.getAlta() == 1){
                    ProveedorController.bajaProveedor(Main.currentProveedor.getIdproveedor());
                } else {
                    ProveedorController.altaProveedor(Main.currentProveedor.getIdproveedor());
                }

                dispose();
            }
        });

    }
}
