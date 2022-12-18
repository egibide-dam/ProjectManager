package com.proyecto.TableModels;

import com.proyecto.PedidosEntity;
import com.proyecto.PiezasEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.ProveedorController;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PiezasTableModel extends AbstractTableModel {

    private String[] columnas = {"ID", "Nombre", "Descripción", "Precio", "Proveedor", "Estado"};

    private PiezasEntity pieza;
    private List<PiezasEntity> lista;

    public PiezasTableModel(List<PiezasEntity> lista) {
        this.pieza = pieza;
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

        PiezasEntity p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return "PIEZ-" + p.getIdpieza();
            case 1:
                return p.getNombre();
            case 2:
                return p.getDescripcion();
            case 3:
                return p.getPrecio();
            case 4:
                return ProveedorController.leerProveedor(p.getProveedoresByIdproveedor().getIdproveedor());
            case 5:
                return estadotext(p);
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public String estadotext(PiezasEntity p){
        String text = "";
        if (p.getAlta() == 1){
            text = "ALTA";
        } else {
            text = "BAJA";
        }

        return text;
    }

}
