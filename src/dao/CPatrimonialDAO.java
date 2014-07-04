/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


/**
 *
 * @author Toditos
 */
public class CPatrimonialDAO {
    
   public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";
    
              public static String verificarCPatrimonial(String nPatrimonial) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);

             String sql="SELECT id_patrimonial From patrimonial Where id_patrimonial like '"+nPatrimonial+"'";
            
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
             Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,clave);
               String sql="INSERT INTO patrimonial (id_patrimonial,estado) VALUES ('"+
                       nPatrimonial+"','0');";
        
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
