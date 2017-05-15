/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.vista.info;

import static com.google.common.base.Strings.emptyToNull;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 *
 * @author marces
 */
public class InfoTeatro extends Info {
    
    private Long id;
    
    private String 
            nombre, capacidad, telefono, email,
            calle, depto, barrio, codigo;
    
    public static InfoTeatro crearInfoTeatro(){
        return new InfoTeatro();
    }
    
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getCapacidad() {
        return capacidad;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getEmail() {
        return email;
    }

    public String getCalle() {
        return calle;
    }

    public String getDepto() {
        return depto;
    }

    public String getBarrio() {
        return barrio;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public InfoTeatro withId(Long id) {
        this.id = id;
        return this;
    }

    public InfoTeatro withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    public InfoTeatro withCapacidad(String capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public InfoTeatro withEmail(String email) {
        this.email = emptyToNull(email);
        return this;
    }

    public InfoTeatro withTelefono(String telefono) {
        this.telefono = emptyToNull(telefono);
        return this;
    }

    public InfoTeatro withCalle(String calle) {
        this.calle = calle;
        return this;
    }

    public InfoTeatro withDepto(String numero) {
        this.depto = numero;
        return this;
    }

    public InfoTeatro withBarrio(String barrio) {
        this.barrio = emptyToNull(barrio);
        return this;
    }
    
    /**
     * Metodo sobrecargado para setear el objeto de dominio
     * @param codigo 
     * @return this (fluent interface).
     */
    public InfoTeatro withCodigo(String codigo) {
        this.codigo = emptyToNull(codigo);
        return this;
    }
    
    /**
     * Metodo sobrecargado para setear la vista.
     * @param value atributo opcional y por tanto "nullable".
     * @return this (fluent interface).
     */
    public InfoTeatro withCodigo(Integer value) {
        
        if (isNull(value)) this.codigo = null;
        
        /**Si era null hubiese lanzado una excepción.
         * Sin embargo, el atributo es opcional y por tanto es probable
         * que el mismo sea nulo. En ese caso la vista mostrara el campo vacío.
         */
        else this.codigo = value.toString();
        
        return this;
    }
}
