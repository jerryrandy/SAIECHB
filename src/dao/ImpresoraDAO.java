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
public class ImpresoraDAO {
    
   
         
              public static String verificarNSerie(String nSerie) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
             String sql="SELECT id_impresora From impresora Where id_impresora="+nSerie;
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                   rpta = dr.getString(1);  
            }

        } catch (Exception e) {
            throw new Exception("Verifica "+e.getMessage(), e);
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

         public static boolean insertar(Impresora objImpresora) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
   
               String sql="INSERT INTO impresora (id_impresora,id_componente,id_empleado,estado) VALUES ('"+
                       objImpresora.getStr_id_impresora()+"','"+objImpresora.getObjComponente().getStr_id_componente()+
                        "','"+objImpresora.getObjEmpleado().getInt_id_empleado()+"','"+objImpresora.getInt_estado()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
            String IdComponente= objImpresora.getObjComponente().getStr_id_componente();
           if(rpta)
           {           
                         ComponenteDAO.actualizarEstado(IdComponente,2);            
           }
          
        } catch (Exception e) {
            throw new Exception("Registrar Impresora "+e.getMessage(), e);
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

           public static List<Impresora> listarTodosOrdenado(int Estado) throws Exception
    {
        List<Impresora> listImpresora = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {               
                     String sql="SELECT impresora.id_impresora,impresora.id_componente,"
                             + "impresora.id_empleado,impresora.estado,componente.id_modelo,"
                             + "componente.caracteristica,modelo.id_marca,modelo.id_tipo,modelo.nombre,"
                             + "modelo.caracteristica,marca.nombre,tipo.nombre,empleado.id_cargo,"
                             + "empleado.id_area,empleado.apellidos,empleado.nombres,area.nombre,"
                             + "area.id_departamento,departamento.nombre,cargo.nombre from impresora "
                             + "inner join empleado inner join area inner join departamento inner join "
                             + "cargo inner join componente join modelo join tipo join marca where "
                             + "impresora.id_empleado=empleado.id_empleado and empleado.id_area=area.id_area "
                             + "and area.id_departamento=departamento.id_departamento and empleado.id_cargo=cargo.id_cargo "
                             + "and impresora.id_componente=componente.id_componente and componente.id_modelo=modelo.id_modelo "
                             + "and modelo.id_marca=marca.id_marca and modelo.id_tipo=tipo.id_tipo and impresora.estado='"+Estado+"' order by marca.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listImpresora == null)
                    listImpresora = new ArrayList<Impresora>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(13));
                    objCargo.setStr_nombre(dr.getString(20));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(18));
                    objDepartamento.setStr_nombre(dr.getString(19));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(14));
                    objArea.setStr_nombre(dr.getString(17));
                    objArea.setObjDepartamento(objDepartamento);                      
                    
                    
                    Empleado objEmpleado=new Empleado();
                    objEmpleado.setInt_id_empleado(dr.getInt(3));
                    objEmpleado.setStr_apellido(dr.getString(15));
                    objEmpleado.setStr_nombre(dr.getString(16));               
                    objEmpleado.setObjArea(objArea);
                    objEmpleado.setObjCargo(objCargo);
                    
                     Marca objMarca = new Marca();
                objMarca.setInt_id_marca(dr.getInt(7));
                objMarca.setStr_nombre(dr.getString(11));
                
                Tipo objTipo = new Tipo();
                objTipo.setInt_id_tipo(dr.getInt(8));
                objTipo.setStr_nombre(dr.getString(12));
                
                 Modelo objModelo = new Modelo();
                 objModelo.setInt_id_modelo(dr.getInt(5));
                 objModelo.setObjMarca(objMarca);
                 objModelo.setObjTipo(objTipo);
                 objModelo.setStr_nombre(dr.getString(9));
                 objModelo.setStr_caracteristica(dr.getString(10));
                 
                   Componente objComponente = new Componente();
                    objComponente.setStr_id_componente(dr.getString(2));
                    objComponente.setStr_caracteristica(dr.getString(6));
                    objComponente.setObjModelo(objModelo);

                                             
                 Impresora impresora = new Impresora(dr.getString(1),objComponente,objEmpleado,dr.getInt(4));
 
                listImpresora.add(impresora);
            }

        } catch (Exception e) {
            throw new Exception("Listar Computador "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listImpresora;
    }
           
             public static boolean eliminar(String IdImpresora) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="Delete From impresora Where id_impresora like '"+IdImpresora+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Elimino Impresora "+e.getMessage(), e);
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
