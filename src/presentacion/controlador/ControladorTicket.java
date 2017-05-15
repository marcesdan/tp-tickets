/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static presentacion.vista.info.InfoTicket.crearInfoTicket;
import static presentacion.vista.info.InfoCliente.crearInfoCliente;
import dao.TicketDao;
import dao.DaoFactory;
import dao.ClienteDao;
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
import presentacion.vista.panel.PanelFactory;

/**
 *
 * @author marces
 */
public class ControladorTicket implements Controlador {

    private VistaPadre vistaPadre;
    private VistaHija vistaHija;
    private ControladorHijo controladorHijo;
    private TicketDao ticketDao;
    private ClienteDao clienteDao;
    private boolean disponible;
    private Funcion funcionElegida;

    public ControladorTicket() {
        DaoFactory factory = new DaoFactory();
        ticketDao = factory.crearTicketDao();
        clienteDao = factory.crearClienteDao();
    }
    
    @Override
    public void setVista(Vista vista) {
        this.vistaPadre = (VistaPadre) vista;
    }

    /**Crea un nuevo ticket si la función elegida tiene asientos disponibles 
     * si el cliente elegido no esta en la BD, se lo registra, y ahí recién
     * se crea el ticket. */
    public void nuevoTicket() {
        cargarFunciones(); // Se queda en espera hasta que se cierra el dialog.
        
        // Si no hay asientos disponibles volvemos al panel principal
        if (!disponible) return;

        // Mostramos una entrada de texto para que ingrese el DNI.
        String stDni = Main.getInstance()
                .mostrarDialogInput("Ingrese el documento del cliente");

        // Si el DNI es invalido volvemos al panel principal
        if (!validarDni(stDni)) return;
        
        Integer intDni = Integer.parseInt(stDni); 
        Cliente cliente = clienteDao.buscarPorDni(intDni); // Hacemos la busqueda

        // Si existia un cliente bajo ese DNI, nos vamos a la venta del ticket.
        if (!isNull(cliente)) cargarVentaTicket(cliente);
        
        else {  // Si NO existe un cliente bajo ese DNI, creamos el cliente.
            cargar(new ClientesFactory());

            // Sino escribiría el DNI dos veces :)
            vistaHija.setDatos(crearInfoCliente().withDocumento(stDni));

            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Nuevo cliente");      
            
            // Si realmente se creó el cliente bajo ese DNI
            cliente = clienteDao.buscarPorDni(intDni);
            if (!isNull(cliente)) cargarVentaTicket(cliente);
            else return;
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
            Ticket ticket = ticketDao.read(id);
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
            // Si el usuario confirma el borrado...
            if (vistaPadre.confirmacionBorrado()) {
                Long id = model.getId(fila); // Obtenemos su id del modelo
                Integer docCliente = (Integer) model.getValueAt(fila, 0); // y su DNI
                ticketDao.delete(ticketDao.read(id)); // Leemos

                vistaPadre.actualizar();
                vistaPadre.mostrarMensaje("El ticket del cliente " + docCliente + ""
                        + " fue borrado exitosamente");
            }
        } 
        else vistaPadre.mostrarMensaje(""
                    + "Primero debe seleccionar una fila de la tabla");
    }

    public void funcionElegida(Object selectedItem) {
        // Casteamos la funcion elegida.
        Funcion funcion = (Funcion) selectedItem;
        
        // Nos quedamos con la cantidad de tickets vendidos de esa funcion.
        Integer cantidadTickets = ticketDao.buscarTicketsFuncion(funcion.getId());
        Integer capacidad = funcion.getTeatro().getCapacidad();
        if (capacidad <= cantidadTickets) { // Si no quedan asientos disponibles.
            
            this.disponible = false;
            vistaPadre.mostrarMensaje("La función " + funcion.getNombre()
                + " no tiene asientos disponibles!!!");
        }  
        /**
         * Indicamos la disponibilidad: como swing es concurrente, el metodo
         * nuevoTicket podrá hacer uso de "disponible" una vez se llame a
         * cerrarDialogAux porque se quedó "esperando" cuando llamamos a
         * cargarFuncione.
         */
        else {
            this.disponible = true;
            this.funcionElegida = funcion;
        }
        Main.getInstance().cerrarDialogAux();
    }
    
    /** Se setean las vistas y los controladores mutuamente. */
    private void cargar(AbstractFactoryCompleta factory) {
        controladorHijo = factory.crearControladorHijo();
        vistaHija = factory.crearVistaHija();
        controladorHijo.setVista(vistaHija);
        controladorHijo.setVistaPadre(vistaPadre);
        vistaHija.setControlador(controladorHijo);
    }

    private void cargarVentaTicket(Cliente cliente){
            cargar(new TicketsFactory()); 

            // Cargamos los datos en pantalla
            vistaHija.setDatos(crearInfoTicket() 
                    .withDocumento(cliente.getDni().toString())
                    .withNombre(cliente.toString())
                    .withFuncion(funcionElegida)
                    .withPrecio(funcionElegida.getPrecio().toString())
                    .withTeatro(funcionElegida.getTeatro().toString())
            );  

            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Venta de ticket");
    }
    
    /**  Mostramos una vista con una lista de las funciones disponibles
     * De este modo, si la función a elegir agotó las entradas, el usuario
     * podrá informarlo rápidamente sin tener que ingresar más datos. */
    private void cargarFunciones() {
        
        Vista vistaAux = new PanelFactory().crearPanelFuncionComboBox();
        vistaAux.setControlador(this);
        Main.getInstance().mostrarPanelEnDialog(vistaAux, ""
                + "Funciones");
    }

    private boolean validarDni(String stDni) {
        
        if (isNullOrEmpty(stDni)) return false;
        
        try {     
            // Reglas de validación
            checkArgument(isNumeric(stDni),
                    "El campo documento debe ser un número");

            Integer intDni = Integer.parseInt(stDni);
            checkArgument(intDni > 1000000 && intDni < 100000000,
                    "Verifique el rango del documento");
            
              return true;

        } catch (IllegalArgumentException ex) {
            vistaPadre.mostrarMensaje(ex.getMessage());
            return false;
        }
    }
}