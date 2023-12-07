package uniandes.edu.co.proyecto.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prestamos")
public class Prestamo {
    @Id
    private int id;
    private String utensilio;
    private Double costoPerdida;
    private Boolean devuelto;
    private String cliente;
    private int habitacion;

    public Prestamo(String utensilio, Double costoPerdida, Boolean devuelto, String cliente, int habitacion) {
        this.utensilio = utensilio;
        this.costoPerdida = costoPerdida;
        this.devuelto = devuelto;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public Prestamo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUtensilio() {
        return utensilio;
    }

    public void setUtensilio(String utensilio) {
        this.utensilio = utensilio;
    }

    public Double getCostoPerdida() {
        return costoPerdida;
    }

    public void setCostoPerdida(Double costoPerdida) {
        this.costoPerdida = costoPerdida;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }


    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }
}
