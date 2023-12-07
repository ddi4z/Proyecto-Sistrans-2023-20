package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tiposHabitacion")
public class TipoHabitacion {
    @Id
    private int id;
    private String nombre;
    private int capacidad;
    private double costoNoche;
    private List<ElementoDotacion> elementos;

    public TipoHabitacion(String nombre, int capacidad, double costoNoche, List<ElementoDotacion> elementos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costoNoche = costoNoche;
        this.elementos = elementos;
    }

    public TipoHabitacion() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public List<ElementoDotacion> getElementos() {
        return elementos;
    }

    public void setElementos(List<ElementoDotacion> elementos) {
        this.elementos = elementos;
    }
}
