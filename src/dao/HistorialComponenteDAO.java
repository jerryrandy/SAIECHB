/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entidades.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Toditos
 */
public class HistorialComponenteDAO {
     public static boolean insertar(String IdComponente,String Descripcion) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
                  
               String sql = "INSERT INTO historial_componente (id_componente,fecha,descripcion)"
                       + " VALUES ('"+IdComponente+"',curdate(),'"+Descripcion+"')";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Registrar Historial "+e.getMessage(), e);
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
    
        public static List<HistorialComponente> listarHistorial(String IdComponente) throws Exception
    {
        List<HistorialComponente> listHistorialComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT id_componente,fecha,descripcion FROM historial_componente where id_componente like '"+IdComponente+"' order by fecha DESC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listHistorialComponente == null)
                    listHistorialComponente = new ArrayList<HistorialComponente>();

                Componente objComponente = new Componente();
                objComponente.setStr_id_componente(dr.getString(1));    
                
                HistorialComponente objHistorialComponente = new HistorialComponente(objComponente,dr.getDate(2),dr.getString(3));
                listHistorialComponente.add(objHistorialComponente);
            }

        } catch (Exception e) {
            throw new Exception("Listar Historial "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listHistorialComponente;
    }
     
}
