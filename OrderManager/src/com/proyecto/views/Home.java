package com.proyecto.views;

import com.proyecto.*;
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
import java.awt.event.*;
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
    private JComboBox estadoFiltroPieza;
    private JTextField searchinputPiezas;
    private JComboBox estadoFiltroProveedor;
    private JTextArea searchTextProveedor;
    private JTextField searchinputProveedores;
    private JTextField searchinputProyectos;
    private JComboBox estadoFiltroProyectos;
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
    private JButton Ayuda;


    //LISTAS ACTUALES EN TABLA
    List<PiezasEntity> currentPiezasList;
    List<ProveedoresEntity> currentProveedoresList;
    List<ProyectosEntity> currentProyectosList;
    List<PedidosEntity> currentPedidosList;


    ///MÉTODOS
    public void clearPedidos(){

        tablaPedidos.setModel(new PedidosTableModel(PedidosController.leerTodosPedidos()));
        currentPedidosList = PedidosController.leerTodosPedidos();
        detallePedido.setEnabled(false);
        eliminarPedido.setEnabled(false);
        limpiarFiltrarPedidos.setEnabled(false);
        filtrarPedidos.setEnabled(false);
        searchinputPedido.setText("");
        piezaFiltroPedido.setSelectedIndex(-1);
        proveedorFiltroPedido.setSelectedIndex(-1);
        proyectoFiltroPedido.setSelectedIndex(-1);
        estadoFiltroPedido.setSelectedIndex(0);
    }

    public void clearProyectos(){

        tablaProyectos.setModel(new ProyectosTableModel(ProyectoController.leerTodosProyectos()));
        currentProyectosList = ProyectoController.leerTodosProyectos();
        detallesProyecto.setEnabled(false);
        editarProyecto.setEnabled(false);
        altaProyecto.setEnabled(false);
        searchinputProyectos.setText("");
        estadoFiltroProyectos.setSelectedIndex(0);

    }


    public void clearProveedores(){

        tablaproveedores.setModel(new ProveedoresTableModel(ProveedorController.leerTodosProveedores()));
        currentProveedoresList = ProveedorController.leerTodosProveedores();
        detallesProveedor.setEnabled(false);
        editarProveedor.setEnabled(false);
        altasProveedor.setEnabled(false);
        searchinputProveedores.setText("");
        estadoFiltroProveedor.setSelectedIndex(0);

    }

    public void clearPiezas(){
        tablaPiezas.setModel(new PiezasTableModel(PiezaController.leerTodosPiezas()));
        currentPiezasList = PiezaController.leerTodosPiezas();
        detallesPieza.setEnabled(false);
        editarPieza.setEnabled(false);
        altasPieza.setEnabled(false);
        searchinputPiezas.setText("");
        estadoFiltroPieza.setSelectedIndex(0);
    }

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

    private void buscarPedidos(String consulta){
        PedidosTableModel ptm = (PedidosTableModel) tablaPedidos.getModel();
        TableRowSorter<PedidosTableModel> tr = new TableRowSorter<>(ptm);
        tablaPedidos.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    private void buscarProyectos(String consulta){
        ProyectosTableModel ptm = (ProyectosTableModel) tablaProyectos.getModel();
        TableRowSorter<ProyectosTableModel> tr = new TableRowSorter<>(ptm);
        tablaProyectos.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    private void buscarProveedores(String consulta){
        ProveedoresTableModel ptm = (ProveedoresTableModel) tablaproveedores.getModel();
        TableRowSorter<ProveedoresTableModel> tr = new TableRowSorter<>(ptm);
        tablaproveedores.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    private void buscarPiezas(String consulta){
        PiezasTableModel ptm = (PiezasTableModel) tablaPiezas.getModel();
        TableRowSorter<PiezasTableModel> tr = new TableRowSorter<>(ptm);
        tablaPiezas.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
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
                clearPedidos();
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
                clearProyectos();
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
                clearProveedores();

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
                clearPiezas();

            }
        });


        Ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ventanaAyuda();
                frame.setName("Ayuda");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });




        //PAG HOME
        rellenarTop5Piezas();
        rellenarTop5Proveedores();
        rellenarTop5Proyectos();






        //PAG PEDIDOS
        searchtTextPedidos.setText("Busca por id, nombre de\nproyecto, pieza a proveedor:");
        scrollFiltroPedidos.setBorder(BorderFactory.createEmptyBorder());
        listaProveedores(proveedorFiltroPedido);
        listaPiezas(piezaFiltroPedido);
        listaProyectos(proyectoFiltroPedido);
        clearPedidos();


        nuevoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new NuevoPedido(tablaPedidos, detallePedido, eliminarPedido);
                frame.setName("Nuevo Pedido");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        tablaPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = tablaPedidos.getSelectedRow();
                    PedidosEntity ped = currentPedidosList.get(row);
                    Main.currentPedido = PedidosController.leerPedido(ped.getIdpedido());
                    detallePedido.setEnabled(true);
                    if (ped.getAlta()==1){
                        eliminarPedido.setEnabled(true);
                    } else {
                        eliminarPedido.setEnabled(false);
                    }
                } catch (Exception ex) {
                    clearPedidos();
                }
            }
        });

        eliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new CancelarPedido(tablaPedidos, detallePedido, eliminarPedido);
                frame.setName("Cancelar Pedido");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallePedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new DetallePedido();
                frame.setName("Detalle de Pedido");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        searchinputPedido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarPedidos(searchinputPedido.getText());
            }
        });

        proyectoFiltroPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPedidos.setEnabled(true);
                limpiarFiltrarPedidos.setEnabled(true);
                searchinputPedido.setText("");
            }
        });

        proveedorFiltroPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPedidos.setEnabled(true);
                limpiarFiltrarPedidos.setEnabled(true);
                searchinputPedido.setText("");
            }
        });

        piezaFiltroPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPedidos.setEnabled(true);
                limpiarFiltrarPedidos.setEnabled(true);
                searchinputPedido.setText("");
            }
        });

        estadoFiltroPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPedidos.setEnabled(true);
                limpiarFiltrarPedidos.setEnabled(true);
                searchinputPedido.setText("");
            }
        });

        filtrarPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPedidos.setEnabled(false);
                limpiarFiltrarPedidos.setEnabled(true);
                searchinputPedido.setText("");

                Integer proyecto = -1;
                if (proyectoFiltroPedido.getSelectedIndex() != -1){
                    proyecto = ((ProyectosEntity)proyectoFiltroPedido.getSelectedItem()).getIdproyecto();
                }
                Integer proveedor = -1;
                if (proveedorFiltroPedido.getSelectedIndex() != -1){
                    proveedor = ((ProveedoresEntity)proveedorFiltroPedido.getSelectedItem()).getIdproveedor();
                }
                Integer pieza = -1;
                if (piezaFiltroPedido.getSelectedIndex() != -1){
                    pieza = ((PiezasEntity)piezaFiltroPedido.getSelectedItem()).getIdpieza();
                }
                Integer estado = estadoFiltroPedido.getSelectedIndex();
                tablaPedidos.setModel(new PedidosTableModel(PedidosController.filtrarPedidos(proveedor, pieza, proyecto, estado)));
                currentPedidosList = PedidosController.filtrarPedidos(proveedor, pieza, proyecto, estado);
            }
        });

        limpiarFiltrarPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPedidos();
            }
        });







        //PAG PROYECTOS
        searchTextProyectos.setText("Busca por id, nombre de\nproyecto o ciudad:");
        clearProyectos();


        nuevoProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new NuevoProyecto(tablaProyectos,detallesProyecto,editarProyecto,altaProyecto);
                frame.setName("Nuevo Proyecto");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        tablaProyectos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = tablaProyectos.getSelectedRow();
                    ProyectosEntity proy = currentProyectosList.get(row);
                    Main.currentProyecto = ProyectoController.leerProyecto(proy.getIdproyecto());
                    detallesProyecto.setEnabled(true);
                    editarProyecto.setEnabled(true);
                    altaProyecto.setEnabled(true);
                } catch (Exception ex) {
                    clearProyectos();
                }
            }
        });

        editarProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new EditarProyecto(tablaProyectos,detallesProyecto,editarProyecto,altaProyecto);
                frame.setName("Editar Proyecto");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        altaProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new BajaProyecto(tablaProyectos,detallesProyecto,editarProyecto,altaProyecto);
                frame.setName("Estado Proyecto");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallesProyecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new DetalleProyecto();
                frame.setName("Detalle de Proyecto");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        searchinputProyectos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarProyectos(searchinputProyectos.getText());
            }
        });


        estadoFiltroProyectos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estadoFiltroProyectos.getSelectedIndex() != 0){
                    tablaProyectos.setModel(new ProyectosTableModel(ProyectoController.filtrarProyectos(estadoFiltroProyectos.getSelectedIndex())));
                    currentProyectosList = ProyectoController.filtrarProyectos(estadoFiltroProyectos.getSelectedIndex());
                } else {
                    clearProyectos();
                }
            }
        });






        //PAG PROVEEDORES
        searchTextProveedor.setText("Busca por id, nombre, apellidos\no dirección de proveedor:");
        clearProveedores();


        nuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new NuevoProveedor(tablaproveedores, detallesProveedor, editarProveedor, altasProveedor);
                frame.setName("Nuevo Proveedor");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        tablaproveedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = tablaproveedores.getSelectedRow();
                    ProveedoresEntity prov = currentProveedoresList.get(row);
                    Main.currentProveedor = ProveedorController.leerProveedor(prov.getIdproveedor());
                    detallesProveedor.setEnabled(true);
                    editarProveedor.setEnabled(true);
                    altasProveedor.setEnabled(true);
                } catch (Exception ex) {
                    clearProveedores();
                }
            }
        });

        editarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new EditarProveedor(tablaproveedores, detallesProveedor, editarProveedor, altasProveedor);
                frame.setName("Editar Proveedor");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        altasProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new BajaProveedor(tablaproveedores, detallesProveedor, editarProveedor, altasProveedor);
                frame.setName("Estado Proveedor");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallesProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new DetalleProveedor();
                frame.setName("Detalle de Proveedor");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        searchinputProveedores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarProveedores(searchinputProveedores.getText());
            }
        });

        estadoFiltroProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estadoFiltroProveedor.getSelectedIndex() != 0){
                    tablaproveedores.setModel(new ProveedoresTableModel(ProveedorController.filtrarProveedores(estadoFiltroProveedor.getSelectedIndex())));
                    currentProveedoresList = ProveedorController.filtrarProveedores(estadoFiltroProveedor.getSelectedIndex());
                } else {
                    clearProveedores();
                }
            }
        });






        //PAG PIEZAS
        searchTextPiezas.setText("Busca por id o nombre de pieza\no de proveedor:");
        clearPiezas();


        nuevaPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new NuevaPieza(tablaPiezas, detallesPieza, editarPieza, altasPieza);
                frame.setName("Nueva Pieza");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        tablaPiezas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = tablaPiezas.getSelectedRow();
                    PiezasEntity piez = currentPiezasList.get(row);
                    Main.currentPieza = PiezaController.leerPieza(piez.getIdpieza());
                    detallesPieza.setEnabled(true);
                    editarPieza.setEnabled(true);
                    ProveedoresEntity prov = ProveedorController.leerProveedor(piez.getProveedoresByIdproveedor().getIdproveedor());
                    if (prov.getAlta() == 1){
                        altasPieza.setEnabled(true);
                    } else {
                        altasPieza.setEnabled(false);
                    }
                } catch (Exception ex) {
                    clearPiezas();
                }
            }
        });

        editarPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //ABRIR VENTANA!!!
                    JFrame frame = null;
                    frame = new EditarPieza(tablaPiezas, detallesPieza, editarPieza, altasPieza);
                    frame.setName("Editar Pieza");
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } catch (IOException | ClassNotFoundException ex) {

                }

            }
        });

        altasPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new BajaPieza(tablaPiezas, detallesPieza, editarPieza, altasPieza);
                frame.setName("Estado Pieza");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        detallesPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ABRIR VENTANA!!!
                JFrame frame = new DetallePieza();
                frame.setName("Detalle de Pieza");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        searchinputPiezas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarPiezas(searchinputPiezas.getText());
            }
        });

        estadoFiltroPieza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estadoFiltroPieza.getSelectedIndex() != 0){
                    tablaPiezas.setModel(new PiezasTableModel(PiezaController.filtrarPiezas(estadoFiltroPieza.getSelectedIndex())));
                    currentPiezasList = PiezaController.filtrarPiezas(estadoFiltroPieza.getSelectedIndex());
                } else {
                    clearPiezas();
                }
            }
        });


    }


}
