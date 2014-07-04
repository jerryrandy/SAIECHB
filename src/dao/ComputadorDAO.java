/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidades.*;
import entidades.Computador;
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
public class ComputadorDAO {
    
          public static String verificarNombre(String Nombre) throws Exception {
         String rpta = "";
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
              String sql="SELECT id_computador From computador Where  id_computador like '"+Nombre+"'";
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
   

         public static boolean insertar(Computador objComputador) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
   
               String sql="INSERT INTO computador (id_computador,id_cpu,id_monitor,id_empleado,estado) VALUES ('"+
                       objComputador.getStr_id_computador()+"','"+objComputador.getObjCPU().getStr_id_cpu()+"','"+
                       objComputador.getObjMonitor().getStr_id_monitor()+"','"+objComputador.getObjEmpleado().getInt_id_empleado()+
                       "','"+objComputador.getInt_estado()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           int IdEmpleado= objComputador.getObjEmpleado().getInt_id_empleado();
           if(rpta)
           {           
                         EmpleadoDAO.actualizarEstado(IdEmpleado,1);            
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


             public static List<Computador> listarFiltro(String filtro) throws Exception
    {
        List<Computador> listComputador = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {               
                     String sql="SELECT computador.id_computador,computador.id_cpu,computador.id_monitor,computador.id_empleado,"
                    + "computador.estado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre,monitor.id_componente from computador inner join empleado inner join area inner join departamento "
                    + "inner join cargo inner join monitor where computador.id_empleado=empleado.id_empleado and empleado.id_area=area.id_area and "
                    + "area.id_departamento=departamento.id_departamento and empleado.id_cargo=cargo.id_cargo and computador.id_monitor=monitor.id_monitor and "
                    + "(computador.id_cpu like '%"+filtro+"%' or computador.id_monitor like '%"+filtro+"%' or "
                    + "departamento.nombre like '%"+filtro+"%' or area.nombre like '%"+filtro+"%' or empleado.usuario like '%"+filtro+"%' or "
                    + "empleado.nombres like '%"+filtro+"%' or empleado.apellidos like '%"+filtro+"%' or cargo.nombre like '%"+filtro+"%' or "
                    + "computador.id_computador like '"+filtro+"%') order by computador.id_computador ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listComputador == null)
                    listComputador = new ArrayList<Computador>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(6));
                    objCargo.setStr_nombre(dr.getString(16));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(14));
                    objDepartamento.setStr_nombre(dr.getString(15));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(7));
                    objArea.setStr_nombre(dr.getString(13));
                    objArea.setObjDepartamento(objDepartamento);
                    
                    CPU objCPU = new CPU();
                    objCPU.setStr_id_cpu(dr.getString(2));
                    
                    Componente objComponente = new Componente();
                    objComponente.setStr_id_componente(dr.getString(17));
                    
                    Monitor objMonitor = new Monitor();
                    objMonitor.setStr_id_monitor(dr.getString(3));
                    objMonitor.setObjComponente(objComponente);
                    
                    Empleado objEmpleado=new Empleado();
                     objEmpleado.setInt_id_empleado(dr.getInt(4));
                     objEmpleado.setStr_apellido(dr.getString(8));
                     objEmpleado.setStr_nombre(dr.getString(9));
                     objEmpleado.setStr_usuario(dr.getString(10));
                    objEmpleado.setInt_activa(dr.getInt(11));
                    objEmpleado.setInt_estado(dr.getInt(12));                   
                    objEmpleado.setObjArea(objArea);
                    objEmpleado.setObjCargo(objCargo);
                                             
                 Computador Computador = new Computador(dr.getString(1),objCPU,objMonitor,objEmpleado,dr.getInt(5));
                listComputador.add(Computador);
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
        return listComputador;
    }

   public static List<Computador> listarTodosOrdenado(int Estado) throws Exception
    {
        List<Computador> listComputador = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {               
                     String sql="SELECT computador.id_computador,computador.id_cpu,computador.id_monitor,computador.id_empleado,"
                    + "computador.estado,empleado.id_cargo,empleado.id_area,empleado.apellidos,"
                    + "empleado.nombres,empleado.usuario,empleado.activa,empleado.estado,area.nombre,area.id_departamento,"
                    + "departamento.nombre,cargo.nombre,monitor.id_componente from computador inner join empleado inner join area inner join departamento "
                    + "inner join cargo inner join monitor where computador.id_empleado=empleado.id_empleado and empleado.id_area=area.id_area and "
                    + "area.id_departamento=departamento.id_departamento and empleado.id_cargo=cargo.id_cargo and computador.id_monitor=monitor.id_monitor and "
                    + " computador.estado='"+Estado+"' order by computador.id_computador ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

            while(dr.next())
            {
                 if(listComputador == null)
                    listComputador = new ArrayList<Computador>();
                    Cargo objCargo = new Cargo();
                    objCargo.setInt_id_cargo(dr.getInt(6));
                    objCargo.setStr_nombre(dr.getString(16));
                    
                    Departamento objDepartamento = new Departamento();
                     objDepartamento.setInt_id_departamento(dr.getInt(14));
                    objDepartamento.setStr_nombre(dr.getString(15));
                    
                    Area objArea = new Area();
                    objArea.setInt_id_area(dr.getInt(7));
                    objArea.setStr_nombre(dr.getString(13));
                    objArea.setObjDepartamento(objDepartamento);
                    
                    CPU objCPU = new CPU();
                    objCPU.setStr_id_cpu(dr.getString(2));
                    
                    Componente objComponente = new Componente();
                    objComponente.setStr_id_componente(dr.getString(17));
                    
                    Monitor objMonitor = new Monitor();
                    objMonitor.setStr_id_monitor(dr.getString(3));
                    objMonitor.setObjComponente(objComponente);
                    
                    Empleado objEmpleado=new Empleado();
                     objEmpleado.setInt_id_empleado(dr.getInt(4));
                     objEmpleado.setStr_apellido(dr.getString(8));
                     objEmpleado.setStr_nombre(dr.getString(9));
                     objEmpleado.setStr_usuario(dr.getString(10));
                    objEmpleado.setInt_activa(dr.getInt(11));
                    objEmpleado.setInt_estado(dr.getInt(12));                   
                    objEmpleado.setObjArea(objArea);
                    objEmpleado.setObjCargo(objCargo);
                                             
                 Computador Computador = new Computador(dr.getString(1),objCPU,objMonitor,objEmpleado,dr.getInt(5));
                listComputador.add(Computador);
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
        return listComputador;
    }

    public static boolean actualizar(Computador objComputador) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql=" UPDATE computador SET id_cpu='"+objComputador.getObjCPU().getStr_id_cpu()+
                    "',id_monitor='"+objComputador.getObjMonitor().getStr_id_monitor()+
                    "',id_empleado='"+objComputador.getObjEmpleado().getInt_id_empleado()+
                     "',estado='"+objComputador.getInt_estado()+
                    "' WHERE id_computador like '"+objComputador.getStr_id_computador()+"'";
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
