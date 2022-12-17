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

    public static Boolean nuevoProyecto(String nombre, String ciudad){
        ProyectosEntity p = new ProyectosEntity();
        p.setNombre(nombre);
        p.setCiudad(ciudad);
        p.setAlta((byte)1);
        if (HibernateUtil.guardar(p)){
            return true;
        } else {
            return false;
        }
    }

    public static Boolean editarProyecto(int id, String nombre, String ciudad){
        ProyectosEntity p = leerProyecto(id);
        if(p != null){
            p.setNombre(nombre);
            p.setCiudad(ciudad);
            if (HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean bajaProyecto(int id){
        ProyectosEntity p = leerProyecto(id);
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

    public static Boolean altaProyecto(int id){
        ProyectosEntity p = leerProyecto(id);
        if(p != null){
            p.setAlta((byte)1);
            if (HibernateUtil.actualizar(p)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
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

    public static List<ProyectosEntity> filtrarProyectos(int alta) {

        String sentencia = "";
        if (alta == 1) {
            sentencia = "WHERE alta = 1";

        } else if (alta == 2) {

            sentencia = "WHERE alta = 0";

        }
        List<Object> objetos = HibernateUtil.filtrar(ProyectosEntity.class, sentencia);
        List<ProyectosEntity> proyectos = new ArrayList<>();
        for (Object o : objetos) {
            proyectos.add((ProyectosEntity) o);
        }
        return proyectos;

    }


}
