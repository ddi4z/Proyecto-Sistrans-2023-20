package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviciosPlanes")
public class ServicioPlan {
    @EmbeddedId
    private ServicioPlanPK pk;

    public ServicioPlan(Servicio servicioId, PlanConsumo planConsumoId) {
        this.pk = new ServicioPlanPK(servicioId, planConsumoId);
    }

    public ServicioPlan() {
        ;
    }

    public ServicioPlanPK getPk() {
        return pk;
    }

    public void setPk(ServicioPlanPK pk) {
        this.pk = pk;
    }
}
