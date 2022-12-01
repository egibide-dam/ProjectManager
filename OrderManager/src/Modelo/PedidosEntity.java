package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "pedidos", schema = "gestionpedidos")
public class PedidosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codped", nullable = false)
    private int codped;
    @Basic
    @Column(name = "proveedor", nullable = false)
    private int proveedor;
    @Basic
    @Column(name = "pieza", nullable = false)
    private int pieza;
    @Basic
    @Column(name = "proyecto", nullable = false)
    private int proyecto;
    @Basic
    @Column(name = "cantidad", nullable = false, precision = 0)
    private double cantidad;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "codprov", nullable = false)
    private ProveedoresEntity proveedoresByProveedor;
    @ManyToOne
    @JoinColumn(name = "pieza", referencedColumnName = "codpiez", nullable = false)
    private PiezasEntity piezasByPieza;
    @ManyToOne
    @JoinColumn(name = "proyecto", referencedColumnName = "codproy", nullable = false)
    private ProyectosEntity proyectosByProyecto;

    public int getCodped() {
        return codped;
    }

    public void setCodped(int codped) {
        this.codped = codped;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getPieza() {
        return pieza;
    }

    public void setPieza(int pieza) {
        this.pieza = pieza;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
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

    public ProveedoresEntity getProveedoresByProveedor() {
        return proveedoresByProveedor;
    }

    public void setProveedoresByProveedor(ProveedoresEntity proveedoresByProveedor) {
        this.proveedoresByProveedor = proveedoresByProveedor;
    }

    public PiezasEntity getPiezasByPieza() {
        return piezasByPieza;
    }

    public void setPiezasByPieza(PiezasEntity piezasByPieza) {
        this.piezasByPieza = piezasByPieza;
    }

    public ProyectosEntity getProyectosByProyecto() {
        return proyectosByProyecto;
    }

    public void setProyectosByProyecto(ProyectosEntity proyectosByProyecto) {
        this.proyectosByProyecto = proyectosByProyecto;
    }
}
