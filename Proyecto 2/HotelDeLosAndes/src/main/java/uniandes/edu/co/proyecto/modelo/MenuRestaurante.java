package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "menusRestaurantes")
public class MenuRestaurante {
    @EmbeddedId
    private MenuRestaurantePK pk;

    public MenuRestaurante(Restaurante restauranteId, Producto productoId) {
        this.pk = new MenuRestaurantePK(restauranteId, productoId);
    }

    public MenuRestaurante() {}

    public MenuRestaurantePK getPk() {
        return pk;
    }

    public void setPk(MenuRestaurantePK pk) {
        this.pk = pk;
    }
}
