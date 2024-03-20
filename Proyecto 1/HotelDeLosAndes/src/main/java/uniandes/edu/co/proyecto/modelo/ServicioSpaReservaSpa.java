package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosSpaReservasSpa")
public class ServicioSpaReservaSpa {
    @EmbeddedId
    private ServicioSpaReservaSpaPK pk;

    public ServicioSpaReservaSpa(ReservaSpa reservaSpaId, ServicioSpa servicioSpaId) {
        this.pk = new ServicioSpaReservaSpaPK(reservaSpaId, servicioSpaId);
    }

    public ServicioSpaReservaSpa() {}

    public ServicioSpaReservaSpaPK getPk() {
        return pk;
    }

    public void setPk(ServicioSpaReservaSpaPK pk) {
        this.pk = pk;
    }
}
