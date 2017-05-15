/*
 * UNTDF - Laboratorio de programación y lenguajes (2017)
 */
package dao;

import entidades.Funcion;
import java.time.LocalDate;
import java.util.List;

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
    public List<Funcion> getAllOrd() {
        
        // Obtenemos todos
        List<Funcion> result = getAll();
        
        // Eliminamos las funciones que ya pasaron
        result.stream().filter((f) ->
                
                (f.getFecha().toLocalDate().isBefore(LocalDate.now())))
                    .forEachOrdered((f) -> { 
                        result.remove(f);
        });
          
        
        /*Los ordenamos manualmente porque, por el momento, no
        hay forma de persistir LocalDate en EclipseLink*/
        result.sort((Funcion o1, Funcion o2) -> {
            
            if (o2.getFecha().isAfter(o1.getFecha()))
                return 1;
            
            else if (o1.getFecha().isAfter(o2.getFecha()))
                return -1;
            
            else return 0;
        });
        
        return result;
    }
}
