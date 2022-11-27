package Modelo;

import javax.persistence.*;

@Entity
@Table(name = "pedidos", schema = "gestionpedidos", catalog = "")
public class PedidosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod", nullable = false, length = 6)
    private String cod;
    @Basic
    @Column(name = "proveedor", nullable = false, length = 6)
    private String proveedor;
    @Basic
    @Column(name = "pieza", nullable = false, length = 6)
    private String pieza;
    @Basic
    @Column(name = "proyecto", nullable = false, length = 6)
    private String proyecto;
    @Basic
    @Column(name = "cantidad", nullable = false, precision = 0)
    private double cantidad;
    @Basic
    @Column(name = "alta", nullable = false)
    private byte alta;
    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "cod", nullable = false)
    private ProveedoresEntity proveedoresByProveedor;
    @ManyToOne
    @JoinColumn(name = "pieza", referencedColumnName = "cod", nullable = false)
    private PiezasEntity piezasByPieza;
    @ManyToOne
    @JoinColumn(name = "proyecto", referencedColumnName = "cod", nullable = false)
    private ProyectosEntity proyectosByProyecto;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
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
