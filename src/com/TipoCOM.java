/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.TipoDAO;
import entidades.Tipo;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class TipoCOM {


       public List<Tipo> listarActivosOrdenado() throws Exception
    {
         return TipoDAO.listarActivosOrdenado();
    }
           public List<Tipo> listarTipoUbicacionActivo(int Ubicacion) throws Exception
    {
         return TipoDAO.listarTipoUbicacionActivo(Ubicacion);
    }
    

    
     public List<Tipo> listarTodosOrdenado() throws Exception
    {
         return TipoDAO.listarTodosOrdenado();
    }
     
       public List<Tipo> listarFiltro(String filtro) throws Exception
    {
         return TipoDAO.listarFiltro(filtro);
    }


    public boolean insertar(Tipo objTipo) throws Exception
    {
        return TipoDAO.insertar(objTipo);
    }
    
    public boolean actualizar(Tipo objTipo) throws Exception
    {
        return TipoDAO.actualizar(objTipo);
    }

    public boolean eliminar(int IdTipo) throws Exception
    {
        return TipoDAO.eliminar(IdTipo);
    }
}
