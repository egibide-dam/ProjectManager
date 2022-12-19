package com.proyecto.controller;

import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PiezaController {

    public static List<PiezasEntity> leerTodosPiezas() {
        List<Object> objetos = HibernateUtil.leerTodos(PiezasEntity.class);
        List<PiezasEntity> piezas = new ArrayList<>();
        for (Object o : objetos) {
            piezas.add((PiezasEntity) o);
        }
        return piezas;
    }


    public static PiezasEntity leerPieza(int id) {
        PiezasEntity p = (PiezasEntity) HibernateUtil.leerObjeto(PiezasEntity.class, id);
        return p;
    }

    public static Boolean nuevaPieza(String nombre, double precio, String descripcion, int idproveedor){
        PiezasEntity p = new PiezasEntity();
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setDescripcion(descripcion);
        p.setAlta((byte)1);
        p.setProveedoresByIdproveedor(ProveedorController.leerProveedor(idproveedor));
        if (HibernateUtil.guardar(p)){
            return true;
        } else {
            return false;
        }
    }

    public static Boolean editarPieza(int id, String nombre, double precio, String descripcion){
        PiezasEntity p = leerPieza(id);
        if(p != null){
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setDescripcion(descripcion);
            if (HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean bajaPieza(int id){
        PiezasEntity p = leerPieza(id);
        if(p != null){
            p.setAlta((byte)0);
            if (HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean altaPieza(int id){
        PiezasEntity p = leerPieza(id);
        if(p != null){
            p.setAlta((byte)1);
            if(HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }



    public static List<PiezasEntity> filtrarPiezas(int alta) {

        String sentencia = "";
        if (alta == 1) {
            sentencia = "WHERE alta = 1";

        } else if (alta == 2) {

            sentencia = "WHERE alta = 0";

        }

        List<Object> objetos = HibernateUtil.filtrar(PiezasEntity.class, sentencia);
        List<PiezasEntity> piezas = new ArrayList<>();
        if (objetos.size() > 0){
            for (Object o : objetos) {
                piezas.add((PiezasEntity) o);
            }
        }
        return piezas;

    }


    public static List<PiezasEntity> piezasPorProveedor(int idproveedor){

        String sentencia = "WHERE idproveedor=" + idproveedor;
        List<Object> objetos = HibernateUtil.filtrar(PiezasEntity.class, sentencia);
        List<PiezasEntity> piezas = new ArrayList<>();
        for (Object o : objetos) {
            piezas.add((PiezasEntity) o);
        }
        return piezas;

    }


}
