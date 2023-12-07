package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "reservas")
public class Reserva {
    @Id
    private int id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int noches;
    private int numeroPersonas;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String cliente;
    private List<Integer> habitaciones;


    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, int noches, int numeroPersonas, LocalDate checkIn, LocalDate checkOut, String cliente, List<Integer> habitaciones) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.noches = noches;
        this.numeroPersonas = numeroPersonas;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cliente = cliente;
        this.habitaciones = habitaciones;

    }

    public Reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Integer> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Integer> habitaciones) {
        this.habitaciones = habitaciones;
    }
    
    
}
