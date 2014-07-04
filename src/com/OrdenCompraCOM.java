/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.OrdenCompraDAO;
import entidades.OrdenCompra;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class OrdenCompraCOM {

    public String verificarNSerie(String nSerie) throws Exception
    {
        return OrdenCompraDAO.verificarNSerie(nSerie);
    }

     public boolean insertar(OrdenCompra objOrdenCompra) throws Exception
    {
        return OrdenCompraDAO.insertar(objOrdenCompra);
    }
    

}
