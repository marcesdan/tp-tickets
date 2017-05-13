/*
/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Funcion;
import java.util.List;

/**
 *
 * @author marces
 */
public interface FuncionDao extends GenericDao<Long, Funcion> {

    List<Funcion> buscarTodos();

}
