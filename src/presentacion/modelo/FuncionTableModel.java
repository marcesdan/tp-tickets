/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import dao.DaoFactory;
import entidades.Cliente;
import entidades.Funcion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Matias
 */
public class FuncionTableModel extends ATableModel{
    
    public FuncionTableModel(){
        
        super(new DaoFactory().crearFuncionDao(),
                
                new String[]{
                    "Nombre","Precio","Fecha y hora","Teatro"},
                
                new Class[]{
                    String.class, Double.class, String.class, Funcion.class});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcion funcion = (Funcion) getData().get(rowIndex);
        switch(columnIndex){
                    case 0:return funcion.getNombre();
                    case 1:return funcion.getPrecio();
                    
                    case 2: {
                        // Devolvemos un string con la fecha formateada (sino sale feita)
                        DateTimeFormatter formatter 
                                = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm");
                        return funcion.getFecha().format(formatter);
                    } 
                    
                    case 3:return funcion.getTeatro();
                }
        
        return null;
    }
    
    @Override
    protected void updateId() {
        for (int i = 0; i < data.size(); i++) 
           id.add( ((Funcion) data.get(i)).getId() );
    }
 
}
