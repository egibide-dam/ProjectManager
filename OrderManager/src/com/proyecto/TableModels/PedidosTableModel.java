package com.proyecto.TableModels;

import com.proyecto.PedidosEntity;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PedidosTableModel extends AbstractTableModel {

    private String[] columnas = {"ID", "Proyecto", "Proveedor", "Pieza", "Cantidad", "Estado"};

    private PedidosEntity pedido;
    private List<PedidosEntity> lista;

    public PedidosTableModel(List<PedidosEntity> lista) {
        this.pedido = pedido;
        this.lista = lista;
    }


    @Override
    public int getRowCount() {
        return lista.size();
    }


    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        PedidosEntity p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return "PED-" + p.getIdpedido();
            case 1:
                return ProyectoController.leerProyecto(p.getProyectosByIdproyecto().getIdproyecto());
            case 2:
                return ProveedorController.leerProveedor(p.getProveedoresByIdproveedor().getIdproveedor());
            case 3:
                return PiezaController.leerPieza(p.getPiezasByIdpieza().getIdpieza());
            case 4:
                return p.getCantidad();
            case 5:
                return estadotext(p);
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public String estadotext(PedidosEntity p){
        String text = "";
        if (p.getAlta() == 1){
            text = "ACTIVO";
        } else {
            text = "CANCELADO";
        }

        return text;
    }

}
