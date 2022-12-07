package com.proyecto.controller;

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

    public static void nuevoProveedor(String nombre, String apellidos, String direccion){
        ProveedoresEntity p = new ProveedoresEntity();
        p.setNombre(nombre);
        p.setApellidos(apellidos);
        p.setDireccion(direccion);
        p.setAlta((byte)1);
        HibernateUtil.guardar(p);
    }

    public static void editarProveedor(int id, String nombre, String apellidos, String direccion){
        ProveedoresEntity p = leerProveedor(id);
        if(p != null){
            p.setNombre(nombre);
            p.setApellidos(apellidos);
            p.setDireccion(direccion);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el proveedor a editar.");
        }
    }

    public static void bajaProveedor(int id){
        ProveedoresEntity p = leerProveedor(id);
        if(p != null){
            p.setAlta((byte)0);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el proveedor a dar de baja.");
        }
    }

    public static void altaProveedor(int id){
        ProveedoresEntity p = leerProveedor(id);
        if(p != null){
            p.setAlta((byte)1);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el proveedor a dar de baja.");
        }
    }



}