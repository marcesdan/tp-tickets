/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Ticket;

/**
 *
 * @author marces
 */
public interface TicketDao extends GenericDao<Long, Ticket> {
    
    /**
     * Nos da la cantidad de tickets vendidos de la funcion bajo "idFuncion".
     * @param idFuncion el id de la funcion a evaluar
     * @return numero con la cantidad de tickets vendidos de la funcion
     */
    public Integer buscarTicketsFuncion(Long idFuncion);
}
