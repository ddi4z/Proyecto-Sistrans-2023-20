package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double costo;
    private Boolean incluidoEnPlanes;
    
    public Producto(Double costo, Boolean incluidoEnPlanes) {
        this.costo = costo;
        this.incluidoEnPlanes = incluidoEnPlanes;
    }

    public Producto() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Boolean getIncluidoEnPlanes() {
        return incluidoEnPlanes;
    }

    public void setIncluidoEnPlanes(Boolean incluidoEnPlanes) {
        this.incluidoEnPlanes = incluidoEnPlanes;
    }

    
}
