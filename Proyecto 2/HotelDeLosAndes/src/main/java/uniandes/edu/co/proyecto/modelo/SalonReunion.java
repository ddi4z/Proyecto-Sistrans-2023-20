package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALONESREUNION")
public class SalonReunion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Servicio servicio;

    private Integer capacidad;
    private Double costoHora;
    private Double costoEquipos;

    public SalonReunion(Integer capacidad, Double costoHora, Double costoEquipos) {
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.costoEquipos = costoEquipos;
    }

    public SalonReunion() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(Double costoHora) {
        this.costoHora = costoHora;
    }

    public Double getCostoEquipos() {
        return costoEquipos;
    }

    public void setCostoEquipos(Double costoEquipos) {
        this.costoEquipos = costoEquipos;
    }
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

}
