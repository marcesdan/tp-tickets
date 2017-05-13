/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package entidades;

/**
 *
 * @author marces
 */
public class EntityFactory {
    
    public Cliente crearCliente() {
        return new Cliente();
    }
    
    public Direccion crearDireccion() {
        return new Direccion();
    }
    
    public Funcion crearFuncion() {
        return new Funcion();
    }
    
    public Teatro crearTeatro() {
        return new Teatro();
    }
    
    public Ticket crearTicket() {
        return new Ticket();
    }
}
