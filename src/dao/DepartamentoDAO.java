
package dao;

import com.mysql.jdbc.Statement;
import entidades.Departamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
      public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";
    
         public static List<Departamento> listarActivos() throws Exception
    {
        List<Departamento> listDepartamento = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion "
                    + "FROM departamento where activa=1";

         
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listDepartamento == null)
                    listDepartamento = new ArrayList<Departamento>();
                Departamento objDepartamento = new Departamento(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getInt(4),dr.getString(5));
                listDepartamento.add(objDepartamento);
            }
            
            

        } catch (Exception e) {
            throw new Exception("Listar Departamento "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDepartamento;
    }
      
            public static List<Departamento> listarActivosOrdenado() throws Exception
    {
        List<Departamento> listDepartamento = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
              Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion FROM departamento where activa=1 order by nombre ASC";
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listDepartamento == null)
                    listDepartamento = new ArrayList<Departamento>();
                Departamento objDepartamento = new Departamento(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getInt(4),dr.getString(5));
                listDepartamento.add(objDepartamento);
            }

        } catch (Exception e) {
            throw new Exception("Listar Departamento "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDepartamento;
    }
      

            public static List<Departamento> listarTodosOrdenado() throws Exception
    {
        List<Departamento> listDepartamento = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
              Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion FROM departamento order by nombre ASC";
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listDepartamento == null)
                    listDepartamento = new ArrayList<Departamento>();
                Departamento objDepartamento = new Departamento(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getInt(4),dr.getString(5));
                listDepartamento.add(objDepartamento);
            }

        } catch (Exception e) {
            throw new Exception("Listar Departamento "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDepartamento;
    }
            
      public static List<Departamento> listarFiltro(String filtro) throws Exception
    {
        List<Departamento> listDepartamento = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion FROM departamento where nombre like '"+filtro+"%' order by nombre ASC";
         
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
               if(listDepartamento == null)
                    listDepartamento = new ArrayList<Departamento>();
                Departamento objDepartamento = new Departamento(dr.getInt(1),dr.getString(2),dr.getString(3),dr.getInt(4),dr.getString(5));
                listDepartamento.add(objDepartamento);
            }

       } catch (Exception e) {
            throw new Exception("Listar Departamento "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDepartamento;
    }
      
          public static int insertar(Departamento objDepartamento) throws Exception
    {
  
         int rpta=-1;
        Connection conn = null;
        Statement stmt = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            stmt = (Statement) conn.createStatement();
             String sql="INSERT INTO departamento (nombre,iniciales, activa, descripcion) VALUES ('"+objDepartamento.getStr_nombre()+
                     "', '"+objDepartamento.getStr_iniciales()+"','"+objDepartamento.getIntl_activa()+"','"+objDepartamento.getStr_descripcion()+"');";

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
          
        public static boolean actualizar(Departamento objDepartamento) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql=" UPDATE departamento SET nombre='"+objDepartamento.getStr_nombre()+
                    "',activa='"+objDepartamento.getIntl_activa()+"',iniciales='"+objDepartamento.getStr_iniciales()+"',descripcion='"+objDepartamento.getStr_descripcion()+
                    "' WHERE id_departamento = '"+objDepartamento.getInt_id_departamento()+"'";
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Departamento "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
        
       public static boolean eliminar(int IdDepartamento) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
            String sql="Delete From departamento Where id_departamento="+IdDepartamento;
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Departamento "+e.getMessage(), e);
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
