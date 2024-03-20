package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tienen")
public class Tienen {
    @EmbeddedId
    private TienenPK pk;

    public Tienen(Gimnasio gimnasioId, MaquinaGimnasio maquinaGimnasioId) {
        this.pk = new TienenPK(gimnasioId, maquinaGimnasioId);
    }

    public Tienen() {}

    public TienenPK getPk() {
        return pk;
    }

    public void setPk(TienenPK pk) {
        this.pk = pk;
    }
}
