package com.proyecto.controller;

import com.proyecto.PiezasEntity;
import com.proyecto.ProveedoresEntity;
import com.proyecto.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProveedorController {

    public static List<ProveedoresEntity> leerTodosProveedores() {
        List<Object> objetos = HibernateUtil.leerTodos(ProveedoresEntity.class);
        List<ProveedoresEntity> proveedores = new ArrayList<>();
        for (Object o : objetos) {
            proveedores.add((ProveedoresEntity) o);
        }
        return proveedores;
    }


    public static ProveedoresEntity leerProveedor(int id) {
        ProveedoresEntity p = (ProveedoresEntity) HibernateUtil.leerObjeto(ProveedoresEntity.class, id);
        return p;
    }

    public static Boolean nuevoProveedor(String nombre, String apellidos, String direccion) {
        ProveedoresEntity p = new ProveedoresEntity();
        p.setNombre(nombre);
        p.setApellidos(apellidos);
        p.setDireccion(direccion);
        p.setAlta((byte) 1);
        if (HibernateUtil.guardar(p)){
            return true;
        } else {
            return false;
        }
    }

    public static Boolean editarProveedor(int id, String nombre, String apellidos, String direccion) {
        ProveedoresEntity p = leerProveedor(id);
        if (p != null) {
            p.setNombre(nombre);
            p.setApellidos(apellidos);
            p.setDireccion(direccion);
            if (HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean bajaProveedor(int id) {
        ProveedoresEntity p = leerProveedor(id);
        if (p != null) {
            p.setAlta((byte) 0);
            if (HibernateUtil.actualizar(p)){
                List<PiezasEntity> piezasdeproveedor = PiezaController.piezasPorProveedor(id);
                for (PiezasEntity pi : piezasdeproveedor){
                    PiezaController.bajaPieza(pi.getIdpieza());
                }

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean altaProveedor(int id) {
        ProveedoresEntity p = leerProveedor(id);
        if (p != null) {
            p.setAlta((byte) 1);
            if(HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public static List<ProveedoresEntity> filtrarProveedores(int alta) {

        String sentencia = "";
        if (alta == 1) {
            sentencia = "WHERE alta = 1";

        } else if (alta == 2) {

            sentencia = "WHERE alta = 0";

        }
        List<Object> objetos = HibernateUtil.filtrar(ProveedoresEntity.class, sentencia);
        List<ProveedoresEntity> proveedores = new ArrayList<>();
        for (Object o : objetos) {
            proveedores.add((ProveedoresEntity) o);
        }
        return proveedores;

    }


}
