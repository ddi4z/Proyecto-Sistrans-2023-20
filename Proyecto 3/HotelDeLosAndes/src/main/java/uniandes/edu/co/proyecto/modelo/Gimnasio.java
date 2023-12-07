package uniandes.edu.co.proyecto.modelo;

import java.util.List;

public class Gimnasio extends Servicio{
    private int capacidad;
    private String horaInicio;
    private String horaFin;
    private double costoAdicional;
    private List<MaquinaGimnasio> maquinas;

    public Gimnasio(String nombre, String tipo,int capacidad, String horaInicio, String horaFin, double costoAdicional, List<MaquinaGimnasio> maquinas) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.costoAdicional = costoAdicional;
        this.maquinas = maquinas;
    }

    public Gimnasio() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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

    public List<MaquinaGimnasio> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<MaquinaGimnasio> maquinas) {
        this.maquinas = maquinas;
    }

    

}
