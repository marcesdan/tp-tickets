/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static java.util.Objects.isNull;
import entidades.Ticket;
import entidades.EntityFactory;
import dao.TicketDao;
import dao.DaoFactory;
import entidades.Funcion;
import java.time.LocalDateTime;
import presentacion.vista.info.InfoTicket;
import presentacion.vista.Main;
import presentacion.vista.Vista;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class ControladorTicketNuevo implements ControladorHijo {

    private VistaPadre vistaTicket;
    private VistaHija vistaNuevoTicket;
    private TicketDao ticketDao;
    private Long id;

    public ControladorTicketNuevo() {
        DaoFactory factory = new DaoFactory();
        ticketDao = factory.crearTicketDao();
    }

    @Override
    public void setVista(Vista vista) {
        this.vistaNuevoTicket = (VistaHija) vista;
    }

    @Override
    public void setVistaPadre(Vista vista) {
        this.vistaTicket = (VistaPadre) vista;
    }

    public void guardarTicket(InfoTicket infoTicket) {

        id = infoTicket.getId();
        if (isNull(id)) {
            
            Ticket ticket = new EntityFactory().crearTicket();
            setearDatos(infoTicket, ticket);
            ticketDao.create(ticket);

        } else {

            Ticket ticket = ticketDao.read(infoTicket.getId());
            setearDatos(infoTicket, ticket);

            // Por el momento solo puede cambiar la funcion
            ticketDao.update(ticket);
        }

        vistaNuevoTicket.mostrarMensaje("Ticket guardado exitosamente");
        vistaTicket.actualizar();
        Main.getInstance().cerrarDialogAux();
    }

    private void setearDatos(InfoTicket info, Ticket ticket)
            throws IllegalArgumentException {
       
        // Consulta que busca por DNI.
        ticket.withCliente(new DaoFactory()
                    .crearClienteDao()
                    .buscarPorDni(Integer.parseInt(info.getDocumento()))) // info aloja strings.
              .withFuncion((Funcion) info.getFuncion()); // info aloja una ref. a funcion
    }

    /** La vista indica al controlador que cambió FuncionComboBoxModel y requiere 
     * los respectivos datos actualizados; tambien verifica la disponibilidad.
     * @param info objeto con la información del ticket que manejan las vistas.
     * @param obj la funcion elegida en el ComboBox
     * @return true si la funcion elegida tiene disponibilidad, false de lo contrario.
     */
    public boolean cambiaFuncion(InfoTicket info, Object obj) {
        boolean aux;
        Funcion funcion = (Funcion) obj;
        
        // Nos quedamos con la cantidad de tickets vendidos de esa funcion.
        Integer cantidadTickets = ticketDao.buscarTicketsFuncion(funcion.getId());
        Integer capacidad = funcion.getTeatro().getCapacidad();
        if (capacidad <= cantidadTickets) { // Si no quedan asientos disponibles.

            vistaNuevoTicket.mostrarMensaje("La funcion " + funcion.getNombre()
                + " no tiene asientos disponibles!!!");
            
            aux = false;
        }  
        
        else aux = true;
        
        info.withFuncion(funcion)
                .withPrecio(funcion.getPrecio().toString())
                .withTeatro(funcion.getTeatro().toString());
        
        return aux;
    }
}