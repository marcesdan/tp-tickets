/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.factory;

import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorHijo;
import presentacion.controlador.ControladorTeatroNuevo;
import presentacion.controlador.ControladorTeatro;
import presentacion.vista.panel.PanelTeatro;
import presentacion.vista.panel.PanelTeatroNuevo;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;
import presentacion.vista.panel.PanelFactory;

/**
 *
 * @author marces
 */
public class TeatrosFactory implements AbstractFactoryCompleta{
    
    PanelFactory factory = new PanelFactory();
    
    @Override
    public VistaPadre crearVista() {
        return new PanelTeatro();
    }

    @Override
    public Controlador crearControlador() {
        return new ControladorTeatro();
    }

    @Override
    public VistaHija crearVistaHija() {
        return new PanelTeatroNuevo();
    }

    @Override
    public ControladorHijo crearControladorHijo() {
        return new ControladorTeatroNuevo();
    }
}    
