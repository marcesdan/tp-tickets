/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Funcion;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marces
 */
public class FuncionJpa extends JpaDao<Long, Funcion> 
    implements FuncionDao {
    
    public FuncionJpa() {
        super();
    }
    
    @Override
    public List<Funcion> buscarTodos() {
        Query consulta = getEm().createQuery("select s from " 
                + entityClass.getName() + "s");
        return (List<Funcion>) consulta.getResultList();
    }

    @Override
    public List<Funcion> getAllOrd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
