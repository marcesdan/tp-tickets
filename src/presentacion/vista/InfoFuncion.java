/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.vista;

import java.time.LocalDateTime;

/**
 *
 * @author marces
 */
public class InfoFuncion {
    
    private Long id;
    private String precio, nombre;
    private LocalDateTime fechaHora;
    private Object teatro;
    
    
    public static InfoFuncion crearInfoFuncion(){
        return new InfoFuncion();
    }
    
    public Long getId() {
        return id;
    }

    public String getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public Object getTeatro() {
        return teatro;
    }
    
    public InfoFuncion withId(Long id) {
        this.id = id;
        return this;
    }

    public InfoFuncion withPrecio(String precio) {
        this.precio = precio;
        return this;
    }

    public InfoFuncion withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    public InfoFuncion withFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        return this;
    }
    
    public InfoFuncion withTeatro(Object teatro) {
        this.teatro = teatro;
        return this;
    }
}
