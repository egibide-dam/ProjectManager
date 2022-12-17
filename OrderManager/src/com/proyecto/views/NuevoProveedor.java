package com.proyecto.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoProveedor extends JFrame{
    JPanel nuevoProveedor;
    private JLabel matchSearchTitle;
    private JButton cancelarNuevoProveedor;
    private JButton guardarNuevoProveedor;
    private JTextField newNameProveedor;
    private JTextField newApellidosProveedor;
    private JTextField newDireccionProveedor;


    public NuevoProveedor(){

        setContentPane(nuevoProveedor);

        cancelarNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }
}
