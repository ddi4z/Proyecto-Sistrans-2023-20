package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasHabitaciones")
public class ReservaHabitacion {
    @EmbeddedId
    private ReservaHabitacionPK pk;

    public ReservaHabitacion(Reserva reservaId, Habitacion habitacionId) {
        this.pk = new ReservaHabitacionPK(reservaId, habitacionId);
    }

    public ReservaHabitacion() {}

    public ReservaHabitacionPK getPk() {
        return pk;
    }

    public void setPk(ReservaHabitacionPK pk) {
        this.pk = pk;
    }
}
