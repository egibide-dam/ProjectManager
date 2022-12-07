package com.proyecto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "proyectos", schema = "gestionpedidos", catalog = "")
public class ProyectosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproyecto", nullable = false)
    private int idproyecto;
    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    @Basic
    @Column(name = "ciudad", nullable = true, length = 40)
    private String ciudad;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @OneToMany(mappedBy = "proyectosByIdproyecto")
    private Collection<PedidosEntity> pedidosByIdproyecto;

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }

    public Collection<PedidosEntity> getPedidosByIdproyecto() {
        return pedidosByIdproyecto;
    }

    public void setPedidosByIdproyecto(Collection<PedidosEntity> pedidosByIdproyecto) {
        this.pedidosByIdproyecto = pedidosByIdproyecto;
    }
}
