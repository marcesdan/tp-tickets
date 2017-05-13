/*
/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Direccion;
import java.util.List;

/**
 *
 * @author marces
 */
public interface DireccionDao extends GenericDao<Long, Direccion> {

    List<Direccion> buscarTodos();
}
