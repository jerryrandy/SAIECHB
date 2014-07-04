/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;




import dao.PortatilDAO;
import entidades.Portatil;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class PortatilCOM {


       public String verificarNSerie(String nSerie) throws Exception
    {
        return PortatilDAO.verificarNSerie(nSerie);
    }

     public boolean insertar(Portatil objPortatil) throws Exception
    {
        return PortatilDAO.insertar(objPortatil);
    }
     
    public List<Portatil> listarTodosOrdenado(int Estado) throws Exception
    {
         return PortatilDAO.listarTodosOrdenado(Estado);
    }
    
    public List<Portatil> listarFiltro(String filtro) throws Exception
    {
         return PortatilDAO.listarFiltro(filtro);
    }
    
       
      public boolean actualizar(Portatil objPortatil) throws Exception
    {
        return PortatilDAO.actualizar(objPortatil);
    }

}
