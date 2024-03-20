package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SpaServicioSpaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Spa_id", referencedColumnName = "id")
    private Spa spaId;

    @ManyToOne
    @JoinColumn(name = "ServicioSpa_id", referencedColumnName = "id")
    private ServicioSpa servicioSpaId;

    public SpaServicioSpaPK(Spa spaId, ServicioSpa servicioSpaId) {
        super();
        this.spaId = spaId;
        this.servicioSpaId = servicioSpaId;
    }

    public Spa getSpaId() {
        return spaId;
    }

    public void setSpaId(Spa spaId) {
        this.spaId = spaId;
    }

    public ServicioSpa getServicioSpaId() {
        return servicioSpaId;
    }

    public void setServicioSpaId(ServicioSpa servicioSpaId) {
        this.servicioSpaId = servicioSpaId;
    }
}
