
package dao;


import entidades.Cargo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";
    
            public static List<Cargo> listarActivosOrdenado() throws Exception
    {
        List<Cargo> listCargo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT id_cargo,nombre,activa,descripcion FROM cargo where activa=1 order by nombre ASC";
          
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listCargo == null)
                    listCargo = new ArrayList<Cargo>();
                Cargo objCargo = new Cargo(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4));
                listCargo.add(objCargo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Cargo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listCargo;
    }
      

            public static List<Cargo> listarTodosOrdenado() throws Exception
    {
        List<Cargo> listCargo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT id_cargo,nombre,activa,descripcion FROM cargo order by nombre ASC";
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

             while(dr.next())
            {
                 if(listCargo == null)
                    listCargo = new ArrayList<Cargo>();
                Cargo objCargo = new Cargo(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4));
                listCargo.add(objCargo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Cargo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listCargo;
    }
            
      public static List<Cargo> listarFiltro(String filtro) throws Exception
    {
        List<Cargo> listCargo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT id_cargo,nombre,activa,descripcion FROM cargo where nombre like '"+filtro+"%' order by nombre ASC";
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();
   while(dr.next())
            {
                 if(listCargo == null)
                    listCargo = new ArrayList<Cargo>();
                Cargo objCargo = new Cargo(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4));
                listCargo.add(objCargo);
            }

       } catch (Exception e) {
            throw new Exception("Listar Cargo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listCargo;
    }
      
          public static boolean insertar(Cargo objCargo) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
             String sql="INSERT INTO cargo (nombre,activa, descripcion) VALUES ('"+objCargo.getStr_nombre()+
                     "','"+objCargo.getIntl_activa()+"','"+objCargo.getStr_descripcion()+"');";
          
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
          
        public static boolean actualizar(Cargo objCargo) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql=" UPDATE cargo SET nombre='"+objCargo.getStr_nombre()+
                    "',activa='"+objCargo.getIntl_activa()+"',descripcion='"+objCargo.getStr_descripcion()+
                    "' WHERE id_cargo = '"+objCargo.getInt_id_cargo()+"'";
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Cargo "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
        
       public static boolean eliminar(int IdCargo) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="Delete From cargo Where id_cargo="+IdCargo;
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Cargo "+e.getMessage(), e);
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
