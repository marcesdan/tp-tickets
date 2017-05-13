/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import static presentacion.vista.InfoTicket.crearInfoTicket;
import static presentacion.vista.InfoCliente.crearInfoCliente;
import dao.TicketDao;
import dao.DaoFactory;
import entidades.Cliente;
import entidades.Funcion;
import entidades.Ticket;
import presentacion.vista.Main;
import presentacion.vista.Vista;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;
import presentacion.factory.AbstractFactoryCompleta;
import presentacion.factory.ClientesFactory;
import presentacion.factory.TicketsFactory;
import presentacion.modelo.ATableModel;
import presentacion.vista.PanelFactory;

/**
 *
 * @author marces
 */
public class ControladorTicket implements Controlador {

    private VistaPadre vistaPadre;
    private VistaHija vistaHija;
    private ControladorHijo controladorHijo;
    private boolean disponible;
    private boolean clienteFijado;

    @Override
    public void setVista(Vista vista) {
        this.vistaPadre = (VistaPadre) vista;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public void setClienteFijado(boolean clienteFijado) {
        this.clienteFijado = clienteFijado;
    }

    public void nuevoTicket() {

        /*  Mostramos una vista con una lista de las funciones disponibles.
            De este modo, si la función a elegir agotó las entradas el usuario
            podrá informarlo rápidamente sin tener que ingresar más datos.
         */
        cargarFunciones();
        
        if (!disponible) {
            return;
        }

        // Mostramos una entrada de texto para que ingrese el DNI.
        String stDni = Main.getInstance()
                .mostrarDialogInput("Ingrese el documento del cliente");

        // Si no ingresa nada vuelve al panel principal.
        if (isEmpty(stDni)) {
            return;
        }

        Integer intDni = 0;
        try {
            // Reglas de validación
            checkArgument(isNumeric(stDni),
                    "El campo documento debe ser un número");

            intDni = Integer.parseInt(stDni);
            checkArgument(intDni > 1000000 && intDni < 100000000,
                    "Verifique el rango del documento");

        } catch (IllegalArgumentException ex) {
            vistaPadre.mostrarMensaje(ex.getMessage());
            return;
        }

        // Hacemos la busqueda
        Cliente cliente = new DaoFactory()
                .crearClienteDao()
                .buscarPorDni(intDni);

        // Si existia un cliente bajo ese DNI...
        if (!isNull(cliente)) {

            // LLamamos a los factorys.
            cargar(new TicketsFactory());

            // Cargamos los datos en la pantalla
            vistaHija.setDatos(crearInfoTicket()
                    .withDocumento(cliente.getDni().toString())
                    .withNombre(cliente.toString())
            );

            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Venta de ticket");
        } 
        
        // Si NO existe un cliente bajo ese DNI
        else {
            // Primero creamos el cliente
            ClientesFactory clienteFactory = new ClientesFactory();
            cargar(clienteFactory);

            // Sino escribiría el DNI dos veces :)
            vistaHija.setDatos(crearInfoCliente()
                    .withDocumento(stDni));

            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Nuevo cliente");
            
            // Aca hay que preguntar si el cliente se cargo o no!!!
            
            // Y luego el ticket
            TicketsFactory ticketFactory = new TicketsFactory();
            cargar(ticketFactory);
            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Venta de ticket");
        }
    }

    public void modificarTicket(ATableModel model, int fila) {

        // Si se se seleccionó una fila...
        if (fila != -1) {

            // Mostramos en pantalla el panel para modificar el ticket
            cargar(new TicketsFactory());

            // Nos quedamos con el campo id de fila seleccionada en la tabla
            Long id = model.getId(fila);

            // Realizamos la busqueda
            TicketDao dao = new DaoFactory().crearTicketDao();
            Ticket ticket = dao.read(id);

            vistaHija.setDatos(crearInfoTicket()
                    .withId(ticket.getId()) // Tambien disponemos de "id"...
                    .withDocumento(ticket.getCliente().getDni().toString())
                    .withNombre(ticket.getCliente().toString())
                    .withFuncion(ticket.getFuncion())
                    .withTeatro(ticket.getFuncion().getTeatro().getNombre())
                    .withPrecio(ticket.getFuncion().getPrecio().toString())
            );

            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Modifición de ticket");
        } 
        
        else vistaPadre.mostrarMensaje(""
                + "Primero debe seleccionar una fila de la tabla");
        
    }

    public void eliminarTicket(ATableModel model, int fila) {

        if (fila != -1) {

            if (vistaPadre.confirmacionBorrado()) {

                Long id = model.getId(fila);
                Integer cliente = (Integer) model.getValueAt(fila, 0);

                TicketDao dao = new DaoFactory().crearTicketDao();
                dao.delete(dao.read(id));

                vistaPadre.actualizar();
                vistaPadre.mostrarMensaje("El ticket del cliente " + cliente + ""
                        + " fue borrado exitosamente");
            }
        } else {
            vistaPadre.mostrarMensaje(""
                    + "Primero debe seleccionar una fila de la tabla");
        }
    }

    private void cargar(AbstractFactoryCompleta factory) {
        controladorHijo = factory.crearControladorHijo();
        vistaHija = factory.crearVistaHija();
        controladorHijo.setVista(vistaHija);
        controladorHijo.setVistaPadre(vistaPadre);
        vistaHija.setControlador(controladorHijo);
    }

    private void cargarFunciones() {
        Vista vistaAux = new PanelFactory().crearPanelFuncionComboBox();
        vistaAux.setControlador(this);
        Main.getInstance().mostrarPanelEnDialog(vistaAux, ""
                + "Funciones");
    }

    public void funcionElegida(Object selectedItem) {
        // Casteamos la funcion elegida.
        Funcion funcion = (Funcion) selectedItem;
        
        // Nos quedamos con la cantidad de tickets vendidos de esa funcion.
        Long cantidadTickets = new DaoFactory()
                .crearTicketDao()
                .buscarTicketsFuncion(funcion.getId());
        
        Integer capacidad = funcion.getTeatro().getCapacidad();

        // Si no quedan asientos disponibles.
        if (capacidad <= cantidadTickets) {
            
            this.disponible = false;  
            
            vistaPadre.mostrarMensaje("La funcion " + funcion.getNombre()
                + " no tiene asientos disponibles!!!");
        }
        
        // Indicamos la disponibilidad.
        else this.disponible = true;
        
        Main.getInstance().cerrarDialogAux();
    }
}