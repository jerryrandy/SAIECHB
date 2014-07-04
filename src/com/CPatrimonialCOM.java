/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;



import dao.CPatrimonialDAO;
import entidades.CPU;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class CPatrimonialCOM {

    public String verificarNSerie(String nPatrimonial) throws Exception
    {
        return CPatrimonialDAO.verificarCPatrimonial(nPatrimonial);
    }

     public boolean insertar(String nPatrimonial) throws Exception
    {
        return CPatrimonialDAO.insertar(nPatrimonial);
    }
    

}
