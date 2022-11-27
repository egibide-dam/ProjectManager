package Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "piezas", schema = "gestionpedidos", catalog = "")
public class PiezasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod", nullable = false, length = 6)
    private String cod;
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
    @Column(name = "proveedor", nullable = false, length = 6)
    private String proveedor;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @OneToMany(mappedBy = "piezasByPieza")
    private Collection<PedidosEntity> pedidosByCod;
    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "cod", nullable = false)
    private ProveedoresEntity proveedoresByProveedor;

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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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

    public ProveedoresEntity getProveedoresByProveedor() {
        return proveedoresByProveedor;
    }

    public void setProveedoresByProveedor(ProveedoresEntity proveedoresByProveedor) {
        this.proveedoresByProveedor = proveedoresByProveedor;
    }
}
