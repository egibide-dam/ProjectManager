package com.proyecto.controller;

import com.proyecto.PedidosEntity;
import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PedidosController {

    public static List<PedidosEntity> leerTodosPedidos() {
        List<Object> objetos = HibernateUtil.leerTodos(PedidosEntity.class);
        List<PedidosEntity> pedidos = new ArrayList<>();
        for (Object o : objetos) {
            pedidos.add((PedidosEntity) o);
        }
        return pedidos;
    }


    public static PedidosEntity leerPedido(int id) {
        PedidosEntity p = (PedidosEntity) HibernateUtil.leerObjeto(PedidosEntity.class, id);
        return p;
    }

    public static void nuevoPedido(int cantidad, int idproveedor, int idpieza, int idproyecto){
        PedidosEntity p = new PedidosEntity();
        p.setCantidad(cantidad);
        p.setProveedoresByIdproveedor(ProveedorController.leerProveedor(idproveedor));
        p.setPiezasByIdpieza(PiezaController.leerPieza(idpieza));
        p.setProyectosByIdproyecto(ProyectoController.leerProyecto(idproyecto));
        p.setAlta((byte)1);
        HibernateUtil.guardar(p);
    }

    public static void editarPedido(int id, int cantidad, int idproveedor, int idpieza, int idproyecto){
        PedidosEntity p = leerPedido(id);
        if(p != null){
            p.setCantidad(cantidad);
            p.setProveedoresByIdproveedor(ProveedorController.leerProveedor(idproveedor));
            p.setPiezasByIdpieza(PiezaController.leerPieza(idpieza));
            p.setProyectosByIdproyecto(ProyectoController.leerProyecto(idproyecto));
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el pedido a editar.");
        }
    }

    public static void bajaPedido(int id){
        PedidosEntity p = leerPedido(id);
        if(p != null){
            p.setAlta((byte)0);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el pedido a dar de baja.");
        }
    }

    public static void altaPedido(int id){
        PedidosEntity p = leerPedido(id);
        if(p != null){
            p.setAlta((byte)1);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el pedido a dar de alta.");
        }
    }

    public static List<PedidosEntity> buscarPedidos(String busqueda){

        busqueda = busqueda.trim();
        String sentencia = "";
        if (!busqueda.equals("")){

            try {

                int busid = Integer.parseInt(busqueda);
                sentencia = "WHERE idpedido=" + busid;

            } catch (NumberFormatException e){

                sentencia = "WHERE idproveedor = (select idproveedor from " + ProveedoresEntity.class.getName() + " where UPPER(nombre) LIKE '%" + busqueda.toUpperCase() + "%') OR idpieza = (select idpieza from " + PiezasEntity.class.getName() + " where UPPER(nombre) LIKE '%" + busqueda.toUpperCase() + "%') or idproyecto = (select idproyecto from " + ProyectosEntity.class.getName() + " where UPPER(nombre) LIKE '%" + busqueda.toUpperCase() + "%')";

            }

        }
        List<Object> objetos = HibernateUtil.filtrar(PedidosEntity.class, sentencia);
        List<PedidosEntity> pedidos = new ArrayList<>();
        for (Object o : objetos) {
            pedidos.add((PedidosEntity) o);
        }
        return pedidos;

    }


    public static List<PedidosEntity> filtrarPedidos(int proveedor, int pieza, int proyecto, int alta) {

        String sentencia = "";

        if (proveedor != -1){
            sentencia = "WHERE idproveedor=" + proveedor;

            if (pieza != -1){
                sentencia = sentencia + " AND idpieza=" + pieza;
            }

            if (proyecto != -1){
                sentencia = sentencia + " AND idproyecto=" + proyecto;
            }

            if (alta == 1) {
                sentencia = sentencia + " AND alta = 1";

            } else if (alta == 2) {
                sentencia = sentencia + " AND alta = 0";

            }
        } else {
            if (pieza != -1){
                sentencia = "WHERE idpieza=" + pieza;

                if (proyecto != -1){
                    sentencia = sentencia + " AND idproyecto=" + proyecto;
                }

                if (alta == 1) {
                    sentencia = sentencia + " AND alta = 1";

                } else if (alta == 2) {
                    sentencia = sentencia + " AND alta = 0";

                }
            } else {
                if (proyecto != -1){
                    sentencia = "WHERE idproyecto=" + proyecto;

                    if (alta == 1) {
                        sentencia = sentencia + " AND alta = 1";

                    } else if (alta == 2) {
                        sentencia = sentencia + " AND alta = 0";

                    }
                } else {
                    if (alta == 1) {
                        sentencia = "WHERE alta = 1";

                    } else if (alta == 2) {

                        sentencia = "WHERE alta = 0";

                    }
                }
            }
        }
        System.out.println(sentencia);

        List<Object> objetos = HibernateUtil.filtrar(PedidosEntity.class, sentencia);
        List<PedidosEntity> pedidos = new ArrayList<>();
        for (Object o : objetos) {
            pedidos.add((PedidosEntity) o);
        }
        return pedidos;

    }


}
