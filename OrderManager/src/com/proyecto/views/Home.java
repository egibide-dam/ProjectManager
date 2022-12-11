package com.proyecto.views;

import javax.swing.*;

public class Home {
    public JPanel Home;
    private JToolBar Menubar;
    private JButton HOME;
    private JButton Pedidos;
    private JButton Proyectos;
    private JButton Piezas;
    private JButton Proveedores;
    private JPanel paginaPedidos;
    private JLabel pedidosTitle;
    private JButton nuevoPedido;
    private JButton detallePedido;
    private JButton eliminarPedido;
    private JButton editarPedido;
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
    private JTextField searchinputProyectos;
    private JComboBox estadoFiltroProyectos;
    private JButton buscarProyectosboton;
    private JButton limpiarBuscarProyectos;
    private JButton FitlrarProyectos;
    private JButton limpiarFiltrarProyectos;


    public Home(){

        //NAV BAR


        //PAG PEDIDOS
        searchtTextPedidos.setText("Busca por nombre de proyecto,\npieza a proveedor:");
        scrollFiltroPedidos.setBorder(BorderFactory.createEmptyBorder());

        //PAG PROYECTOs
        searchTextProyectos.setText("Busca por nombre de proyecto\no ciudad:");
        scrollFiltroPedidos.setBorder(BorderFactory.createEmptyBorder());





    }


}
