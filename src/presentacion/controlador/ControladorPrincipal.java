/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import presentacion.factory.ClientesFactory;
import presentacion.factory.FuncionesFactory;
import presentacion.factory.TeatrosFactory;
import presentacion.vista.Main;
import presentacion.vista.Vista;
import presentacion.vista.VistaPadre;
import presentacion.factory.AbstractFactoryCompleta;
import presentacion.factory.TicketsFactory;

/**
 * Clase encargada de controlar la vista principal donde se encuentra la barra
 * de menú que llamará a las vistas: cliente, teatro, funcion y ticket.
 *
 * @author marces
 */
public class ControladorPrincipal implements Controlador {

    private AbstractFactoryCompleta factory;
    private Vista vistaPrincipal;
    private VistaPadre vistaPadre;
    private Controlador controlador;

    @Override
    public void setVista(Vista vista) {
        this.vistaPrincipal = vista;
    }

    /**
     * Se muestra la vista de los clientes y se le asigna su controlador
     */
    public void mostrarClientes() {
        factory = new ClientesFactory();
        cargar(factory);
    }

    /**
     * Se muestra la vista de los teatros y se le asigna su controlador
     */
    public void mostrarTeatros() {

        factory = new TeatrosFactory();
        cargar(factory);
    }

    /**
     * Se muestra la vista de las funciones y se le asigna su controlador
     */
    public void mostrarFunciones() {
        factory = new FuncionesFactory();
        cargar(factory);
    }

    /**
     * Se muestra la vista de los tickets y se le asigna su controlador
     */
    public void mostrarTickets() {  
        factory = new TicketsFactory();
        cargar(factory);
    }

    private void cargar(AbstractFactoryCompleta factory) {
        controlador = factory.crearControlador();
        vistaPadre = factory.crearVista();
        controlador.setVista(vistaPadre);
        vistaPadre.setControlador(controlador);
        Main.getInstance().mostrarPanelEnFrame(vistaPadre);
    }
}
