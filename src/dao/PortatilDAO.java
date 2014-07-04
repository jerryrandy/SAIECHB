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
public class PortatilDAO {
    
   
         
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

           public static boolean insertar(Portatil objPortatil) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
   
               String sql="INSERT INTO portatil (id_portatil,nombre,id_componente,id_empleado,id_software,estado) VALUES ('"+
                       objPortatil.getStr_id_portatil()+"','"+objPortatil.getStr_nombre()+"','"+objPortatil.getObjComponente().getStr_id_componente()+
                        "','"+objPortatil.getObjEmpleado().getInt_id_empleado()+"','"+objPortatil.getObjSoftware().getInt_id_software()+"','"+objPortatil.getInt_estado()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
            int IdEmpleado= objPortatil.getObjEmpleado().getInt_id_empleado();
            String IdComponente= objPortatil.getObjComponente().getStr_id_componente();
           if(rpta)
           {           
                         ComponenteDAO.actualizarEstado(IdComponente,2);  
                          EmpleadoDAO.actualizarEstado(IdEmpleado,1);        
           }
           
            

          
        } catch (Exception e) {
            throw new Exception("Registrar Equipo "+e.getMessage(), e);
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

        public static List<Portatil> listarTodosOrdenado(int Estado) throws Exception
    {
        List<Portatil> listPortatil = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {               
                     String sql="SELECT portatil.id_portatil,portatil.nombre,portatil.id_componente,"
                             + "portatil.id_empleado,portatil.id_software,portatil.estado,empleado.id_cargo,"
                             + "empleado.id_area,empleado.apellidos,empleado.nombres,empleado.usuario,"
                             + "empleado.activa,empleado.estado,area.nombre,area.id_departamento,departamento.nombre,"
                             + "cargo.nombre,software.nombre from portatil inner join empleado inner join area "
                             + "inner join departamento inner join cargo inner join software where "
                             + "portatil.id_empleado=empleado.id_empleado and empleado.id_area=area.id_area and "
                             + "area.id_departamento=departamento.id_departamento and empleado.id_cargo=cargo.id_cargo "
                             + "and portatil.id_software=software.id_software and portatil.estado='"+Estado+"' order by portatil.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listPortatil == null)
                    listPortatil = new ArrayList<Portatil>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(7));
                    objCargo.setStr_nombre(dr.getString(17));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(15));
                    objDepartamento.setStr_nombre(dr.getString(16));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(8));
                    objArea.setStr_nombre(dr.getString(14));
                    objArea.setObjDepartamento(objDepartamento);                    
                
                    Componente objComponente = new Componente();
                    objComponente.setStr_id_componente(dr.getString(3));
                    
                    
                    Empleado objEmpleado=new Empleado();
                    objEmpleado.setInt_id_empleado(dr.getInt(4));
                    objEmpleado.setStr_apellido(dr.getString(9));
                    objEmpleado.setStr_nombre(dr.getString(10));
                    objEmpleado.setStr_usuario(dr.getString(11));
                    objEmpleado.setInt_activa(dr.getInt(12));
                    objEmpleado.setInt_estado(dr.getInt(13));                   
                    objEmpleado.setObjArea(objArea);
                    objEmpleado.setObjCargo(objCargo);
                    
                    Software objSoftware = new Software();
                    objSoftware.setInt_id_software(dr.getInt(5));
                    objSoftware.setStr_nombre(dr.getString(18));
                                             
                 Portatil portatil = new Portatil(dr.getString(1),dr.getString(2),objComponente,objEmpleado,objSoftware,dr.getInt(6));
               
                listPortatil.add(portatil);
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
        return listPortatil;
    }
        
           public static List<Portatil>  listarFiltro(String filtro) throws Exception
    {
        List<Portatil> listPortatil = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {               
                     String sql="SELECT portatil.id_portatil,portatil.nombre,portatil.id_componente,"
                             + "portatil.id_empleado,portatil.id_software,portatil.estado,empleado.id_cargo,"
                             + "empleado.id_area,empleado.apellidos,empleado.nombres,empleado.usuario,"
                             + "empleado.activa,empleado.estado,area.nombre,area.id_departamento,departamento.nombre,"
                             + "cargo.nombre,software.nombre from portatil inner join empleado inner join area "
                             + "inner join departamento inner join cargo inner join software where "
                             + "portatil.id_empleado=empleado.id_empleado and empleado.id_area=area.id_area and "
                             + "area.id_departamento=departamento.id_departamento and empleado.id_cargo=cargo.id_cargo "
                             + "and portatil.id_software=software.id_software and (portatil.id_portatil like '%"+filtro+"%' or "
                             + "portatil.nombre like '%"+filtro+"%' or departamento.nombre like '%"+filtro+"%' or "
                             + "area.nombre like '%"+filtro+"%' or empleado.usuario like '%"+filtro+"%' or empleado.nombres "
                             + "like '%"+filtro+"%' or empleado.apellidos like '%"+filtro+"%' or cargo.nombre like '%"+filtro+"%') "
                             + "order by portatil.nombre ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listPortatil == null)
                    listPortatil = new ArrayList<Portatil>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(7));
                    objCargo.setStr_nombre(dr.getString(17));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(15));
                    objDepartamento.setStr_nombre(dr.getString(16));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(8));
                    objArea.setStr_nombre(dr.getString(14));
                    objArea.setObjDepartamento(objDepartamento);                    
                
                    Componente objComponente = new Componente();
                    objComponente.setStr_id_componente(dr.getString(3));
                    
                    
                    Empleado objEmpleado=new Empleado();
                    objEmpleado.setInt_id_empleado(dr.getInt(4));
                    objEmpleado.setStr_apellido(dr.getString(9));
                    objEmpleado.setStr_nombre(dr.getString(10));
                    objEmpleado.setStr_usuario(dr.getString(11));
                    objEmpleado.setInt_activa(dr.getInt(12));
                    objEmpleado.setInt_estado(dr.getInt(13));                   
                    objEmpleado.setObjArea(objArea);
                    objEmpleado.setObjCargo(objCargo);
                    
                    Software objSoftware = new Software();
                    objSoftware.setInt_id_software(dr.getInt(5));
                    objSoftware.setStr_nombre(dr.getString(18));
                                             
                 Portatil portatil = new Portatil(dr.getString(1),dr.getString(2),objComponente,objEmpleado,objSoftware,dr.getInt(6));
               
                listPortatil.add(portatil);
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
        return listPortatil;
    }
           
     public static boolean actualizar(Portatil objPortatil) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql=" UPDATE portatil SET nombre='"+objPortatil.getStr_nombre()+
                    "',id_componente='"+objPortatil.getObjComponente().getStr_id_componente()+
                    "',id_empleado='"+objPortatil.getObjEmpleado().getInt_id_empleado()+
                     "',id_software='"+objPortatil.getObjSoftware().getInt_id_software()+
                     "',estado='"+objPortatil.getInt_estado()+
                    "' WHERE id_portatil like '"+objPortatil.getStr_id_portatil()+"'";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            rpta = stmt.executeUpdate() == 1;

        } catch (Exception e) {
            throw new Exception("Actualizar Computador "+e.getMessage(), e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
        
        


}
