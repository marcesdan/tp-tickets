/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author marces
 */
@Entity
public class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private Double precio;
    
    @Column(nullable = false)
    private LocalDateTime fechaHora;
    
    @OneToMany
    private List<Ticket> tickets;
    
    @ManyToOne
    private Teatro teatro;
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public boolean agregarTicket(Ticket ticket){
        return tickets.add(ticket);
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha() {
        return fechaHora;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fechaHora = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }
     
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Withs">
    public Funcion withNombre(String nombre) {
        setNombre(nombre);
        return this;
    }
    
    public Funcion withFecha(LocalDateTime fechaHora) {
        setFecha(fechaHora);
        return this;
    }
    
    public Funcion withPrecio(Double precio) {
        setPrecio(precio);
        return this;
    }

    public Funcion withTeatro(Teatro teatro) {
        setTeatro(teatro);
        return this;
    }
    //</editor-fold>   
    
    //<editor-fold defaultstate="collapsed" desc="Metodos generados">
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    
//</editor-fold>
}
