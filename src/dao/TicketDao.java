/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Funcion;
import entidades.Ticket;
import java.util.List;

/**
 *
 * @author marces
 */
public interface TicketDao extends GenericDao<Long, Ticket> {

    public List<Ticket> buscarTodos();
    
    public Long buscarTicketsFuncion(Long idFuncion);
}
