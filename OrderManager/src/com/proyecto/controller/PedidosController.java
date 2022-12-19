package com.proyecto.controller;

import com.proyecto.PedidosEntity;
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

    public static Boolean nuevoPedido(int cantidad, int idproveedor, int idpieza, int idproyecto){
        PedidosEntity p = new PedidosEntity();
        p.setCantidad(cantidad);
        p.setProveedoresByIdproveedor(ProveedorController.leerProveedor(idproveedor));
        p.setPiezasByIdpieza(PiezaController.leerPieza(idpieza));
        p.setProyectosByIdproyecto(ProyectoController.leerProyecto(idproyecto));
        p.setAlta((byte)1);
        if (HibernateUtil.guardar(p)){
            return true;
        } else {
            return false;
        }
    }


    public static Boolean bajaPedido(int id){
        PedidosEntity p = leerPedido(id);
        if(p != null){
            p.setAlta((byte)0);
            if(HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }



    public static List<PedidosEntity> filtrarPedidos(Integer proveedor, Integer pieza, Integer proyecto, Integer alta) {

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

        List<Object> objetos = HibernateUtil.filtrar(PedidosEntity.class, sentencia);
        List<PedidosEntity> pedidos = new ArrayList<>();
        if (objetos != null){
            for (Object o : objetos) {
                pedidos.add((PedidosEntity) o);
            }
        }
        return pedidos;

    }



    public static List<Integer> top5Piezas(){

        String sentencia = "SELECT idpieza, SUM(cantidad) FROM pedidos GROUP  BY idpieza ORDER BY SUM(cantidad) DESC";
        List<Object> objetos = HibernateUtil.sentenciaTop5(sentencia);
        List<Integer> top5 = new ArrayList<>();


        int i = 0;
        for (Object o : objetos) {
            if(i<5){
                Object[] piezacanti = (Object[]) o;
                top5.add((int) piezacanti[0]);
                top5.add((int)(double) piezacanti[1]);
            }
            i++;
        }

        return top5;

    }

    public static List<Integer> top5Proveedores(){

        String sentencia = "SELECT idproveedor, SUM(cantidad) FROM pedidos GROUP  BY idproveedor ORDER BY SUM(cantidad) DESC";
        List<Object> objetos = HibernateUtil.sentenciaTop5(sentencia);
        List<Integer> top5 = new ArrayList<>();

        int i = 0;
        for (Object o : objetos) {
            if(i<5){
                Object[] proveecanti = (Object[]) o;
                top5.add((int) proveecanti[0]);
                top5.add((int)(double) proveecanti[1]);
            }
            i++;
        }

        return top5;

    }

    public static List<Integer> top5Proyectos(){

        String sentencia = "SELECT idproyecto, SUM(cantidad) FROM pedidos GROUP  BY idproyecto ORDER BY SUM(cantidad) DESC";
        List<Object> objetos = HibernateUtil.sentenciaTop5(sentencia);
        List<Integer> top5 = new ArrayList<>();


        int i = 0;
        for (Object o : objetos) {
            if(i<5){
                Object[] proyecanti = (Object[]) o;
                top5.add((int) proyecanti[0]);
                top5.add((int)(double) proyecanti[1]);
            }
            i++;
        }


        return top5;

    }


}
