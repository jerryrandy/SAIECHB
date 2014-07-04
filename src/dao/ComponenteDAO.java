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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toditos
 */
public class ComponenteDAO {
    
   
        
       public static String verificarNSerie(String nSerie) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT id_componente From componente Where id_componente like '"+nSerie+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                   rpta = dr.getString(1);  
            }

        } catch (Exception e) {
            throw new Exception("Verificar Componente "+e.getMessage(), e);
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

 public static boolean insertar(Componente objComponente) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
                  
               String sql = "INSERT INTO componente (id_componente,id_modelo,estado,garantia,caracteristica)"
                       + " VALUES ('"+objComponente.getStr_id_componente()+"','"+objComponente.getObjModelo().getInt_id_modelo()
                       +"','"+objComponente.getInt_estado()+"','"+objComponente.getInt_garantia()+"','"+objComponente.getStr_caracteristica()+"')";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Registrar Componente "+e.getMessage(), e);
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
   public static List<Componente> listarComponentesXCPU(String IdCPU) throws Exception
    {
        List<Componente> listComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT componente.id_componente,componente.id_modelo,"
                    + "componente.estado,componente.garantia,componente.caracteristica,"
                    + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                    + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica "
                    + "FROM cpu_componentes inner join componente inner join modelo inner "
                    + "join marca inner join tipo where cpu_componentes.id_componente=componente.id_componente "
                    + "and componente.id_modelo=modelo.id_modelo and modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and cpu_componentes.id_cpu  like '"+IdCPU+"' order by tipo.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listComponente == null)
                    listComponente = new ArrayList<Componente>();
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente objComponente = new Componente(dr.getString(1),objModelo,dr.getInt(3),dr.getInt(4),dr.getString(5));
                listComponente.add(objComponente);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listComponente;
    }
       
     public static List<Componente> listarComponentesxTipo(int IdTipo,int Estado) throws Exception
    {
        List<Componente> listComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT componente.id_componente,componente.id_modelo,"
                    + "componente.estado,componente.garantia,componente.caracteristica,"
                    + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                    + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica "
                    + "FROM componente inner join modelo inner join marca inner join tipo "
                    + "where componente.id_modelo=modelo.id_modelo and modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and componente.estado='"+Estado+"' and "
                    + "tipo.id_tipo='"+IdTipo+"' order by tipo.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listComponente == null)
                    listComponente = new ArrayList<Componente>();
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente objComponente = new Componente(dr.getString(1),objModelo,dr.getInt(3),dr.getInt(4),dr.getString(5));
                listComponente.add(objComponente);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listComponente;
    }
     
     
     
      public static List<Componente> listarFiltro(String filtro,int Estado) throws Exception
    {
        List<Componente> listComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT componente.id_componente,componente.id_modelo,"
                    + "componente.estado,componente.garantia,componente.caracteristica,"
                    + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                    + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica "
                    + "FROM componente inner join modelo inner join marca inner join tipo "
                    + "where componente.id_modelo=modelo.id_modelo and modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and componente.estado='"+Estado+"' and "
                    + "(modelo.nombre like '%"+filtro+"%' or marca.nombre like '%"+filtro+"%' "
                    + "or tipo.nombre like '%"+filtro+"%') order by tipo.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listComponente == null)
                    listComponente = new ArrayList<Componente>();
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente objComponente = new Componente(dr.getString(1),objModelo,dr.getInt(3),dr.getInt(4),dr.getString(5));
                listComponente.add(objComponente);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listComponente;
    }
     
         public static List<DetalleComponente> listarFiltroDetalles(String filtro,int Estado) throws Exception
    {
        List<DetalleComponente> listDetalleComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT detalle_orden.id_componente,componente.id_modelo,"
                    + "componente.estado,componente.garantia,componente.caracteristica,"
                    + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                    + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica,"
                    + "detalle_orden.id_orden_compra,orden_compra.id_proveedor,orden_compra.fecha,"
                    + "proveedor.nombre,proveedor.direcion,proveedor.telefono,proveedor.fax,"
                    + "proveedor.activa,proveedor.descripcion FROM detalle_orden inner join orden_compra "
                    + "inner join proveedor inner join componente inner join modelo inner join marca "
                    + "inner join tipo where detalle_orden.id_componente=componente.id_componente and "
                    + "detalle_orden.id_orden_compra=orden_compra.id_orden_compra and "
                    + "orden_compra.id_proveedor=proveedor.id_proveedor and componente.id_modelo=modelo.id_modelo "
                    + "and modelo.id_marca=marca.id_marca and modelo.id_tipo=tipo.id_tipo and componente.estado='"+Estado+"' and "
                    + "(componente.id_componente like '"+filtro+"%' or modelo.nombre like '%"+filtro+"' or marca.nombre like '%"+filtro+"' "
                    + "or orden_compra.id_orden_compra like '%"+filtro+"' or proveedor.nombre like '%"+filtro+"' "
                    + "or tipo.nombre like '%"+filtro+"%') order by orden_compra.fecha DESC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listDetalleComponente == null)
                    listDetalleComponente = new ArrayList<DetalleComponente>();
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente objComponente = new Componente();
                objComponente.setStr_id_componente(dr.getString(1));
                objComponente.setObjModelo(objModelo);
                objComponente.setInt_estado(dr.getInt(3));
                objComponente.setInt_garantia(dr.getDouble(4));
                objComponente.setStr_caracteristica(dr.getString(5));
                
                Proveedor objProveedor = new Proveedor();
                objProveedor.setInt_id_proveedor(dr.getInt(16));
                objProveedor.setStr_nombre(dr.getString(18));               
                objProveedor.setStr_direccion(dr.getString(19));
                objProveedor.setStr_telefono(dr.getString(20));
                objProveedor.setStr_fax(dr.getString(21));
                objProveedor.setIntl_activa(dr.getInt(22));
                objProveedor.setStr_descripcion(dr.getString(23));
                
                OrdenCompra objOrdenCompra = new OrdenCompra();
                objOrdenCompra.setStr_id_orden_compra(dr.getString(15));
                objOrdenCompra.setObjProveedor(objProveedor);
                objOrdenCompra.setDat_fecha(dr.getDate(17));

                DetalleComponente objDetalleComponente = new DetalleComponente(objComponente,objOrdenCompra );
                listDetalleComponente.add(objDetalleComponente);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDetalleComponente;
    }
         
            public static List<DetalleComponente> listarDetallesxEstado(int Estado) throws Exception
    {
        List<DetalleComponente> listDetalleComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT detalle_orden.id_componente,componente.id_modelo,"
                    + "componente.estado,componente.garantia,componente.caracteristica,"
                    + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                    + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica,"
                    + "detalle_orden.id_orden_compra,orden_compra.id_proveedor,orden_compra.fecha,"
                    + "proveedor.nombre,proveedor.direcion,proveedor.telefono,proveedor.fax,"
                    + "proveedor.activa,proveedor.descripcion FROM detalle_orden inner join orden_compra "
                    + "inner join proveedor inner join componente inner join modelo inner join marca "
                    + "inner join tipo where detalle_orden.id_componente=componente.id_componente and "
                    + "detalle_orden.id_orden_compra=orden_compra.id_orden_compra and "
                    + "orden_compra.id_proveedor=proveedor.id_proveedor and componente.id_modelo=modelo.id_modelo "
                    + "and modelo.id_marca=marca.id_marca and modelo.id_tipo=tipo.id_tipo "
                    + "and componente.estado='"+Estado+"' order by orden_compra.fecha DESC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listDetalleComponente == null)
                    listDetalleComponente = new ArrayList<DetalleComponente>();
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente objComponente = new Componente();
                objComponente.setStr_id_componente(dr.getString(1));
                objComponente.setObjModelo(objModelo);
                objComponente.setInt_estado(dr.getInt(3));
                objComponente.setInt_garantia(dr.getDouble(4));
                objComponente.setStr_caracteristica(dr.getString(5));
                
                Proveedor objProveedor = new Proveedor();
                objProveedor.setInt_id_proveedor(dr.getInt(16));
                objProveedor.setStr_nombre(dr.getString(18));               
                objProveedor.setStr_direccion(dr.getString(19));
                objProveedor.setStr_telefono(dr.getString(20));
                objProveedor.setStr_fax(dr.getString(21));
                objProveedor.setIntl_activa(dr.getInt(22));
                objProveedor.setStr_descripcion(dr.getString(23));
                
                OrdenCompra objOrdenCompra = new OrdenCompra();
                objOrdenCompra.setStr_id_orden_compra(dr.getString(15));
                objOrdenCompra.setObjProveedor(objProveedor);
                objOrdenCompra.setDat_fecha(dr.getDate(17));

                DetalleComponente objDetalleComponente = new DetalleComponente(objComponente,objOrdenCompra );
                listDetalleComponente.add(objDetalleComponente);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listDetalleComponente;
    }
         
         
       public static List<Componente> listarComponentesxEstado(int Estado) throws Exception
    {
        List<Componente> listComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT componente.id_componente,componente.id_modelo,"
                    + "componente.estado,componente.garantia,componente.caracteristica,"
                    + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                    + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica "
                    + "FROM componente inner join modelo inner join marca inner join tipo "
                    + "where componente.id_modelo=modelo.id_modelo and modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and componente.estado='"+Estado+"' order by tipo.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listComponente == null)
                    listComponente = new ArrayList<Componente>();
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente objComponente = new Componente(dr.getString(1),objModelo,dr.getInt(3),dr.getInt(4),dr.getString(5));
                listComponente.add(objComponente);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listComponente;
    }
     
        public static List<Componente> listarComponentesxUbicacion(int Ubicacion,int Estado) throws Exception
    {
        List<Componente> listComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
           String sql="SELECT componente.id_componente,componente.id_modelo,componente.estado,"
                   + "componente.garantia,componente.caracteristica,modelo.id_marca,modelo.id_tipo,"
                   + "modelo.nombre,modelo.caracteristica,modelo.activa,marca.nombre,tipo.nombre,"
                   + "tipo.ubicacion,tipo.caracteristica FROM componente inner join modelo inner join "
                   + "marca inner join tipo where componente.id_modelo=modelo.id_modelo and "
                   + "modelo.id_marca=marca.id_marca and modelo.id_tipo=tipo.id_tipo and componente.estado='"+Estado
                   + "' and tipo.ubicacion="+Ubicacion+" order by tipo.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listComponente == null)
                    listComponente = new ArrayList<Componente>();
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente objComponente = new Componente(dr.getString(1),objModelo,dr.getInt(3),dr.getInt(4),dr.getString(5));
                listComponente.add(objComponente);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Tipo "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listComponente;
    }

              public static boolean actualizarEstado(String IdComponente,int Estado) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql="UPDATE componente SET estado='"+Estado+"' WHERE id_componente= '"+IdComponente+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Estado "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
    public static Componente buscarComponenteXId(String IdCamponente) throws Exception
    {
        Componente objComponente = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
           String sql="SELECT componente.id_componente,componente.id_modelo,componente.estado,"
                   + "componente.garantia,componente.caracteristica,modelo.id_marca,modelo.id_tipo,"
                   + "modelo.nombre,modelo.caracteristica,modelo.activa,marca.nombre,tipo.nombre,"
                   + "tipo.ubicacion,tipo.caracteristica FROM componente inner join modelo inner join "
                   + "marca inner join tipo where componente.id_modelo=modelo.id_modelo and "
                   + "modelo.id_marca=marca.id_marca and modelo.id_tipo=tipo.id_tipo "
                   + "and componente.id_componente like '"+IdCamponente+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            if(dr.next())
            {
                 
                      Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(6));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(7));
                objTipo.setStr_nombre(dr.getString(12));
                objTipo.setInt_ubicacion(dr.getInt(13));
                objTipo.setStr_caractarestica(dr.getString(14));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(2));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(8));
                 objModelo.setStr_caracteristica(dr.getString(9));
                 objModelo.setInt_activa(dr.getInt(10));
     
                Componente componente = new Componente(dr.getString(1),objModelo,dr.getInt(3),dr.getInt(4),dr.getString(5));
                objComponente=componente;
               
            }

        } catch (Exception e) {
            throw new Exception("Componente "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return objComponente;
    }

}
