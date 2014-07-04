/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


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
public class AreaDAO {
    
   
       public static List<Area> listarTodosOrdenadoIniciales() throws Exception
    {
        List<Area> listArea = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT area.id_area,area.id_departamento,area.nombre,area.activa,area.descripcion,departamento.nombre,departamento.iniciales "
                    + "FROM area inner join departamento where area.id_departamento=departamento.id_departamento order by area.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listArea == null)
                    listArea = new ArrayList<Area>();
                Departamento objDepartamento = new Departamento();
                objDepartamento.setInt_id_departamento(dr.getInt(2));
                objDepartamento.setStr_nombre(dr.getString(6));
                objDepartamento.setStr_iniciales(dr.getString(7));
                 Area objArea = new Area(dr.getInt(1),objDepartamento,dr.getString(3),dr.getInt(4),dr.getString(5));
                listArea.add(objArea);
            }

        } catch (Exception e) {
            throw new Exception("Listar Area "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listArea;
    }
       
          public static List<Area> listarFiltro(String filtro) throws Exception
    {
        List<Area> listArea = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT area.id_area,area.id_departamento,area.nombre,area.activa,area.descripcion,departamento.nombre,departamento.iniciales "
                    + "FROM area inner join departamento where area.id_departamento=departamento.id_departamento and area.nombre like '%"+filtro+"%'"
                    + " order by area.nombre ASC";
            
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listArea == null)
                    listArea = new ArrayList<Area>();
                Departamento objDepartamento = new Departamento();
                objDepartamento.setInt_id_departamento(dr.getInt(2));
                objDepartamento.setStr_nombre(dr.getString(6));
                objDepartamento.setStr_iniciales(dr.getString(7));
                 Area objArea = new Area(dr.getInt(1),objDepartamento,dr.getString(3),dr.getInt(4),dr.getString(5));
                listArea.add(objArea);
            }

        } catch (Exception e) {
            throw new Exception("Listar Area "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listArea;
    }

       public static boolean insertar(Area objArea) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="INSERT INTO area (id_departamento,nombre, activa, descripcion) VALUES ('"+
                     objArea.getObjDepartamento().getInt_id_departamento()+"','"+objArea.getStr_nombre()+
                     "', '"+objArea.getIntl_activa()+"','"+objArea.getStr_descripcion()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Registrar Area "+e.getMessage(), e);
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
            public static boolean actualizar(Area objArea) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql=" UPDATE area SET nombre='"+objArea.getStr_nombre()+
                    "',activa='"+objArea.getIntl_activa()+"',id_departamento='"+objArea.getObjDepartamento().getInt_id_departamento()+"',descripcion='"+objArea.getStr_descripcion()+
                    "' WHERE id_area = '"+objArea.getInt_id_area()+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Area "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        

    
       public static boolean eliminar(int IdArea) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="Delete From area Where id_area="+IdArea;
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Area "+e.getMessage(), e);
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

    public static List<Area> listarActivosXDepartamento(int IdDepartamento)throws Exception
    {
        List<Area> listArea = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT area.id_area,area.id_departamento,area.nombre,area.activa,area.descripcion,departamento.nombre,departamento.iniciales "
                    + "FROM area inner join departamento where area.id_departamento=departamento.id_departamento and area.activa=1 and area.id_departamento="+IdDepartamento+" order by area.nombre ASC";

            conn = DBManager.getConnection();
            
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listArea == null)
                    listArea = new ArrayList<Area>();
                Departamento objDepartamento = new Departamento();
                objDepartamento.setInt_id_departamento(dr.getInt(2));
                objDepartamento.setStr_nombre(dr.getString(6));
                objDepartamento.setStr_iniciales(dr.getString(7));
                 Area objArea = new Area(dr.getInt(1),objDepartamento,dr.getString(3),dr.getInt(4),dr.getString(5));
                listArea.add(objArea);
            }

        } catch (Exception e) {
            throw new Exception("Listar Area "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listArea;
    }


}
