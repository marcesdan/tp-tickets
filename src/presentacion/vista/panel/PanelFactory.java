/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.vista.panel;

import presentacion.vista.Vista;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class PanelFactory {

    public VistaPadre crearPanelCliente() {
        return new PanelCliente();
    }
    
    public VistaHija crearPanelNuevoCliente() {
        return new PanelClienteNuevo();
    }
    
    public VistaPadre crearPanelFuncion() {
        return new PanelFuncion();
    }

    public VistaHija crearPanelFuncionNueva() {
        return new PanelFuncionNueva();
    }

    public VistaPadre crearPanelTeatro() {
        return new PanelTeatro();
    }

    public VistaHija crearPanelTeatroNuevo() {
        return new PanelTeatroNuevo();
    }

    public VistaPadre crearPanelTicket() {
        return new PanelTicket();
    }

    public VistaHija crearPanelTicketNuevo() {
        return new PanelTicketNuevo();
    }

    public Vista crearPanelFuncionComboBox() {
        return new PanelFuncionComboBox();
    }
    
    
}
