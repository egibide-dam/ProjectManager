package com.proyecto.TableModels;

import com.proyecto.PedidosEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProveedoresTableModel extends AbstractTableModel {

    private String[] columnas = {"ID", "Nombre", "Apellidos", "Dirección", "Estado"};

    private ProveedoresEntity proveedor;
    private List<ProveedoresEntity> lista;

    public ProveedoresTableModel(List<ProveedoresEntity> lista) {
        this.proveedor = proveedor;
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

        ProveedoresEntity p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getIdproveedor();
            case 1:
                return p.getNombre();
            case 2:
                return p.getApellidos();
            case 3:
                return p.getDireccion();
            case 4:
                return estadotext(p);
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }


    public String estadotext(ProveedoresEntity p){
        String text = "";
        if (p.getAlta() == 1){
            text = "ALTA";
        } else {
            text = "BAJA";
        }

        return text;
    }
}
