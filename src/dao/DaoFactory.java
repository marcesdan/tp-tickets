/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

/**
 *
 * @author marces
 */
public class DaoFactory {

    public TeatroDao crearTeatroDao() {
        return new TeatroJpa();
    }

    public FuncionDao crearFuncionDao() {
        return new FuncionJpa();
    }

    public DireccionDao crearDireccionDao() {
        return new DireccionJpa();
    }
    
    public TicketDao crearTicketDao() {
        return new TicketJpa();
    }
    
    public ClienteDao crearClienteDao() {
        return new ClienteJpa();
    }
}
