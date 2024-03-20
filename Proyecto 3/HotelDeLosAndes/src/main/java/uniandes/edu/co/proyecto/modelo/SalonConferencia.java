package uniandes.edu.co.proyecto.modelo;


public class SalonConferencia extends Servicio{
    private int capacidad;
    private Double costoHora;

    public SalonConferencia(String nombre, String tipo,int capacidad, Double costoHora) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.costoHora = costoHora;
    }

    public SalonConferencia() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(Double costoHora) {
        this.costoHora = costoHora;
    }
}
