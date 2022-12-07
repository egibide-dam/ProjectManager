package com.proyecto.controller;

import com.proyecto.ProveedoresEntity;
import com.proyecto.ProyectosEntity;
import com.proyecto.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProyectoController {

    public static List<ProyectosEntity> leerTodosProyectos() {
        List<Object> objetos = HibernateUtil.leerTodos(ProyectosEntity.class);
        List<ProyectosEntity> proyectos = new ArrayList<>();
        for (Object o : objetos) {
            proyectos.add((ProyectosEntity) o);
        }
        return proyectos;
    }


    public static ProyectosEntity leerProyecto(int id) {
        ProyectosEntity p = (ProyectosEntity) HibernateUtil.leerObjeto(ProyectosEntity.class, id);
        return p;
    }

    public static void nuevoProyecto(String nombre, String ciudad){
        ProyectosEntity p = new ProyectosEntity();
        p.setNombre(nombre);
        p.setCiudad(ciudad);
        p.setAlta((byte)1);
        HibernateUtil.guardar(p);
    }

    public static void editarProyecto(int id, String nombre, String ciudad){
        ProyectosEntity p = leerProyecto(id);
        if(p != null){
            p.setNombre(nombre);
            p.setCiudad(ciudad);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el proyecto a editar.");
        }
    }

    public static void bajaProyecto(int id){
        ProyectosEntity p = leerProyecto(id);
        if(p != null){
            p.setAlta((byte)0);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el proyecto a dar de baja.");
        }
    }

    public static void altaProyecto(int id){
        ProyectosEntity p = leerProyecto(id);
        if(p != null){
            p.setAlta((byte)1);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado el proyecto a dar de alta.");
        }
    }

    public static List<ProyectosEntity> buscarProyectos(String busqueda){

        busqueda = busqueda.trim();
        String sentencia = "";
        if (!busqueda.equals("")){

            try {

                int busid = Integer.parseInt(busqueda);
                sentencia = "WHERE idproyecto=" + busid;

            } catch (NumberFormatException e){

                sentencia = "WHERE UPPER(nombre) LIKE '%" + busqueda.toUpperCase() + "%' or UPPER(ciudad) LIKE '%";

            }

        }
        List<Object> objetos = HibernateUtil.filtrar(ProyectosEntity.class, sentencia);
        List<ProyectosEntity> proyectos = new ArrayList<>();
        for (Object o : objetos) {
            proyectos.add((ProyectosEntity) o);
        }
        return proyectos;

    }
}
