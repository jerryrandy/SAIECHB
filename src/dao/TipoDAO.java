/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Tipo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class TipoDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";    
    
            public static List<Tipo> listarActivosOrdenado() throws Exception
    {
        List<Tipo> listTipo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_tipo,nombre,ubicacion,caracteristica,activa FROM tipo where activa=1 order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listTipo == null)
                    listTipo = new ArrayList<Tipo>();
                Tipo objTipo = new Tipo(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4),dr.getInt(5));
                listTipo.add(objTipo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listTipo;
    }
                     public static List<Tipo> listarTipoUbicacionActivo(int Ubicacion) throws Exception
    {
        List<Tipo> listTipo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_tipo,nombre,ubicacion,caracteristica,activa FROM tipo where activa=1 and ubicacion="+Ubicacion+" order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listTipo == null)
                    listTipo = new ArrayList<Tipo>();
                Tipo objTipo = new Tipo(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4),dr.getInt(5));
                listTipo.add(objTipo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listTipo;
    }
      

      
      
      

            public static List<Tipo> listarTodosOrdenado() throws Exception
    {
        List<Tipo> listTipo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_tipo,nombre,ubicacion,caracteristica,activa FROM tipo order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

             while(dr.next())
            {
                 if(listTipo == null)
                    listTipo = new ArrayList<Tipo>();
                Tipo objTipo = new Tipo(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4),dr.getInt(5));
                listTipo.add(objTipo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listTipo;
    }
            
      public static List<Tipo> listarFiltro(String filtro) throws Exception
    {
        List<Tipo> listTipo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_tipo,nombre,ubicacion,caracteristica,activa FROM tipo where nombre like '"+filtro+"%' order by nombre ASC";
        
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
        while(dr.next())
            {
                 if(listTipo == null)
                    listTipo = new ArrayList<Tipo>();
                Tipo objTipo = new Tipo(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4),dr.getInt(5));
                listTipo.add(objTipo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listTipo;
    }
      
          public static boolean insertar(Tipo obTipo) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
             String sql="INSERT INTO tipo (nombre,ubicacion,caracteristica,activa) VALUES ('"+obTipo.getStr_nombre()+
                     "','"+obTipo.getInt_ubicacion()+"','"+obTipo.getStr_caractarestica()+"','"+obTipo.getInt_activa()+"');";
            
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Registrar Cargo "+e.getMessage(), e);
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
          
        public static boolean actualizar(Tipo objTipo) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql=" UPDATE tipo SET nombre='"+objTipo.getStr_nombre()+
                    "',ubicacion='"+objTipo.getInt_ubicacion()+"',caracteristica='"+objTipo.getStr_caractarestica()+
                    "',activa='"+objTipo.getInt_activa()+"' WHERE id_tipo = '"+objTipo.getInt_id_tipo()+"'";
            
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar tipo "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
        
       public static boolean eliminar(int IdTipo) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="Delete From tipo Where id_tipo="+IdTipo;
            
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Tipo "+e.getMessage(), e);
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
