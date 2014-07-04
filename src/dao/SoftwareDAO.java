/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Software;
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
public class SoftwareDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";    
    
    public static List<Software> listarActivosOrdenado() throws Exception
    {
        List<Software> listSoftware = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql="SELECT id_software,nombre,tipo,activa FROM software where activa=1 order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listSoftware == null)
                    listSoftware = new ArrayList<Software>();
                Software objSoftware = new Software(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getInt(4));
                listSoftware.add(objSoftware);
            }

        } catch (Exception e) {
            throw new Exception("Listar Software "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listSoftware;
    }
                     public static List<Software> listarTipoActivo(int Tipo) throws Exception
    {
        List<Software> listSoftware = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql="SELECT id_software,nombre,tipo,activa FROM software where activa=1 and tipo="+Tipo+" order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

               while(dr.next())
            {
                 if(listSoftware == null)
                    listSoftware = new ArrayList<Software>();
                Software objSoftware = new Software(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getInt(4));
                listSoftware.add(objSoftware);
            }

        } catch (Exception e) {
            throw new Exception("Listar Software "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listSoftware;
    }  

            public static List<Software> listarTodosOrdenado() throws Exception
    {
        List<Software> listSoftware = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql="SELECT id_software,nombre,tipo,activa FROM software order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
        while(dr.next())
            {
                 if(listSoftware == null)
                    listSoftware = new ArrayList<Software>();
                Software objSoftware = new Software(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getInt(4));
                listSoftware.add(objSoftware);
            }

        } catch (Exception e) {
            throw new Exception("Listar Software "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listSoftware;
    }
            
      public static List<Software> listarFiltro(String filtro) throws Exception
    {
        List<Software> listSoftware = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT id_software,nombre,tipo,activa FROM software where nombre like '%"+filtro+"%' order by nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
          while(dr.next())
            {
                 if(listSoftware == null)
                    listSoftware = new ArrayList<Software>();
                Software objSoftware = new Software(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getInt(4));
                listSoftware.add(objSoftware);
            }

        } catch (Exception e) {
            throw new Exception("Listar Software "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listSoftware;
    }
      
          public static boolean insertar(Software obSoftware) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);    
            
            String sql="INSERT INTO software (nombre,tipo,activa) VALUES ('"+obSoftware.getStr_nombre()+
                     "','"+obSoftware.getInt_tipo()+"','"+obSoftware.getInt_activa()+"');";
            
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Registrar Software "+e.getMessage(), e);
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
          
        public static boolean actualizar(Software objSoftware) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {

            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql=" UPDATE software SET nombre='"+objSoftware.getStr_nombre()+
                    "',tipo='"+objSoftware.getInt_tipo()+"',activa='"+objSoftware.getInt_activa()+
                    "' WHERE id_software = '"+objSoftware.getInt_id_software()+"'";
          
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Software "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
        
       public static boolean eliminar(int IdSoftware) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            
            String sql="Delete From software Where id_software="+IdSoftware;
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Software "+e.getMessage(), e);
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

     public static List<Software> listarTipoXEmpleado(int IdEmpleado,int Tipo) throws Exception
    {
        List<Software> listSoftware = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql="SELECT software.id_software,software.nombre,software.tipo,software.activa "
                    + "FROM empleado_software inner join software where "
                    + "empleado_software.id_software=software.id_software and "
                    + "empleado_software.id_empleado="+IdEmpleado+" and software.tipo="+Tipo+" order by software.nombre ASC";
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

               while(dr.next())
            {
                 if(listSoftware == null)
                    listSoftware = new ArrayList<Software>();
                Software objSoftware = new Software(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getInt(4));
                listSoftware.add(objSoftware);
            }

        } catch (Exception e) {
            throw new Exception("Listar Software "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listSoftware;
    }  
        
     
          public static Software buscarTipoXEmpleado(int IdEmpleado,int Tipo) throws Exception
    {
       Software objSoftware = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT software.id_software,software.nombre,software.tipo,software.activa "
                    + "FROM empleado_software inner join software where "
                    + "empleado_software.id_software=software.id_software and "
                    + "empleado_software.id_empleado="+IdEmpleado+" and software.tipo="+Tipo+" order by software.nombre ASC";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

               if(dr.next())
            {

                Software software = new Software(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getInt(4));
                objSoftware=software;
    
            }

        } catch (Exception e) {
            throw new Exception("Listar Software "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return objSoftware;
    }  
      
          public static Software buscarSistemaXCPU(String IdCPU) throws Exception
    {
       Software objSoftware = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
            String sql="SELECT software.id_software,software.nombre,software.tipo,software.activa "
                    + "FROM cpu inner join software where "
                    + "cpu.id_software=software.id_software and "
                    + "cpu.id_cpu like '"+IdCPU+"'";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

               if(dr.next())
            {

                Software software = new Software(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getInt(4));
                objSoftware=software;
    
            }

        } catch (Exception e) {
            throw new Exception("Listar Software "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return objSoftware;
    }  
      
     
          public static boolean insertarXEmpleado(int idEmpleado,int idSoftware) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
             String sql="INSERT INTO empleado_software (id_empleado,id_software) "
                     + "VALUES ('"+idEmpleado+"','"+idSoftware+"')";
            
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Registrar Software "+e.getMessage(), e);
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
          
            
          public static boolean eliminarXEmpleado(int idEmpleado,int idSoftware) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
             String sql="Delete From empleado_software Where id_empleado="+idEmpleado+" and id_software="+idSoftware;
    
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Eliminar Software "+e.getMessage(), e);
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
