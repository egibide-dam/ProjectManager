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
            System.out.println("\nNo se ha encontrado la pieza a dar de baja.");
        }
    }

    public static void altaPieza(int id){
        PiezasEntity p = leerPieza(id);
        if(p != null){
            p.setAlta((byte)1);
            HibernateUtil.actualizar(p);
        } else {
            System.out.println("\nNo se ha encontrado la pieza a dar de alta.");
        }
    }


    public static List<PiezasEntity> buscarPiezas(String busqueda){

        busqueda = busqueda.trim();
        String sentencia = "";
        if (!busqueda.equals("")){

            try {

                int busid = Integer.parseInt(busqueda);
                sentencia = "WHERE idpieza=" + busid;

            } catch (NumberFormatException e){

                sentencia = "WHERE UPPER(nombre) LIKE '%" + busqueda.toUpperCase()  + "%'";

            }

        }
        List<Object> objetos = HibernateUtil.filtrar(PiezasEntity.class, sentencia);
        List<PiezasEntity> piezas = new ArrayList<>();
        for (Object o : objetos) {
            piezas.add((PiezasEntity) o);
        }
        return piezas;

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
        for (Object o : objetos) {
            piezas.add((PiezasEntity) o);
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


    public static int idProveedorPieza(int idpieza){

        String sentencia = "SELECT idproveedor from piezas WHERE idpieza=" + idpieza;
        List<Integer> objetos = HibernateUtil.sentenciaEspecial(sentencia);

        int idproveedor = objetos.get(0);
        return idproveedor;

    }


    public static void main(String[] args) {
        nuevaPieza("Prueba", 2.35, "Nada", 1);
    }


}
