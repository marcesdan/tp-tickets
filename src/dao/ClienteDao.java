/*
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
public interface ClienteDao extends GenericDao<Long, Cliente> {

    public List<Cliente> buscarTodos();
    
    public Cliente buscarPorDni(int dni);
}
