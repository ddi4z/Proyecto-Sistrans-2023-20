package uniandes.edu.co.proyecto.modelo;


public class ServicioLavanderia extends Servicio{
    private double costo;

    public ServicioLavanderia(String nombre, String tipo, double costo) {
        super(nombre, tipo);
        this.costo = costo;
    }

    public ServicioLavanderia() {
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }


}
