package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MenuRestaurantePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Restaurante_id", referencedColumnName = "id")
    private Restaurante restauranteId;

    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto productoId;

    public MenuRestaurantePK(Restaurante restauranteId, Producto productoId) {
        super();
        this.restauranteId = restauranteId;
        this.productoId = productoId;
    }

    public Restaurante getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Restaurante restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

}
