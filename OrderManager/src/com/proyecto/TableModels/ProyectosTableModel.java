package com.proyecto.TableModels;

import com.proyecto.PedidosEntity;
import com.proyecto.ProyectosEntity;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class ProyectosTableModel extends AbstractTableModel {

    private String[] columnas = {"ID", "Nombre", "Ciudad", "Estado"};

    private ProyectosEntity proyecto;
    private List<ProyectosEntity> lista;

    public ProyectosTableModel(List<ProyectosEntity> lista) {
        this.proyecto = proyecto;
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

        ProyectosEntity p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return "PROY-" + p.getIdproyecto();
            case 1:
                return p.getNombre();
            case 2:
                return p.getCiudad();
            case 3:
                return estadotext(p);
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public String estadotext(ProyectosEntity p){
        String text = "";
        if (p.getAlta() == 1){
            text = "ALTA";
        } else {
            text = "BAJA";
        }

        return text;
    }

}
