/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import entidades.Teatro;
import dao.DaoFactory;

/**
 *
 * @author marces
 */
public class TeatroTableModel extends ATableModel{
    
    public TeatroTableModel(){
        
        super(new DaoFactory().crearTeatroDao(),
                
                new String[]{
                    "Nombre","Capacidad",
                    "Calle","Número","Barrio","Código"},
                
                new Class[]{
                    String.class, Integer.class,
                    String.class, String.class, String.class, Integer.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teatro s = (Teatro) getData().get(rowIndex);
        switch(columnIndex){
                    case 0:return s.getNombre();
                    case 1:return s.getCapacidad();
                    case 2:return s.getDireccion().getCalle();
                    case 3:return s.getDireccion().getNumero();
                    case 4:return s.getDireccion().getBarrio();
                    case 5:return s.getDireccion().getCodigoPostal();
                }
        
        return null;
    }
    
    @Override
    protected void updateId() {
        for (int i = 0; i < data.size(); i++) 
           id.add( ((Teatro) data.get(i)).getId() );
    }
}
