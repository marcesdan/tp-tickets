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
import presentacion.vista.InfoTicket;
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

            EntityFactory factory = new EntityFactory();
            Ticket ticket = factory.crearTicket();
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

        ticket.withCliente(
                new DaoFactory()
                        .crearClienteDao()
                        .buscarPorDni(Integer // Consulta que busca por DNI.
                                .parseInt(info.getDocumento()))) // info aloja strings.

                .withFechaVenta(LocalDateTime.now()) // En el momento que se vende
                .withFuncion((Funcion) info.getFuncion()); // info aloja una ref. a funcion
    }

    public void cambiaFuncion(InfoTicket info, Object obj) {

        Funcion funcion = (Funcion) obj;
        info.withFuncion(funcion)
                .withPrecio(funcion.getPrecio().toString())
                .withTeatro(funcion.getTeatro().toString());
        
        
    }
}
