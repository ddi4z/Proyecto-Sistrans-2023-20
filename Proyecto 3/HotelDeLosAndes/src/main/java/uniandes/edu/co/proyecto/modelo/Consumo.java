package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumos")
public class Consumo {
    @Id
    private int id;
    private LocalDateTime fecha;
    private String descripcion;
    private double costo;
    private boolean pagado;
    private int habitacion;
    private int servicio;
    private String cliente;


    public Consumo(LocalDateTime fecha, String descripcion, double costo, boolean pagado, int habitacion,
            int servicio, String cliente) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.costo = costo;
        this.pagado = pagado;
        this.habitacion = habitacion;
        this.servicio = servicio;
        this.cliente = cliente;
    }

    public Consumo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


}
