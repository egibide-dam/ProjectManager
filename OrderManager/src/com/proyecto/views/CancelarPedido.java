package com.proyecto.views;

import com.proyecto.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelarPedido extends JFrame{
    JPanel cancelarPedido;
    private JLabel textoEliminarPedido;
    private JButton cancelarEliminarPedido;
    private JButton guardarEliminarPedido;
    private JLabel idCancelarPedido;




    public CancelarPedido(){

        setContentPane(cancelarPedido);

        textoEliminarPedido.setText("¿Estás seguro de cancelar el pedido?");


        idCancelarPedido.setText("PEDIDO-" + Main.currentPieza.getIdpieza());

        cancelarEliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarEliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
