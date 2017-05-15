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
import presentacion.controlador.ControladorHijo;
import presentacion.controlador.ControladorTicket;
import presentacion.controlador.ControladorTicketNuevo;
import presentacion.vista.panel.PanelTicket;
import presentacion.vista.panel.PanelTicketNuevo;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;
import presentacion.vista.panel.PanelFactory;

/**
 *
 * @author marces
 */
public class TicketsFactory implements AbstractFactoryCompleta{
    
    PanelFactory factory = new PanelFactory();
    
    @Override
    public VistaPadre crearVista() {
        return factory.crearPanelTicket();
    }

    @Override
    public Controlador crearControlador() {
        return new ControladorTicket();
    }

    @Override
    public VistaHija crearVistaHija() {
        return factory.crearPanelTicketNuevo();
    }

    @Override
    public ControladorHijo crearControladorHijo() {
        return new ControladorTicketNuevo();
    }
}