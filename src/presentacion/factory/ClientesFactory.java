/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.factory;

import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorCliente;
import presentacion.controlador.ControladorHijo;
import presentacion.controlador.ControladorClienteNuevo;
import presentacion.vista.panel.PanelCliente;
import presentacion.vista.panel.PanelClienteNuevo;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;
import presentacion.vista.panel.PanelFactory;

/**
 *
 * @author marces
 */
public class ClientesFactory implements AbstractFactoryCompleta{
    
    PanelFactory factory = new PanelFactory();
    
    @Override
    public VistaPadre crearVista() {
        return factory.crearPanelCliente();
    }

    @Override
    public Controlador crearControlador() {
        return new ControladorCliente();
    }

    @Override
    public VistaHija crearVistaHija() {
        return factory.crearPanelNuevoCliente();
    }

    @Override
    public ControladorHijo crearControladorHijo() {
        return new ControladorClienteNuevo();
    }
}