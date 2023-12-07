package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicioSpaReservaSpaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ReservaSpa_id", referencedColumnName = "id")
    private ReservaSpa reservaSpaId;

    @ManyToOne
    @JoinColumn(name = "ServicioSpa_id", referencedColumnName = "id")
    private ServicioSpa servicioSpaId;

    public ServicioSpaReservaSpaPK(ReservaSpa reservaSpaId, ServicioSpa servicioSpaId) {
        super();
        this.reservaSpaId = reservaSpaId;
        this.servicioSpaId = servicioSpaId;
    }

    public ReservaSpa getReservaSpaId() {
        return reservaSpaId;
    }

    public void setReservaSpaId(ReservaSpa reservaSpaId) {
        this.reservaSpaId = reservaSpaId;
    }

    public ServicioSpa getServicioSpaId() {
        return servicioSpaId;
    }

    public void setServicioSpaId(ServicioSpa servicioSpaId) {
        this.servicioSpaId = servicioSpaId;
    }

    

}
