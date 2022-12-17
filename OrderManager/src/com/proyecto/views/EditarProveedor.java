package com.proyecto.views;

import com.proyecto.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarProveedor extends JFrame{
    JPanel editarProveedor;
    private JLabel titleEditarProveedor;
    private JButton cancelarEditarProveedor;
    private JButton guardarEditarProveedor;
    private JTextField editNameProveedor;
    private JTextField editApellidosProveedor;
    private JTextField editDireccionProveedor;



    public EditarProveedor(){

        setContentPane(editarProveedor);

        titleEditarProveedor.setText("Editar PROV-" + Main.currentProveedor.getIdproveedor());
        editNameProveedor.setText(Main.currentProveedor.getNombre());
        editApellidosProveedor.setText(Main.currentProveedor.getApellidos());
        editDireccionProveedor.setText(Main.currentProveedor.getDireccion());

        cancelarEditarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });

        guardarEditarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
