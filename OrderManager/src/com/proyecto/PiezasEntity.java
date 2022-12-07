package com.proyecto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "piezas", schema = "gestionpedidos", catalog = "")
public class PiezasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpieza", nullable = false)
    private int idpieza;
    @Basic
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    @Basic
    @Column(name = "precio", nullable = false, precision = 0)
    private double precio;
    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)
    private String descripcion;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @OneToMany(mappedBy = "piezasByIdpieza")
    private Collection<PedidosEntity> pedidosByIdpieza;
    @ManyToOne
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor", nullable = false)
    private ProveedoresEntity proveedoresByIdproveedor;

    public int getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(int idpieza) {
        this.idpieza = idpieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }

    public Collection<PedidosEntity> getPedidosByIdpieza() {
        return pedidosByIdpieza;
    }

    public void setPedidosByIdpieza(Collection<PedidosEntity> pedidosByIdpieza) {
        this.pedidosByIdpieza = pedidosByIdpieza;
    }

    public ProveedoresEntity getProveedoresByIdproveedor() {
        return proveedoresByIdproveedor;
    }

    public void setProveedoresByIdproveedor(ProveedoresEntity proveedoresByIdproveedor) {
        this.proveedoresByIdproveedor = proveedoresByIdproveedor;
    }
}
