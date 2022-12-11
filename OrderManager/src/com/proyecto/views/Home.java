package com.proyecto.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    public JPanel Home;
    private JToolBar Menubar;
    private JButton Homebutton;
    private JButton Pedidos;
    private JButton Proyectos;
    private JButton Piezas;
    private JButton Proveedores;
    private JPanel paginaPedidos;
    private JLabel pedidosTitle;
    private JButton nuevoPedido;
    private JButton detallePedido;
    private JButton eliminarPedido;
    private JTable tablaPedidos;
    private JScrollPane scrollFiltroPedidos;
    private JComboBox piezaFiltroPedido;
    private JComboBox proveedorFiltroPedido;
    private JComboBox proyectoFiltroPedido;
    private JComboBox estadoFiltroPedido;
    private JTextArea searchtTextPedidos;
    private JButton limpiarbuscarPedidos;
    private JButton buscarPedidosboton;
    private JButton filtrarPedidos;
    private JButton limpiarFiltrarPedidos;
    private JTextField searchinputPedido;
    private JPanel paginaProyectos;
    private JButton detallesProyecto;
    private JButton editarProyecto;
    private JButton altaProyecto;
    private JTable tablaProyectos;
    private JTextArea searchTextProyectos;
    private JPanel paginaProveedores;
    private JButton nuevoProveedor;
    private JButton detallesProveedor;
    private JButton editarProveedor;
    private JButton altasProveedor;
    private JTable tablaproveedores;
    private JPanel paginaPiezas;
    private JButton nuevaPieza;
    private JButton detallesPieza;
    private JButton editarPieza;
    private JButton altasPieza;
    private JTable tablaPiezas;
    private JTextArea searchTextPiezas;
    private JComboBox piezaFiltroPieza;
    private JComboBox estadoFiltroPieza;
    private JButton limpiarBuscarPiezas;
    private JButton buscarPiezasboton;
    private JButton limpiarFiltroPieza;
    private JButton filtrarPieza;
    private JTextField searchinputPiezas;
    private JComboBox proveedorFiltroProveedor;
    private JComboBox estadoFiltroProveedor;
    private JTextArea searchTextProveedor;
    private JButton limpiarBuscarProveedor;
    private JButton buscarProveedorboton;
    private JButton limpiarFiltrosProveedores;
    private JButton filtrarProveedores;
    private JTextField searchinputProveedores;
    private JTextField searchinputProyectos;
    private JButton limpiarBuscarProyectos;
    private JButton buscarProyectoboton;
    private JComboBox proyectoFiltroProyecto;
    private JComboBox estadoFiltroProyectos;
    private JButton limpiarFiltrosProyectos;
    private JButton filtrarProyectos;


    public Home(){

        //NAV BAR

        Homebutton.setEnabled(false);
        Pedidos.setEnabled(true);
        Proyectos.setEnabled(true);
        Piezas.setEnabled(true);
        Proveedores.setEnabled(true);
        paginaPedidos.setVisible(true);
        paginaProyectos.setVisible(false);
        paginaProveedores.setVisible(false);
        paginaPiezas.setVisible(false);


        Homebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homebutton.setEnabled(false);
                Pedidos.setEnabled(true);
                Proyectos.setEnabled(true);
                Piezas.setEnabled(true);
                Proveedores.setEnabled(true);
                paginaPedidos.setVisible(true);
                paginaProyectos.setVisible(false);
                paginaProveedores.setVisible(false);
                paginaPiezas.setVisible(false);
                //blankMatches();

            }
        });

        Pedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homebutton.setEnabled(true);
                Pedidos.setEnabled(false);
                Proyectos.setEnabled(true);
                Piezas.setEnabled(true);
                Proveedores.setEnabled(true);
                paginaPedidos.setVisible(true);
                paginaProyectos.setVisible(false);
                paginaProveedores.setVisible(false);
                paginaPiezas.setVisible(false);
                //blankMatches();
            }
        });

        Proyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homebutton.setEnabled(true);
                Pedidos.setEnabled(true);
                Proyectos.setEnabled(false);
                Piezas.setEnabled(true);
                Proveedores.setEnabled(true);
                paginaPedidos.setVisible(false);
                paginaProyectos.setVisible(true);
                paginaProveedores.setVisible(false);
                paginaPiezas.setVisible(false);
                //blankMatches();
            }
        });

        Piezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homebutton.setEnabled(true);
                Pedidos.setEnabled(true);
                Proyectos.setEnabled(true);
                Piezas.setEnabled(false);
                Proveedores.setEnabled(true);
                paginaPedidos.setVisible(false);
                paginaProyectos.setVisible(false);
                paginaProveedores.setVisible(false);
                paginaPiezas.setVisible(true);
                //blankMatches();

            }
        });

        Proveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homebutton.setEnabled(true);
                Pedidos.setEnabled(true);
                Proyectos.setEnabled(true);
                Piezas.setEnabled(true);
                Proveedores.setEnabled(false);
                paginaPedidos.setVisible(false);
                paginaProyectos.setVisible(false);
                paginaProveedores.setVisible(true);
                paginaPiezas.setVisible(false);
                //blankMatches();

            }
        });


        //PAG PEDIDOS
        searchtTextPedidos.setText("Busca por nombre de proyecto,\npieza a proveedor:");
        scrollFiltroPedidos.setBorder(BorderFactory.createEmptyBorder());

        //PAG PROYECTOS
        searchTextProyectos.setText("Busca por nombre de proyecto\no ciudad:");

        //PAG PROVEEDORES
        searchTextProveedor.setText("Busca por nombre, apellidos\n o dirección de proveedor:");

        //PAG PIEZAS
        searchTextPiezas.setText("Busca por nombre de pieza:");





    }


}
