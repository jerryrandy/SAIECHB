/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.MarcaDAO;
import entidades.Marca;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MarcaCOM {
/**
    public List<Marca> listarMarcasImpresorasActivos()throws Exception
    {
         return MarcaDAO.listarMarcasImpresorasActivos();
    }
     * */
       public List<Marca> listarActivosOrdenado() throws Exception
    {
         return MarcaDAO.listarActivosOrdenado();
    }
    
     public List<Marca> listarTodosOrdenado() throws Exception
    {
         return MarcaDAO.listarTodosOrdenado();
    }
     
       public List<Marca> listarFiltro(String filtro) throws Exception
    {
         return MarcaDAO.listarFiltro(filtro);
    }


    public boolean insertar(Marca objMarca) throws Exception
    {
        return MarcaDAO.insertar(objMarca);
    }
    
    public boolean actualizar(Marca objArea) throws Exception
    {
        return MarcaDAO.actualizar(objArea);
    }

    public boolean eliminar(int IdMarca) throws Exception
    {
        return MarcaDAO.eliminar(IdMarca);
    }
}
