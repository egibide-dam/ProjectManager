package com.proyecto.controller;

import com.proyecto.ProveedoresEntity;
import com.proyecto.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProveedorController {


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



}
