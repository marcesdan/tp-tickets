/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static presentacion.vista.info.InfoTeatro.crearInfoTeatro;
import dao.TeatroDao;
import dao.DaoFactory;
import entidades.Teatro;
import presentacion.factory.TeatrosFactory;
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
public class ControladorTeatro implements Controlador {
    
    private VistaPadre vistaPadre;
    private VistaHija vistaHija;
    private ControladorHijo controladorHijo;
    
    @Override
    public void setVista(Vista vista) {
        this.vistaPadre = (VistaPadre) vista;
    }
    
    public void nuevoTeatro() {
        cargar();
        Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Nuevo teatro");
    }
    
    public void modificarTeatro(ATableModel model, int fila) {
        
        // Si se se seleccionó una fila...
        if (fila != -1 ) {
            cargar();
            
            // Nos quedamos con el campo id de fila seleccionada en la tabla
            Long id = model.getId(fila);
            
            // Realizamos la busqueda
            TeatroDao dao = new DaoFactory().crearTeatroDao();
            Teatro teatro = dao.read(id); 
            
            vistaHija.setDatos(crearInfoTeatro()
                    .withId(teatro.getId()) // Tambien disponemos de "id"...
                    .withNombre(teatro.getNombre())
                    .withCapacidad(teatro.getCapacidad().toString())
                    .withTelefono(teatro.getTelefono())
                    .withCalle(teatro.getDireccion().getCalle())
                    .withDepto(teatro.getDireccion().getNumero())
                    .withBarrio(teatro.getDireccion().getBarrio())
                    .withCodigo(teatro.getDireccion().getCodigoPostal())
            );
            
            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Modifición de teatro");
        }
        
        else vistaPadre.mostrarMensaje(""
                + "Primero debe seleccionar una fila de la tabla");
    }   
    
    public void eliminarTeatro(ATableModel model, int fila) {
        
        if (fila != -1 ) {
            
            if (vistaPadre.confirmacionBorrado()) {
                
                Long id = model.getId(fila);
                String apellido = (String) model.getValueAt(fila, 0);
               
                TeatroDao dao = new DaoFactory().crearTeatroDao();
                dao.delete(dao.read(id));
                
                vistaPadre.actualizar();
                vistaPadre.mostrarMensaje("El teatro "+apellido+""
                        + " fue borrado exitosamente");
            }
        }
        
        else vistaPadre.mostrarMensaje(""
                + "Primero debe seleccionar una fila de la tabla");
    }
    
    private void cargar() {
        
        AbstractFactoryCompleta factory = new TeatrosFactory();
        controladorHijo = factory.crearControladorHijo();
        vistaHija = factory.crearVistaHija();
        controladorHijo.setVista(vistaHija);
        controladorHijo.setVistaPadre(vistaPadre);
        vistaHija.setControlador(controladorHijo);
    }
}
