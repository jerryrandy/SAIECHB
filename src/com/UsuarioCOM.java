/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.UsuarioDAO;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class UsuarioCOM {
    
     public boolean insertar(Usuario objUsuario) throws Exception
    {
        return UsuarioDAO.insertar(objUsuario);
    }
     
     public boolean verAdministrador() throws Exception
    {
        return UsuarioDAO.verAdministrador();
    }
     
     public  Usuario iniciarSesion(String user,String pass) throws Exception
     {
         return UsuarioDAO.iniciarSesion(user, pass);
     }  
     
      public boolean actualizar(Usuario objUsuario) throws Exception
    {
        return UsuarioDAO.actualizar(objUsuario);
    }
      
     public List<Usuario> listarActivosOrdenado() throws Exception
    {
         return UsuarioDAO.listarActivosOrdenado();
    }
    
     public List<Usuario> listarTodosOrdenado() throws Exception
    {
         return UsuarioDAO.listarTodosOrdenado();
    }
     
        public List<Usuario> listarFiltro(String filtro) throws Exception
    {
         return UsuarioDAO.listarFiltro(filtro);
    }
        public boolean eliminar(int IdUsuario) throws Exception
    {
        return UsuarioDAO.eliminar(IdUsuario);
    }    
            
         
        

   
}
