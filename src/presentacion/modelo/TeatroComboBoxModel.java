/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package presentacion.modelo;

import dao.DaoFactory;
import dao.TeatroDao;
import entidades.Teatro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author marces
 */
public class TeatroComboBoxModel implements ComboBoxModel {
    
    private Teatro item;
    private List<Teatro> teatros;
    private TeatroDao dao;

    public TeatroComboBoxModel() {
        dao = new DaoFactory().crearTeatroDao();
        teatros = new ArrayList(dao.getAll());
    }
    
    @Override
    public Object getElementAt(int index) {
        return teatros.get(index);
    }

    @Override
    public int getSize() {
        return teatros.size();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        item = (Teatro) anItem; // to select and register an
    } // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    @Override
    public Teatro getSelectedItem() {
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