package com.proyecto.views;

import com.proyecto.Main;

import javax.swing.*;

public class DetallePedido extends JFrame{
    JPanel detallePedido;
    private JLabel idDetallePedido;
    private JLabel estadoDetallePedido;
    private JLabel proyectonombreDetallePedido;
    private JLabel proyectoidDetallePedido;
    private JLabel proveedoridDetallePedido;
    private JLabel proveedornombreDetallePedido;
    private JLabel piezaidDetallePEdido;
    private JLabel piezanombreDetallePedida;
    private JLabel piezaunidadesDetallePedido;
    private JLabel precioTotalText;


    public DetallePedido(){

        setContentPane(detallePedido);

        idDetallePedido.setText("PED-" + Main.currentPedido.getIdpedido());
        if (Main.currentPedido.getAlta() == 1){
            estadoDetallePedido.setText("ACTIVO");
        } else {
            estadoDetallePedido.setText("CANCELADO");
        }
        proyectoidDetallePedido.setText("PROY-" + Main.currentPedido.getProyectosByIdproyecto().getIdproyecto());
        proyectonombreDetallePedido.setText(Main.currentPedido.getProyectosByIdproyecto().getNombre());
        proveedoridDetallePedido.setText("PROV-" + Main.currentPedido.getProveedoresByIdproveedor().getIdproveedor());
        proveedornombreDetallePedido.setText(Main.currentPedido.getProveedoresByIdproveedor().getNombre() + " " + Main.currentPedido.getProveedoresByIdproveedor().getApellidos());
        piezaidDetallePEdido.setText("PIEZ-" + Main.currentPedido.getPiezasByIdpieza().getIdpieza());
        piezanombreDetallePedida.setText(Main.currentPedido.getPiezasByIdpieza().getNombre());
        int unidades = (int) Main.currentPedido.getCantidad();
        piezaunidadesDetallePedido.setText(unidades + " uds.");
        double total = (Main.currentPedido.getPiezasByIdpieza().getPrecio()) * (Main.currentPedido.getCantidad());
        precioTotalText.setText("PRECIO TOTAL : " + total + " €");

    }
}
