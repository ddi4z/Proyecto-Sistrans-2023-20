package uniandes.edu.co.proyecto.modelo;

import java.util.List;

public class Restaurante extends Servicio{
    private int capacidad;
    private String estilo;
    private List<Producto> productos;

    public Restaurante(String nombre, String tipo, int capacidad, String estilo, List<Producto> productos) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.estilo = estilo;
        this.productos = productos;
    }

    public Restaurante() {
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
