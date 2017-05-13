/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Ticket;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marces
 */
public class TicketJpa extends JpaDao<Long, Ticket> 
    implements TicketDao{
    
    public TicketJpa(){
        super();
    }

    @Override
    public List<Ticket> buscarTodos() {
        
        Query consulta = getEm().createQuery("select s from " 
                + entityClass.getName() + "s");
        
        return (List<Ticket>) consulta.getResultList();
    }

    @Override
    public List<Ticket> getAllOrd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long buscarTicketsFuncion(Long idFuncion) {
                
        return (Long) getEm()
                .createQuery("SELECT count(e) FROM " + entityClass.getName() + 
                        " e JOIN FETCH e.funcion a where a.id = "
                        + idFuncion.toString()).getSingleResult();
        
        /*
         List list = getEm()
                .createQuery("SELECT e, a FROM " 
                        + entityClass.getName() +
                        " e, Funcion a WHERE e.id = a.id").getResultList();*/
                 
    }
}
