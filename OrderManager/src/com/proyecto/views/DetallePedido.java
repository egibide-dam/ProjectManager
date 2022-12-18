package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

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
        ProyectosEntity proy = ProyectoController.leerProyecto(Main.currentPedido.getProyectosByIdproyecto().getIdproyecto());
        proyectoidDetallePedido.setText("PROY-" + proy.getIdproyecto());
        proyectonombreDetallePedido.setText(proy.getNombre());
        ProveedoresEntity p = ProveedorController.leerProveedor(Main.currentPedido.getProyectosByIdproyecto().getIdproyecto());
        proveedoridDetallePedido.setText("PROV-" + p.getIdproveedor());
        proveedornombreDetallePedido.setText(p.getNombre() + " " + p.getApellidos());
        PiezasEntity pie = PiezaController.leerPieza(Main.currentPedido.getPiezasByIdpieza().getIdpieza());
        piezaidDetallePEdido.setText("PIEZ-" + pie.getIdpieza());
        piezanombreDetallePedida.setText(pie.getNombre());
        int unidades = (int) Main.currentPedido.getCantidad();
        piezaunidadesDetallePedido.setText(unidades + " uds.");
        double total = (pie.getPrecio()) * (Main.currentPedido.getCantidad());
        precioTotalText.setText("PRECIO TOTAL : " + total + " €");

    }
}
