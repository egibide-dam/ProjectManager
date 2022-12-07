package com.proyecto;

import javax.persistence.*;

@Entity
@Table(name = "pedidos", schema = "gestionpedidos", catalog = "")
public class PedidosEntity {

    private int idpedido;
    private double cantidad;
    private byte alta;

    private ProveedoresEntity proveedoresByIdproveedor;
    private PiezasEntity piezasByIdpieza;
    private ProyectosEntity proyectosByIdproyecto;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpedido", nullable = false)

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    @Basic
    @Column(name = "cantidad", nullable = false, precision = 0)

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "alta", nullable = false)

    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }

    @ManyToOne
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor", nullable = false)

    public ProveedoresEntity getProveedoresByIdproveedor() {
        return proveedoresByIdproveedor;
    }

    public void setProveedoresByIdproveedor(ProveedoresEntity proveedoresByIdproveedor) {
        this.proveedoresByIdproveedor = proveedoresByIdproveedor;
    }

    @ManyToOne
    @JoinColumn(name = "idpieza", referencedColumnName = "idpieza", nullable = false)

    public PiezasEntity getPiezasByIdpieza() {
        return piezasByIdpieza;
    }

    public void setPiezasByIdpieza(PiezasEntity piezasByIdpieza) {
        this.piezasByIdpieza = piezasByIdpieza;
    }

    @ManyToOne
    @JoinColumn(name = "idproyecto", referencedColumnName = "idproyecto", nullable = false)

    public ProyectosEntity getProyectosByIdproyecto() {
        return proyectosByIdproyecto;
    }

    public void setProyectosByIdproyecto(ProyectosEntity proyectosByIdproyecto) {
        this.proyectosByIdproyecto = proyectosByIdproyecto;
    }
}
