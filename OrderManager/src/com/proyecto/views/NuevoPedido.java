package com.proyecto.views;

import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import java.util.List;

public class NuevoPedido {
    JPanel nuevoPedido;
    private JLabel matchSearchTitle;
    private JComboBox newProyectoPedido;
    private JComboBox newProveedorPedido;
    private JComboBox newPiezaPedido;
    private JSpinner newCantidadPedido;
    private JButton cancelarNuevoPedido;
    private JButton guardarNuevoPedido;


    ///MÉTODOS
    public void listaProyectos(JComboBox<ProyectosEntity> select) {
        DefaultComboBoxModel<ProyectosEntity> proyectosListModel = new DefaultComboBoxModel<>();

        proyectosListModel.removeAllElements();

        List<ProyectosEntity> proves = ProyectoController.leerTodosProyectos();

        for (ProyectosEntity p : proves) {
            proyectosListModel.addElement(p);
        }

        select.setModel(proyectosListModel);

    }

    public void listaProveedores(JComboBox<ProveedoresEntity> select) {
        DefaultComboBoxModel<ProveedoresEntity> proveedoresListModel = new DefaultComboBoxModel<>();

        proveedoresListModel.removeAllElements();

        List<ProveedoresEntity> proves = ProveedorController.leerTodosProveedores();

        for (ProveedoresEntity p : proves) {
            proveedoresListModel.addElement(p);
        }

        select.setModel(proveedoresListModel);

    }

    public void listaPiezas(JComboBox<PiezasEntity> select) {
        DefaultComboBoxModel<PiezasEntity> piezasListModel = new DefaultComboBoxModel<>();

        piezasListModel.removeAllElements();

        List<PiezasEntity> proves = PiezaController.leerTodosPiezas();

        for (PiezasEntity p : proves) {
            piezasListModel.addElement(p);
        }

        select.setModel(piezasListModel);

    }


    public NuevoPedido(){

        listaProveedores(newProveedorPedido);
        listaPiezas(newPiezaPedido);
        listaProyectos(newProyectoPedido);


    }
}
