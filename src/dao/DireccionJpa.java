/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Direccion;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marces
 */
public class DireccionJpa extends JpaDao<Long, Direccion> 
    implements DireccionDao {
    
    public DireccionJpa() {
        super();
    }
    
    @Override
    public List<Direccion> buscarTodos() {
        Query consulta = getEm().createQuery("select s from " 
                + entityClass.getName() + "s");
        return (List<Direccion>) consulta.getResultList();
    }

    @Override
    public List<Direccion> getAllOrd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}