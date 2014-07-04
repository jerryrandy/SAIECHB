/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.EmpleadoDAO;
import entidades.Empleado;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class EmpleadoCOM {

    public EmpleadoCOM() {
    }
    
     public int insertar(Empleado objEmpleado) throws Exception
    {
        return EmpleadoDAO.insertar(objEmpleado);
    }
     
        public List<Empleado> listarFiltro(String filtro) throws Exception
    {
         return EmpleadoDAO.listarFiltro(filtro);
    }
            public List<Empleado> listarFiltroAsignado(String filtro,int Estado) throws Exception
    {
         return EmpleadoDAO.listarFiltroAsignado(filtro,Estado);
    }

    public List<Empleado> listarTodosOrdenado() throws Exception
    {
        return EmpleadoDAO.listarTodosOrdenado();
    }
    
      public List<Empleado> listarTodosActivos() throws Exception
    {
        return EmpleadoDAO.listarTodosActivos();
    }
    
    
     public List<Empleado> listarEmpleadoXArea(int idArea) throws Exception
    {
        return EmpleadoDAO.listarEmpleadoXArea(idArea);
    }
       public List<Empleado> listarEmpleadoXAreaAsigando(int idArea,int Estado) throws Exception
    {
        return EmpleadoDAO.listarEmpleadoXAreaAsigando(idArea,Estado);
    }
     public boolean actualizar(Empleado objEmpleado) throws Exception
    {
        return EmpleadoDAO.actualizar(objEmpleado);
    }
    public  boolean actualizarEstado(int IdEmpleado,int Estado)throws Exception
    {
        return EmpleadoDAO.actualizarEstado(IdEmpleado, Estado);
    }
       public List<Empleado> listarEmpleadoAsignado(int Estado) throws Exception
    {
        return EmpleadoDAO.listarEmpleadoAsignado(Estado);
    }
    
         public boolean eliminar(int IdEmpleado) throws Exception
    {
        return EmpleadoDAO.eliminar(IdEmpleado);
    }

       

    
}
