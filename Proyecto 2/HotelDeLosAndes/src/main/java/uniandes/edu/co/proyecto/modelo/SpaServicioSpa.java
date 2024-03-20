package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "spasServiciosSpa")
public class SpaServicioSpa {
    @EmbeddedId
    private SpaServicioSpaPK pk;

    public SpaServicioSpa(Spa spaId, ServicioSpa servicioSpaId) {
        this.pk = new SpaServicioSpaPK(spaId, servicioSpaId);
    }

    public SpaServicioSpa() {}

    public SpaServicioSpaPK getPk() {
        return pk;
    }

    public void setPk(SpaServicioSpaPK pk) {
        this.pk = pk;
    }
}