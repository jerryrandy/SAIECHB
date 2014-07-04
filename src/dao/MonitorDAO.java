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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class MonitorDAO {
    
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/demo";
    public static String usuario = "root";
    public static String clave = "";   
         
    public static String verificarNSerie(String nSerie) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);            
             String sql="SELECT id_monitor From monitor Where id_monitor like '"+nSerie+"'";
            
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                   rpta = dr.getString(1);  
            }

        } catch (Exception e) {
            throw new Exception("Listar Monitor "+e.getMessage(), e);
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

         public static boolean insertar(Monitor objMonitor) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {

            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);
               String sql="INSERT INTO monitor (id_monitor,id_componente) VALUES ('"+
                       objMonitor.getStr_id_monitor()+"','"+objMonitor.getObjComponente().getStr_id_componente()+"');";
            
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
          
        } catch (Exception e) {
            throw new Exception("Registrar Monitor "+e.getMessage(), e);
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

    public static List<Monitor> ListarMonitorXEstado(int Estado) throws Exception
    {
        List<Monitor> listMonitor = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {               
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,usuario,clave);     
            
         String sql="SELECT monitor.id_monitor,monitor.id_componente,componente.id_modelo,"
                 + "componente.estado,componente.garantia,componente.caracteristica,"
                 + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                 + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica "
                 + "FROM monitor inner join componente inner join modelo inner join marca inner "
                 + "join tipo where monitor.id_componente=componente.id_componente "
                 + "and componente.id_modelo=modelo.id_modelo and modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and componente.estado='"+Estado+"'";
           
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listMonitor == null)
                    listMonitor = new ArrayList<Monitor>();
                  Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(7));
                objMarca.setStr_nombre(dr.getString(12));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(8));
                objTipo.setStr_nombre(dr.getString(13));
                objTipo.setInt_ubicacion(dr.getInt(14));
                objTipo.setStr_caractarestica(dr.getString(15));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(3));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(9));
                 objModelo.setStr_caracteristica(dr.getString(10));
                 objModelo.setInt_activa(dr.getInt(11));
                 
     
                  Componente objComponente = new Componente();
                  objComponente.setStr_id_componente(dr.getString(2));
                  objComponente.setObjModelo(objModelo);
                  objComponente.setInt_estado(dr.getInt(4));
                  objComponente.setInt_garantia(dr.getInt(5));
                  objComponente.setStr_caracteristica(dr.getString(6));
                  
                                     
                 Monitor monitor = new Monitor(dr.getString(1),objComponente);
                listMonitor.add(monitor);
            }

        } catch (Exception e) {
            throw new Exception("Listar Monitor "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listMonitor;
    }
 
     

}
