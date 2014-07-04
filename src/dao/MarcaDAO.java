 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidades.Marca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MarcaDAO {
    

            public static List<Marca> listarActivosOrdenado() throws Exception
    {
        List<Marca> listMarca = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_marca,nombre,activa,descripcion FROM marca where activa=1 order by nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listMarca == null)
                    listMarca = new ArrayList<Marca>();
                Marca objMarca = new Marca(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4));
                listMarca.add(objMarca);
            }

        } catch (Exception e) {
            throw new Exception("Listar Marca "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listMarca;
    }
      

            public static List<Marca> listarTodosOrdenado() throws Exception
    {
        List<Marca> listMarca = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_marca,nombre,activa,descripcion FROM marca order by nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listMarca == null)
                    listMarca = new ArrayList<Marca>();
                Marca objMarca = new Marca(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4));
                listMarca.add(objMarca);
            }

        } catch (Exception e) {
            throw new Exception("Listar Marca "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listMarca;
    }
            
      public static List<Marca> listarFiltro(String filtro) throws Exception
    {
        List<Marca> listMarca = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT id_marca,nombre,activa,descripcion FROM marca where nombre like '"+filtro+"%' order by nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
               if(listMarca == null)
                    listMarca = new ArrayList<Marca>();
                Marca objMarca = new Marca(dr.getInt(1),dr.getString(2),dr.getInt(3),dr.getString(4));
                listMarca.add(objMarca);
            }

       } catch (Exception e) {
            throw new Exception("Listar Marca "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listMarca;
    }
      
          public static boolean insertar(Marca objMarca) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="INSERT INTO marca (nombre,activa, descripcion) VALUES ('"+objMarca.getStr_nombre()+
                     "', '"+objMarca.getIntl_activa()+"','"+objMarca.getStr_descripcion()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Registrar Marca "+e.getMessage(), e);
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
          
        public static boolean actualizar(Marca objMarca) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql=" UPDATE marca SET nombre='"+objMarca.getStr_nombre()+
                    "',activa='"+objMarca.getIntl_activa()+"',descripcion='"+objMarca.getStr_descripcion()+
                    "' WHERE id_marca = '"+objMarca.getInt_id_marca()+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Marca "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
        
       public static boolean eliminar(int IdMarca) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="Delete From marca Where id_marca="+IdMarca;
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Marca "+e.getMessage(), e);
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
