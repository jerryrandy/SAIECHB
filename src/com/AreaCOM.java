/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.AreaDAO;
import entidades.Area;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class AreaCOM {

    public AreaCOM() {
    }

    
     public List<Area> listarTodosOrdenadoIniciales() throws Exception
    {
         return AreaDAO.listarTodosOrdenadoIniciales();
    }
     
       public List<Area> listarFiltro(String filtro) throws Exception
    {
         return AreaDAO.listarFiltro(filtro);
    }


    public boolean insertar(Area objArea) throws Exception
    {
        return AreaDAO.insertar(objArea);
    }
    
    public boolean actualizar(Area objArea) throws Exception
    {
        return AreaDAO.actualizar(objArea);
    }

    public boolean eliminar(int IdArea) throws Exception
    {
        return AreaDAO.eliminar(IdArea);
    }

    public List<Area> listarActivosXDepartamento(int IdDepartamento)throws Exception
    {
         return AreaDAO.listarActivosXDepartamento(IdDepartamento);
    }

  
}
