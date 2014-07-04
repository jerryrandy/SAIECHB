/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidades.OrdenCompra;
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
public class OrdenCompraDAO {
    
   
        
       public static String verificarNSerie(String nSerie) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT id_orden_compra From orden_compra Where id_orden_compra like '"+nSerie+"'";
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
    
         public static boolean insertar(OrdenCompra objOrdenCompra) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            //String fechaNac = sdf.format(objOrdenCompra.getDat_fecha());
           Timestamp time  = new Timestamp(objOrdenCompra.getDat_fecha().getTime());
               String sql="INSERT INTO orden_compra (id_orden_compra,id_proveedor,fecha) VALUES ('"+
                       objOrdenCompra.getStr_id_orden_compra()+"','"+objOrdenCompra.getObjProveedor().getInt_id_proveedor()+
                       "','"+time+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           String idOrdem = objOrdenCompra.getStr_id_orden_compra();
           if(rpta)
           {
                 for(OrdenCompra.DetalleOrdenCompra objDetalle: objOrdenCompra.getDetalleOrdenCompra())
                {
                     if(ComponenteDAO.insertar(objDetalle.getObComponente()))
                         insertarDetalle(idOrdem,objDetalle.getObComponente().getStr_id_componente());

                }
               
           }
        } catch (Exception e) {
            throw new Exception("Registrar Orden de COmpra "+e.getMessage(), e);
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

           public static boolean insertarDetalle(String IdOrden,String IdComponente) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {

               String sql="INSERT INTO detalle_orden (id_orden_compra,id_componente) VALUES ('"+
                       IdOrden+"','"+IdComponente+"')";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           
        } catch (Exception e) {
            throw new Exception("Registrar Detalle de Orden Compra "+e.getMessage(), e);
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
