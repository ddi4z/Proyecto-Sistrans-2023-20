package uniandes.edu.co.proyecto.modelo;


public class Internet extends Servicio{
    private int capacidad;
    private double costoDia;

    public Internet(String nombre, String tipo,int capacidad, double costoDia) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.costoDia = costoDia;
    }

    public Internet() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(double costoDia) {
        this.costoDia = costoDia;
    }


    

}
