package com.proyecto.views;

import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

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
    private JPanel paginaHome;
    private JLabel topPieza1nombre;
    private JLabel topPieza2nombre;
    private JLabel topPieza3nombre;
    private JLabel topPieza4nombre;
    private JLabel topPieza5nombre;
    private JLabel topPieza1uds;
    private JLabel topPieza2uds;
    private JLabel topPieza3uds;
    private JLabel topPieza4uds;
    private JLabel topPieza5uds;
    private JLabel topProveedor1nombre;
    private JLabel topProveedor2nombre;
    private JLabel topProveedor3nombre;
    private JLabel topProveedor4nombre;
    private JLabel topProveedor5nombre;
    private JLabel topProveedor1uds;
    private JLabel topProveedor2uds;
    private JLabel topProveedor3uds;
    private JLabel topProveedor4uds;
    private JLabel topProveedor5uds;
    private JLabel topProyect1nombre;
    private JLabel topProyect2nombre;
    private JLabel topProyect3nombre;
    private JLabel topProyect4nombre;
    private JLabel topProyect5nombre;
    private JLabel topProyect1uds;
    private JLabel topProyect2uds;
    private JLabel topProyect3uds;
    private JLabel topProyect4uds;
    private JLabel topProyect5uds;
    private JButton nuevoProyecto;


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




    public Home(){

        //NAV BAR

        Homebutton.setEnabled(false);
        Pedidos.setEnabled(true);
        Proyectos.setEnabled(true);
        Piezas.setEnabled(true);
        Proveedores.setEnabled(true);
        paginaHome.setVisible(true);
        paginaPedidos.setVisible(false);
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
                paginaHome.setVisible(true);
                paginaPedidos.setVisible(false);
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
                paginaHome.setVisible(false);
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
                paginaHome.setVisible(false);
                paginaPedidos.setVisible(false);
                paginaProyectos.setVisible(true);
                paginaProveedores.setVisible(false);
                paginaPiezas.setVisible(false);
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
                paginaHome.setVisible(false);
                paginaPedidos.setVisible(false);
                paginaProyectos.setVisible(false);
                paginaProveedores.setVisible(true);
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
                paginaHome.setVisible(false);
                paginaPedidos.setVisible(false);
                paginaProyectos.setVisible(false);
                paginaProveedores.setVisible(false);
                paginaPiezas.setVisible(true);
                //blankMatches();

            }
        });



        //PAG PEDIDOS
        searchtTextPedidos.setText("Busca por nombre de proyecto,\npieza a proveedor:");
        scrollFiltroPedidos.setBorder(BorderFactory.createEmptyBorder());
        listaProveedores(proveedorFiltroPedido);
        listaPiezas(piezaFiltroPedido);
        listaProyectos(proyectoFiltroPedido);

        nuevoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Nuevo Pedido");
                frame.setContentPane(new NuevoPedido().nuevoPedido);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });


        //PAG PROYECTOS
        searchTextProyectos.setText("Busca por nombre de proyecto\no ciudad:");
        listaProyectos(proyectoFiltroProyecto);

        nuevoProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Nuevo Pedido");
                frame.setContentPane(new NuevoProyecto().nuevoProyecto);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        //PAG PROVEEDORES
        searchTextProveedor.setText("Busca por nombre, apellidos\n o dirección de proveedor:");
        listaProveedores(proveedorFiltroProveedor);

        nuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Nuevo Pedido");
                frame.setContentPane(new NuevoProveedor().nuevoProveedor);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });


        //PAG PIEZAS
        searchTextPiezas.setText("Busca por nombre de pieza:");
        listaPiezas(piezaFiltroPieza);

        nuevaPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Nueva Pieza");
                frame.setContentPane(new NuevaPieza().nuevaPieza);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });


    }


}
