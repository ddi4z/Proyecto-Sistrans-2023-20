package uniandes.edu.co.proyecto.modelo;

import java.util.List;

public class Spa extends Servicio{
    private int capacidad;
    private List<ServicioSpa> serviciosSpa;

    public Spa(String nombre, String tipo, int capacidad, String estilo, List<ServicioSpa> serviciosSpa) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.serviciosSpa = serviciosSpa;
    }

    public Spa() {}

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<ServicioSpa> getServiciosSpa() {
        return serviciosSpa;
    }

    public void setServiciosSpa(List<ServicioSpa> serviciosSpa) {
        this.serviciosSpa = serviciosSpa;
    }
}
