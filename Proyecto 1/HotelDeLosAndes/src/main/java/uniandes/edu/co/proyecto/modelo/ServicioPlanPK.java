package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicioPlanPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Servicio_id", referencedColumnName = "id")
    private Servicio servicioId;

    @ManyToOne
    @JoinColumn(name = "PlanConsumo_id", referencedColumnName = "id")
    private PlanConsumo planConsumoId;

    public ServicioPlanPK(Servicio servicioId, PlanConsumo planConsumoId) {
        super();
        this.servicioId = servicioId;
        this.planConsumoId = planConsumoId;
    }

    public Servicio getServicioId() {
        return servicioId;
    }

    public void setServicioId(Servicio servicioId) {
        this.servicioId = servicioId;
    }

    public PlanConsumo getPlanConsumoId() {
        return planConsumoId;
    }

    public void setPlanConsumoId(PlanConsumo planConsumoId) {
        this.planConsumoId = planConsumoId;
    }
}
