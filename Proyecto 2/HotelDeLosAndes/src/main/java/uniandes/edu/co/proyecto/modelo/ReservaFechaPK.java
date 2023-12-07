package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservaFechaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Reserva_id", referencedColumnName = "id")
    private Reserva reservaId;

    @ManyToOne
    @JoinColumn(name = "fecha", referencedColumnName = "fecha")
    private Fecha fecha;

    public ReservaFechaPK(Reserva reservaId, Fecha fecha) {
        super();
        this.reservaId = reservaId;
        this.fecha = fecha;
    }

    public Reserva getReservaId() {
        return reservaId;
    }

    public void setReservaId(Reserva reservaId) {
        this.reservaId = reservaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
}
