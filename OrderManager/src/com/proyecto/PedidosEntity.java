package com.proyecto;

import javax.persistence.*;

@Entity
@Table(name = "pedidos", schema = "gestionpedidos", catalog = "")
public class PedidosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpedido", nullable = false)
    private int idpedido;
    @Basic
    @Column(name = "cantidad", nullable = false, precision = 0)
    private double cantidad;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @ManyToOne
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor", nullable = false)
    private ProveedoresEntity proveedoresByIdproveedor;
    @ManyToOne
    @JoinColumn(name = "idpieza", referencedColumnName = "idpieza", nullable = false)
    private PiezasEntity piezasByIdpieza;
    @ManyToOne
    @JoinColumn(name = "idproyecto", referencedColumnName = "idproyecto", nullable = false)
    private ProyectosEntity proyectosByIdproyecto;

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }

    public ProveedoresEntity getProveedoresByIdproveedor() {
        return proveedoresByIdproveedor;
    }

    public void setProveedoresByIdproveedor(ProveedoresEntity proveedoresByIdproveedor) {
        this.proveedoresByIdproveedor = proveedoresByIdproveedor;
    }

    public PiezasEntity getPiezasByIdpieza() {
        return piezasByIdpieza;
    }

    public void setPiezasByIdpieza(PiezasEntity piezasByIdpieza) {
        this.piezasByIdpieza = piezasByIdpieza;
    }

    public ProyectosEntity getProyectosByIdproyecto() {
        return proyectosByIdproyecto;
    }

    public void setProyectosByIdproyecto(ProyectosEntity proyectosByIdproyecto) {
        this.proyectosByIdproyecto = proyectosByIdproyecto;
    }
}
