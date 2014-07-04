/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.ModeloDAO;
import entidades.Modelo;
import java.util.List;

/**
 *
 * @author prac_hbt
 */
public class ModeloCOM {

       public List<Modelo> listarActivosOrdenado() throws Exception
    {
         return ModeloDAO.listarActivosOrdenado();
    }
    
     public List<Modelo> listarTodosOrdenado() throws Exception
    {
         return ModeloDAO.listarTodosOrdenado();
    }
     
        public List<Modelo> listarActivosXTipo(int IdTipo) throws Exception
    {
         return ModeloDAO.listarActivosXTipo(IdTipo);
    }
    public List<Modelo> listarActivosXTipoMarca(int IdTipo,int idMarca) throws Exception
    {
         return ModeloDAO.listarActivosXTipoMarca(IdTipo,idMarca);
    }
        
        
        
     
       public List<Modelo> listarFiltro(String filtro) throws Exception
    {
         return ModeloDAO.listarFiltro(filtro);
    }


    public boolean insertar(Modelo objModelo) throws Exception
    {
        return ModeloDAO.insertar(objModelo);
    }
    
    public boolean actualizar(Modelo objModelo) throws Exception
    {
        return ModeloDAO.actualizar(objModelo);
    }

    public boolean eliminar(int IdModelo) throws Exception
    {
        return ModeloDAO.eliminar(IdModelo);
    }
    
}
