package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Servicio servicio;

    private String utensilio;
    private Double costoPerdida;
    private Boolean devuelto;

    public Prestamo(String utensilio, Double costoPerdida, Boolean devuelto) {
        this.utensilio = utensilio;
        this.costoPerdida = costoPerdida;
        this.devuelto = devuelto;
    }

    public Prestamo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUtensilio() {
        return utensilio;
    }

    public void setUtensilio(String utensilio) {
        this.utensilio = utensilio;
    }

    public Double getCostoPerdida() {
        return costoPerdida;
    }

    public void setCostoPerdida(Double costoPerdida) {
        this.costoPerdida = costoPerdida;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
