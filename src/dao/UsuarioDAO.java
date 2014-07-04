/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class UsuarioDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";
    
       public static boolean insertar(Usuario objUsuario) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
               String sql="INSERT INTO usuario (nombre,apellido,usuario,clave,nivel,activa) VALUES ('"+
                     objUsuario.getStr_nombre()+"','"+objUsuario.getStr_apellido()+
                     "', '"+objUsuario.getStr_usuario()+"','"+objUsuario.getStr_clave()+
                    "', '"+objUsuario.getInt_nivel()+"','"+objUsuario.getInt_activa()+"');";
            
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Registrar Usuario "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
       
           public static boolean verAdministrador() throws Exception
    {
        boolean activo=false;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_usuario From usuario where nivel='1'";

            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next() && activo==false)
            {
                if(dr.getString(1)==null);
                activo=true;
            }

        } catch (Exception e) {
            throw new Exception("Ver Usuarios "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return activo;
    }
           
        public static Usuario iniciarSesion(String user,String pass) throws Exception
    {
        Usuario Objusuario = null;
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_usuario,nombre,apellido,usuario,clave,nivel,activa FROM usuario WHERE usuario='"+user+"' and clave='"+pass+"'";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
             if(dr.next())
            {
                Objusuario = new Usuario(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getString(4),dr.getString(5),dr.getInt(6),dr.getInt(7));
            }


        } catch (Exception e) {
            throw new Exception("Inciar Sesion "+e.getMessage(), e);
        }finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return Objusuario;
    }

          public static boolean actualizar(Usuario objUsuario) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
             String sql="UPDATE usuario SET nombre='"+objUsuario.getStr_nombre()+
                     "',apellido='"+objUsuario.getStr_apellido()+"',usuario='"+objUsuario.getStr_usuario()+
                     "',clave='"+objUsuario.getStr_clave()+"',nivel='"+objUsuario.getInt_nivel()+"',activa='"+objUsuario.getInt_activa()+
                     "' WHERE id_usuario = '"+objUsuario.getInt_id_usuario()+"'";
            
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Actualizar Usuario "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
          
    
            public static List<Usuario> listarActivosOrdenado() throws Exception
    {
        List<Usuario> listUsuario = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
              String sql="SELECT id_usuario,nombre,apellido,usuario,clave,nivel,activa FROM usuario where activa=1 and nivel='2' order by nombre ASC";

      
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
            while(dr.next())
            {
                if(listUsuario == null)
                    listUsuario = new ArrayList<Usuario>();
                Usuario objUsuario = new Usuario(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getString(4),dr.getString(5),dr.getInt(6),dr.getInt(7));
                listUsuario.add(objUsuario);
            }

        } catch (Exception e) {
            throw new Exception("Listar Proveedor "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listUsuario;
    }
      

            public static List<Usuario> listarTodosOrdenado() throws Exception
    {
        List<Usuario> listUsuario = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_usuario,nombre,apellido,usuario,clave,nivel,activa FROM usuario where nivel='2' order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listUsuario == null)
                    listUsuario = new ArrayList<Usuario>();
                Usuario objUsuario = new Usuario(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getString(4),dr.getString(5),dr.getInt(6),dr.getInt(7));
                listUsuario.add(objUsuario);
            }

        } catch (Exception e) {
            throw new Exception("Listar Proveedor "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listUsuario;
    }
            
            
     public static List<Usuario> listarFiltro(String filtro) throws Exception
    {
        List<Usuario> listUsuario = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_usuario,nombre,apellido,usuario,clave,nivel,activa FROM"
                    + " usuario where (apellido like '%"+filtro+"%' or nombre like '%"+filtro+"%') and nivel='2' order by nombre ASC";
          
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listUsuario == null)
                    listUsuario = new ArrayList<Usuario>();
                Usuario objUsuario = new Usuario(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getString(4),dr.getString(5),dr.getInt(6),dr.getInt(7));
                listUsuario.add(objUsuario);
            }

       } catch (Exception e) {
            throw new Exception("Listar Proveedor "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listUsuario;
    }

    public static boolean eliminar(int IdUsuario) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="Delete From usuario Where id_usuario="+IdUsuario;
            
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Usuario "+e.getMessage(), e);
        }
        finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
     
     
}
