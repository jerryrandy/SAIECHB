/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.ComponenteDAO;
import entidades.Componente;
import entidades.DetalleComponente;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ComponenteCOM {

    public String verificarNSerie(String nSerie) throws Exception
    {
        return ComponenteDAO.verificarNSerie(nSerie);
    }
     public List<Componente> listarComponentesxTipo(int IdTipo,int Estado) throws Exception
    {
         return ComponenteDAO.listarComponentesxTipo(IdTipo,Estado);
    }
     
    public List<Componente> listarComponentesxUbicacion(int Ubicacion,int Estado) throws Exception
    {
         return ComponenteDAO.listarComponentesxUbicacion(Ubicacion,Estado);
    }
    
     public Componente buscarComponenteXId(String IdCamponente) throws Exception
    {
         return ComponenteDAO.buscarComponenteXId(IdCamponente);
    }
      public List<Componente>  listarComponentesXCPU(String IdCPU) throws Exception
    {
         return ComponenteDAO.listarComponentesXCPU(IdCPU);
    }
      
   public  boolean actualizarEstado(String IdComponente,int Estado) throws Exception
   {
        return ComponenteDAO.actualizarEstado(IdComponente, Estado);
   }

    public List<Componente>  listarComponentesxEstado(int Estado) throws Exception
    {
         return ComponenteDAO.listarComponentesxEstado(Estado);
    }
    
      public List<Componente>  listarFiltro(String filtro,int Estado) throws Exception
    {
         return ComponenteDAO.listarFiltro(filtro,Estado);
    }
   
        public List<DetalleComponente>  listarDetallesxEstado(int Estado) throws Exception
    {
         return ComponenteDAO.listarDetallesxEstado(Estado);
    }
    
      public List<DetalleComponente>  listarFiltroDetalles(String filtro,int Estado) throws Exception
    {
         return ComponenteDAO.listarFiltroDetalles(filtro,Estado);
    }
   

}
