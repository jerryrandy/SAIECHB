/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import dao.HistorialComponenteDAO;
import entidades.HistorialComponente;
import java.util.List;
/**
 *
 * @author Toditos
 */
public class HistorialComponenteCOM {
    
       public boolean insertar(String IdComponente,String Descripcion) throws Exception
    {
        return HistorialComponenteDAO.insertar(IdComponente,Descripcion);
    }
      
        public List<HistorialComponente> listarHistorial(String IdComponente)throws Exception
    {
         return HistorialComponenteDAO.listarHistorial(IdComponente);
    }

}
