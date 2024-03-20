package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "elementosHabitacion")
public class ElementoHabitacion {
    @EmbeddedId
    private ElementoHabitacionPK pk;

    public ElementoHabitacion(TipoHabitacion tipoHabitacionId, ElementoDotacion elementoDotacionId) {
        this.pk = new ElementoHabitacionPK(tipoHabitacionId, elementoDotacionId);
    }

    public ElementoHabitacion() {}

    public ElementoHabitacionPK getPk() {
        return pk;
    }

    public void setPk(ElementoHabitacionPK pk) {
        this.pk = pk;
    }
}
