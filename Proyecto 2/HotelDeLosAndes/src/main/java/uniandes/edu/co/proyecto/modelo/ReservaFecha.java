package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasFechas")
public class ReservaFecha {
    @EmbeddedId
    private ReservaFechaPK pk;

    public ReservaFecha(Reserva reservaId, Fecha fecha) {
        this.pk = new ReservaFechaPK(reservaId, fecha);
    }

    public ReservaFecha() {}

    public ReservaFechaPK getPk() {
        return pk;
    }

    public void setPk(ReservaFechaPK pk) {
        this.pk = pk;
    }
}
