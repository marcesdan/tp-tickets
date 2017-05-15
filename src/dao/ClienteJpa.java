/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Cliente;
import java.util.List;

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
    public List<Cliente> getAllOrd() {
        
        return (List<Cliente>) getEm()
                .createQuery("select s from "+ entityClass.getName() + ""
                        + " s order by s.apellido asc, s.nombre asc")
                .getResultList(); 
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
