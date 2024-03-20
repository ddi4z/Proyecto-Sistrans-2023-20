package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TienenPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Gimnasio_id", referencedColumnName = "id")
    private Gimnasio gimnasioId;

    @ManyToOne
    @JoinColumn(name = "MaquinaGimnasio_id", referencedColumnName = "id")
    private MaquinaGimnasio maquinaGimnasioId;

    public TienenPK(Gimnasio gimnasioId, MaquinaGimnasio maquinaGimnasioId) {
        super();
        this.gimnasioId = gimnasioId;
        this.maquinaGimnasioId = maquinaGimnasioId;
    }

    public Gimnasio getGimnasioId() {
        return gimnasioId;
    }

    public void setGimnasioId(Gimnasio gimnasioId) {
        this.gimnasioId = gimnasioId;
    }

    public MaquinaGimnasio getMaquinaGimnasioId() {
        return maquinaGimnasioId;
    }

    public void setMaquinaGimnasioId(MaquinaGimnasio maquinaGimnasioId) {
        this.maquinaGimnasioId = maquinaGimnasioId;
    }
}
