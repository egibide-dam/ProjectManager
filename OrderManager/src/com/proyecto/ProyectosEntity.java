package com.proyecto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "proyectos", schema = "gestionpedidos")
public class ProyectosEntity {

    private int idproyecto;
    private String nombre;
    private String ciudad;
    private byte alta;
    private Collection<PedidosEntity> pedidosByIdproyecto;



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproyecto", nullable = false)
    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }
    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Basic
    @Column(name = "ciudad", nullable = true, length = 40)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    @Basic
    @Column(name = "alta", nullable = false)
    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }
    @OneToMany(mappedBy = "proyectosByIdproyecto")
    public Collection<PedidosEntity> getPedidosByIdproyecto() {
        return pedidosByIdproyecto;
    }

    public void setPedidosByIdproyecto(Collection<PedidosEntity> pedidosByIdproyecto) {
        this.pedidosByIdproyecto = pedidosByIdproyecto;
    }

    @Override
    public String toString() {
        return "PROY-" + idproyecto + " : " + nombre;
    }
}
