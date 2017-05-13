/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Teatro;
import java.util.List;
import javax.persistence.Query;

/** 
 *
 * @author marces
 */
public class TeatroJpa extends JpaDao<Long, Teatro> 
    implements TeatroDao {
    
    public TeatroJpa() {
        super();
    }
    
    @Override
    public List<Teatro> buscarTodos() {
        Query consulta = getEm().createQuery("select s from " 
                + entityClass.getName() + "s");
        return (List<Teatro>) consulta.getResultList();
    }

    @Override
    public List<Teatro> getAllOrd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}