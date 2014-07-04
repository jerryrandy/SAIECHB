/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Componente;
import entidades.Modelo;

/**
 *
 * @author MBRINGASCH
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
  
      boolean verdadero= UsuarioDAO.verAdministrador();
      
      if(verdadero)
          System.out.println("si hay");
      else
          System.out.println("no hay");
        
    }
}
