package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservasSpa")
public class ReservaSpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private Double costo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_spa", referencedColumnName = "id")
    private Spa spa;

    @ManyToOne()
    @JoinColumn(name = "num_documento", referencedColumnName = "numDocumento")
    private Usuario usuario;

    public ReservaSpa(LocalDateTime horaInicio, LocalDateTime horaFin, Double costo, Spa spa, Usuario usuario) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.costo = costo;
        this.spa = spa;
        this.usuario = usuario;
    }

    public ReservaSpa() {}

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
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Spa getSpa() {
        return spa;
    }

    public void setSpa(Spa spa) {
        this.spa = spa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
