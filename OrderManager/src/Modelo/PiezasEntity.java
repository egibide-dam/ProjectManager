package Modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "piezas", schema = "gestionpedidos", catalog = "")
public class PiezasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codpiez", nullable = false)
    private int codpiez;
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
    @Column(name = "proveedor", nullable = false)
    private int proveedor;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @OneToMany(mappedBy = "piezasByPieza")
    private Collection<PedidosEntity> pedidosByCodpiez;
    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "codprov", nullable = false)
    private ProveedoresEntity proveedoresByProveedor;


    public PiezasEntity(int codpiez, String nombre, double precio, String descripcion, int proveedor, byte alta) {
        this.codpiez = codpiez;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.alta = alta;
    }

    public int getCodpiez() {
        return codpiez;
    }

    public void setCodpiez(int codpiez) {
        this.codpiez = codpiez;
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

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public byte getAlta() {
        return alta;
    }

    public void setAlta(byte alta) {
        this.alta = alta;
    }

    public Collection<PedidosEntity> getPedidosByCodpiez() {
        return pedidosByCodpiez;
    }

    public void setPedidosByCodpiez(Collection<PedidosEntity> pedidosByCodpiez) {
        this.pedidosByCodpiez = pedidosByCodpiez;
    }

    public ProveedoresEntity getProveedoresByProveedor() {
        return proveedoresByProveedor;
    }

    public void setProveedoresByProveedor(ProveedoresEntity proveedoresByProveedor) {
        this.proveedoresByProveedor = proveedoresByProveedor;
    }
}
