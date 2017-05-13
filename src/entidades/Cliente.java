/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author marces
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private List<Ticket> tickets;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;
    
    @Column(unique = true)
    private Integer dni;
    
    @Column(nullable = false)
    private String apellido, nombre, telefono;
    
    public Cliente() {
        this.tickets = new ArrayList<>();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public boolean agregarTicket(Ticket ticket) {
        return tickets.add(ticket);
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public Integer getDni() {
        return dni;
    }
    
    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono= telefono;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Withs">
    public Cliente withNombre(String nombre) {
        setNombre(nombre);
        return this;
    }
    
    public Cliente withApellido(String apellido) {
        setApellido(apellido);
        return this;
    }
    
    public Cliente withDni(Integer dni) {
        setDni(dni);
        return this;
    }

    public Cliente withTelefono(String telefono) {
        setTelefono(telefono);
        return this;
    }
    
    public Cliente withDireccion(Direccion direccion) {
        setDireccion(direccion);
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return apellido + ", " + nombre; 
    }
    
//</editor-fold> 
}
