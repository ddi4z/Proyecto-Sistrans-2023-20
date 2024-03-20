package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "menusBares")
public class MenuBar {
    @EmbeddedId
    private MenuBarPK pk;

    public MenuBar(Bar barId, Producto productoId) {
        this.pk = new MenuBarPK(barId, productoId);
    }

    public MenuBar() {}

    public MenuBarPK getPk() {
        return pk;
    }

    public void setPk(MenuBarPK pk) {
        this.pk = pk;
    }
}

