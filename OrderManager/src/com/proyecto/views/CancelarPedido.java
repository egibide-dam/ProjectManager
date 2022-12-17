package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.controller.PedidosController;
import com.proyecto.controller.ProyectoController;

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


        idCancelarPedido.setText("PEDIDO-" + Main.currentPedido.getIdpedido());

        cancelarEliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarEliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarPedido.setEnabled(false);
                guardarEliminarPedido.setEnabled(false);

                if (PedidosController.bajaPedido(Main.currentPedido.getIdpedido())){
                    JOptionPane.showMessageDialog(null, "Se ha cancelado el pedido " + Main.currentPedido.getIdpedido() + ".", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido cancelar el pedido " + Main.currentPedido.getIdpedido() + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                dispose();
            }
        });
    }

}
