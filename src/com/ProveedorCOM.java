/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.ProveedorDAO;
import entidades.Proveedor;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ProveedorCOM {


       public List<Proveedor> listarActivosOrdenado() throws Exception
    {
         return ProveedorDAO.listarActivosOrdenado();
    }
    
     public List<Proveedor> listarTodosOrdenado() throws Exception
    {
         return ProveedorDAO.listarTodosOrdenado();
    }
     
       public List<Proveedor> listarFiltro(String filtro) throws Exception
    {
         return ProveedorDAO.listarFiltro(filtro);
    }


    public int insertar(Proveedor objProveedor) throws Exception
    {
        return ProveedorDAO.insertar(objProveedor);
    }
    
    public boolean actualizar(Proveedor objProveedor) throws Exception
    {
        return ProveedorDAO.actualizar(objProveedor);
    }

    public boolean eliminar(int IdProveedor) throws Exception
    {
        return ProveedorDAO.eliminar(IdProveedor);
    }
}
