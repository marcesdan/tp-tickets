/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static com.google.common.base.Preconditions.checkArgument;
import entidades.Cliente;
import entidades.Direccion;
import entidades.EntityFactory;
import dao.ClienteDao;
import dao.DaoFactory;
import presentacion.vista.info.InfoCliente;
import presentacion.vista.Main;
import presentacion.vista.Vista;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class ControladorClienteNuevo implements ControladorHijo {

    private VistaPadre vistaCliente;
    private VistaHija vistaNuevoCliente;
    private ClienteDao clienteDao;
    private Long id;

    public ControladorClienteNuevo() {
        DaoFactory factory = new DaoFactory();
        clienteDao = factory.crearClienteDao();
    }

    @Override
    public void setVista(Vista vista) {
        this.vistaNuevoCliente = (VistaHija) vista;
    }

    @Override
    public void setVistaPadre(Vista vista) {
        this.vistaCliente = (VistaPadre) vista;
    }

    public void guardarCliente(InfoCliente infoCliente) {

        try {
            
            id = infoCliente.getId();
            if (isNull(id)) {
                
                EntityFactory factory = new EntityFactory();
                Cliente cliente = factory.crearCliente();
                Direccion direccion = factory.crearDireccion();
                setearDatos(infoCliente, cliente, direccion);   
                
                clienteDao.create(cliente);
                
            } else {
                
                Cliente cliente = clienteDao.read(infoCliente.getId());
                setearDatos(infoCliente, cliente, cliente.getDireccion());
                
                clienteDao.update(cliente);
            }

            vistaNuevoCliente.mostrarMensaje("Cliente guardado exitosamente");
            vistaCliente.actualizar();
            Main.getInstance().cerrarDialogAux();        

        } catch (IllegalArgumentException ex) {

            vistaNuevoCliente.mostrarMensaje("Error: "
                    + "el cliente no pudo ser guardado.\n\n"
                    + ex.getMessage());
        }
    }

    private void setearDatos(InfoCliente info, Cliente cliente, Direccion direc)
            throws IllegalArgumentException {

        direc.withCalle(info.getCalle())
                .withNumero(info.getDepto())
                .withBarrio(info.getBarrio())
                .withCodigoPostal(validarCodigoPostal(info.getCodigo()));

        cliente.withApellido(validarNombres(info.getApellido()))
                .withNombre(validarNombres(info.getNombre()))
                .withDni(validarDocumento(info.getDocumento()))
                .withTelefono(info.getTelefono())
                .withDireccion(direc);
    }

    // <editor-fold defaultstate="collapsed" desc=" Validaciones ">
    public String validarNombres(String value) throws IllegalArgumentException {

        // Reglas de validación
        checkArgument(value.matches("^[\\p{L} .'-]+$"),
                "Verifique que el nombre y el apellido sean correctos");
        
        return value;
    }

    public Integer validarDocumento(String value) throws IllegalArgumentException {

        // Reglas de validación
        checkArgument(isNumeric(value),
                "El campo documento debe ser un número");
        
        Integer aux = Integer.parseInt(value);
        checkArgument(aux > 1000000 && aux < 100000000, 
                "Verifique el rango del documento");

        // Si es un create
        if (isNull(id))
            checkArgument(isNull(clienteDao.buscarPorDni(aux)),
                    "Ya existe un cliente con ese documento");
        
        /* Pero si es un update hay que comprobar además el id debido a la
        * insertidumbre de desconocer si el campo dni fue o no modificado. */
        else {
            Cliente cliente = clienteDao.buscarPorDni(aux);
            
            /* Si es null, entonces lo modifico por uno que no existe, pero si 
             * no es null y los IDs son distintos, el usuario modificó el 
             * documento por uno que ya existe en la BD. (short-circuit)*/
            checkArgument(isNull(cliente) || cliente.getId() == id,
                    "Ya existe un cliente con ese documento");
        }

        return aux;
    }

    public Integer validarCodigoPostal(String value) throws IllegalArgumentException {

        // Es opcional...
        if (!isNull(value)) {

            checkArgument(isNumeric(value),
                    "El campo código postal debe ser un número válido");

            return Integer.parseInt(value);
        } // Ausencia del atributo
        else {
            return null;
        }
    }
    // </editor-fold> 
}
