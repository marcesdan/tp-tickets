/*
/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Teatro;
import java.util.List;

/**
 *
 * @author marces
 */
public interface TeatroDao extends GenericDao<Long, Teatro> {

    List<Teatro> buscarTodos();
}
