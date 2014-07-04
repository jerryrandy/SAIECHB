/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidades.Proveedor;
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
public class ProveedorDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";    
  
    public static List<Proveedor> listarActivosOrdenado() throws Exception
    {
        List<Proveedor> listProveedor = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
          String sql="SELECT id_proveedor,nombre,direcion,telefono,fax,activa,descripcion FROM proveedor where activa=1  order by nombre ASC";
      
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listProveedor == null)
                    listProveedor = new ArrayList<Proveedor>();
                Proveedor objProveedor = new Proveedor(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getString(4),dr.getString(4),dr.getInt(6),dr.getString(7));
                listProveedor.add(objProveedor);
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
        return listProveedor;
    }
      

            public static List<Proveedor> listarTodosOrdenado() throws Exception
    {
        
        List<Proveedor> listProveedor = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        
        
        
        try {
            
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_proveedor,nombre,direcion,telefono,fax,activa,descripcion FROM proveedor  order by nombre ASC";
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listProveedor == null)
                    listProveedor = new ArrayList<Proveedor>();
                Proveedor objProveedor = new Proveedor(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getString(4),dr.getString(4),dr.getInt(6),dr.getString(7));
                listProveedor.add(objProveedor);
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
        return listProveedor;
    }
            
      public static List<Proveedor> listarFiltro(String filtro) throws Exception
    {
        List<Proveedor> listProveedor = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_proveedor,nombre,direcion,telefono,fax,activa,descripcion FROM proveedor where nombre like '%"+filtro+"%' order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listProveedor == null)
                    listProveedor = new ArrayList<Proveedor>();
                Proveedor objProveedor = new Proveedor(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getString(4),dr.getString(4),dr.getInt(6),dr.getString(7));
                listProveedor.add(objProveedor);
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
        return listProveedor;
    }
      
      //insetar devolviendo el 
           public static int insertar(Proveedor objProveedor) throws Exception
    {
        
        int rpta=-1;
        Connection conn = null;
        Statement stmt = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            stmt = (Statement) conn.createStatement();
            String sql="INSERT INTO proveedor (nombre,direcion,telefono,fax,activa,descripcion ) VALUES ('"+objProveedor.getStr_nombre()+
                     "', '"+objProveedor.getStr_direccion()+"','"+objProveedor.getStr_telefono()+
                     "','"+objProveedor.getStr_fax()+"','"+objProveedor.getIntl_activa()+"','"+objProveedor.getStr_descripcion()+"');";

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
             ResultSet resulset = stmt.getGeneratedKeys();

            if (resulset.next()) {
                rpta = resulset.getInt(1);
            }
            
        } catch (Exception e) {
            throw new Exception("Registrar Departamento "+e.getMessage(), e);
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
          
      
     
        public static boolean actualizar(Proveedor objProveedor) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql=" UPDATE proveedor SET nombre='"+objProveedor.getStr_nombre()+
                    "',direcion='"+objProveedor.getStr_direccion()+"',telefono='"+objProveedor.getStr_telefono()+
                    "',fax='"+objProveedor.getStr_fax()+"',activa='"+objProveedor.getIntl_activa()+
                    "',descripcion='"+objProveedor.getStr_descripcion()+
                    "' WHERE id_proveedor = '"+objProveedor.getInt_id_proveedor()+"'";
            
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Proveedor "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
        
       public static boolean eliminar(int IdProveedor) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="Delete From proveedor Where id_proveedor="+IdProveedor;
            
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Proveedor "+e.getMessage(), e);
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
