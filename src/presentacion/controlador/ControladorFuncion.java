/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static presentacion.vista.info.InfoFuncion.crearInfoFuncion;
import dao.FuncionDao;
import dao.DaoFactory;
import entidades.Funcion;
import presentacion.factory.FuncionesFactory;
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
public class ControladorFuncion implements Controlador {
    
    private VistaPadre vistaPadre;
    private VistaHija vistaHija;
    private ControladorHijo controladorHijo;
    
    @Override
    public void setVista(Vista vista) {
        this.vistaPadre = (VistaPadre) vista;
    }
    
    public void nuevaFuncion() {
        cargar();
        Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Nuevo funcion");
    }
    
    public void modificarFuncion(ATableModel model, int fila) {
        
        // Si se se seleccionó una fila...
        if (fila != -1 ) {
            cargar();
            
            // Nos quedamos con el campo id de fila seleccionada en la tabla
            Long id = model.getId(fila);
            
            // Realizamos la busqueda
            FuncionDao dao = new DaoFactory().crearFuncionDao();
            Funcion funcion = dao.read(id); 
            
            vistaHija.setDatos(crearInfoFuncion()
                    .withId(funcion.getId()) // Tambien disponemos de "id"...
                    .withNombre(funcion.getNombre())
                    .withPrecio(funcion.getPrecio().toString())
                    .withFechaHora(funcion.getFecha())
                    .withTeatro(funcion.getTeatro())
            );
            
            Main.getInstance().mostrarPanelEnDialog(vistaHija, ""
                    + "Modifición de funcion");
        }
        
        else vistaPadre.mostrarMensaje(""
                + "Primero debe seleccionar una fila de la tabla");
    }   
    
    public void eliminarFuncion(ATableModel model, int fila) {
        
        if (fila != -1 ) {
            
            if (vistaPadre.confirmacionBorrado()) {
                
                Long id = model.getId(fila);
                String apellido = (String) model.getValueAt(fila, 0);
               
                FuncionDao dao = new DaoFactory().crearFuncionDao();
                dao.delete(dao.read(id));
                
                vistaPadre.actualizar();
                vistaPadre.mostrarMensaje("El funcion "+apellido+""
                        + " fue borrado exitosamente");
            }
        }
        
        else vistaPadre.mostrarMensaje(""
                + "Primero debe seleccionar una fila de la tabla");
    }
    
    private void cargar() {
        
        AbstractFactoryCompleta factory = new FuncionesFactory();
        controladorHijo = factory.crearControladorHijo();
        vistaHija = factory.crearVistaHija();
        controladorHijo.setVista(vistaHija);
        controladorHijo.setVistaPadre(vistaPadre);
        vistaHija.setControlador(controladorHijo);
    }
}
