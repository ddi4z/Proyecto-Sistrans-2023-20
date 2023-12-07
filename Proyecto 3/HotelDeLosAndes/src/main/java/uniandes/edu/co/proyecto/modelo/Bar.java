package uniandes.edu.co.proyecto.modelo;

import java.util.List;

public class Bar extends Servicio{
    private int capacidad;
    private String estilo;
    private List<Producto> productos;

    public Bar(String nombre, String tipo, int capacidad, String estilo, List<Producto> productos) {
        super(nombre, tipo);
        this.capacidad = capacidad;
        this.estilo = estilo;
        this.productos = productos;

    }

    public Bar() {
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
