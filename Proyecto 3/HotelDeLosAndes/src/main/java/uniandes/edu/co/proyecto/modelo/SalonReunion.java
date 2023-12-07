package uniandes.edu.co.proyecto.modelo;


public class SalonReunion extends Servicio{
    private int capacidad;
    private double costoHora;
    private double costoEquipos;

    public SalonReunion(String nombre, String tipo, int capacidad, double costoHora, double costoEquipos) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.costoEquipos = costoEquipos;
    }

    public SalonReunion() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(double costoHora) {
        this.costoHora = costoHora;
    }

    public double getCostoEquipos() {
        return costoEquipos;
    }

    public void setCostoEquipos(double costoEquipos) {
        this.costoEquipos = costoEquipos;
    }


    

}
