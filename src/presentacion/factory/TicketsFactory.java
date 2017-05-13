/**
 *
 * Trabajo Integrador: Control de Proyectos.
 * Programación y Diseño Orientado a Objetos.
 *
 * Alumno: Mariano César D'Angelo .
 *
 */
package presentacion.factory;

import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorCliente;
import presentacion.controlador.ControladorClienteNuevo;
import presentacion.controlador.ControladorHijo;
import presentacion.controlador.ControladorTicket;
import presentacion.controlador.ControladorTicketNuevo;
import presentacion.vista.PanelCliente;
import presentacion.vista.PanelClienteNuevo;
import presentacion.vista.PanelTicket;
import presentacion.vista.PanelTicketNuevo;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class TicketsFactory implements AbstractFactoryCompleta{

     @Override
    public VistaPadre crearVista() {
        return new PanelTicket();
    }

    @Override
    public Controlador crearControlador() {
        return new ControladorTicket();
    }

    @Override
    public VistaHija crearVistaHija() {
        return new PanelTicketNuevo();
    }

    @Override
    public ControladorHijo crearControladorHijo() {
        return new ControladorTicketNuevo();
    }
}