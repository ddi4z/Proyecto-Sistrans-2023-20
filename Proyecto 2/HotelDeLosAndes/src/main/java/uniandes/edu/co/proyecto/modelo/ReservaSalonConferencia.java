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
@Table(name = "reservasSalonConferencia")
public class ReservaSalonConferencia {
    private static final Integer duracionLimpieza = 720;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime horaInicio;
    private Integer duracion;
    private Double costo;
    private LocalDateTime horaFinLimpieza;

    @ManyToOne
    @JoinColumn(name = "id_salon", referencedColumnName = "id")
    private SalonReunion salon;

    @ManyToOne
    @JoinColumn(name = "num_documento", referencedColumnName = "numDocumento")
    private Usuario usuario;

    public ReservaSalonConferencia(LocalDateTime horaInicio, Integer duracion, Double costo, 
        SalonReunion salon, Usuario usuario) {
        this.horaInicio = horaInicio;
        this.duracion = duracion;
        this.costo = costo;
        this.horaFinLimpieza = horaInicio.plusMinutes(duracion + duracionLimpieza);
        this.salon = salon;
        this.usuario = usuario;
    }

    public ReservaSalonConferencia() {}

    public static Integer getDuracionLimpieza() {
        return duracionLimpieza;
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
        this.horaFinLimpieza = horaInicio.plusMinutes(duracion + duracionLimpieza);
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
        this.horaFinLimpieza = horaInicio.plusMinutes(duracion + duracionLimpieza);
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public LocalDateTime getHoraFinLimpieza() {
        return horaFinLimpieza;
    }

    public SalonReunion getSalon() {
        return salon;
    }

    public void setSalon(SalonReunion salon) {
        this.salon = salon;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

