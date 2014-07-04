/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Statement;
import entidades.Area;
import entidades.Departamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class DepartamentoDAO {
    
    
         public static List<Departamento> listarActivos() throws Exception
    {
        List<Departamento> listDepartamento = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion "
                    + "FROM departamento where activa=1";

            conn = DBManager.getConnection();
            
            conn = DBManager.getConnection();
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
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion FROM departamento where activa=1 order by nombre ASC";
            conn = DBManager.getConnection();
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
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion FROM departamento order by nombre ASC";
            conn = DBManager.getConnection();
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
            String sql="SELECT id_departamento,nombre,iniciales,activa,descripcion FROM departamento where nombre like '"+filtro+"%' order by nombre ASC";
            conn = DBManager.getConnection();
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
        Connection conn =DBManager.getConnection();
        Statement stmt = null;
        try {
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
            String sql=" UPDATE departamento SET nombre='"+objDepartamento.getStr_nombre()+
                    "',activa='"+objDepartamento.getIntl_activa()+"',iniciales='"+objDepartamento.getStr_iniciales()+"',descripcion='"+objDepartamento.getStr_descripcion()+
                    "' WHERE id_departamento = '"+objDepartamento.getInt_id_departamento()+"'";
            conn = DBManager.getConnection();
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
            String sql="Delete From departamento Where id_departamento="+IdDepartamento;
            conn = DBManager.getConnection();
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
