/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidades.*;
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
public class ModeloDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";    
    
    public static List<Modelo> listarActivosOrdenado() throws Exception
    {
        List<Modelo> listModelo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql="SELECT modelo.id_modelo,modelo.id_marca,modelo.id_tipo,"
                    + "modelo.nombre,modelo.caracteristica,modelo.activa,marca.nombre,"
                    + "tipo.nombre,tipo.ubicacion,tipo.caracteristica FROM modelo "
                    + "inner join marca inner join tipo where modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and modelo.activa=1 order by tipo.nombre ASC";
            Class.forName(driver);
            
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listModelo == null)
                    listModelo = new ArrayList<Modelo>();
                Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(2));
                objMarca.setStr_nombre(dr.getString(7));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(3));
                objTipo.setStr_nombre(dr.getString(8));
                objTipo.setInt_ubicacion(dr.getInt(9));
                objTipo.setStr_caractarestica(dr.getString(10));
                
                 Modelo objModelo = new Modelo(dr.getInt(1),objMarca,objTipo,dr.getString(4),dr.getString(5),dr.getInt(6));
                listModelo.add(objModelo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Modelo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listModelo;
    }
      
       public static List<Modelo> listarTodosOrdenado() throws Exception
    {
        List<Modelo> listModelo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
             String sql="SELECT modelo.id_modelo,modelo.id_marca,modelo.id_tipo,"
                    + "modelo.nombre,modelo.caracteristica,modelo.activa,marca.nombre,"
                    + "tipo.nombre,tipo.ubicacion,tipo.caracteristica FROM modelo "
                    + "inner join marca inner join tipo where modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo order by tipo.nombre ASC";

            stmt = conn.prepareCall(sql);
            
            dr = stmt.executeQuery();

            while(dr.next())
            {
                if(listModelo == null)
                    listModelo = new ArrayList<Modelo>();
                Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(2));
                objMarca.setStr_nombre(dr.getString(7));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(3));
                objTipo.setStr_nombre(dr.getString(8));
                objTipo.setInt_ubicacion(dr.getInt(9));
                objTipo.setStr_caractarestica(dr.getString(10));
                
                 Modelo objModelo = new Modelo(dr.getInt(1),objMarca,objTipo,dr.getString(4),dr.getString(5),dr.getInt(6));
                listModelo.add(objModelo);
            }
        } catch (Exception e) {
            throw new Exception("Listar Modelo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listModelo;
    }
       
    public static List<Modelo> listarFiltro(String IdModelo) throws Exception
    {
        List<Modelo> listModelo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql="SELECT modelo.id_modelo,modelo.id_marca,modelo.id_tipo,"
                    + "modelo.nombre,modelo.caracteristica,modelo.activa,marca.nombre,"
                    + "tipo.nombre,tipo.ubicacion,tipo.caracteristica FROM modelo "
                    + "inner join marca inner join tipo where modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and (modelo.nombre like '%"+IdModelo+"%' "
                     + "or tipo.nombre like '%"+IdModelo+"%' or marca.nombre like '%"+IdModelo+"%') order by tipo.nombre ASC";

                     
       
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listModelo == null)
                    listModelo = new ArrayList<Modelo>();
                Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(2));
                objMarca.setStr_nombre(dr.getString(7));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(3));
                objTipo.setStr_nombre(dr.getString(8));
                objTipo.setInt_ubicacion(dr.getInt(9));
                objTipo.setStr_caractarestica(dr.getString(10));
                
                 Modelo objModelo = new Modelo(dr.getInt(1),objMarca,objTipo,dr.getString(4),dr.getString(5),dr.getInt(6));
                listModelo.add(objModelo);
            }

        } catch (Exception e) {
            throw new Exception("Listar Modelo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listModelo;
    }

       public static boolean insertar(Modelo objModelo) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
             String sql="INSERT INTO modelo (id_marca,id_tipo,nombre,caracteristica,activa) VALUES ('"+
                     objModelo.getObjMarca().getInt_id_marca()+"','"+objModelo.getObjTipo().getInt_id_tipo()+
                     "', '"+objModelo.getStr_nombre()+"','"+objModelo.getStr_caracteristica()+"','"+objModelo.getInt_activa()+"')";
            
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Registrar Modelo "+e.getMessage(), e);
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
            public static boolean actualizar(Modelo objModelo) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            
            String sql=" UPDATE modelo SET id_marca='"+objModelo.getObjMarca().getInt_id_marca()+
                    "',id_tipo='"+objModelo.getObjTipo().getInt_id_tipo()+"',nombre='"+objModelo.getStr_nombre()+
                    "',caracteristica='"+objModelo.getStr_caracteristica()+"',activa='"+objModelo.getInt_activa()+
                    "' WHERE id_modelo = '"+objModelo.getInt_id_modelo()+"'";
           
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Modelo "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        

    
       public static boolean eliminar(int IdModelo) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
            String sql="Delete From modelo Where id_modelo="+IdModelo;
            
        
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Modelo "+e.getMessage(), e);
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

    public static List<Modelo> listarActivosXTipo(int IdTipo)throws Exception
    {
        List<Modelo> listModelo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {           
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
               String sql="SELECT modelo.id_modelo,modelo.id_marca,modelo.id_tipo,"
                    + "modelo.nombre,modelo.caracteristica,modelo.activa,marca.nombre,"
                    + "tipo.nombre,tipo.ubicacion,tipo.caracteristica FROM modelo "
                    + "inner join marca inner join tipo where modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and modelo.activa=1 and tipo.id_tipo="+IdTipo+" order by tipo.nombre ASC";   

            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

          while(dr.next())
            {
                 if(listModelo == null)
                    listModelo = new ArrayList<Modelo>();
                Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(2));
                objMarca.setStr_nombre(dr.getString(7));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(3));
                objTipo.setStr_nombre(dr.getString(8));
                objTipo.setInt_ubicacion(dr.getInt(9));
                objTipo.setStr_caractarestica(dr.getString(10));
                
                 Modelo objModelo = new Modelo(dr.getInt(1),objMarca,objTipo,dr.getString(4),dr.getString(5),dr.getInt(6));
                listModelo.add(objModelo);
            }
        } catch (Exception e) {
            throw new Exception("Listar Modelo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listModelo;
    }
     public static List<Modelo> listarActivosXTipoMarca(int IdTipo,int IdMarca)throws Exception
    {
        List<Modelo> listModelo = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {                
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
               String sql="SELECT modelo.id_modelo,modelo.id_marca,modelo.id_tipo,"
                    + "modelo.nombre,modelo.caracteristica,modelo.activa,marca.nombre,"
                    + "tipo.nombre,tipo.ubicacion,tipo.caracteristica FROM modelo "
                    + "inner join marca inner join tipo where modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and modelo.activa=1 and tipo.id_tipo="+IdTipo+" "
                    + "and marca.id_marca="+IdMarca+" order by tipo.nombre ASC";   

            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

          while(dr.next())
            {
                 if(listModelo == null)
                    listModelo = new ArrayList<Modelo>();
                Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(2));
                objMarca.setStr_nombre(dr.getString(7));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(3));
                objTipo.setStr_nombre(dr.getString(8));
                objTipo.setInt_ubicacion(dr.getInt(9));
                objTipo.setStr_caractarestica(dr.getString(10));
                
                 Modelo objModelo = new Modelo(dr.getInt(1),objMarca,objTipo,dr.getString(4),dr.getString(5),dr.getInt(6));
                listModelo.add(objModelo);
            }
        } catch (Exception e) {
            throw new Exception("Listar Modelo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listModelo;
    }

}
