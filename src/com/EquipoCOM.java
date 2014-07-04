/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;




import dao.EquipoDAO;
import entidades.Equipo;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class EquipoCOM {

      public String verificarNSerie(String nSerie) throws Exception
    {
        return EquipoDAO.verificarNSerie(nSerie);
    }

     public boolean insertar(Equipo objEquipo) throws Exception
    {
        return EquipoDAO.insertar(objEquipo);
    }
     
          public List<Equipo> listarTodosOrdenado(int Estado) throws Exception
    {
         return EquipoDAO.listarTodosOrdenado(Estado);
    }
        
             public boolean eliminar(String IdEquipo) throws Exception
    {
        return EquipoDAO.eliminar(IdEquipo);
    }    
    
    

}
