/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Ticket;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author marces
 */
public class TicketJpa
        extends JpaDao<Long, Ticket>
        implements TicketDao {

    public TicketJpa() {
        super();
    }

    @Override
    public List<Ticket> getAllOrd() {
         /**
         * Como EclipseLink no nos permite mapear LocalDateTime (Java8 salió
         * despues que la última actualización de EclipseLink), eliminamos las
         * funciones que ya pasaron. */
         
         // Obtenemos todos
         List<Ticket> result = getAll();
        
        /* Eliminamos las funciones que ya pasaron
        result.stream().filter((ticket) ->
                
                (ticket.getFuncion().getFecha().isBefore(LocalDateTime.now().minusHours(3))))
                    .forEachOrdered((ticket) -> { 
                        result.remove(ticket);
        });*/
        
        //Los ordenamos manualmente
        result.sort((Ticket t1, Ticket t2) -> {
            
            if (t2.getFuncion().getFecha().isAfter(t1.getFuncion().getFecha()))
                return 1;
            
            else if (t1.getFuncion().getFecha().isAfter(t2.getFuncion().getFecha()))
                return -1;
            
            else return 0;
        });
        
        return result;
    }

    @Override
    public Integer buscarTicketsFuncion(Long idFuncion) {

        return ((Long) getEm().createQuery("SELECT count(e) FROM " + entityClass.getName()
                + " e JOIN FETCH e.funcion a where a.id = "
                + idFuncion.toString()).getSingleResult()).intValue();

    }
}
