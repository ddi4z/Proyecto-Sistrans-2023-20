package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "menusEstablecimientos")
public class MenuEstablecimiento {
    @EmbeddedId
    private MenuEstablecimientoPK pk;

    public MenuEstablecimiento(EstablecimientoComercio establecimientoId, Producto productoId) {
        this.pk = new MenuEstablecimientoPK(establecimientoId, productoId);
    }

    public MenuEstablecimiento() {
        ;
    }

    public MenuEstablecimientoPK getPk() {
        return pk;
    }

    public void setPk(MenuEstablecimientoPK pk) {
        this.pk = pk;
    }
}