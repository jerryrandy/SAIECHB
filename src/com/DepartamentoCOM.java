/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.DepartamentoDAO;
import entidades.Departamento;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class DepartamentoCOM {

    public List<Departamento> listarActivos()throws Exception
    {
         return DepartamentoDAO.listarActivos();
    }
       public List<Departamento> listarActivosOrdenado() throws Exception
    {
         return DepartamentoDAO.listarActivosOrdenado();
    }
    
     public List<Departamento> listarTodosOrdenado() throws Exception
    {
         return DepartamentoDAO.listarTodosOrdenado();
    }
     
       public List<Departamento> listarFiltro(String filtro) throws Exception
    {
         return DepartamentoDAO.listarFiltro(filtro);
    }


    public int insertar(Departamento objDepartamento) throws Exception
    {
        return DepartamentoDAO.insertar(objDepartamento);
    }
    
    public boolean actualizar(Departamento objDepartamento) throws Exception
    {
        return DepartamentoDAO.actualizar(objDepartamento);
    }

    public boolean eliminar(int IdDepartamentoa) throws Exception
    {
        return DepartamentoDAO.eliminar(IdDepartamentoa);
    }
}
