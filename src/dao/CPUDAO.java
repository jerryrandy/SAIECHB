/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entidades.CPU;
import entidades.Software;
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
public class CPUDAO {
    
   
        
       public static boolean verificarNSerie(String nSerie) throws Exception {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
            String sql="SELECT * From cpu Where id_cpu="+nSerie;
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
         public static boolean insertar(CPU objCPU) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {

               String sql="INSERT INTO cpu (id_cpu,id_software,estado) VALUES ('"+
                       objCPU.getStr_id_cpu()+"','"+objCPU.getObjSoftware().getInt_id_software()+"','"+objCPU.getInt_estado()+"');";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           String idCPU= objCPU.getStr_id_cpu();
           if(rpta)
           {
                 for(CPU.DetalleCPU objDetalle: objCPU.getDetalleCPU())
                {
                    String idComponente=objDetalle.getObjComponente().getStr_id_componente();
                     if(insertarCPUcomponentes(idCPU,idComponente))
                         ComponenteDAO.actualizarEstado(idComponente,2);

                }
               
           }
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

           public static boolean insertarCPUcomponentes(String IdCPU,String IdComponente) throws Exception
    {
         boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {

               String sql="INSERT INTO cpu_componentes (id_cpu,id_componente,estado) VALUES ('"+
                       IdCPU+"','"+IdComponente+"','0')";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
           
        } catch (Exception e) {
            throw new Exception("Registrar Detalle de CPU "+e.getMessage(), e);
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
       
      public static List<CPU> listarTodosOrdenado(int Estado) throws Exception
    {
        List<CPU> listCPU = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT cpu.id_cpu,cpu.id_software,cpu.estado,software.nombre FROM cpu inner join software "
                    + "where cpu.id_software=software.id_software and cpu.estado='"+Estado+"'  order by cpu.id_cpu ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

             while(dr.next())
            {
                 if(listCPU == null)
                    listCPU = new ArrayList<CPU>();
                 Software objSoftware = new Software();
                 objSoftware.setStr_nombre(dr.getString(4));
                 objSoftware.setInt_id_software(dr.getInt(2));
                 
                CPU objCPU=new CPU(dr.getString(1),objSoftware,dr.getInt(3));
                listCPU.add(objCPU);
            }

        } catch (Exception e) {
            throw new Exception("Listar CPU "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listCPU;
    }
            
         public static List<CPU> listarFiltro(String filtro,int Estado) throws Exception
    {
        List<CPU> listCPU = null;
        Connection conn =null;
        CallableStatement stmt = null;
        ResultSet dr = null;
        try {
            String sql="SELECT cpu.id_cpu,cpu.id_software,cpu.estado,software.nombre FROM "
                    + "cpu inner join software where cpu.id_software=software.id_software "
                    + "and cpu.estado='"+Estado+"' and cpu.id_cpu like '"+filtro+"%' order by cpu.id_cpu ASC";
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
            dr = stmt.executeQuery();

             while(dr.next())
            {
                 if(listCPU == null)
                    listCPU = new ArrayList<CPU>();
                 Software objSoftware = new Software();
                 objSoftware.setStr_nombre(dr.getString(4));
                 objSoftware.setInt_id_software(dr.getInt(2));
                 
                CPU objCPU=new CPU(dr.getString(1),objSoftware,dr.getInt(3));
                listCPU.add(objCPU);
            }

        } catch (Exception e) {
            throw new Exception("Listar CPU "+e.getMessage(), e);
        }
        finally{
            try {
                dr.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return listCPU;
    }

            public static boolean actualizarEstado(String IdCPU,int Estado) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql="UPDATE cpu SET estado='"+Estado+
                    "' WHERE id_cpu like '"+IdCPU+"'";
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
              
      public static boolean actualizarSistema(String IdCPU,int IdSoftware) throws Exception
    {
        boolean rpta = false;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            String sql="UPDATE cpu SET id_software='"+IdSoftware+
                    "' WHERE id_cpu like '"+IdCPU+"'";
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
    public static boolean eliminarCPUComponete(String IdCPU,String IdComponente) throws Exception
    {
        boolean rpta = false;
        Connection conn =null;
        CallableStatement stmt = null;
        try {
             String sql="Delete From cpu_componentes Where id_cpu like '"+IdCPU+"' and id_componente like '"+IdComponente+"'";
    
            conn = DBManager.getConnection();
            stmt = conn.prepareCall(sql);
           rpta = stmt.executeUpdate() == 1;
        } catch (Exception e) {
            throw new Exception("Eliminar Software "+e.getMessage(), e);
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
