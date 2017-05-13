/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import java.util.List;

/**
 *
 * @author marces
 * @param <K> Clave primaria.
 * @param <E> Entidad.
 */
public interface GenericDao<K, E> {

    public E create(E entity);

    public E read(K id);

    public E update(E entity);

    public void delete(E entity);
    
    public Long getCount();
    
    public List<E> getAll();
    
    public List<E> getAllOrd();
}
