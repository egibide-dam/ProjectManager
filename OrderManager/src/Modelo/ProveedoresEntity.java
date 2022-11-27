package Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "proveedores", schema = "gestionpedidos", catalog = "")
public class ProveedoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod", nullable = false, length = 6)
    private String cod;
    @Basic
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    @Basic
    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;
    @Basic
    @Column(name = "direccion", nullable = false, length = 40)
    private String direccion;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @OneToMany(mappedBy = "proveedoresByProveedor")
    private Collection<PedidosEntity> pedidosByCod;
    @OneToMany(mappedBy = "proveedoresByProveedor")
    private Collection<PiezasEntity> piezasByCod;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Collection<PiezasEntity> getPiezasByCod() {
        return piezasByCod;
    }

    public void setPiezasByCod(Collection<PiezasEntity> piezasByCod) {
        this.piezasByCod = piezasByCod;
    }
}
