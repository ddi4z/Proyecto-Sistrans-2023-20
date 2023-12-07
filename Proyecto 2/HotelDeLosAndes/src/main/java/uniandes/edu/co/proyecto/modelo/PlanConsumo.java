package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planesConsumo")
public class PlanConsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate fechaInicioVigencia;
    private LocalDate fechaFinVigencia;
    private String nombre;
    private Double descuentoAlojamiento;
    private Double descuentoBar;
    private Double descuentoRestaurante;
    private Double descuentoSpa;
    private String tipo;

    public PlanConsumo(LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia, String nombre, Double descuentoAlojamiento,
            Double descuentoBar, Double descuentoRestaurante, Double descuentoSpa, String tipo) {
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaFinVigencia = fechaFinVigencia;
        this.nombre = nombre;
        this.descuentoAlojamiento = descuentoAlojamiento;
        this.descuentoBar = descuentoBar;
        this.descuentoRestaurante = descuentoRestaurante;
        this.descuentoSpa = descuentoSpa;
        this.tipo = tipo;
    }

    public PlanConsumo() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public LocalDate getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getDescuentoAlojamiento() {
        return descuentoAlojamiento;
    }

    public void setDescuentoAlojamiento(Double descuentoAlojamiento) {
        this.descuentoAlojamiento = descuentoAlojamiento;
    }

    public Double getDescuentoBar() {
        return descuentoBar;
    }

    public void setDescuentoBar(Double descuentoBar) {
        this.descuentoBar = descuentoBar;
    }

    public Double getDescuentoRestaurante() {
        return descuentoRestaurante;
    }

    public void setDescuentoRestaurante(Double descuentoRestaurante) {
        this.descuentoRestaurante = descuentoRestaurante;
    }

    public Double getDescuentoSpa() {
        return descuentoSpa;
    }

    public void setDescuentoSpa(Double descuentoSpa) {
        this.descuentoSpa = descuentoSpa;
    }

    
}
