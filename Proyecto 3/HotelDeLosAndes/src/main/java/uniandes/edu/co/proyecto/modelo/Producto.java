package uniandes.edu.co.proyecto.modelo;

public class Producto {
    private String nombre;

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreProducto) {
        this.nombre = nombreProducto;
    }
}
