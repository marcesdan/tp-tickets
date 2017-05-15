/*
/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Cliente;
/**
 *
 * @author marces
 */
public interface ClienteDao extends GenericDao<Long, Cliente> {
    
    /** Consulta sql que nos devuelve el cliente bajo un DNI
     * @param dni documento del cliente. Es clave candidata (Unique)
     * @return instancia del cliente bajo ese DNI
     */
    public Cliente buscarPorDni(int dni);
}
