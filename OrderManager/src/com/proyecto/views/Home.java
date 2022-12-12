package com.proyecto.views;

import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.TableModels.PedidosTableModel;
import com.proyecto.TableModels.PiezasTableModel;
import com.proyecto.TableModels.ProveedoresTableModel;
import com.proyecto.TableModels.ProyectosTableModel;
import com.proyecto.controller.PedidosController;
import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;
import com.proyecto.controller.ProyectoController;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public void rellenarTop5Piezas(){

        List<Integer> piezas = PedidosController.top5Piezas();

        if (piezas.size() == 0 ){
            //nada
        } else if (piezas.size() == 2){
            topPieza1nombre.setText(piezas.get(0) + "- " + PiezaController.leerPieza(piezas.get(0)).getNombre());
            topPieza1uds.setText(String.valueOf(piezas.get(1)));
        } else if (piezas.size() == 4){
            topPieza2nombre.setText(piezas.get(2) + "- " + PiezaController.leerPieza(piezas.get(2)).getNombre());
            topPieza2uds.setText(String.valueOf(piezas.get(3)));
        } else if (piezas.size() == 6){
            topPieza3nombre.setText(piezas.get(4) + "- " + PiezaController.leerPieza(piezas.get(4)).getNombre());
            topPieza3uds.setText(String.valueOf(piezas.get(5)));
        } else if (piezas.size() == 8){
            topPieza4nombre.setText(piezas.get(6) + "- " + PiezaController.leerPieza(piezas.get(6)).getNombre());
            topPieza4uds.setText(String.valueOf(piezas.get(7)));
        } else if (piezas.size() == 10){
            topPieza5nombre.setText(piezas.get(8) + "- " + PiezaController.leerPieza(piezas.get(8)).getNombre());
            topPieza5uds.setText(String.valueOf(piezas.get(9)));
        }

    }


    public void rellenarTop5Proveedores(){

        List<Integer> provs = PedidosController.top5Proveedores();

        if (provs.size() == 0 ){
            //nada
        } else if (provs.size() == 2){
            topProveedor1nombre.setText(provs.get(0) + "- " + ProveedorController.leerProveedor(provs.get(0)).getNombre() + " " + ProveedorController.leerProveedor(provs.get(0)).getApellidos());
            topProveedor1uds.setText(String.valueOf(provs.get(1)));
        } else if (provs.size() == 4){
            topProveedor2nombre.setText(provs.get(2) + "- " + ProveedorController.leerProveedor(provs.get(2)).getNombre() + " " + ProveedorController.leerProveedor(provs.get(2)).getApellidos());
            topProveedor2uds.setText(String.valueOf(provs.get(3)));
        } else if (provs.size() == 6){
            topProveedor3nombre.setText(provs.get(4) + "- " + ProveedorController.leerProveedor(provs.get(4)).getNombre() + " " + ProveedorController.leerProveedor(provs.get(4)).getApellidos());
            topProveedor3uds.setText(String.valueOf(provs.get(5)));
        } else if (provs.size() == 8){
            topProveedor4nombre.setText(provs.get(6) + "- " + ProveedorController.leerProveedor(provs.get(6)).getNombre() + " " + ProveedorController.leerProveedor(provs.get(6)).getApellidos());
            topProveedor4uds.setText(String.valueOf(provs.get(7)));
        } else if (provs.size() == 10){
            topProveedor5nombre.setText(provs.get(8) + "- " + ProveedorController.leerProveedor(provs.get(8)).getNombre() + " " + ProveedorController.leerProveedor(provs.get(8)).getNombre());
            topProveedor5uds.setText(String.valueOf(provs.get(9)));
        }

    }


    public void rellenarTop5Proyectos(){

        List<Integer> proyecs = PedidosController.top5Proyectos();

        if (PedidosController.leerTodosPedidos().size() == 0 ){
            //nada
        } else if (proyecs.size() == 2){
            topProyect1nombre.setText(proyecs.get(0) + "- " + ProyectoController.leerProyecto(proyecs.get(0)).getNombre());
            topProyect1uds.setText(String.valueOf(proyecs.get(1)));
        } else if (proyecs.size() == 4){
            topProyect2nombre.setText(proyecs.get(2) + "- " + ProyectoController.leerProyecto(proyecs.get(2)).getNombre());
            topProyect2uds.setText(String.valueOf(proyecs.get(3)));
        } else if (proyecs.size() == 6){
            topProyect3nombre.setText(proyecs.get(4) + "- " + ProyectoController.leerProyecto(proyecs.get(4)).getNombre());
            topProyect3uds.setText(String.valueOf(proyecs.get(5)));
        } else if (proyecs.size() == 8){
            topProyect4nombre.setText(proyecs.get(6) + "- " + ProyectoController.leerProyecto(proyecs.get(6)).getNombre());
            topProyect4uds.setText(String.valueOf(proyecs.get(7)));
        } else if (proyecs.size() == 10){
            topProyect5nombre.setText(proyecs.get(8) + "- " + ProyectoController.leerProyecto(proyecs.get(8)).getNombre());
            topProyect5uds.setText(String.valueOf(proyecs.get(9)));
        }

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
                rellenarTop5Piezas();
                rellenarTop5Proveedores();
                rellenarTop5Proyectos();

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


        //PAG HOME

        rellenarTop5Piezas();
        rellenarTop5Proveedores();
        rellenarTop5Proyectos();






        //PAG PEDIDOS
        searchtTextPedidos.setText("Busca por nombre de proyecto,\npieza a proveedor:");
        scrollFiltroPedidos.setBorder(BorderFactory.createEmptyBorder());
        listaProveedores(proveedorFiltroPedido);
        listaPiezas(piezaFiltroPedido);
        listaProyectos(proyectoFiltroPedido);
        tablaPedidos.setModel(new PedidosTableModel(PedidosController.leerTodosPedidos()));


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

        eliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Cancelar Pedido");
                frame.setContentPane(new CancelarPedido().cancelarPedido);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallePedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Detalle de Pedido");
                frame.setContentPane(new DetallePedido().detallePedido);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });






        //PAG PROYECTOS
        searchTextProyectos.setText("Busca por nombre de proyecto\no ciudad:");
        listaProyectos(proyectoFiltroProyecto);
        tablaProyectos.setModel(new ProyectosTableModel(ProyectoController.leerTodosProyectos()));


        nuevoProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Nuevo Proyecto");
                frame.setContentPane(new NuevoProyecto().nuevoProyecto);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        editarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Editar Proyecto");
                frame.setContentPane(new EditarProyecto().editProyecto);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        altaProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Estado Proyecto");
                frame.setContentPane(new BajaProyecto().bajaProyecto);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallesProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Detalle de Proyecto");
                frame.setContentPane(new DetalleProyecto().detalleProyecto);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });


        //PAG PROVEEDORES
        searchTextProveedor.setText("Busca por nombre, apellidos\n o dirección de proveedor:");
        listaProveedores(proveedorFiltroProveedor);
        tablaproveedores.setModel(new ProveedoresTableModel(ProveedorController.leerTodosProveedores()));


        nuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Nuevo Proveedor");
                frame.setContentPane(new NuevoProveedor().nuevoProveedor);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        editarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Editar Proveedor");
                frame.setContentPane(new EditarProveedor().editarProveedor);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        altasProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Estado Proveedor");
                frame.setContentPane(new BajaProveedor().bajaProveedor);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallesProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Detalle de Proveedor");
                frame.setContentPane(new DetalleProveedor().detalleProveedor);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });






        //PAG PIEZAS
        searchTextPiezas.setText("Busca por nombre de pieza:");
        listaPiezas(piezaFiltroPieza);
        tablaPiezas.setModel(new PiezasTableModel(PiezaController.leerTodosPiezas()));


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

        editarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Editar Pieza");
                frame.setContentPane(new EditarPieza().editarPieza);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        altasPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Estado Pieza");
                frame.setContentPane(new BajaPieza().bajaPieza);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallesPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new JFrame("Detalle de Pieza");
                frame.setContentPane(new DetallePieza().detallePieza);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });



    }


}
