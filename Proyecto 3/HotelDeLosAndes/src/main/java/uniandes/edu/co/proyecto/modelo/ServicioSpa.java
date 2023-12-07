package uniandes.edu.co.proyecto.modelo;

public class ServicioSpa {
    private String nombre;
    private int duracionMinutos;
    private double costo;

    public ServicioSpa() {
    }

    public ServicioSpa(String nombre, int duracionMinutos, double costo) {
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public double getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
