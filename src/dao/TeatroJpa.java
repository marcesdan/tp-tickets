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
    public List<Teatro> getAllOrd() {
        
        return (List<Teatro>) 
                getEm().createQuery("select s from "+entityClass.getName()+ ""
                        + " s order by s.nombre")
                       .getResultList(); 
    }
}