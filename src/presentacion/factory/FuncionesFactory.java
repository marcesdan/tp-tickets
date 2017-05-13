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
import presentacion.vista.PanelFuncion;
import presentacion.vista.PanelFuncionNueva;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class FuncionesFactory implements AbstractFactoryCompleta{

    @Override
    public VistaPadre crearVista() {
        return new PanelFuncion();
    }

    @Override
    public Controlador crearControlador() {
        return new ControladorFuncion();
            
    }

    @Override
    public VistaHija crearVistaHija() {
        return new PanelFuncionNueva();
    }

    @Override
    public ControladorHijo crearControladorHijo() {
        return new ControladorFuncionNuevo();
    }
}