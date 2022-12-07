package com.proyecto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "proveedores", schema = "gestionpedidos")
public class ProveedoresEntity {

    private int idproveedor;
    private String nombre;
    private String apellidos;
    private String direccion;
    private byte alta;
    private Collection<PedidosEntity> pedidosByIdproveedor;
    private Collection<PiezasEntity> piezasByIdproveedor;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproveedor", nullable = false)
    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
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
    @Column(name = "apellidos", nullable = false, length = 30)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "direccion", nullable = false, length = 40)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "alta", nullable = false)
    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }

    @OneToMany(mappedBy = "proveedoresByIdproveedor")
    public Collection<PedidosEntity> getPedidosByIdproveedor() {
        return pedidosByIdproveedor;
    }

    public void setPedidosByIdproveedor(Collection<PedidosEntity> pedidosByIdproveedor) {
        this.pedidosByIdproveedor = pedidosByIdproveedor;
    }

    @OneToMany(mappedBy = "proveedoresByIdproveedor")
    public Collection<PiezasEntity> getPiezasByIdproveedor() {
        return piezasByIdproveedor;
    }

    public void setPiezasByIdproveedor(Collection<PiezasEntity> piezasByIdproveedor) {
        this.piezasByIdproveedor = piezasByIdproveedor;
    }


}
