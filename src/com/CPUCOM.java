/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import dao.CPUDAO;
import entidades.CPU;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class CPUCOM {

    public boolean verificarNSerie(String nSerie) throws Exception
    {
        return CPUDAO.verificarNSerie(nSerie);
    }

     public boolean insertar(CPU objCPU) throws Exception
    {
        return CPUDAO.insertar(objCPU);
    }
      public List<CPU> listarTodosOrdenado(int Estado) throws Exception
    {
        return CPUDAO.listarTodosOrdenado(Estado);
    }
      
        public List<CPU> listarFiltro(String filtro,int Estado) throws Exception
    {
        return CPUDAO.listarFiltro(filtro,Estado);
    }
      
               
         public  boolean actualizarEstado(String IdCPU,int Estado)throws Exception
    {
        return CPUDAO.actualizarEstado(IdCPU, Estado);
    }
   public  boolean insertarCPUcomponentes(String IdCPU,String IdComponente) throws Exception
   {
       return CPUDAO.insertarCPUcomponentes(IdCPU, IdComponente);
   }

   
    public  boolean actualizarSistema(String IdCPU,int IdSoftware) throws Exception
   {
       return CPUDAO.actualizarSistema(IdCPU, IdSoftware);
   }

    public boolean eliminarCPUComponete(String IdCPU,String IdComponente) throws Exception {
         return CPUDAO.eliminarCPUComponete(IdCPU, IdComponente);
    }
}
