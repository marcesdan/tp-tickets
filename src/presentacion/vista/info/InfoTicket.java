/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.vista.info;

/**
 *
 * @author marces
 */
public class InfoTicket extends Info {
    
    private Long id;
    private String precio, nombre, documento, teatro;
    private Object funcion;
    
    
    public static InfoTicket crearInfoTicket(){
        return new InfoTicket();
    }
    
    public Long getId() {
        return id;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Object getFuncion() {
        return funcion;
    }
    
    public String getTeatro() {
        return teatro;
    }
    
    public String getPrecio() {
        return precio;
    }
    
    public InfoTicket withId(Long id) {
        
        this.id = id;
        return this;
    }
    
    public InfoTicket withDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    public InfoTicket withPrecio(String precio) {
        this.precio = precio;
        return this;
    }

    public InfoTicket withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    public InfoTicket withFuncion(Object funcion) {
        this.funcion = funcion;
        return this;
    }

    public InfoTicket withTeatro(String teatro) {
        this.teatro = teatro;
        return this;
    }    
}
