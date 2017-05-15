/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.vista.info;

import static com.google.common.base.Strings.emptyToNull;
import static java.util.Objects.isNull;

/**
 *
 * @author marces
 */
public class InfoCliente extends Info {
    
    private Long id;
    
    private String 
            documento, apellido, nombre, telefono,
            calle, depto, barrio, codigo;
    
    public static InfoCliente crearInfoCliente(){
        return new InfoCliente();
    }
    
    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
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
    
    public InfoCliente withId(Long id) {
        this.id = id;
        return this;
    }

    public InfoCliente withDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public InfoCliente withApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public InfoCliente withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public InfoCliente withTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public InfoCliente withCalle(String calle) {
        this.calle = calle;
        return this;
    }

    public InfoCliente withDepto(String numero) {
        this.depto = numero;
        return this;
    }

    public InfoCliente withBarrio(String barrio) {
        this.barrio = emptyToNull(barrio);
        return this;
    }
    
    /**
     * Metodo sobrecargado para setear el objeto de dominio
     * @param codigo 
     * @return this (fluent interface).
     */
    public InfoCliente withCodigo(String codigo) {
        this.codigo = emptyToNull(codigo);
        return this;
    }
    
    /**
     * Metodo sobrecargado para setear la vista.
     * @param value atributo opcional y por tanto "nullable".
     * @return this (fluent interface).
     */
    public InfoCliente withCodigo(Integer value) {
        
        if (isNull(value)) this.codigo = null;
        
        /**Si era null hubiese lanzado una excepción.
         * Sin embargo, el atributo es opcional y por tanto es probable
         * que el mismo sea nulo. En ese caso la vista mostrara el campo vacío.
         */
        else this.codigo = value.toString();
        
        return this;
    }
}
