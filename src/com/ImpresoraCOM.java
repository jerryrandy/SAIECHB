/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;




import dao.ImpresoraDAO;
import entidades.Impresora;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ImpresoraCOM {

    public String verificarNSerie(String nSerie) throws Exception
    {
        return ImpresoraDAO.verificarNSerie(nSerie);
    }

     public boolean insertar(Impresora objImpresora) throws Exception
    {
        return ImpresoraDAO.insertar(objImpresora);
    }
        public List<Impresora> listarTodosOrdenado(int Estado) throws Exception
    {
         return ImpresoraDAO.listarTodosOrdenado(Estado);
    }
        
             public boolean eliminar(String IdImpresora) throws Exception
    {
        return ImpresoraDAO.eliminar(IdImpresora);
    }    

}
