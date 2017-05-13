/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import entidades.Cliente;
import dao.DaoFactory;

/**
 *
 * @author Matias
 */
public class ClienteTableModel extends ATableModel{
    
    public ClienteTableModel(){
        
        super(new DaoFactory().crearClienteDao(),
                
                new String[]{
                    "apellido","nombre","documento","telefono",
                    "calle","numero","barrio","codigo"},
                
                new Class[]{
                    String.class, String.class, Long.class, String.class,
                    String.class, String.class, String.class, Integer.class});
        
        // llenamos un array de IDs. No los queremos mostrar en la tabla.
        for (int i = 0; i < data.size(); i++) 
           id.add( ((Cliente) data.get(i)).getId() );
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente s = (Cliente) getData().get(rowIndex);
        switch(columnIndex){
                    case 0:return s.getApellido();
                    case 1:return s.getNombre();
                    case 2:return s.getDni();
                    case 3:return s.getTelefono();
                    case 4:return s.getDireccion().getCalle();
                    case 5:return s.getDireccion().getNumero();
                    case 6:return s.getDireccion().getBarrio();
                    case 7:return s.getDireccion().getCodigoPostal();
                }
        
        return null;
    }
 
}
