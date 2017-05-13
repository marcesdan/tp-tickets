/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Cliente;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marces
 */
public class ClienteJpa extends JpaDao<Long, Cliente>
        implements ClienteDao {

    public ClienteJpa() {
        super();
    }

    @Override
    public List<Cliente> buscarTodos() {
        
        Query consulta = getEm().createQuery("select s from "
                + entityClass.getName() + "s");
        
        return (List<Cliente>) consulta.getResultList();
    }

    @Override
    public List<Cliente> getAllOrd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscarPorDni(int dni) {
        
        List<Cliente> result = getEm()
                .createQuery("SELECT t FROM "+entityClass.getName()+" t where t.dni = :dni")
                .setParameter("dni", dni)
                .getResultList();
          
        if (result.isEmpty()) return null;
        
        else return result.get(0);
    }
}
