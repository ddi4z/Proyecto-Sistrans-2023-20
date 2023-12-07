package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservasSalonReunion")
public class ReservaSalonReunion {
    private static final Integer duracionLimpieza = 60;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime horaInicio;
    private Integer duracion;
    private Double costo;
    private LocalDateTime horafinLimpieza;

    @ManyToOne
    @JoinColumn(name = "id_salon", referencedColumnName = "id")
    private SalonReunion salon;

    public ReservaSalonReunion(LocalDateTime horaInicio, Integer duracion, Double costo, SalonReunion salon) {
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.costo = costo;
        this.horafinLimpieza = horaInicio.plusMinutes(duracion + duracionLimpieza);
        this.salon = salon;
    }

    public ReservaSalonReunion() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
        this.horafinLimpieza = horaInicio.plusMinutes(duracion + duracionLimpieza);
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
        this.horafinLimpieza = horaInicio.plusMinutes(duracion + duracionLimpieza);
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public LocalDateTime getHorafinLimpieza() {
        return horafinLimpieza;
    }

    public SalonReunion getSalon() {
        return salon;
    }

    public void setSalon(SalonReunion salon) {
        this.salon = salon;
    }

}
