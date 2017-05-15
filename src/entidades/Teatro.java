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
public class Teatro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    private String telefono, email;
    
    @Column(nullable = false)
    private Integer capacidad;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Direccion direccion;
    
    @OneToMany
    private List<Funcion> funciones;
    
    public Teatro(){
        funciones = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public boolean agregarFuncion(Funcion funcion){
        return funciones.add(funcion);
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
    
    public Integer getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Withs">
    public Teatro withNombre(String nombre) {
        setNombre(nombre);
        return this;
    }
    
    public Teatro withCapacidad(Integer capacidad) {
        setCapacidad(capacidad);
        return this;
    }
    
    public Teatro withDireccion(Direccion direccion) {
        setDireccion(direccion);
        return this;
    }
    
    public Teatro withTelefono(String telefono) {
        setTelefono(nombre);
        return this;
    }
    
    public Teatro withEmail(String email) {
        setEmail(email);
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
        if (!(object instanceof Teatro)) {
            return false;
        }
        Teatro other = (Teatro) object;
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
