/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.modelo;

import dao.DaoFactory;
import dao.FuncionDao;
import entidades.Funcion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author marces
 */
public class FuncionComboBoxModel implements ComboBoxModel {
    
    private Funcion item;
    private List<Funcion> funciones;
    private FuncionDao dao;

    public FuncionComboBoxModel() {
        dao = new DaoFactory().crearFuncionDao();
        funciones = new ArrayList(dao.getAll());
    }
    
    @Override
    public Object getElementAt(int index) {
        return funciones.get(index);
    }

    @Override
    public int getSize() {
        return funciones.size();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item = (Funcion) anItem; // to select and register an
    } // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    @Override
    public Funcion getSelectedItem() {
        return item; // to add the selection to the combo box
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        // bye
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        // bye
    }
}