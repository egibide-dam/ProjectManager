package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.PiezasEntity;
import com.proyecto.TableModels.PiezasTableModel;
import com.proyecto.controller.PiezaController;

import javax.swing.*;
import java.util.List;

public class DetalleProveedor  extends JFrame{
    JPanel detalleProveedor;
    private JLabel idDetalleProveedor;
    private JLabel estadoDetalleProveedor;
    private JLabel nombreapellidosDetallePedido;
    private JLabel direccionDetallePedido;
    private JTable tablePiezasDeProveedor;
    private JScrollPane tablaDetalleProveedor;




    public DetalleProveedor(){

        setContentPane(detalleProveedor);

        idDetalleProveedor.setText("PROV-" + Main.currentProveedor.getIdproveedor());
        if (Main.currentProveedor.getAlta() == 1){
            estadoDetalleProveedor.setText("ALTA");
        } else {
            estadoDetalleProveedor.setText("BAJA");
        }
        nombreapellidosDetallePedido.setText(Main.currentProveedor.getNombre() + " " + Main.currentProveedor.getApellidos());
        direccionDetallePedido.setText(Main.currentProveedor.getDireccion());
        tablePiezasDeProveedor.setModel(new PiezasTableModel(PiezaController.piezasPorProveedor(Main.currentProveedor.getIdproveedor())));

    }
}
