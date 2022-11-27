package Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "proyectos", schema = "gestionpedidos", catalog = "")
public class ProyectosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod", nullable = false, length = 6)
    private String cod;
    @Basic
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    @Basic
    @Column(name = "ciudad", nullable = true, length = 40)
    private String ciudad;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @OneToMany(mappedBy = "proyectosByProyecto")
    private Collection<PedidosEntity> pedidosByCod;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
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

    public Collection<PedidosEntity> getPedidosByCod() {
        return pedidosByCod;
    }

    public void setPedidosByCod(Collection<PedidosEntity> pedidosByCod) {
        this.pedidosByCod = pedidosByCod;
    }
}
