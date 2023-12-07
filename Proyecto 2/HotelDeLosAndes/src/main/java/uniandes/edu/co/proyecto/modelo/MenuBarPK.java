package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MenuBarPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Bar_id", referencedColumnName = "id")
    private Bar barId;

    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto productoId;

    public MenuBarPK(Bar barId, Producto productoId) {
        super();
        this.barId = barId;
        this.productoId = productoId;
    }

    public Bar getBarId() {
        return barId;
    }

    public void setBarId(Bar barId) {
        this.barId = barId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

}

