/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static presentacion.vista.info.InfoCliente.crearInfoCliente;
import dao.ClienteDao;
import dao.DaoFactory;
import entidades.Cliente;
import presentacion.factory.ClientesFactory;
import presentacion.vista.Main;
import presentacion.vista.Vista;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;
import presentacion.factory.AbstractFactoryCompleta;
import presentacion.modelo.ATableModel;

/**
 *
 * @author marces
 */
public class ControladorCliente implements Controlador {
    
    private VistaPadre vistaPadre;
    private VistaHija vistaHija;
    private ControladorHijo controladorHijo;
    
    @Override
    public void setVista(Vista vista) {
        this.vistaPadre = (VistaPadre) vista;
    }
   
    public void nuevoCliente() {
        cargar();
        Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Nuevo cliente");
    }
    
    public void modificarCliente(ATableModel model, int fila) {
        
        // Si se se seleccionó una fila...
        if (fila != -1 ) {
            cargar();
            
            // Nos quedamos con el campo id de fila seleccionada en la tabla
            Long id = model.getId(fila);
            
            // Realizamos la busqueda
            ClienteDao dao = new DaoFactory().crearClienteDao();
            Cliente cliente = dao.read(id); 
            
            vistaHija.setDatos(crearInfoCliente()
                    .withId(cliente.getId()) // Tambien disponemos de "id"...
                    .withApellido(cliente.getApellido())
                    .withNombre(cliente.getNombre())
                    .withDocumento(cliente.getDni().toString())
                    .withTelefono(cliente.getTelefono())
                    .withCalle(cliente.getDireccion().getCalle())
                    .withDepto(cliente.getDireccion().getNumero())
                    .withBarrio(cliente.getDireccion().getBarrio())
                    .withCodigo(cliente.getDireccion().getCodigoPostal())
            );
            
            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Modifición de cliente");
        }
        
        else vistaPadre.mostrarMensaje(""
                + "Primero debe seleccionar una fila de la tabla");
    }   
    
    public void eliminarCliente(ATableModel model, int fila) {
        
        if (fila != -1 ) {
            
            if (vistaPadre.confirmacionBorrado()) {
                
                Long id = model.getId(fila);
                String apellido = (String) model.getValueAt(fila, 1);
               
                ClienteDao dao = new DaoFactory().crearClienteDao();
                dao.delete(dao.read(id));
                
                vistaPadre.actualizar();
                vistaPadre.mostrarMensaje("El cliente "+apellido+""
                        + " fue borrado exitosamente");
            }
        }
        
        else vistaPadre.mostrarMensaje(""
                + "Primero debe seleccionar una fila de la tabla");
    }
    
    private void cargar() {
        
        AbstractFactoryCompleta factory = new ClientesFactory();
        controladorHijo = factory.crearControladorHijo();
        vistaHija = factory.crearVistaHija();
        controladorHijo.setVista(vistaHija);
        controladorHijo.setVistaPadre(vistaPadre);
        vistaHija.setControlador(controladorHijo);
    }
}
