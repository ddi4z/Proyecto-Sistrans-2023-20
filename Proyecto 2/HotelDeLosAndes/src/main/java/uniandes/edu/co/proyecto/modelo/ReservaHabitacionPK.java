package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservaHabitacionPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Reserva_id", referencedColumnName = "id")
    private Reserva reservaId;

    @ManyToOne
    @JoinColumn(name = "Habitacion_id", referencedColumnName = "id")
    private Habitacion habitacionId;

    public ReservaHabitacionPK(Reserva reservaId, Habitacion habitacionId) {
        super();
        this.reservaId = reservaId;
        this.habitacionId = habitacionId;
    }

    public Reserva getReservaId() {
        return reservaId;
    }

    public void setReservaId(Reserva reservaId) {
        this.reservaId = reservaId;
    }

    public Habitacion getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Habitacion habitacionId) {
        this.habitacionId = habitacionId;
    }
}
