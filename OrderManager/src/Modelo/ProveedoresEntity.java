package Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "proveedores", schema = "gestionpedidos", catalog = "")
public class ProveedoresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codprov", nullable = false)
    private int codprov;
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
    private Collection<PedidosEntity> pedidosByCodprov;
    @OneToMany(mappedBy = "proveedoresByProveedor")
    private Collection<PiezasEntity> piezasByCodprov;

    public int getCodprov() {
        return codprov;
    }

    public void setCodprov(int codprov) {
        this.codprov = codprov;
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

    public Collection<PedidosEntity> getPedidosByCodprov() {
        return pedidosByCodprov;
    }

    public void setPedidosByCodprov(Collection<PedidosEntity> pedidosByCodprov) {
        this.pedidosByCodprov = pedidosByCodprov;
    }

    public Collection<PiezasEntity> getPiezasByCodprov() {
        return piezasByCodprov;
    }

    public void setPiezasByCodprov(Collection<PiezasEntity> piezasByCodprov) {
        this.piezasByCodprov = piezasByCodprov;
    }
}
