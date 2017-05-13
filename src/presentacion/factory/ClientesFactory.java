/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.factory;

import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorCliente;
import presentacion.controlador.ControladorHijo;
import presentacion.controlador.ControladorClienteNuevo;
import presentacion.vista.PanelCliente;
import presentacion.vista.PanelClienteNuevo;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class ClientesFactory implements AbstractFactoryCompleta{

    @Override
    public VistaPadre crearVista() {
        return new PanelCliente();
    }

    @Override
    public Controlador crearControlador() {
        return new ControladorCliente();
    }

    @Override
    public VistaHija crearVistaHija() {
        return new PanelClienteNuevo();
    }

    @Override
    public ControladorHijo crearControladorHijo() {
        return new ControladorClienteNuevo();
    }
}