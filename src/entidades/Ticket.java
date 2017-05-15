/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author marces
 */
@Entity
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Funcion funcion;
    
    @ManyToOne
    private Cliente cliente;
    
    @Column(nullable = false)
    private LocalDateTime fechaVenta;

    public Ticket() {
        fechaVenta = LocalDateTime.now();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    //</editor-fold>
 
    //<editor-fold defaultstate="collapsed" desc="Withs">
    public Ticket withFechaVenta(LocalDateTime fecha) {
        setFechaVenta(fecha);
        return this;
    }
    
    public Ticket withFuncion(Funcion funcion) {
        setFuncion(funcion);
        return this;
    }
    
    public Ticket withCliente(Cliente cliente) {
        setCliente(cliente);
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "jpaprueba.Libro[ id=" + id + " ]";
    }
    
    //</editor-fold>
}
