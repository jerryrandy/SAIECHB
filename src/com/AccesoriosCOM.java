/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import dao.AccesoriosDAO;
import entidades.Accesorios;
import entidades.Componente;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class AccesoriosCOM {

    public boolean verificarNSerie(String nSerie) throws Exception
    {
        return AccesoriosDAO.verificarNSerie(nSerie);
    }

     public boolean insertarAccComputador(Accesorios objAccesorios,String IdComputador) throws Exception
    {
        return AccesoriosDAO.insertarAccComputador(objAccesorios,IdComputador);
    }
         
      public boolean insertarComputadorAccesorios(String IdComputdor,String IdAccesorios) throws Exception
    {
        return AccesoriosDAO.insertarComputadorAccesorios(IdComputdor,IdAccesorios);
    }

       public boolean insertarAcc(Accesorios objAccesorios) throws Exception
    {
        return AccesoriosDAO.insertarAcc(objAccesorios);
    }
    
           public List<Accesorios>listarAccesoriosXComputador(String IdComputador)throws Exception
    {
         return AccesoriosDAO.listarAccesoriosXComputador(IdComputador);
    }


    public List<Accesorios> listarTodosOrdenado(int Estado)throws Exception
    {
       return AccesoriosDAO.listarTodosOrdenado(Estado);
    }

    public boolean eliminarComputadorComponete(String IdComputador, String IdAccesorios) throws Exception
    {
        return AccesoriosDAO.eliminarComputadorComponete(IdComputador, IdAccesorios);
    }
    
}
