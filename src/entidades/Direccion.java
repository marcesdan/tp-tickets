/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marces
 */
@Entity
public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String calle, numero; 
    
    private String barrio;
    private Integer codigoPostal;
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Seters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }
    
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    
    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    
    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Withs">
    public Direccion withCalle(String calle) {
        setCalle(calle);
        return this;
    }
    
    public Direccion withNumero(String numero) {
        setNumero(numero);
        return this;
    }
    
    public Direccion withBarrio(String barrio) {
        setBarrio(barrio);
        return this;
    }
    
    public Direccion withCodigoPostal(Integer codigo) {
        setCodigoPostal(codigo);
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
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return calle + " " + numero + ". " + barrio + ". " + codigoPostal;
    }
    
//</editor-fold>

}
