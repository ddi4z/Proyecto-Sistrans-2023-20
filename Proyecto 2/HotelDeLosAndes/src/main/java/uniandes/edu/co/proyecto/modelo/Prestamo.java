package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Servicio servicio;

    private String utensilio;
    private Double costoPerdida;
    private Boolean devuelto;

    @ManyToOne
    @JoinColumn(name = "num_documento_cliente", referencedColumnName = "numDocumento")
    private Usuario cliente;

    public Prestamo(String utensilio, Double costoPerdida, Boolean devuelto, Usuario cliente) {
        this.utensilio = utensilio;
        this.costoPerdida = costoPerdida;
        this.devuelto = devuelto;
        this.cliente = cliente;
    }

    public Prestamo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}
