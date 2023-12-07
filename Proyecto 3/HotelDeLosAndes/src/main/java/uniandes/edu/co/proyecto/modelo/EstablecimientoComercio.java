package uniandes.edu.co.proyecto.modelo;

import java.util.List;

public class EstablecimientoComercio extends Servicio{
    private String tipoEstablecimiento;
    private List<Producto> productos;

    public EstablecimientoComercio(String nombre, String tipo, String tipoEstablecimiento, List<Producto> productos) {
        super(nombre, tipo);
        this.tipoEstablecimiento = tipoEstablecimiento;
        this.productos = productos;

    }

    public EstablecimientoComercio() {}

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    

}
