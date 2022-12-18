package com.proyecto;

import com.proyecto.controller.PiezaController;
import com.proyecto.controller.ProveedorController;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "piezas", schema = "gestionpedidos")
public class PiezasEntity {

    private int idpieza;
    private String nombre;
    private double precio;
    private String descripcion;
    private byte alta;
    private Collection<PedidosEntity> pedidosByIdpieza;
    private ProveedoresEntity proveedoresByIdproveedor;



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpieza", nullable = false)
    public int getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(int idpieza) {
        this.idpieza = idpieza;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 20)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio", nullable = false, precision = 0)
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "alta", nullable = false)
    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }


    @OneToMany(mappedBy = "piezasByIdpieza")
    public Collection<PedidosEntity> getPedidosByIdpieza() {
        return pedidosByIdpieza;
    }

    public void setPedidosByIdpieza(Collection<PedidosEntity> pedidosByIdpieza) {
        this.pedidosByIdpieza = pedidosByIdpieza;
    }

    @ManyToOne
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor", nullable = false)

    public ProveedoresEntity getProveedoresByIdproveedor() {
        return proveedoresByIdproveedor;
        //ProveedorController.leerProveedor(PiezaController.idProveedorPieza(this.idpieza));
    }

    public void setProveedoresByIdproveedor(ProveedoresEntity proveedoresByIdproveedor) {
        this.proveedoresByIdproveedor = proveedoresByIdproveedor;
    }


    @Override
    public String toString() {
        return "PIEZ-" + idpieza + " : " + nombre;
    }


}
