package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fechas")
public class Fecha {
    @Id
    private LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Fecha() {}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
