/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import dao.MonitorDAO;
import entidades.Monitor;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MonitorCOM {

    public String verificarNSerie(String nSerie) throws Exception
    {
        return MonitorDAO.verificarNSerie(nSerie);
    }

     public boolean insertar(Monitor objMonitor) throws Exception
    {
        return MonitorDAO.insertar(objMonitor);
    }
     
      public List<Monitor> ListarMonitorXEstado(int Estado)throws Exception
    {
         return MonitorDAO.ListarMonitorXEstado(Estado);
    }



}
