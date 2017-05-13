/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import dao.DaoFactory;
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
                    "nombre","precio","fechaHora",
                    "teatro"},
                
                new Class[]{
                    String.class, Double.class, String.class, Funcion.class});
        
        // llenamos un array de IDs. No los queremos mostrar en la tabla.
        for (int i = 0; i < data.size(); i++) 
           id.add( ((Funcion) data.get(i)).getId() );
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
 
}
