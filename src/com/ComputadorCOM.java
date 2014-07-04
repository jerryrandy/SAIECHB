/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.ComputadorDAO;
import entidades.Computador;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ComputadorCOM {

    public String verificarNombre(String Nombre) throws Exception
    {
        return ComputadorDAO.verificarNombre(Nombre);
    }

     public boolean insertar(Computador objComputador) throws Exception
    {
        return ComputadorDAO.insertar(objComputador);
    }
     
      public boolean actualizar(Computador objComputador) throws Exception
    {
        return ComputadorDAO.actualizar(objComputador);
    }
      
         public List<Computador> listarFiltro(String filtro) throws Exception
    {
         return ComputadorDAO.listarFiltro(filtro);
    }
          public List<Computador> listarTodosOrdenado(int Estado) throws Exception
    {
         return ComputadorDAO.listarTodosOrdenado(Estado);
    }

}
