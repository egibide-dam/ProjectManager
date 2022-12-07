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

    public static void nuevaPieza(String nombre, double precio, String descripcion, int idproveedor){
        PiezasEntity p = new PiezasEntity();
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setDescripcion(descripcion);
        p.setAlta((byte)1);
        p.setProveedoresByIdproveedor(ProveedorController.leerProveedor(idproveedor));
        HibernateUtil.guardar(p);
    }

    public static void editarPieza(int id, String nombre, double precio, String descripcion, int idproveedor){
        PiezasEntity p = leerPieza(id);
        if(p != null){
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setDescripcion(descripcion);
            p.setProveedoresByIdproveedor(ProveedorController.leerProveedor(idproveedor));
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado la pieza a editar.");
        }
    }

    public static void bajaPieza(int id){
        PiezasEntity p = leerPieza(id);
        if(p != null){
            p.setAlta((byte)0);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado la pieza a editar.");
        }
    }

    public static void altaPieza(int id){
        PiezasEntity p = leerPieza(id);
        if(p != null){
            p.setAlta((byte)1);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado la pieza a editar.");
        }
    }

}
