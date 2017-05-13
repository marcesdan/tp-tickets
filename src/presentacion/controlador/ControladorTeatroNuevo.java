/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.controlador;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static com.google.common.base.Preconditions.checkArgument;
import entidades.Direccion;
import entidades.EntityFactory;
import dao.DaoFactory;
import dao.TeatroDao;
import entidades.Teatro;
import presentacion.vista.InfoTeatro;
import presentacion.vista.Main;
import presentacion.vista.Vista;
import presentacion.vista.VistaHija;
import presentacion.vista.VistaPadre;

/**
 *
 * @author marces
 */
public class ControladorTeatroNuevo implements ControladorHijo {

    private VistaPadre vistaTeatro;
    private VistaHija vistaNuevoTeatro;
    private TeatroDao teatroDao;
    private Long id;

    public ControladorTeatroNuevo() {
        DaoFactory factory = new DaoFactory();
        teatroDao = factory.crearTeatroDao();
    }

    @Override
    public void setVista(Vista vista) {
        this.vistaNuevoTeatro = (VistaHija) vista;
    }

    @Override
    public void setVistaPadre(Vista vista) {
        this.vistaTeatro = (VistaPadre) vista;
    }

    public void guardarTeatro(InfoTeatro infoTeatro) {

        try {
            
            id = infoTeatro.getId();
            if (isNull(id)) {
                
                EntityFactory factory = new EntityFactory();
                Teatro teatro =  factory.crearTeatro();
                Direccion direccion = factory.crearDireccion();
                setearDatos(infoTeatro, teatro, direccion);   
                
                teatroDao.create(teatro);
                
            } else {
                
                Teatro teatro = teatroDao.read(infoTeatro.getId());
                setearDatos(infoTeatro, teatro, teatro.getDireccion());
                
                teatroDao.update(teatro);
            }

            vistaNuevoTeatro.mostrarMensaje("Teatro guardado exitosamente");
            vistaTeatro.actualizar();
            Main.getInstance().cerrarDialogAux();        

        } catch (IllegalArgumentException ex) {

            vistaNuevoTeatro.mostrarMensaje("Error: "
                    + "el teatro no pudo ser guardado.\n\n"
                    + ex.getMessage());
        }
    }

    private void setearDatos(InfoTeatro info, Teatro teatro, Direccion direc)
            throws IllegalArgumentException {

        direc.withCalle(info.getCalle())
             .withNumero(info.getDepto())
             .withBarrio(info.getBarrio())
             .withCodigoPostal(validarCodigoPostal(info.getCodigo()));

        teatro.withNombre(validarNombres(info.getNombre()))
              .withCapacidad(validarCapacidad(info.getCapacidad()))
              .withTelefono(info.getTelefono())
              .withEmail(info.getEmail())
              .withDireccion(direc);
    }

    // <editor-fold defaultstate="collapsed" desc=" Validaciones ">
    public String validarNombres(String value) throws IllegalArgumentException {

        // Reglas de validación
        checkArgument(value.matches("^[\\p{L} .'-]+$"),
                "Verifique que el nombre sea correcto");
        
        return value;
    }

    public Integer validarCapacidad(String value) throws IllegalArgumentException {

        // Reglas de validación
        checkArgument(isNumeric(value),
                "El campo capacidad debe ser un número");
        
        Integer aux = Integer.parseInt(value);
        checkArgument(aux >= 1 && aux < 100000, 
                "Verifique el rango de la capacidad");

        return aux;
    }

    public Integer validarCodigoPostal(String value) throws IllegalArgumentException {

        // Es opcional...
        if (!isNull(value)) {

            checkArgument(isNumeric(value),
                    "El campo código postal debe ser un número válido");

            return Integer.parseInt(value);
            
        } // Ausencia del atributo
        
        else return null;
    }
    // </editor-fold> 
}
