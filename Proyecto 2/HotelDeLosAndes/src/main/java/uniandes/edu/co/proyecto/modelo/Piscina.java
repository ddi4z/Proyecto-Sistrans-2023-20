package uniandes.edu.co.proyecto.modelo;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscinas")
public class Piscina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Servicio servicio;

    private Integer capacidad;
    private Integer profundidad;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Double costoAdicional;

    public Piscina(Integer capacidad, Integer profundidad, LocalTime horaInicio, LocalTime horaFin,
        Double costoAdicional) {
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.costoAdicional = costoAdicional;
    }

    public Piscina() {}

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

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Double getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(Double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
