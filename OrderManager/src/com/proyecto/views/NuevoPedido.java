package com.proyecto.views;

import com.proyecto.Main;
import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.TableModels.PedidosTableModel;
import com.proyecto.controller.PedidosController;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NuevoPedido extends JFrame{
    JPanel nuevoPedido;
    private JLabel matchSearchTitle;
    private JComboBox newProyectoPedido;
    private JComboBox newProveedorPedido;
    private JComboBox newPiezaPedido;
    private JSpinner newCantidadPedido;
    private JButton cancelarNuevoPedido;
    private JButton guardarNuevoPedido;


    ///MÉTODOS
    public void clearForm() {
        newProyectoPedido.setEnabled(true);
        newProveedorPedido.setEnabled(true);
        newPiezaPedido.setEnabled(true);
        newCantidadPedido.setEnabled(true);
        newProyectoPedido.setSelectedIndex(-1);
        newProyectoPedido.setBackground(Main.white);
        newProveedorPedido.setSelectedIndex(-1);
        newProveedorPedido.setBackground(Main.white);
        newPiezaPedido.setSelectedIndex(-1);
        newPiezaPedido.setBackground(Main.white);
        newCantidadPedido.setValue(0);
        newCantidadPedido.getEditor().getComponent(0).setBackground(Main.white);
        guardarNuevoPedido.setEnabled(false);
        cancelarNuevoPedido.setEnabled(true);
    }

    public void disableForm() {
        newProyectoPedido.setEnabled(false);
        newProveedorPedido.setEnabled(false);
        newPiezaPedido.setEnabled(false);
        newCantidadPedido.setEnabled(false);
        guardarNuevoPedido.setEnabled(false);
        cancelarNuevoPedido.setEnabled(false);
    }

    public void listaProyectos(JComboBox<ProyectosEntity> select) {
        DefaultComboBoxModel<ProyectosEntity> proyectosListModel = new DefaultComboBoxModel<>();

        proyectosListModel.removeAllElements();

        List<ProyectosEntity> proves = ProyectoController.filtrarProyectos(1);

        for (ProyectosEntity p : proves) {
            proyectosListModel.addElement(p);
        }

        select.setModel(proyectosListModel);

    }

    public void listaProveedores(JComboBox<ProveedoresEntity> select) {
        DefaultComboBoxModel<ProveedoresEntity> proveedoresListModel = new DefaultComboBoxModel<>();

        proveedoresListModel.removeAllElements();

        List<ProveedoresEntity> proves = ProveedorController.filtrarProveedores(1);

        for (ProveedoresEntity p : proves) {
            proveedoresListModel.addElement(p);
        }

        select.setModel(proveedoresListModel);

    }

    public void listaPiezas(int index) {
        DefaultComboBoxModel<PiezasEntity> piezasListModel = new DefaultComboBoxModel<>();

        piezasListModel.removeAllElements();

        List<PiezasEntity> piezas;

        if (index == -1){
            piezas = PiezaController.leerTodosPiezas();
        } else {
            int idprov = ((ProveedoresEntity)(newProveedorPedido.getSelectedItem())).getIdproveedor();
            List<PiezasEntity> altas = PiezaController.filtrarPiezas(1);
            List<PiezasEntity> delprov = PiezaController.piezasPorProveedor(idprov);
            piezas = intersenct(altas, delprov);
        }

        for (PiezasEntity p : piezas) {
            piezasListModel.addElement(p);
        }

        newPiezaPedido.setModel(piezasListModel);

    }

    public static List<PiezasEntity> intersenct(List<PiezasEntity> lista1, List<PiezasEntity> lista2) {

        List<PiezasEntity> intersectedList = new ArrayList<>();

        for (PiezasEntity p1 : lista1) {
            for (PiezasEntity p2 : lista2) {
                if (p1.getIdpieza() == p2.getIdpieza()) {
                    intersectedList.add(p1);
                }
            }
        }

        return intersectedList;

    }



    public NuevoPedido(JTable tabla, JButton ver, JButton cancelar){

        setContentPane(nuevoPedido);

        listaProveedores(newProveedorPedido);
        listaPiezas(-1);
        listaProyectos(newProyectoPedido);
        SpinnerNumberModel spinnermodel = new SpinnerNumberModel(0,0,1000,1);
        newCantidadPedido.setModel(spinnermodel);
        clearForm();

        newProyectoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoPedido.setEnabled(true);
                newProyectoPedido.setBackground(Main.white);
            }
        });

        newProveedorPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoPedido.setEnabled(true);
                newProveedorPedido.setBackground(Main.white);
                listaPiezas(newProveedorPedido.getSelectedIndex());
                newPiezaPedido.setSelectedIndex(-1);
            }
        });

        newPiezaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoPedido.setEnabled(true);
                newPiezaPedido.setBackground(Main.white);
            }
        });

        newCantidadPedido.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) newCantidadPedido.getValue() > 0.0){
                    guardarNuevoPedido.setEnabled(true);
                    newCantidadPedido.getEditor().getComponent(0).setBackground(Main.white);
                }

            }

        });


        cancelarNuevoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        guardarNuevoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarNuevoPedido.setEnabled(false);
                cancelarNuevoPedido.setEnabled(false);

                if (newProyectoPedido.getSelectedIndex() == -1 || newProveedorPedido.getSelectedIndex() == -1 || newPiezaPedido.getSelectedIndex() == -1 ||(int)newCantidadPedido.getValue() == 0) {

                    if (newProyectoPedido.getSelectedIndex() == -1) {
                        newProyectoPedido.setBackground(Main.error);
                    }

                    if (newProveedorPedido.getSelectedIndex() == -1) {
                        newProveedorPedido.setBackground(Main.error);
                    }

                    if (newPiezaPedido.getSelectedIndex() == -1) {
                        newPiezaPedido.setBackground(Main.error);
                    }

                    if ((int)newCantidadPedido.getValue() == 0) {
                        newCantidadPedido.getEditor().getComponent(0).setBackground(Main.error);
                    }

                    cancelarNuevoPedido.setEnabled(true);

                } else {

                    disableForm();
                    ProyectosEntity proyecto = (ProyectosEntity) newProyectoPedido.getSelectedItem();
                    ProveedoresEntity proveedor = (ProveedoresEntity) newProveedorPedido.getSelectedItem();
                    PiezasEntity pieza = (PiezasEntity) newPiezaPedido.getSelectedItem();
                    int cantidad = (int) newCantidadPedido.getValue();
                    if (PedidosController.nuevoPedido(cantidad, proveedor.getIdproveedor(), pieza.getIdpieza(), proyecto.getIdproyecto())){
                        clearForm();
                        tabla.setModel(new PedidosTableModel(PedidosController.leerTodosPedidos()));
                        ver.setEnabled(false);
                        cancelar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Nuevo pedido guardado.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar el pedido.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }


            }
        });


    }
}
