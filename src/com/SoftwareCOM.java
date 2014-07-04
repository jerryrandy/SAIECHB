/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import dao.SoftwareDAO;
import entidades.Software;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class SoftwareCOM {

  public List<Software> listarActivosOrdenado() throws Exception
    {
         return SoftwareDAO.listarActivosOrdenado();
    }
    
     public List<Software> listarTodosOrdenado() throws Exception
    {
         return SoftwareDAO.listarTodosOrdenado();
    }
     
       public List<Software> listarFiltro(String filtro) throws Exception
    {
         return SoftwareDAO.listarFiltro(filtro);
    }


    public boolean insertar(Software objSoftware) throws Exception
    {
        return SoftwareDAO.insertar(objSoftware);
    }
    
    public boolean actualizar(Software objSoftware) throws Exception
    {
        return SoftwareDAO.actualizar(objSoftware);
    }

    public boolean eliminar(int IdSoftware) throws Exception
    {
        return SoftwareDAO.eliminar(IdSoftware);
    }
       public List<Software> listarTipoActivo(int tipo) throws Exception
    {
         return SoftwareDAO.listarTipoActivo(tipo);
    }
       
  
    public boolean insertarXEmpleado(int idEmpleado,int idSoftware) throws Exception
    {
        return SoftwareDAO.insertarXEmpleado(idEmpleado,idSoftware);
    }
    
    
        public List<Software> listarTipoXEmpleado(int IdEmpleado,int Tipo)throws Exception
    {
         return SoftwareDAO.listarTipoXEmpleado(IdEmpleado,Tipo);
    }
        

                  
     public Software buscarSistemaXCPU(String IdCPU) throws Exception
    {
         return SoftwareDAO.buscarSistemaXCPU(IdCPU);
    }
            public Software buscarTipoXEmpleado(int IdEmpleado,int Tipo)throws Exception
    {
         return SoftwareDAO.buscarTipoXEmpleado(IdEmpleado,Tipo);
    }
            
            
          public boolean eliminarXEmpleado(int idEmpleado,int idSoftware) throws Exception
    {
        return SoftwareDAO.eliminarXEmpleado(idEmpleado,idSoftware);
    }   
            
            
            
          

    
    
    
}

