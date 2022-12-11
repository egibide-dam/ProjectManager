package com.proyecto.TableModels;

import com.proyecto.PiezasEntity;
import com.proyecto.ProyectosEntity;

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
                return p.getIdpieza();
            case 1:
                return p.getNombre();
            case 2:
                return p.getDescripcion();
            case 3:
                return p.getPrecio();
            case 4:
                return p.getProveedoresByIdproveedor();
            case 5:
                return p.getAlta();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }


}
