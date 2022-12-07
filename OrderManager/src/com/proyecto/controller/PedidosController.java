package com.proyecto.controller;

import com.proyecto.PedidosEntity;
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
}
