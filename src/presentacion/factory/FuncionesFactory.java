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
import presentacion.controlador.ControladorFuncion;
import presentacion.controlador.ControladorHijo;
import presentacion.controlador.ControladorFuncionNuevo;
import presentacion.vista.panel.PanelFuncion;
import presentacion.vista.panel.PanelFuncionNueva;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;
import presentacion.vista.panel.PanelFactory;

/**
 *
 * @author marces
 */
public class FuncionesFactory implements AbstractFactoryCompleta{
    
    PanelFactory factory = new PanelFactory();
    
    @Override
    public VistaPadre crearVista() {
        return factory.crearPanelFuncion();
    }

    @Override
    public Controlador crearControlador() {
        return new ControladorFuncion();
            
    }

    @Override
    public VistaHija crearVistaHija() {
        return factory.crearPanelFuncionNueva();
    }

    @Override
    public ControladorHijo crearControladorHijo() {
        return new ControladorFuncionNuevo();
    }
}