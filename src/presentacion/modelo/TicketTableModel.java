/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import dao.DaoFactory;
import entidades.Ticket;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Matias
 */
public class TicketTableModel extends ATableModel{
    
    public TicketTableModel(){
        
        super(new DaoFactory().crearTicketDao(),
                
                new String[]{
                    "Cliente","Función","Fecha y hora","Teatro"},
                
                new Class[]{
                    Integer.class, String.class, String.class, String.class});
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Ticket ticket = (Ticket) getData().get(rowIndex);
        switch(columnIndex){
            
                    case 0:return ticket.getCliente().getDni();
                    case 1:return ticket.getFuncion();
                    
                    case 2: {
                        // Devolvemos un string con la fecha formateada (sino sale feita)
                        DateTimeFormatter formatter 
                                = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm");
                        return ticket.getFuncion().getFecha().format(formatter);
                    } 
                    
                    case 3:return ticket.getFuncion().getTeatro();
                }
        
        return null;
    }
    
    @Override
    protected void updateId() {
        for (int i = 0; i < data.size(); i++) 
           id.add( ((Ticket) data.get(i)).getId() );
    }
}
