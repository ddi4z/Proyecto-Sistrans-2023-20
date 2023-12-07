package uniandes.edu.co.proyecto.modelo;



public class Piscina extends Servicio{
    private int capacidad;
    private int profundidad;
    private String horaInicio;
    private String horaFin;
    private double costoAdicional;

    public Piscina(String nombre, String tipo, int capacidad, int profundidad, String horaInicio, String horaFin, double costoAdicional) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.costoAdicional = costoAdicional;
    }

    public Piscina() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }



    

}
