package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MenuEstablecimientoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "EstablecimientoComercio_id", referencedColumnName = "id")
    private EstablecimientoComercio establecimientoId;

    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto productoId;

    public MenuEstablecimientoPK(EstablecimientoComercio establecimientoId, Producto productoId) {
        super();
        this.establecimientoId = establecimientoId;
        this.productoId = productoId;
    }

    public EstablecimientoComercio getEstablecimientoId() {
        return establecimientoId;
    }

    public void setEstablecimientoId(EstablecimientoComercio establecimientoId) {
        this.establecimientoId = establecimientoId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }
}
