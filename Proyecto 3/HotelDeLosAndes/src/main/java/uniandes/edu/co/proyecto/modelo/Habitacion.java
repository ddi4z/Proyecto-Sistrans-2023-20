package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "habitaciones")
public class Habitacion {
    @Id
    private int id;
    private boolean ocupada;
    private int tipo;

    public Habitacion(boolean ocupada, int tipo) {
        this.ocupada = ocupada;
        this.tipo = tipo;
    }

    public Habitacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
