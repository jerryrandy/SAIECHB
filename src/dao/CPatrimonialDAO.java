/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidades.CPU;
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
public class CPatrimonialDAO {
    
   
    
              public static String verificarCPatrimonial(String nPatrimonial) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT id_patrimonial From patrimonial Where id_patrimonial like '"+nPatrimonial+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                   rpta = dr.getString(1);  
            }

        } catch (Exception e) {
            throw new Exception("Codigo"+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }  
    
    
         public static boolean insertar(String nPatrimonial) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {

               String sql="INSERT INTO patrimonial (id_patrimonial,estado) VALUES ('"+
                       nPatrimonial+"','0');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           
        } catch (Exception e) {
            throw new Exception("Registrar CPU "+e.getMessage(), e);
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
