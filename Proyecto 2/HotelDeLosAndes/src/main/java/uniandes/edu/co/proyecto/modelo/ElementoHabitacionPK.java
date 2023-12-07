package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ElementoHabitacionPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "TipoHabitacion_id", referencedColumnName = "id")
    private TipoHabitacion tipoHabitacionId;

    @ManyToOne
    @JoinColumn(name = "ElementoDotacion_id", referencedColumnName = "id")
    private ElementoDotacion elementoDotacionId;

    public ElementoHabitacionPK(TipoHabitacion tipoHabitacionId, ElementoDotacion elementoDotacionId) {
        super();
        this.tipoHabitacionId = tipoHabitacionId;
        this.elementoDotacionId = elementoDotacionId;
    }

    public TipoHabitacion getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(TipoHabitacion tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public ElementoDotacion getElementoDotacionId() {
        return elementoDotacionId;
    }

    public void setElementoDotacionId(ElementoDotacion elementoDotacionId) {
        this.elementoDotacionId = elementoDotacionId;
    }

}
