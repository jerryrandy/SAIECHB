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
public class AccesoriosDAO {
    
   
        
       public static boolean verificarNSerie(String nSerie) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="SELECT * From accesorios Where id_accesorios="+nSerie;
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Numero de Serie Repetido"+e.getMessage(), e);
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
         public static boolean insertarAccComputador(Accesorios objAccesorios,String IdComputador) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
   
               String sql="INSERT INTO accesorios (id_accesorios,id_componente) VALUES ('"+
                       objAccesorios.getStr_id_accesorios()+"','"+objAccesorios.getObjComponente().getStr_id_componente()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           if(rpta)
           {              
                         insertarComputadorAccesorios(IdComputador, objAccesorios.getStr_id_accesorios());
           }
       
        } catch (Exception e) {
            throw new Exception("Insertar Accesorios "+e.getMessage(), e);
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

             public static boolean insertarAcc(Accesorios objAccesorios) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
   
               String sql="INSERT INTO accesorios (id_accesorios,id_componente) VALUES ('"+
                       objAccesorios.getStr_id_accesorios()+"','"+objAccesorios.getObjComponente().getStr_id_componente()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
     
       
        } catch (Exception e) {
            throw new Exception("Insertar Accesorios "+e.getMessage(), e);
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
  
          public static List<Accesorios> listarAccesoriosXComputador(String IdComputador) throws Exception
    {
        List<Accesorios> listAccesorios = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {     
            String sql="SELECT componente.id_componente,componente.id_modelo,"
                    + "componente.estado,componente.garantia,componente.caracteristica,"
                    + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                    + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica, "
                    + "accesorios.id_accesorios FROM computador_accesorios inner join accesorios inner join componente inner join modelo inner "
                    + "join marca inner join tipo where computador_accesorios.id_accesorios=accesorios.id_accesorios "
                    + "and accesorios.id_componente=componente.id_componente "
                    + "and componente.id_modelo=modelo.id_modelo and modelo.id_marca=marca.id_marca "
                    + "and modelo.id_tipo=tipo.id_tipo and computador_accesorios.id_computador  like '"+IdComputador+"'  order by tipo.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listAccesorios == null)
                    listAccesorios = new ArrayList<Accesorios>();
                 
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
                objComponente.setInt_garantia(dr.getInt(3));
                objComponente.setStr_caracteristica(dr.getString(5));
                
     
                
                Accesorios objAccesorios=new Accesorios(dr.getString(15),objComponente);
                
                
                
                
                listAccesorios.add(objAccesorios);
               
            }

        } catch (Exception e) {
            throw new Exception("Listar Accesorios "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listAccesorios;
    }


          
    public static boolean insertarComputadorAccesorios(String IdComputdor,String IdAccesorios) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {

               String sql="INSERT INTO computador_accesorios (id_computador,id_accesorios) VALUES ('"+
                       IdComputdor+"','"+IdAccesorios+"')";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           
        } catch (Exception e) {
            throw new Exception("Registrar Accesorios por Computador "+e.getMessage(), e);
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


       
            public static List<Accesorios> listarTodosOrdenado(int Estado) throws Exception
    {
        List<Accesorios> listAccesorios = null;
      Connection conn =null;
      CallableStatement stmt = null;
      ResultSet dr = null;
      try {
          String sql="SELECT componente.id_componente,componente.id_modelo,"
                  + "componente.estado,componente.garantia,componente.caracteristica,"
                  + "modelo.id_marca,modelo.id_tipo,modelo.nombre,modelo.caracteristica,"
                  + "modelo.activa,marca.nombre,tipo.nombre,tipo.ubicacion,tipo.caracteristica, "
                  + "accesorios.id_accesorios FROM accesorios inner join componente inner join modelo inner "
                  + "join marca inner join tipo where accesorios.id_componente=componente.id_componente "
                  + "and componente.id_modelo=modelo.id_modelo and modelo.id_marca=marca.id_marca "
                  + "and modelo.id_tipo=tipo.id_tipo and componente.estado='"+Estado+"'  order by tipo.nombre ASC";
          conn = DBManager.getConnection();
          stmt = conn.prepareCall(sql);
          dr = stmt.executeQuery();
          
          while(dr.next())
          {
              if(listAccesorios == null)
                  listAccesorios = new ArrayList<Accesorios>();
              
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
              objComponente.setInt_garantia(dr.getInt(3));
              objComponente.setStr_caracteristica(dr.getString(5));
              
              
              
              Accesorios objAccesorios=new Accesorios(dr.getString(15),objComponente);
              
              
              
              
              listAccesorios.add(objAccesorios);
              
          }
          
      } catch (Exception e) {
          throw new Exception("Listar Accesorios "+e.getMessage(), e);
      }
      finally{
          try {
              dr.close();
              stmt.close();
              conn.close();
          } catch (Exception e) {
          }
      }
      return listAccesorios;
    }

    public static boolean eliminarComputadorComponete(String IdComputador, String IdAccesorios) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="Delete From computador_accesorios Where id_computador like '"+IdComputador+"' and id_accesorios like '"+IdAccesorios+"'";
    
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Eliminar Accesorios "+e.getMessage(), e);
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
