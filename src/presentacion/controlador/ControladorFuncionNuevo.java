/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static java.util.Objects.isNull;
import entidades.Funcion;
import entidades.EntityFactory;
import dao.FuncionDao;
import dao.DaoFactory;
import entidades.Teatro;
import presentacion.vista.InfoFuncion;
import presentacion.vista.Main;
import presentacion.vista.Vista;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class ControladorFuncionNuevo implements ControladorHijo {

    private VistaPadre vistaFuncion;
    private VistaHija vistaNuevoFuncion;
    private FuncionDao funcionDao;
    private Long id;

    public ControladorFuncionNuevo() {
        DaoFactory factory = new DaoFactory();
        funcionDao = factory.crearFuncionDao();
    }

    @Override
    public void setVista(Vista vista) {
        this.vistaNuevoFuncion = (VistaHija) vista;
    }

    @Override
    public void setVistaPadre(Vista vista) {
        this.vistaFuncion = (VistaPadre) vista;
    }

    public void guardarFuncion(InfoFuncion infoFuncion) {

        try {
            
            id = infoFuncion.getId();
            if (isNull(id)) {
                
                EntityFactory factory = new EntityFactory();
                Funcion funcion = factory.crearFuncion();
                setearDatos(infoFuncion, funcion);   
                
                funcionDao.create(funcion);
                
            } else {
                
                Funcion funcion = funcionDao.read(infoFuncion.getId());
                setearDatos(infoFuncion, funcion);
                
                funcionDao.update(funcion);
            }
            vistaNuevoFuncion.mostrarMensaje("Funcion guardado exitosamente");
            vistaFuncion.actualizar();
            Main.getInstance().cerrarDialogAux();        

        } catch (IllegalArgumentException ex) {

            vistaNuevoFuncion.mostrarMensaje("Error: "
                    + "el funcion no pudo ser guardado.\n\n"
                    + ex.getMessage());
        }
    }

    private void setearDatos(InfoFuncion info, Funcion funcion)
            throws IllegalArgumentException {

        funcion.withNombre(info.getNombre())
               .withFecha(info.getFechaHora())
               .withPrecio(validarPrecio(info.getPrecio()))
               .withTeatro((Teatro) info.getTeatro());
    }

    // <editor-fold defaultstate="collapsed" desc=" Validaciones ">

    public Double validarPrecio(String value) throws IllegalArgumentException {

        // Es opcional...
        if (!isNull(value)) {
            
            try { 
                
                Double aux =  Double.parseDouble(value);
                return aux;
            
            } catch (NumberFormatException ex) {
                
                throw new IllegalArgumentException("Verifique el formato del precio");
            }
            
        } 
        // Ausencia del atributo
        else return null; 
    }
    // </editor-fold> 
}
