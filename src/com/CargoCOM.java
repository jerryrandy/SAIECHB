/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.CargoDAO;
import entidades.Cargo;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class CargoCOM {


       public List<Cargo> listarActivosOrdenado() throws Exception
    {
         return CargoDAO.listarActivosOrdenado();
    }
    
     public List<Cargo> listarTodosOrdenado() throws Exception
    {
         return CargoDAO.listarTodosOrdenado();
    }
     
       public List<Cargo> listarFiltro(String filtro) throws Exception
    {
         return CargoDAO.listarFiltro(filtro);
    }


    public boolean insertar(Cargo objCargo) throws Exception
    {
        return CargoDAO.insertar(objCargo);
    }
    
    public boolean actualizar(Cargo objArea) throws Exception
    {
        return CargoDAO.actualizar(objArea);
    }

    public boolean eliminar(int IdCargo) throws Exception
    {
        return CargoDAO.eliminar(IdCargo);
    }
}
