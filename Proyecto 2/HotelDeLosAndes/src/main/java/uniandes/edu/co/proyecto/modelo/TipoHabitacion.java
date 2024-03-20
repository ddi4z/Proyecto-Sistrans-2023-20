package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOSHABITACION")
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer capacidad;
    private Double costoNoche;

    public TipoHabitacion(String nombre, Integer capacidad, Double costoNoche) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costoNoche = costoNoche;
    }

    public TipoHabitacion() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(Double costoNoche) {
        this.costoNoche = costoNoche;
    }
}
